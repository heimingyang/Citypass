package com.example.citypass.cotroller.fragment.information;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.information.ChangePhone;
import com.example.citypass.model.bean.information.City;
import com.example.citypass.model.bean.information.Code;
import com.example.citypass.model.biz.infor.IMedalModel;
import com.example.citypass.model.biz.infor.MedaModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述: 更换绑定
 * 创建人: 马杰
 * 创建时间: 2017/6/24 14:27
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class PhoneActivity extends BaseActivity {
    @BindView(R.id.phone_back)
    ImageView phoneBack;
    @BindView(R.id.phone_Relative)
    RelativeLayout phoneRelative;
    @BindView(R.id.phone_text)
    TextView phoneText;
    @BindView(R.id.phone_get)
    Button phoneGet;
    @BindView(R.id.phone_phonenum)
    EditText phonePhonenum;
    @BindView(R.id.phone_RelativeOne)
    RelativeLayout phoneRelativeOne;
    @BindView(R.id.phone_getPhone)
    EditText phoneGetPhone;
    @BindView(R.id.phone_bangding)
    Button phoneBangding;
    private MedaModel model;
    private int time=60;

    @Override
    protected int getLayoutId() {
        return R.layout.acitivity_phone;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        model=new IMedalModel();
    }


    @OnClick({R.id.phone_back, R.id.phone_get, R.id.phone_bangding})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.phone_back:
                onBackPressed();
                break;
            case R.id.phone_get:
                String trim = phonePhonenum.getText().toString().trim();
                if(trim.isEmpty()){
                    Toast.makeText(PhoneActivity.this,"请先输入手机号",Toast.LENGTH_SHORT).show();
                }else {
                    getCodeParam();
                }
                break;
            case R.id.phone_bangding:
                changePhone();
                break;
        }
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    phoneGet.setText(time+"");
                    break;
                case 1:
                    phoneGet.setText("重新获取验证码");
                    break;
            }
        }
    };
    private Runnable run=new Runnable() {
        @Override
        public void run() {
            time--;
            if(time>=0) {
                handler.sendEmptyMessage(0);
                handler.postDelayed(run,1000);
            }else{
                time=60;
                phoneGet.setFocusable(false);
                handler.sendEmptyMessage(1);
                return;
            }
        }
    };

    private void getCodeParam(){
        Code code=new Code();
        code.setPhone(phonePhonenum.getText().toString().trim());
        code.setSiteID(LoginUtils.information.getServerInfo().getSiteID());
        code.setUsiteID(LoginUtils.information.getServerInfo().getSiteID());
        code.setUserName(LoginUtils.information.getServerInfo().getUserName());
        code.setIp(LoginUtils.getIPAddress(PhoneActivity.this));
        String param = LoginUtils.getParam(code, "PHSocket_SetPhoneBindSendCode");
        model.getMedal(param, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                City city = JSON.parseObject(result, City.class);
                int code1 = city.getMessageList().getCode();
                if(code1==1000){
                    handler.postDelayed(run,1000);
                    phoneGet.setFocusable(true);
                    phoneGet.setText(time+"");
                }else{
                    Toast.makeText(PhoneActivity.this,city.getMessageList().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    private void changePhone(){
        ChangePhone phone=new ChangePhone();
        phone.setSiteID(LoginUtils.information.getServerInfo().getSiteID());
        phone.setPhone(phonePhonenum.getText().toString().trim());
        phone.setUsiteID(LoginUtils.information.getServerInfo().getSiteID());
        phone.setUserID(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));
        phone.setAuthKey(phoneGetPhone.getText().toString().trim());
        String param = LoginUtils.getParam(phone, "PHSocket_SetPhoneBindCheck");
        model.getMedal(param, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.e("code",result);
                City city=JSON.parseObject(result,City.class);
                int code = city.getMessageList().getCode();
                if(code==1000){
                    Toast.makeText(PhoneActivity.this,"绑定成功",Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }else{
                    Toast.makeText(PhoneActivity.this,city.getMessageList().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
}
