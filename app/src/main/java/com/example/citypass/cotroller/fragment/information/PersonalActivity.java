package com.example.citypass.cotroller.fragment.information;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.information.Personal;
import com.example.citypass.model.bean.information.PersonalUp;
import com.example.citypass.model.biz.infor.IPersonalModel;
import com.example.citypass.model.biz.infor.PersonalModel;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.citypass.utils.LoginUtils.USERID;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/25 21:28
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class PersonalActivity extends BaseActivity {
    @BindView(R.id.personal_Img)
    ImageView personalImg;
    @BindView(R.id.personal_Age)
    TextView personalAge;
    @BindView(R.id.personal_Address)
    TextView personalAddress;
    @BindView(R.id.personal_Level)
    TextView personalLevel;
    @BindView(R.id.personal_identity)
    TextView personalIdentity;
    @BindView(R.id.personal_evaluate)
    TextView personalEvaluate;
    @BindView(R.id.personal_guanzhu)
    TextView personalGuanzhu;
    @BindView(R.id.personal_fensi)
    TextView personalFensi;
    @BindView(R.id.personal_medal)
    TextView personalMedal;
    @BindView(R.id.personal_gift)
    TextView personalGift;
    @BindView(R.id.personal_ziliao)
    TextView personalZiliao;
    @BindView(R.id.personal_Relative)
    RelativeLayout personalRelative;
    @BindView(R.id.personal_RelativeTwo)
    RelativeLayout personalRelativeTwo;
    @BindView(R.id.personal_Text)
    TextView personalText;
    @BindView(R.id.personal_text_one)
    TextView personalTextOne;
    @BindView(R.id.personal_TextThree)
    TextView personalTextThree;
    @BindView(R.id.personal_TextFour)
    TextView personalTextFour;
    @BindView(R.id.personal_TextFive)
    TextView personalTextFive;
    @BindView(R.id.personal_TextSix)
    TextView personalTextSix;
    @BindView(R.id.personal_TextSeven)
    TextView personalTextSeven;
    @BindView(R.id.personal_TextEight)
    TextView personalTextEight;
    @BindView(R.id.personal_back)
    ImageView personalBack;
    @BindView(R.id.personal_Name)
    TextView personalName;
    @BindView(R.id.personal_Share)
    ImageView personalShare;
    @BindView(R.id.personal_User)
    ImageView personalUser;
    @BindView(R.id.personal_RelativeThree)
    RelativeLayout personalRelativeThree;
    @BindView(R.id.personal_Private_letter)
    TextView personalPrivateLetter;
    @BindView(R.id.personal_Gifts)
    TextView personalGifts;
    @BindView(R.id.personal_impression)
    TextView personalImpression;
    @BindView(R.id.personal_follow)
    TextView personalFollow;
    @BindView(R.id.personal_bottom)
    LinearLayout personalBottom;
    private PersonalModel model;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_homepage;
    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initData() {

    }

    private void initControl() {
        model=new IPersonalModel();
        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);
        getData(id);
    }

    @Override
    protected void initView() {
        initControl();
    }


    @OnClick({R.id.personal_Private_letter, R.id.personal_Gifts, R.id.personal_impression, R.id.personal_follow, R.id.personal_Img, R.id.personal_evaluate, R.id.personal_guanzhu, R.id.personal_fensi, R.id.personal_medal, R.id.personal_gift, R.id.personal_ziliao, R.id.personal_TextThree, R.id.personal_TextFour, R.id.personal_TextFive, R.id.personal_TextSix, R.id.personal_TextSeven, R.id.personal_TextEight, R.id.personal_back, R.id.personal_Share, R.id.personal_User})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_Private_letter:
                break;
            case R.id.personal_Gifts:
                break;
            case R.id.personal_impression:
                break;
            case R.id.personal_follow:
                break;
            case R.id.personal_Img:
                break;
            case R.id.personal_evaluate:
                break;
            case R.id.personal_guanzhu:
                break;
            case R.id.personal_fensi:
                break;
            case R.id.personal_medal:
                break;
            case R.id.personal_gift:
                break;
            case R.id.personal_ziliao:
                break;
            case R.id.personal_TextThree:
                break;
            case R.id.personal_TextFour:
                break;
            case R.id.personal_TextFive:
                break;
            case R.id.personal_TextSix:
                break;
            case R.id.personal_TextSeven:
                break;
            case R.id.personal_TextEight:
                break;
            case R.id.personal_back:
                onBackPressed();
                break;
            case R.id.personal_Share:
                break;
            case R.id.personal_User:
                break;
        }
    }
    private String getPersonal(int id){
        PersonalUp per=new PersonalUp();
        per.setCustomerID(8001);
        per.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"));
        per.setMethod("PHSocket_GetUser_Info");
        per.setCustomerKey("D5607EBE573BE2B59A4D5A1CAE882615");
        per.setAppName("CcooCity");
        per.setVersion("4.5");
        PersonalUp.ParamBean paramBean=new PersonalUp.ParamBean();
        paramBean.setUSiteId(LoginUtils.information.getServerInfo().getSiteID());
        paramBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));
        paramBean.setTouserid(id);
        per.setParam(paramBean);
        PersonalUp.StatisBean statisBean=new PersonalUp.StatisBean();
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("+86"+LoginUtils.information.getServerInfo().getTel());
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(USERID,"")));
        statisBean.setSiteId(LoginUtils.information.getServerInfo().getSiteID());
        String  model= android.os.Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion+"");
        per.setStatis(statisBean);
        String s = JSON.toJSONString(per);
        return s;
    }

    private void getData(int id){
        model.getPersonal(getPersonal(id), new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Personal personal = JSON.parseObject(result, Personal.class);
                int code = personal.getMessageList().getCode();
                if(code==1000){
                    setData(personal);
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    private void setData(Personal per){
        personalName.setText(per.getServerInfo().getUserNick());
        HttpFacory.create().loadImage(per.getServerInfo().getUserFace(),personalImg,true);
        int level = Integer.parseInt(per.getServerInfo().getLevel());
        if(level<=10) {
            personalLevel.setBackgroundResource(R.drawable.di_naonao_recycle_item_level);
        }else if(level<=20&&level>10){
            personalLevel.setBackgroundResource(R.drawable.task_mylevel_bg2);
        }else if(level<=30&&level>20){
            personalLevel.setBackgroundResource(R.drawable.task_mylevel_bg3);
        }
        personalLevel.setText("Lv."+level);
        String gender = per.getServerInfo().getGender();
        if(gender.equals("男")) {
            personalAge.setText(per.getServerInfo().getAge());
        }else{
            personalRelative.setBackgroundResource(R.drawable.girl_top_bg);
            personalRelativeTwo.setBackgroundResource(R.drawable.girl_bottom_bg);
            personalUser.setVisibility(View.GONE);
            personalBottom.setVisibility(View.VISIBLE);
            personalTextThree.setText("美女秀—晒美照，秀自我，同城互动交友");
            Drawable draw=getResources().getDrawable(R.drawable.ccoo_icon_girl1);
            draw.setBounds( 0 ,  0 , draw.getMinimumWidth(), draw.getMinimumHeight());
            personalAge.setCompoundDrawables(draw,null,null,null);
            personalAge.setText(per.getServerInfo().getAge());
            personalAge.setBackgroundResource(R.color.colorAccent);
        }
        personalAddress.setText(per.getServerInfo().getAddress());
        personalIdentity.setText(per.getServerInfo().getHonorName());
        personalGuanzhu.setText("关注 "+per.getServerInfo().getFollowNum());
        personalFensi.setText("粉丝 "+per.getServerInfo().getFansNum());
        personalMedal.setText("勋章 "+per.getServerInfo().getMedalNum());
        personalGift.setText("礼物 "+per.getServerInfo().getGiftNum());



    }
}
