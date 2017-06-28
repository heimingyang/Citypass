package com.example.citypass.cotroller.fragment.information;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.life.MedalAdapter;
import com.example.citypass.model.bean.information.Medal;
import com.example.citypass.model.bean.information.MedalUp;
import com.example.citypass.model.biz.infor.IMedalModel;
import com.example.citypass.model.biz.infor.MedaModel;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LogUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.example.citypass.view.Mylistview;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.citypass.utils.LoginUtils.information;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/27 8:33
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class MedalActivity extends BaseActivity {
    @BindView(R.id.medal_back)
    ImageView medalBack;
    @BindView(R.id.medal_Relative)
    RelativeLayout medalRelative;
    @BindView(R.id.medal_TextOne)
    TextView medalTextOne;
    @BindView(R.id.medal_ListOne)
    Mylistview medalListOne;
    @BindView(R.id.medal_back_TextTwo)
    TextView medalBackTextTwo;
    @BindView(R.id.medal_RelativeOne)
    RelativeLayout medalRelativeOne;
    @BindView(R.id.medal_TextThree)
    TextView medalTextThree;
    @BindView(R.id.medal_ListTwo)
    Mylistview medalListTwo;
    @BindView(R.id.medal_back_TextFour)
    TextView medalBackTextFour;
    @BindView(R.id.medal_RelativeTwo)
    RelativeLayout medalRelativeTwo;
    @BindView(R.id.medal_TextFive)
    TextView medalTextFive;
    @BindView(R.id.medal_RelativeThree)
    RelativeLayout medalRelativeThree;
    @BindView(R.id.medal_List)
    Mylistview medalList;
    @BindView(R.id.medal_scroll)
    ScrollView medalScroll;
    private MedaModel model;
    private List<Medal.ServerInfoBean.TMedalListBean.TMedalListBeans> tMedalList1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_medal;
    }

    @Override
    protected void initListener() {
        medalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Medal.ServerInfoBean.TMedalListBean.TMedalListBeans tMedalListBeans = tMedalList1.get(position);
                Dialog(tMedalListBeans);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        model=new IMedalModel();
        medalScroll.smoothScrollTo(0, 0);
        LogUtils.e("aaaaa",getParams());
        model.getMedal(getParams(), new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                LogUtils.e("aaaa",result);
                Medal medal = JSON.parseObject(result, Medal.class);
                int code = medal.getMessageList().getCode();
                if(code==1000){
                    Medal.ServerInfoBean.TMedalListBean tMedalList = medal.getServerInfo().getTMedalList();
                    tMedalList1 = tMedalList.getTMedalList();
                    MedalAdapter adapter=new MedalAdapter(tMedalList1,MedalActivity.this);
                    medalList.setAdapter(adapter);
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }


    @OnClick({R.id.medal_back, R.id.medal_back_TextTwo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.medal_back:
                onBackPressed();
                break;
            case R.id.medal_back_TextTwo:
                Intent intent=new Intent(MedalActivity.this,TaskActivity.class);
                startActivity(intent);
                break;
        }
    }

    private String getParams(){
        MedalUp medal=new MedalUp();
        medal.setCustomerID(8001);
        medal.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"));
        medal.setMethod("PHSocket_APP_MyUserMedalList");
        medal.setCustomerKey("D5607EBE573BE2B59A4D5A1CAE882615");
        medal.setAppName("CcooCity");
        medal.setVersion("4.5");
        MedalUp.ParamBean paramBean=new MedalUp.ParamBean();
        paramBean.setSiteID(information.getServerInfo().getSiteID());
        paramBean.setUserID(SpUtils.getSp().getString(LoginUtils.USERID,""));
        paramBean.setPageSize(100);
        paramBean.setCurPage(1);
        medal.setParam(paramBean);
        MedalUp.StatisBean statisBean=new MedalUp.StatisBean();
        statisBean.setSiteId(information.getServerInfo().getSiteID());
        paramBean.setUserID(SpUtils.getSp().getString(LoginUtils.USERID,""));
        String  model= android.os.Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion+"");
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("+86"+LoginUtils.information.getServerInfo().getTel());
        medal.setStatis(statisBean);
        String s = JSON.toJSONString(medal);
        return s;
    }

    private void Dialog(Medal.ServerInfoBean.TMedalListBean.TMedalListBeans bean){
        View view= LayoutInflater.from(MedalActivity.this).inflate(R.layout.medal_dialog_itemone,null);
        ImageView imgOne= (ImageView) view.findViewById(R.id.medal_dialog_back);
        ImageView imgTwo= (ImageView) view.findViewById(R.id.medal_dialog_Img);
        TextView textOne= (TextView) view.findViewById(R.id.medal_dialog_textOne);
        TextView textTwo= (TextView) view.findViewById(R.id.medal_dialog_texttwo);
        TextView textThree= (TextView) view.findViewById(R.id.medal_dialog_textthree);
        TextView textFour= (TextView) view.findViewById(R.id.medal_dialog_textfour);
        TextView textFive= (TextView) view.findViewById(R.id.medal_dialog_textfive);
        ProgressBar pro= (ProgressBar) view.findViewById(R.id.medal_dialog_progress);
        pro.setProgress(Integer.parseInt(bean.getIProgress()));
        HttpFacory.create().loadImage(bean.getImage(),imgTwo,false);
        textOne.setText(bean.getSName());
        textTwo.setText(bean.getDescription());
        textThree.setText("当前完成数："+bean.getMState());
        textFour.setText("点亮可获得"+bean.getDCoin()+"城市币，"+bean.getDIntegral()+"成长值");
        textFive.setText(bean.getCanBeLitCondition()+bean.getEffectivetime());
        final AlertDialog dialog=new AlertDialog.Builder(MedalActivity.this)
                .setView(view)
                .create();
        imgOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
