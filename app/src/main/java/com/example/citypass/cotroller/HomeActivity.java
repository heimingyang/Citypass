package com.example.citypass.cotroller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.base.MyViewPager;
import com.example.citypass.cotroller.fragment.FaXianFragment;
import com.example.citypass.cotroller.fragment.LifeFragment;
import com.example.citypass.cotroller.fragment.NaoNaoFragment;
import com.example.citypass.cotroller.fragment.SheQuFragment;
import com.example.citypass.cotroller.fragment.TouTiaoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {


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
    MyViewPager mainViewpager;
    @BindView(R.id.main_drawlayout)
    DrawerLayout mainDrawlayout;
    @BindView(R.id.main_Img)
    ImageView mainImg;
    @BindView(R.id.main_Title)
    TextView mainTitle;
    @BindView(R.id.main_right_img)
    ImageView mainRightImg;
    @BindView(R.id.main_right_imgTwo)
    ImageView mainRightImgTwo;


    private HomeAdapter homeAdapter;
    private List<Fragment> mflist = new ArrayList<>();
    //分别为头条、闹闹、社区、生活、发现的Fragment
    private TouTiaoFragment touTiaoFragment;
    private NaoNaoFragment naoNaoFragment;
    private SheQuFragment sheQuFragment;
    private LifeFragment lifeFragment;
    private FaXianFragment faXianFragment;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        touTiaoFragment = new TouTiaoFragment();
        naoNaoFragment = new NaoNaoFragment();
        sheQuFragment = new SheQuFragment();
        lifeFragment = new LifeFragment();
        faXianFragment = new FaXianFragment();
        mflist.add(touTiaoFragment);
        mflist.add(naoNaoFragment);
        mflist.add(sheQuFragment);
        mflist.add(lifeFragment);
        mflist.add(faXianFragment);


        homeAdapter = new HomeAdapter(getSupportFragmentManager(), mflist);
        mainViewpager.setAdapter(homeAdapter);

    }


    @OnClick({R.id.main_The_headlines, R.id.main_Community, R.id.main_Show, R.id.main_Life, R.id.main_find})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_The_headlines:
                changeView(0);

                break;
            case R.id.main_Community:
                changeView(1);

                break;
            case R.id.main_Show:
                changeView(2);

                break;
            case R.id.main_Life:
                changeView(3);

                break;
            case R.id.main_find:
                changeView(4);

                break;
        }
    }

    @Override
    public TextView getText() {
        return this.mainTitle;
    }

    @Override
    public ImageView getImgOne() {
        return this.mainRightImgTwo;
    }

    @Override
    public ImageView getImgTwo() {
        return this.mainRightImg;
    }

    private void changeView(int desTab) {
        mainViewpager.setCurrentItem(desTab, true);
    }

}
