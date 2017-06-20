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
 * 类描述: 验证密码的界面
 * 创建人: 马杰
 * 创建时间: 2017/6/20 17:39
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class PasswordActivity extends BaseActivity {
    @BindView(R.id.mima_back)
    ImageView mimaBack;
    @BindView(R.id.mima_Relative)
    RelativeLayout mimaRelative;
    @BindView(R.id.mima_phone)
    EditText mimaPhone;
    @BindView(R.id.mima_yanzheng)
    EditText mimaYanzheng;
    @BindView(R.id.mima_fasong)
    TextView mimaFasong;
    @BindView(R.id.mima_Btn)
    Button mimaBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mima;
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


    @OnClick({R.id.mima_back, R.id.mima_fasong, R.id.mima_Btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mima_back:
                onBackPressed();
                break;
            case R.id.mima_fasong:
                break;
            case R.id.mima_Btn:
                break;
        }
    }
}
