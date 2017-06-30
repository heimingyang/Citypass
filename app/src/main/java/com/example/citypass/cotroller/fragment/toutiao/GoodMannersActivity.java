package com.example.citypass.cotroller.fragment.toutiao;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.toutiao.HgoodmannerslAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodMannersActivity extends BaseActivity {

    @BindView(R.id.goodmanners_back)
    ImageView goodmannersBack;
    @BindView(R.id.goodmanners_title)
    RelativeLayout goodmannersTitle;
    @BindView(R.id.goodmanners_tablayout)
    TabLayout goodmannersTablayout;
    @BindView(R.id.goodmanners_viewpager)
    ViewPager goodmannersViewpager;
    private String[] title={"实物礼品","我的道具","抵用券","我的礼包"};
    @Override
    protected int getLayoutId() {
        return R.layout.activity_good_manners;
    }

    @Override
    protected void initListener() {

        ArrayList<Fragment> fragments=new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            HgoodmannersFragment fragment= new HgoodmannersFragment();
            fragments.add(fragment);
        }
        HgoodmannerslAdapter adapter=new HgoodmannerslAdapter(getSupportFragmentManager(),fragments,title);
        goodmannersViewpager.setAdapter(adapter);
        goodmannersTablayout.setupWithViewPager(goodmannersViewpager);
        goodmannersTablayout.setTabMode(TabLayout.MODE_FIXED);

        goodmannersTablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,R.color.red));
        goodmannersTablayout.setTabTextColors
                (ContextCompat.getColor(this,R.color.black),ContextCompat.getColor(this,R.color.red));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.goodmanners_back)
    public void onViewClicked() {
        finish();
    }
}
