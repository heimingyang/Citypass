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
 * 类描述: 注册页面
 * 创建人: 马杰
 * 创建时间: 2017/6/20 19:25
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.register_back)
    ImageView registerBack;
    @BindView(R.id.register_Relative)
    RelativeLayout registerRelative;
    @BindView(R.id.register_chengshi)
    TextView registerChengshi;
    @BindView(R.id.register_phone)
    EditText registerPhone;
    @BindView(R.id.register_yanzheng)
    EditText registerYanzheng;
    @BindView(R.id.register_fasong)
    TextView registerFasong;
    @BindView(R.id.register_Btn)
    Button registerBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
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


    @OnClick({R.id.register_back, R.id.register_chengshi, R.id.register_fasong, R.id.register_Btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_back:
                onBackPressed();
                break;
            case R.id.register_chengshi:
                break;
            case R.id.register_fasong:
                break;
            case R.id.register_Btn:
                break;
        }
    }
}
