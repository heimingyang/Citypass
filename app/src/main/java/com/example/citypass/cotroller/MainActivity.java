package com.example.citypass.cotroller;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_Img)
    ImageView mainImg;
    @BindView(R.id.main_Title)
    TextView mainTitle;
    @BindView(R.id.main_right_img)
    ImageView mainRightImg;
    @BindView(R.id.main_right_imgTwo)
    ImageView mainRightImgTwo;
    @BindView(R.id.main_Relative)
    RelativeLayout mainRelative;
    @BindView(R.id.main_The_headlines)
    RadioButton mainTheHeadlines;
    @BindView(R.id.main_Community)
    RadioButton mainCommunity;
    @BindView(R.id.main_Show)
    RadioButton mainShow;
    @BindView(R.id.main_Life)
    RadioButton mainLife;
    @BindView(R.id.main_find)
    RadioButton mainFind;
    @BindView(R.id.main_group)
    RadioGroup mainGroup;
    @BindView(R.id.main_Viewpager)
    ViewPager mainViewpager;
    @BindView(R.id.main_drawlayout)
    DrawerLayout mainDrawlayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
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


    @OnClick({R.id.main_Img, R.id.main_Title, R.id.main_right_img, R.id.main_right_imgTwo, R.id.main_The_headlines, R.id.main_Community, R.id.main_Show, R.id.main_Life, R.id.main_find})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_Img:
                break;
            case R.id.main_Title:
                break;
            case R.id.main_right_img:
                break;
            case R.id.main_right_imgTwo:
                break;
            case R.id.main_The_headlines:
                break;
            case R.id.main_Community:
                break;
            case R.id.main_Show:
                break;
            case R.id.main_Life:
                break;
            case R.id.main_find:
                break;
        }
    }
}
