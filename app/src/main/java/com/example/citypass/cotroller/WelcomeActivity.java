package com.example.citypass.cotroller;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/6 20:23
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.welcome_bottom)
    RelativeLayout welcomeBottom;
    @BindView(R.id.welcome_img)
    ImageView welcomeImg;
    @BindView(R.id.welcome_Top)
    RelativeLayout welcomeTop;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
    private Handler handler=new Handler(){};

    @Override
    protected void initView() {
        if(SpUtils.getSp().getBoolean(LoginUtils.LOGIN,false)) {
            HttpFacory.create().loadImage(SpUtils.getSp().getString("img",""),welcomeImg,true);
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(WelcomeActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },2500);
    }

}
