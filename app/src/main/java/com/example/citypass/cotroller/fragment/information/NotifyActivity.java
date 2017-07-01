package com.example.citypass.cotroller.fragment.information;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.information.GetNotify;
import com.example.citypass.model.bean.information.Notify;
import com.example.citypass.model.biz.infor.IMedalModel;
import com.example.citypass.model.biz.infor.MedaModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.string.no;

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
    private MedaModel model;

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
        model=new IMedalModel();
        Notify notify=new Notify();
        notify.setUserid(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));
        notify.setSiteid(LoginUtils.information.getServerInfo().getSiteID());
        String param = LoginUtils.getParam(notify, "PHSocket_GetMsg_HomeList");
        model.getMedal(param, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                GetNotify notify1= JSON.parseObject(result,GetNotify.class);
                int code = notify1.getMessageList().getCode();
                if(code==1000){
                    notificationTextOnes.setText(notify1.getServerInfo().getTop7().get(0).getTitle1());
                    notificationTextTwos.setText(notify1.getServerInfo().getTop7().get(0).getTitle2());
                    notificationTextThrees.setText(notify1.getServerInfo().getTop7().get(0).getTitle3());
                    notificationTextFours.setText(notify1.getServerInfo().getTop7().get(0).getTitle7());
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }


    @OnClick({R.id.notification_back, R.id.notification_imgOne, R.id.notification_Btn_One, R.id.notification_Btn_Two, R.id.notification_Btn_Three, R.id.notification_Btn_Four})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.notification_back:
                onBackPressed();
                break;
            case R.id.notification_imgOne:
                Intent intent=new Intent(NotifyActivity.this,MailActivity.class);
                startActivity(intent);
                break;
            case R.id.notification_Btn_One:
                start("精彩推荐","PHSocket_GetRecommandDataList");
                break;
            case R.id.notification_Btn_Two:
                start("系统通知","PHSocket_GetUserSysMsgDataList");
                break;
            case R.id.notification_Btn_Three:
                start("好友动态","PHSocket_GetFriendDynamicList");
                break;
            case R.id.notification_Btn_Four:
                start("谁看过我","PHSocket_GetUserMsgVisitorList");
                break;
        }
    }
    private void start(String title,String str){
        Intent intent=new Intent(NotifyActivity.this,NotifyDeatailActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("str",str);
        startActivity(intent);
    }
}
