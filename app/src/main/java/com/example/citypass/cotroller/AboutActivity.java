package com.example.citypass.cotroller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
 * 类描述: 免责声明
 * 创建人: 马杰
 * 创建时间: 2017/6/22 15:16
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class AboutActivity extends BaseActivity {
    @BindView(R.id.about_back)
    ImageView aboutBack;
    @BindView(R.id.about_Relative)
    RelativeLayout aboutRelative;
    @BindView(R.id.about_img)
    ImageView aboutImg;
    @BindView(R.id.about_textThree)
    TextView aboutTextThree;
    @BindView(R.id.about_textFour)
    TextView aboutTextFour;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
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


    @OnClick({R.id.about_back, R.id.about_textFour})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.about_back:
                onBackPressed();
                break;
            case R.id.about_textFour:
                Intent intent=new Intent(AboutActivity.this,AboutActivity2.class);
                startActivity(intent);
                break;
        }
    }
}
