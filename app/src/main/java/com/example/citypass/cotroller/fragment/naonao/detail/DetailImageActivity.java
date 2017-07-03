package com.example.citypass.cotroller.fragment.naonao.detail;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.naonao.detail.NaoNao_ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/30 23:33
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DetailImageActivity extends BaseActivity {
    @BindView(R.id.NaoNao_ImageViewpager)
    ViewPager mViewpager;
    @BindView(R.id.NaoNao_viewpagerBack)
    ImageView NaoNaoViewpagerBack;
    @BindView(R.id.naonao_viewpagerTitle)
    RelativeLayout naonaoViewpagerTitle;
    @BindView(R.id.naonao_viewpagerText)
    TextView pagerText;
    private List<View> mlist;
    private NaoNao_ViewPager adapter;
    private List<String> strList;
    private int position;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_naonao_viewpager;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        strList = new ArrayList<>();
        mlist = new ArrayList<>();
        Intent intent = getIntent();
        strList = (List<String>) intent.getSerializableExtra("image");
        position = intent.getIntExtra("position", 0);
        for (int i = 0; i < strList.size(); i++) {
            ImageView imageview = new ImageView(this);
            imageview.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            Glide.with(this).load(strList.get(i)).placeholder(R.drawable.ic_loading).error(R.drawable.ic_loading).into(imageview);
            mlist.add(imageview);
        }
        adapter = new NaoNao_ViewPager(mlist);
        mViewpager.setAdapter(adapter);
        //设置当前项目为传过来的图片，每个索引
        mViewpager.setCurrentItem(position);


        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int size = strList.size();
                pagerText.setText(mViewpager.getCurrentItem()+1+"/"+size);

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @OnClick(R.id.NaoNao_viewpagerBack)
    public void onViewClicked() {
        onBackPressed();

    }


}
