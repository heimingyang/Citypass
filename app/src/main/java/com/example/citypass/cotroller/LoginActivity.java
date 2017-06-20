package com.example.citypass.cotroller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
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
                break;
            case R.id.login_wangji:
                Intent intent=new Intent(LoginActivity.this,PasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.login_register:
                break;
        }
    }
}
