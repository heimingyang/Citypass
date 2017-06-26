package com.example.citypass.cotroller;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/26 11:29
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class NotifyActivity extends BaseActivity {
    @BindView(R.id.notification_back)
    ImageView notificationBack;
    @BindView(R.id.notification_imgOne)
    ImageView notificationImgOne;
    @BindView(R.id.notification_Relative)
    RelativeLayout notificationRelative;
    @BindView(R.id.notification_Imgs)
    ImageView notificationImgs;
    @BindView(R.id.notification_Text_One)
    TextView notificationTextOne;
    @BindView(R.id.notification_Text_ones)
    TextView notificationTextOnes;
    @BindView(R.id.notification_Btn_One)
    RelativeLayout notificationBtnOne;
    @BindView(R.id.notification_Imgss)
    ImageView notificationImgss;
    @BindView(R.id.notification_Text_Twos)
    TextView notificationTextTwoss;
    @BindView(R.id.notification_Text_twos)
    TextView notificationTextTwos;
    @BindView(R.id.notification_Btn_Two)
    RelativeLayout notificationBtnTwo;
    @BindView(R.id.notification_Imgsss)
    ImageView notificationImgsss;
    @BindView(R.id.notification_Text_Threes)
    TextView notificationTextThreess;
    @BindView(R.id.notification_Text_threes)
    TextView notificationTextThrees;
    @BindView(R.id.notification_Btn_Three)
    RelativeLayout notificationBtnThree;
    @BindView(R.id.notification_Imgssss)
    ImageView notificationImgssss;
    @BindView(R.id.notification_Text_Fours)
    TextView notificationTextFourss;
    @BindView(R.id.notification_Text_fours)
    TextView notificationTextFours;
    @BindView(R.id.notification_Btn_Four)
    RelativeLayout notificationBtnFour;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_notification;
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


    @OnClick({R.id.notification_back, R.id.notification_imgOne, R.id.notification_Btn_One, R.id.notification_Btn_Two, R.id.notification_Btn_Three, R.id.notification_Btn_Four})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.notification_back:
                onBackPressed();
                break;
            case R.id.notification_imgOne:
                break;
            case R.id.notification_Btn_One:
                break;
            case R.id.notification_Btn_Two:
                break;
            case R.id.notification_Btn_Three:
                break;
            case R.id.notification_Btn_Four:
                break;
        }
    }
}
