package com.example.citypass.cotroller.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述: 意见反馈页面
 * 创建人: 马杰
 * 创建时间: 2017/6/21 19:31
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class FeedBackActivity extends BaseActivity {
    @BindView(R.id.feedback_back)
    ImageView feedbackBack;
    @BindView(R.id.feedback_Relative)
    RelativeLayout feedbackRelative;
    @BindView(R.id.feedback_phone)
    EditText feedbackPhone;
    @BindView(R.id.feedback_order)
    EditText feedbackOrder;
    @BindView(R.id.feedback_feed)
    Button feedbackFeed;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feedback;
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


    @OnClick({R.id.feedback_back, R.id.feedback_feed})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.feedback_back:
                onBackPressed();
                break;
            case R.id.feedback_feed:
                break;
        }
    }
}
