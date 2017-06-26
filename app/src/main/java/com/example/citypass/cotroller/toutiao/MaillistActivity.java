package com.example.citypass.cotroller.toutiao;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.toutiao.HmailAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MaillistActivity extends BaseActivity {

    @BindView(R.id.hml_back)
    ImageView hmlBack;
    @BindView(R.id.hml_title)
    RelativeLayout hmlTitle;
    @BindView(R.id.hml_tablayout)
    TabLayout hmlTablayout;
    @BindView(R.id.hml_viewpage)
    ViewPager hmlViewpage;
    @BindView(R.id.activity_maillist)
    RelativeLayout activityMaillist;
    private ArrayList<Fragment> fragments;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_maillist;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        fragments = new ArrayList<>();
        fragments.add(new mailonefragment());
        fragments.add(new mailtwofragment());
        HmailAdapter adapter=new HmailAdapter(getSupportFragmentManager(),fragments);

        hmlViewpage.setAdapter(adapter);

        hmlTablayout.setupWithViewPager(hmlViewpage);
        hmlTablayout.setTabMode(TabLayout.MODE_FIXED);

        hmlTablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,R.color.red));
        hmlTablayout.setTabTextColors
                (ContextCompat.getColor(this,R.color.red),ContextCompat.getColor(this,R.color.red));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.hml_back)
    public void onViewClicked() {
        finish();
    }
}
