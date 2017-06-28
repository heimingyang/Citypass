package com.example.citypass.cotroller.fragment.information;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.model.bean.Information;
import com.example.citypass.model.bean.Informations;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.IsLogin;
import com.example.citypass.model.bean.Login;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述: 登录使用的页面
 * 创建人: 马杰
 * 创建时间: 2017/6/20 16:35
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.login_back)
    ImageView loginBack;
    @BindView(R.id.login_Relative)
    RelativeLayout loginRelative;
    @BindView(R.id.login_username)
    EditText loginUsername;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_Btn)
    Button loginBtn;
    @BindView(R.id.login_wangji)
    TextView loginWangji;
    @BindView(R.id.login_register)
    Button loginRegister;
    @BindView(R.id.login_Text)
    TextView loginText;
    @BindView(R.id.login_Linear)
    LinearLayout loginLinear;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.login_back, R.id.login_Btn, R.id.login_wangji, R.id.login_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_back:
                onBackPressed();
                break;
            case R.id.login_Btn:
                String username=loginUsername.getText().toString().trim();
                String pwd=loginPassword.getText().toString().trim();
                login(username,pwd);
                break;
            case R.id.login_wangji:
                Intent intent=new Intent(LoginActivity.this,PasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.login_register:
                Intent intentOne=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intentOne);
                break;
        }
    }
    private void login(final String username, String pwd){
        Login login=new Login();
        login.setCustomerID(8001);
        login.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"));
        login.setMethod("PHSocket_CheckUserLogin");
        login.setCustomerKey("E45AB41A52D150F4CB9EE6832ECFCE75");
        login.setAppName("CcooCity");
        login.setVersion("4.5");
        Login.ParamBean paramBean=new Login.ParamBean();
        paramBean.setLoginName(username);
        paramBean.setUserPWD(pwd);
        paramBean.setIp(getIP());
        paramBean.setPost("8000");
        paramBean.setVersion("android 4.3");
        login.setParam(paramBean);
        Login.StatisBean statisBean=new Login.StatisBean();
        statisBean.setSiteId(2422);
        statisBean.setUserId(31042672);
        String  model= android.os.Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion+"");
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("86"+username);
        String s = JSON.toJSONString(login);
        HashMap<String,String> map=new HashMap<>();
        map.put("param",s);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                IsLogin isLogin = JSON.parseObject(result, IsLogin.class);
                int code = isLogin.getMessageList().getCode();
                if(code==1000){
                    SpUtils.upSp().putBoolean(LoginUtils.LOGIN,true);
                    SpUtils.upSp().putString(LoginUtils.MYIMG,isLogin.getServerInfo().getRoleImg());
                    SpUtils.upSp().putString(LoginUtils.NAME,isLogin.getServerInfo().getRoleName());
                    SpUtils.upSp().putString(LoginUtils.OUSITEID, String.valueOf(isLogin.getServerInfo().getOuSiteID()));
                    SpUtils.upSp().putString(LoginUtils.USITEID, String.valueOf(isLogin.getServerInfo().getUSiteID()));
                    SpUtils.upSp().putString(LoginUtils.USERNAME,isLogin.getServerInfo().getUserName());
                    SpUtils.upSp().putString(LoginUtils.USERID, String.valueOf(isLogin.getServerInfo().getUserID()));
                    SpUtils.upSp().putString(LoginUtils.PHONE, "+86"+username);
                    SpUtils.upSp().commit();
                    getInformation();
                }else{
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
    private String getIP(){
        WifiManager wifiManager = (WifiManager) getApplication().getSystemService(Context.WIFI_SERVICE);
        //判断wifi是否开启,wifi未开启时，返回的ip为0.0.0.0
        if (!wifiManager.isWifiEnabled())
        {
            wifiManager.setWifiEnabled(true);
        }
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        String Ip = intToIp(wifiInfo.getIpAddress());
        return Ip;
    }

    private String intToIp(int i) {
        return (i & 0xFF ) + "." + ((i >> 8 ) & 0xFF) + "." + ((i >> 16 ) & 0xFF) + "." + ( i >> 24 & 0xFF) ;
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    break;
                case 0:
                    Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    public void getInformation(){
        Informations informations=new Informations();
        informations.setCustomerID(8001);
        informations.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"));
        informations.setMethod("PHSocket_GetBBSUsersInfoNew");
        informations.setCustomerKey("D5607EBE573BE2B59A4D5A1CAE882615");
        informations.setAppName("CcooCity");
        informations.setVersion("4.5");
        Informations.ParamBean paramBean=new Informations.ParamBean();
        paramBean.setSiteID(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USITEID,"")));
        paramBean.setUserName(SpUtils.getSp().getString(LoginUtils.USERNAME,""));
        informations.setParam(paramBean);
        Informations.StatisBean statisBean=new Informations.StatisBean();
        statisBean.setSiteId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USITEID,"")));
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));
        String  model= android.os.Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion+"");
        statisBean.setPhoneId("863181036606964");
        statisBean.setPhoneNum(SpUtils.getSp().getString(LoginUtils.PHONE,""));
        informations.setStatis(statisBean);
        String s = JSON.toJSONString(informations);
        HashMap<String,String> map=new HashMap<>();
        map.put("param",s);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                LoginUtils.information = JSON.parseObject(result, Information.class);
                int code = LoginUtils.information.getMessageList().getCode();
                if(code==1000){
                    handler.sendEmptyMessage(1);
                    setResult(111);
                    onBackPressed();
                }else{
                    handler.sendEmptyMessage(0);
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
}
