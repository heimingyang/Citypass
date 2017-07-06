package com.example.citypass.cotroller.fragment.information;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.example.citypass.model.bean.information.City;
import com.example.citypass.model.bean.information.ModifyPassActivity;
import com.example.citypass.model.bean.information.Phone;
import com.example.citypass.model.bean.information.UpPhone;
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
 * 类描述: 密码修改
 * 创建人: 马杰
 * 创建时间: 2017/6/22 14:42
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ModifyActivity extends BaseActivity {
    @BindView(R.id.modify_back)
    ImageView modifyBack;
    @BindView(R.id.modify_Relative)
    RelativeLayout modifyRelative;
    @BindView(R.id.modify_text)
    TextView modifyText;
    @BindView(R.id.modify_textOne)
    TextView modifyTextOne;
    @BindView(R.id.modify_get)
    Button modifyGet;
    @BindView(R.id.modify_phone)
    EditText modifyPhone;
    @BindView(R.id.modify_one)
    RelativeLayout modifyOne;
    @BindView(R.id.modify_textTwo)
    TextView modifyTextTwo;
    @BindView(R.id.modify_yanzheng)
    EditText modifyYanzheng;
    @BindView(R.id.modify_two)
    RelativeLayout modifyTwo;
    @BindView(R.id.modify_back_login)
    Button modifyBackLogin;
    private MedaModel model;
    private int a=180;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify;
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


    @OnClick({R.id.modify_back, R.id.modify_get, R.id.modify_back_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.modify_back:
                onBackPressed();
                break;
            case R.id.modify_get:
                getCode();
                modifyGet.setText(a+"");
                han.postDelayed(run,1000);
                break;
            case R.id.modify_back_login:
                upCode();
                break;
        }
    }

    private Runnable run=new Runnable() {
        @Override
        public void run() {
            if(a>0) {
                a--;
                han.sendEmptyMessage(0);
                han.postDelayed(run, 1000);
            }else{
                han.sendEmptyMessage(1);
                a=180;
            }
        }
    };
    private Handler han=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    modifyGet.setText(a+"");
                    break;
                case 1:
                    modifyGet.setText("重新获取验证码");
                    break;
                case 2:
                    Intent intent=new Intent(ModifyActivity.this, ModifyPassActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
    
    private void getCode(){
        Phone phone=new Phone();
        phone.setSiteID(LoginUtils.information.getServerInfo().getSiteID());
        phone.setUserName(LoginUtils.information.getServerInfo().getUserName());
        phone.setPhone(modifyPhone.getText().toString().trim());
        String param = LoginUtils.getParam(phone, "PHSocket_EditPhoneBindSendCode");
        model.getMedal(param, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                City city = JSON.parseObject(result, City.class);
                int code = city.getMessageList().getCode();
                if(code==1000){
                    Toast.makeText(ModifyActivity.this,"获取成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ModifyActivity.this,city.getMessageList().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
    
    
    private void upCode(){
        UpPhone phone=new UpPhone();
        phone.setPhone(modifyPhone.getText().toString().trim());
        phone.setUserID(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));
        phone.setSiteID(LoginUtils.information.getServerInfo().getSiteID());
        phone.setAuthKey(modifyYanzheng.getText().toString().trim());
        phone.setUsetName(LoginUtils.information.getServerInfo().getUserName());
        String param = LoginUtils.getParam(phone, "PHSocket_EditPhoneBindCheck");
        model.getMedal(param, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                City city = JSON.parseObject(result, City.class);
                int code = city.getMessageList().getCode();
                if(code==1000){
                    Toast.makeText(ModifyActivity.this,"验证成功",Toast.LENGTH_SHORT).show();
                    han.sendEmptyMessage(2);
                }else{
                    Toast.makeText(ModifyActivity.this,city.getMessageList().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
}
