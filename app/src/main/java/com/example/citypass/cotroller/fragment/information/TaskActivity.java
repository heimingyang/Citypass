package com.example.citypass.cotroller.fragment.information;

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
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述: 任务页面
 * 创建人: 马杰
 * 创建时间: 2017/6/27 16:13
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class TaskActivity extends BaseActivity {
    @BindView(R.id.task_back)
    ImageView taskBack;
    @BindView(R.id.task_Relative)
    RelativeLayout taskRelative;
    @BindView(R.id.task_RelativeOne)
    RelativeLayout taskRelativeOne;
    @BindView(R.id.task_radio_One)
    RadioButton taskRadioOne;
    @BindView(R.id.task_radio_Two)
    RadioButton taskRadioTwo;
    @BindView(R.id.task_Radio)
    RadioGroup taskRadio;
    @BindView(R.id.task_Text_num)
    TextView taskTextNum;
    @BindView(R.id.task_text_one)
    TextView taskTextOne;
    @BindView(R.id.task_text_two)
    TextView taskTextTwo;
    @BindView(R.id.task_Linear)
    LinearLayout taskLinear;
    @BindView(R.id.task_Viewpager)
    ViewPager taskViewpager;
    private List<Fragment> mList=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_task;
    }

    @Override
    protected void initListener() {
        taskViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    taskRadioOne.setChecked(true);
                    taskTextOne.setVisibility(View.VISIBLE);
                    taskTextTwo.setVisibility(View.INVISIBLE);
                }else if(position==1){
                    taskRadioTwo.setChecked(true);
                    taskTextOne.setVisibility(View.INVISIBLE);
                    taskTextTwo.setVisibility(View.VISIBLE);
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
        TaskOneFragment fragmentOne=new TaskOneFragment();
        fragmentOne.setProperty(1);
        TaskOneFragment fragmentTwo=new TaskOneFragment();
        fragmentTwo.setProperty(0);
        mList.add(fragmentOne);
        mList.add(fragmentTwo);
        FragmentAdapter adapter=new FragmentAdapter(getSupportFragmentManager(),TaskActivity.this,mList);
        taskViewpager.setAdapter(adapter);
    }


    @OnClick({R.id.task_back, R.id.task_radio_One, R.id.task_radio_Two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.task_back:
                onBackPressed();
                break;
            case R.id.task_radio_One:
                taskViewpager.setCurrentItem(0);
                taskTextOne.setVisibility(View.VISIBLE);
                taskTextTwo.setVisibility(View.INVISIBLE);
                break;
            case R.id.task_radio_Two:
                taskViewpager.setCurrentItem(1);
                taskTextOne.setVisibility(View.INVISIBLE);
                taskTextTwo.setVisibility(View.VISIBLE);
                break;
        }
    }
}
