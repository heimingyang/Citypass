package com.example.citypass.cotroller.fragment.information;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.life.IssueApdater;
import com.example.citypass.utils.LoginUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/3 19:39
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IssuePostActivity extends BaseActivity {
    @BindView(R.id.issue_back)
    ImageView issueBack;
    @BindView(R.id.issue_post)
    TextView issuePost;
    @BindView(R.id.issue_Relative)
    RelativeLayout issueRelative;
    @BindView(R.id.issue_Section)
    TextView issueSection;
    @BindView(R.id.issue_Title)
    EditText issueTitle;
    @BindView(R.id.issue_imgOne)
    ImageView issueImgOne;
    @BindView(R.id.issue_imgTwo)
    ImageView issueImgTwo;
    @BindView(R.id.issue_imgThree)
    ImageView issueImgThree;
    @BindView(R.id.issue_imgFour)
    ImageView issueImgFour;
    @BindView(R.id.issue_imgFive)
    ImageView issueImgFive;
    @BindView(R.id.issue_RelativeTwo)
    RelativeLayout issueRelativeTwo;
    @BindView(R.id.issue_delete)
    ImageView issueDelete;
    @BindView(R.id.issue_RelativeOne)
    RelativeLayout issueRelativeOne;
    @BindView(R.id.issue_order)
    EditText issueOrder;
    @BindView(R.id.issue_post_Relative)
    RelativeLayout issuePostRelative;
    @BindView(R.id.issue_viewpager)
    ViewPager issueViewpager;
    @BindView(R.id.issue_radio_one)
    RadioButton issueRadioOne;
    @BindView(R.id.issue_radio_two)
    RadioButton issueRadioTwo;
    @BindView(R.id.issue_radio_three)
    RadioButton issueRadioThree;
    @BindView(R.id.issue_add_biaoqing)
    ImageView issueAddBiaoqing;
    @BindView(R.id.issue_biaoqingOne)
    TextView issueBiaoqingOne;
    @BindView(R.id.issue_bottom_Linear)
    LinearLayout issueBottomLinear;
    @BindView(R.id.issue_RelativeThree)
    RelativeLayout issueRelativeThree;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_post_issue;
    }

    @Override
    protected void initListener() {
        issueViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    issueRadioOne.setChecked(true);
                }else if(position==1){
                    issueRadioTwo.setChecked(true);
                }else if(position==2){
                    issueRadioThree.setChecked(true);
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

    }


    @OnClick({R.id.issue_back, R.id.issue_post, R.id.issue_Section, R.id.issue_imgOne, R.id.issue_imgTwo, R.id.issue_imgThree, R.id.issue_imgFour, R.id.issue_imgFive, R.id.issue_RelativeOne, R.id.issue_delete,R.id.issue_radio_one, R.id.issue_radio_two, R.id.issue_radio_three, R.id.issue_add_biaoqing, R.id.issue_biaoqingOne})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.issue_back:
                onBackPressed();
                break;
            case R.id.issue_post:
                break;
            case R.id.issue_Section:
                break;
            case R.id.issue_imgOne:
                setBottmView();
                break;
            case R.id.issue_imgTwo:
                break;
            case R.id.issue_imgThree:
                break;
            case R.id.issue_imgFour:
                int level = LoginUtils.information.getServerInfo().getLevel();
                if (level >= 13) {

                } else {
                    Toast.makeText(IssuePostActivity.this, "lv.13及以上等级用户才能发投票贴", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.issue_imgFive:
                break;
            case R.id.issue_RelativeOne:
                break;
            case R.id.issue_delete:
                issueRelativeOne.setVisibility(View.INVISIBLE);
                break;
            case R.id.issue_radio_one:
                issueViewpager.setCurrentItem(0);
                break;
            case R.id.issue_radio_two:
                issueViewpager.setCurrentItem(1);
                break;
            case R.id.issue_radio_three:
                issueViewpager.setCurrentItem(2);
                break;
            case R.id.issue_add_biaoqing:
                break;
            case R.id.issue_biaoqingOne:
                break;
        }
    }

    private void setBottmView() {
        issueRelativeThree.setVisibility(View.VISIBLE);
        IssueApdater apdater=new IssueApdater(IssuePostActivity.this);
        issueViewpager.setAdapter(apdater);
    }

    private void showPopwindow() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(0, null);
        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        window.setBackgroundDrawable(dw);
        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.Animation);
        window.setOutsideTouchable(true);
        // 在底部显示
        window.showAtLocation(IssuePostActivity.this.findViewById(R.id.start),
                Gravity.BOTTOM, 0, 0);

    }
}
