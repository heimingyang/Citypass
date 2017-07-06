package com.example.citypass.cotroller.fragment.information;

import android.content.Intent;
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
 * 类描述: 消费排行榜
 * 创建人: 马杰
 * 创建时间: 2017/7/3 14:04
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class GongActivity extends BaseActivity {
    @BindView(R.id.hang_back)
    ImageView hangBack;
    @BindView(R.id.hang_Relative)
    RelativeLayout hangRelative;
    @BindView(R.id.hang_Linear_TextOne)
    RelativeLayout hangLinearTextOne;
    @BindView(R.id.shopping_Linear_TextTwo)
    RelativeLayout shoppingLinearTextTwo;
    @BindView(R.id.hang_Linear)
    LinearLayout hangLinear;
    @BindView(R.id.hang_one)
    RadioButton hangOne;
    @BindView(R.id.hang_two)
    RadioButton hangTwo;
    @BindView(R.id.hang_three)
    RadioButton hangThree;
    @BindView(R.id.hang_group)
    RadioGroup hangGroup;
    @BindView(R.id.hang_one_text)
    TextView hangOneText;
    @BindView(R.id.hang_two_text)
    TextView hangTwoText;
    @BindView(R.id.hang_three_text)
    TextView hangThreeText;
    @BindView(R.id.hang_viewpag)
    ViewPager hangViewpag;
    private List<Fragment> mList=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gong;
    }

    @Override
    protected void initListener() {
        hangViewpag.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    hangOne.setChecked(true);
                    hangOneText.setVisibility(View.VISIBLE);
                    hangTwoText.setVisibility(View.INVISIBLE);
                    hangThreeText.setVisibility(View.INVISIBLE);
                }else if(position==1){
                    hangTwo.setChecked(true);
                    hangOneText.setVisibility(View.INVISIBLE);
                    hangTwoText.setVisibility(View.VISIBLE);
                    hangThreeText.setVisibility(View.INVISIBLE);
                }else if(position==2){
                    hangThree.setChecked(true);
                    hangOneText.setVisibility(View.INVISIBLE);
                    hangTwoText.setVisibility(View.INVISIBLE);
                    hangThreeText.setVisibility(View.VISIBLE);
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
        mList.add(gongOne);
        mList.add(gongTwo);
        mList.add(gongThree);
        FragmentAdapter adapter=new FragmentAdapter(getSupportFragmentManager(),GongActivity.this,mList);
        hangViewpag.setAdapter(adapter);
    }


    @OnClick({R.id.hang_back, R.id.hang_Linear_TextOne, R.id.shopping_Linear_TextTwo, R.id.hang_one, R.id.hang_two, R.id.hang_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hang_back:
                onBackPressed();
                break;
            case R.id.hang_Linear_TextOne:
                Intent intent=new Intent(GongActivity.this,ExchangeActivity.class);
                startActivity(intent);
                break;
            case R.id.shopping_Linear_TextTwo:
                Intent intentOne=new Intent(GongActivity.this,ExchangeActivity.class);
                startActivity(intentOne);
                break;
            case R.id.hang_one:
                hangViewpag.setCurrentItem(0);
                hangOneText.setVisibility(View.VISIBLE);
                hangTwoText.setVisibility(View.INVISIBLE);
                hangThreeText.setVisibility(View.INVISIBLE);
                break;
            case R.id.hang_two:
                hangViewpag.setCurrentItem(1);
                hangOneText.setVisibility(View.INVISIBLE);
                hangTwoText.setVisibility(View.VISIBLE);
                hangThreeText.setVisibility(View.INVISIBLE);
                break;
            case R.id.hang_three:
                hangViewpag.setCurrentItem(2);
                hangOneText.setVisibility(View.INVISIBLE);
                hangTwoText.setVisibility(View.INVISIBLE);
                hangThreeText.setVisibility(View.VISIBLE);
                break;
        }
    }
}
