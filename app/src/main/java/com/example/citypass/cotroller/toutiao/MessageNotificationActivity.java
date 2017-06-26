package com.example.citypass.cotroller.toutiao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageNotificationActivity extends BaseActivity {

    @BindView(R.id.hmn_back)
    ImageView hmnBack;
    @BindView(R.id.hmn_mail)
    ImageView hmnMail;
    @BindView(R.id.hmn_title)
    RelativeLayout hmnTitle;
    @BindView(R.id.hmn_img1)
    ImageView hmnImg1;
    @BindView(R.id.hmn_lin1)
    RelativeLayout hmnLin1;
    @BindView(R.id.hmn_img2)
    ImageView hmnImg2;
    @BindView(R.id.hmn_lin2)
    RelativeLayout hmnLin2;
    @BindView(R.id.hmn_img3)
    ImageView hmnImg3;
    @BindView(R.id.hmn_lin3)
    RelativeLayout hmnLin3;
    @BindView(R.id.hmn_img4)
    ImageView hmnImg4;
    @BindView(R.id.hmn_lin4)
    RelativeLayout hmnLin4;
    @BindView(R.id.activity_message_notification)
    RelativeLayout activityMessageNotification;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message_notification;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.hmn_back, R.id.hmn_mail})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hmn_back:
                finish();
                break;
            case R.id.hmn_mail:
                Intent intent=new Intent(this,MaillistActivity.class);
                startActivity(intent);
                break;
        }
    }
}
