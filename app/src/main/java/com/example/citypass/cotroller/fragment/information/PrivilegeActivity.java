package com.example.citypass.cotroller.fragment.information;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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
import com.example.citypass.cotroller.adapter.life.PrivilegeAdapter;
import com.example.citypass.model.bean.information.Level;
import com.example.citypass.model.bean.information.Medal;
import com.example.citypass.model.bean.information.Privilege;
import com.example.citypass.model.biz.infor.ILevelModel;
import com.example.citypass.model.biz.infor.LevelModel;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.example.citypass.view.Mylistview;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.citypass.utils.LoginUtils.USERID;
import static com.example.citypass.utils.LoginUtils.information;

/**
 * 项目名称: 血压卫士
 * 类描述: 我的特权
 * 创建人: 马杰
 * 创建时间: 2017/6/28 9:37
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class PrivilegeActivity extends BaseActivity {
    @BindView(R.id.privilege_back)
    ImageView privilegeBack;
    @BindView(R.id.privilege_Relative)
    RelativeLayout privilegeRelative;
    @BindView(R.id.privilege_Text_one)
    TextView privilegeTextOne;
    @BindView(R.id.privilege_ListOne)
    Mylistview privilegeListOne;
    @BindView(R.id.privilege_TextTwo)
    TextView privilegeTextTwo;
    @BindView(R.id.privilege_RelativeOne)
    RelativeLayout privilegeRelativeOne;
    @BindView(R.id.privilege_Text_three)
    TextView privilegeTextThree;
    @BindView(R.id.privilege_RelativeTwo)
    RelativeLayout privilegeRelativeTwo;
    @BindView(R.id.privilege_List)
    Mylistview privilegeList;
    @BindView(R.id.privilege_scroll)
    ScrollView privilegeScroll;
    private LevelModel model;
    private List<Privilege.ServerInfoBean.UserPrivilegeListBean.UserPrivilegeListBeans> userPrivilegeList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_privilege;
    }

    @Override
    protected void initListener() {
        privilegeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog(userPrivilegeList.get(position));
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        model=new ILevelModel();
        privilegeScroll.smoothScrollTo(0, 0);
        model.getList(gerParam(), new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Privilege privilege = JSON.parseObject(result, Privilege.class);
                int code = privilege.getMessageList().getCode();
                if(code==1000){
                    userPrivilegeList = privilege.getServerInfo().getUserPrivilegeList().getUserPrivilegeList();
                    PrivilegeAdapter adapter=new PrivilegeAdapter(userPrivilegeList,PrivilegeActivity.this);
                    privilegeList.setAdapter(adapter);
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
    private String gerParam() {
        Level level = new Level();
        level.setCustomerID(8001);
        level.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(), "yyyy-MM-dd hh:mm:ss"));
        level.setMethod("PHSocket_APP_GetUserPrivilegeList");
        level.setCustomerKey("D5607EBE573BE2B59A4D5A1CAE882615");
        level.setAppName("CcooCity");
        level.setVersion("4.5");
        Level.ParamBean paramBean = new Level.ParamBean();
        paramBean.setSiteID(information.getServerInfo().getSiteID());
        paramBean.setUserID(SpUtils.getSp().getString(USERID, ""));
        paramBean.setCurPage(1);
        paramBean.setPageSize(50);
        level.setParam(paramBean);
        Level.StatisBean statisBean = new Level.StatisBean();
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("+86" + information.getServerInfo().getTel());
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(USERID, "")));
        statisBean.setSiteId(information.getServerInfo().getSiteID());
        String model = Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion = Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion + "");
        level.setStatis(statisBean);
        String s = JSON.toJSONString(level);
        return s;
    }


    @OnClick({R.id.privilege_back, R.id.privilege_TextTwo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.privilege_back:
                onBackPressed();
                break;
            case R.id.privilege_TextTwo:
                Intent intent=new Intent(PrivilegeActivity.this,TaskActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void Dialog(Privilege.ServerInfoBean.UserPrivilegeListBean.UserPrivilegeListBeans bean){
        View view= LayoutInflater.from(PrivilegeActivity.this).inflate(R.layout.medal_dialog_itemone,null);
        ImageView imgOne= (ImageView) view.findViewById(R.id.medal_dialog_back);
        ImageView imgTwo= (ImageView) view.findViewById(R.id.medal_dialog_Img);
        TextView textOne= (TextView) view.findViewById(R.id.medal_dialog_textOne);
        TextView textTwo= (TextView) view.findViewById(R.id.medal_dialog_texttwo);
        TextView textThree= (TextView) view.findViewById(R.id.medal_dialog_textthree);
        TextView textFour= (TextView) view.findViewById(R.id.medal_dialog_textfour);
        TextView textFive= (TextView) view.findViewById(R.id.medal_dialog_textfive);
        ProgressBar pro= (ProgressBar) view.findViewById(R.id.medal_dialog_progress);
        HttpFacory.create().loadImage(bean.getPImage(),imgTwo,false);
        textOne.setText(bean.getName());
        textTwo.setText(bean.getDescription());
        textThree.setText(bean.getHName()+"及以上等级享有");
        textFour.setText("");
        pro.setVisibility(View.GONE);
        textFive.setVisibility(View.GONE);
        final AlertDialog dialog=new AlertDialog.Builder(PrivilegeActivity.this)
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
