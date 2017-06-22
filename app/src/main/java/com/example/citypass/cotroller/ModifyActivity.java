package com.example.citypass.cotroller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

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

    }


    @OnClick({R.id.modify_back, R.id.modify_yanzheng, R.id.modify_back_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.modify_back:
                onBackPressed();
                break;
            case R.id.modify_yanzheng:
                break;
            case R.id.modify_back_login:
                break;
        }
    }
}
