package com.example.citypass.cotroller.fragment.information;

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
import com.example.citypass.cotroller.adapter.life.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/3 14:42
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ExchangeActivity extends BaseActivity {
    @BindView(R.id.hang_back)
    ImageView hangBack;
    @BindView(R.id.hang_Relative)
    RelativeLayout hangRelative;
    @BindView(R.id.change_one)
    RadioButton changeOne;
    @BindView(R.id.change_two)
    RadioButton changeTwo;
    @BindView(R.id.change_three)
    RadioButton changeThree;
    @BindView(R.id.change_four)
    RadioButton changeFour;
    @BindView(R.id.change_group)
    RadioGroup changeGroup;
    @BindView(R.id.change_one_text)
    TextView changeOneText;
    @BindView(R.id.change_two_text)
    TextView changeTwoText;
    @BindView(R.id.change_three_text)
    TextView changeThreeText;
    @BindView(R.id.change_four_text)
    TextView changeFourText;
    @BindView(R.id.change_viewpage)
    ViewPager changeViewpage;
    private List<Fragment> mList=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_exchange;
    }

    @Override
    protected void initListener() {
        changeViewpage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    changeOne.setChecked(true);
                    changeOneText.setVisibility(View.VISIBLE);
                    changeTwoText.setVisibility(View.INVISIBLE);
                    changeThreeText.setVisibility(View.INVISIBLE);
                    changeFourText.setVisibility(View.INVISIBLE);
                }else if(position==1){
                    changeTwo.setChecked(true);
                    changeOneText.setVisibility(View.INVISIBLE);
                    changeTwoText.setVisibility(View.VISIBLE);
                    changeThreeText.setVisibility(View.INVISIBLE);
                    changeFourText.setVisibility(View.INVISIBLE);
                }else if(position==2){
                    changeThree.setChecked(true);
                    changeOneText.setVisibility(View.INVISIBLE);
                    changeTwoText.setVisibility(View.INVISIBLE);
                    changeThreeText.setVisibility(View.VISIBLE);
                    changeFourText.setVisibility(View.INVISIBLE);
                }else if(position==3){
                    changeFour.setChecked(true);
                    changeOneText.setVisibility(View.INVISIBLE);
                    changeTwoText.setVisibility(View.INVISIBLE);
                    changeThreeText.setVisibility(View.INVISIBLE);
                    changeFourText.setVisibility(View.VISIBLE);
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
        GongFragment gongOne=new GongFragment();
        GongFragment gongTwo=new GongFragment();
        GongFragment gongThree=new GongFragment();
        GongFragment gongFour=new GongFragment();
        mList.add(gongOne);
        mList.add(gongTwo);
        mList.add(gongThree);
        mList.add(gongFour);
        FragmentAdapter adapter=new FragmentAdapter(getSupportFragmentManager(),ExchangeActivity.this,mList);
        changeViewpage.setAdapter(adapter);
    }


    @OnClick({R.id.hang_back, R.id.change_one, R.id.change_two, R.id.change_three, R.id.change_four})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hang_back:
                onBackPressed();
                break;
            case R.id.change_one:
                changeViewpage.setCurrentItem(0);
                changeOneText.setVisibility(View.VISIBLE);
                changeTwoText.setVisibility(View.INVISIBLE);
                changeThreeText.setVisibility(View.INVISIBLE);
                changeFourText.setVisibility(View.INVISIBLE);
                break;
            case R.id.change_two:
                changeViewpage.setCurrentItem(1);
                changeOneText.setVisibility(View.INVISIBLE);
                changeTwoText.setVisibility(View.VISIBLE);
                changeThreeText.setVisibility(View.INVISIBLE);
                changeFourText.setVisibility(View.INVISIBLE);
                break;
            case R.id.change_three:
                changeViewpage.setCurrentItem(2);
                changeOneText.setVisibility(View.INVISIBLE);
                changeTwoText.setVisibility(View.INVISIBLE);
                changeThreeText.setVisibility(View.VISIBLE);
                changeFourText.setVisibility(View.INVISIBLE);
                break;
            case R.id.change_four:
                changeViewpage.setCurrentItem(3);
                changeOneText.setVisibility(View.INVISIBLE);
                changeTwoText.setVisibility(View.INVISIBLE);
                changeThreeText.setVisibility(View.INVISIBLE);
                changeFourText.setVisibility(View.VISIBLE);
                break;
        }
    }
}
