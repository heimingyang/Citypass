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
 * 类描述:
 * 创建人: dell
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

    }


    @OnClick({R.id.phone_back, R.id.phone_get, R.id.phone_bangding})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.phone_back:
                onBackPressed();
                break;
            case R.id.phone_get:
                break;
            case R.id.phone_bangding:
                break;
        }
    }
}
