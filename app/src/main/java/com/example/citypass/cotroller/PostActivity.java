package com.example.citypass.cotroller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.FragmentAdapter;
import com.example.citypass.cotroller.fragment.PostFragment;
import com.example.citypass.cotroller.fragment.ReplayFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/26 15:25
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class PostActivity extends BaseActivity {
    @BindView(R.id.post_back)
    ImageView postBack;
    @BindView(R.id.post_Release)
    ImageView postRelease;
    @BindView(R.id.post_Relative)
    RelativeLayout postRelative;
    @BindView(R.id.post_one)
    RadioButton postOne;
    @BindView(R.id.post_two)
    RadioButton postTwo;
    @BindView(R.id.post_three)
    RadioButton postThree;
    @BindView(R.id.post_four)
    RadioButton postFour;
    @BindView(R.id.post_radio)
    RadioGroup postRadio;
    @BindView(R.id.post_linear_one)
    TextView postLinearOne;
    @BindView(R.id.post_linear_two)
    TextView postLinearTwo;
    @BindView(R.id.post_linear_three)
    TextView postLinearThree;
    @BindView(R.id.post_linear_four)
    TextView postLinearFour;
    @BindView(R.id.post_linear)
    LinearLayout postLinear;
    @BindView(R.id.post_viewpager)
    ViewPager postViewpager;
    private List<Fragment> mList=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_post;
    }

    @Override
    protected void initListener() {
        postViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        postOne.setChecked(true);
                        postLinearOne.setVisibility(View.VISIBLE);
                        postLinearTwo.setVisibility(View.INVISIBLE);
                        postLinearThree.setVisibility(View.INVISIBLE);
                        postLinearFour.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        postTwo.setChecked(true);
                        postLinearOne.setVisibility(View.INVISIBLE);
                        postLinearTwo.setVisibility(View.VISIBLE);
                        postLinearThree.setVisibility(View.INVISIBLE);
                        postLinearFour.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        postThree.setChecked(true);
                        postLinearOne.setVisibility(View.INVISIBLE);
                        postLinearTwo.setVisibility(View.INVISIBLE);
                        postLinearThree.setVisibility(View.VISIBLE);
                        postLinearFour.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        postFour.setChecked(true);
                        postLinearOne.setVisibility(View.INVISIBLE);
                        postLinearTwo.setVisibility(View.INVISIBLE);
                        postLinearThree.setVisibility(View.INVISIBLE);
                        postLinearFour.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initView() {
        mList.add(new PostFragment());
        mList.add(new ReplayFragment());
        mList.add(new ReplayFragment());
        mList.add(new ReplayFragment());
        FragmentAdapter adapter=new FragmentAdapter(getSupportFragmentManager(),PostActivity.this,mList);
        postViewpager.setAdapter(adapter);
    }


    @OnClick({R.id.post_back, R.id.post_Release, R.id.post_one, R.id.post_two, R.id.post_three, R.id.post_four})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.post_back:
                onBackPressed();
                break;
            case R.id.post_Release:
                break;
            case R.id.post_one:
                postViewpager.setCurrentItem(0);
                postLinearOne.setVisibility(View.VISIBLE);
                postLinearTwo.setVisibility(View.INVISIBLE);
                postLinearThree.setVisibility(View.INVISIBLE);
                postLinearFour.setVisibility(View.INVISIBLE);
                break;
            case R.id.post_two:
                postViewpager.setCurrentItem(1);
                postLinearOne.setVisibility(View.INVISIBLE);
                postLinearTwo.setVisibility(View.VISIBLE);
                postLinearThree.setVisibility(View.INVISIBLE);
                postLinearFour.setVisibility(View.INVISIBLE);
                break;
            case R.id.post_three:
                postViewpager.setCurrentItem(2);
                postLinearOne.setVisibility(View.INVISIBLE);
                postLinearTwo.setVisibility(View.INVISIBLE);
                postLinearThree.setVisibility(View.VISIBLE);
                postLinearFour.setVisibility(View.INVISIBLE);
                break;
            case R.id.post_four:
                postViewpager.setCurrentItem(3);
                postLinearOne.setVisibility(View.INVISIBLE);
                postLinearTwo.setVisibility(View.INVISIBLE);
                postLinearThree.setVisibility(View.INVISIBLE);
                postLinearFour.setVisibility(View.VISIBLE);
                break;
        }
    }
}
