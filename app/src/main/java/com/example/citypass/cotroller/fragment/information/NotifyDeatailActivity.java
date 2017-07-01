package com.example.citypass.cotroller.fragment.information;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.life.MessageAdapter;
import com.example.citypass.model.bean.information.Msg;
import com.example.citypass.model.bean.information.Notify;
import com.example.citypass.model.bean.information.NotifyDetail;
import com.example.citypass.model.bean.information.NotifyOne;
import com.example.citypass.model.bean.information.NotifyTwo;
import com.example.citypass.model.bean.toutiao.Param;
import com.example.citypass.model.biz.infor.IMedalModel;
import com.example.citypass.model.biz.infor.MedaModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.ClearDateUtils;
import com.example.citypass.utils.LogUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.view.MRecyclerView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/30 14:50
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class NotifyDeatailActivity extends BaseActivity {
    @BindView(R.id.notifyDetail_back)
    ImageView notifyDetailBack;
    @BindView(R.id.notifyDetail_Title)
    TextView notifyDetailTitle;
    @BindView(R.id.notifyDetail_ImgTwo)
    ImageView notifyDetailImgTwo;
    @BindView(R.id.notifyDetail_Relative)
    RelativeLayout notifyDetailRelative;
    @BindView(R.id.notifyDetail_Recycler)
    MRecyclerView notifyDetailRecycler;
    @BindView(R.id.notifyDetail_Image)
    ImageView notifyDetailImage;
    @BindView(R.id.notifyDetail_RelativeTwo)
    RelativeLayout notifyDetailRelativeTwo;
    private MedaModel model;
    private List<String> mList=new ArrayList<>();
    private List<Msg.ServerInfoBean> mStrList=new ArrayList<>();
    private String param;
    private String title;
    private String str;
    private  File file;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_notifydetail;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        str = intent.getStringExtra("str");
        title=intent.getStringExtra("title");
        notifyDetailTitle.setText(title);
        model=new IMedalModel();
        file=getDir(title+".txt",MODE_PRIVATE);
        if(!file.exists()){
            file.mkdirs();
        }
        if(title.equals("谁看过我")) {
            NotifyDetail notify = new NotifyDetail();
            notify.setUserid(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));
            notify.setSiteid(LoginUtils.information.getServerInfo().getSiteID());
            notify.setPageindex(1);
            notify.setPagesize(10);
            param= LoginUtils.getParam(notify, str);
        }else if(title.equals("系统通知")){
            NotifyTwo two=new NotifyTwo();
            two.setUserid(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));
            two.setSiteid(LoginUtils.information.getServerInfo().getSiteID());
            two.setLastTime(SpUtils.getSp().getString("lasttimetwo",""));
            param= LoginUtils.getParam(two, str);
        }else if(title.equals("精彩推荐")){
            NotifyTwo two=new NotifyTwo();
            two.setUserid(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));
            two.setSiteid(LoginUtils.information.getServerInfo().getSiteID());
            two.setLastTime(SpUtils.getSp().getString("lasttimeone",""));
            param= LoginUtils.getParam(two, str);
        }else if(title.equals("好友动态")){
            NotifyOne one=new NotifyOne();
            one.setSiteid(LoginUtils.information.getServerInfo().getSiteID());
            one.setUsername(LoginUtils.information.getServerInfo().getUserName());
            one.setPagesize(10);
            one.setPageindex(1);
            param=LoginUtils.getParam(one,str);
        }
        LinearLayoutManager layoutmanager=new LinearLayoutManager(NotifyDeatailActivity.this);
        layoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        notifyDetailRecycler.setLayoutManager(layoutmanager);
        MessageAdapter adapter=new MessageAdapter(NotifyDeatailActivity.this,mStrList);
        notifyDetailRecycler.setAdapter(adapter);
        notifyDetailRecycler.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {
                getmsg(param,title,false);
            }

            @Override
            public void onLoadMore() {
            }
        });
        getmsg(param,title,false);
    }
    private void getmsg(String param, final String title, final boolean boo){
        model.getMedal(param, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Msg msg = JSON.parseObject(result, Msg.class);
                int code = msg.getMessageList().getCode();
                if(code==1000) {
                    List<Msg.ServerInfoBean> serverInfo = msg.getServerInfo();
                    if(serverInfo!=null) {
                        mStrList.addAll(serverInfo);
                            notifyDetailRecycler.setVisibility(View.VISIBLE);
                            notifyDetailRelativeTwo.setVisibility(View.GONE);
                            notifyDetailImgTwo.setVisibility(View.VISIBLE);
                        if (boo) {
                            notifyDetailRecycler.loadMoreComplete();
                        } else {
                            notifyDetailRecycler.refreshComplete();
                        }
                    }
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }


    @OnClick({R.id.notifyDetail_back, R.id.notifyDetail_ImgTwo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.notifyDetail_back:
                onBackPressed();
                break;
            case R.id.notifyDetail_ImgTwo:
                if(title.equals("精彩推荐")) {
                    SpUtils.upSp().putString("lasttimeone", mStrList.get(mStrList.size() - 1).getCreateTime());
                    SpUtils.upSp().commit();
                    NotifyTwo two=new NotifyTwo();
                    two.setUserid(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));
                    two.setSiteid(LoginUtils.information.getServerInfo().getSiteID());
                    two.setLastTime(SpUtils.getSp().getString("lasttimeone",""));
                    param= LoginUtils.getParam(two, str);
                }else if(title.equals("系统通知")){
                    SpUtils.upSp().putString("lasttimetwo", mStrList.get(mStrList.size() - 1).getCreateTime());
                    SpUtils.upSp().commit();
                    NotifyTwo two=new NotifyTwo();
                    two.setUserid(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));
                    two.setSiteid(LoginUtils.information.getServerInfo().getSiteID());
                    two.setLastTime(SpUtils.getSp().getString("lasttimetwo",""));
                    param= LoginUtils.getParam(two, str);
                }
                getmsg(param,title,false);
                break;
        }
    }

    private void Input(){
        FileInputStream inputStream=null;
        try {
            inputStream=openFileInput(title+".txt");
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        String str=null;
        while ((str=reader.readLine())!=null){
            mList.add(str);
        }
        reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Output(String param){
        FileOutputStream outputStream;
        try {
            outputStream=openFileOutput(title+".txt",MODE_PRIVATE);
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(param+"/r/n");
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
