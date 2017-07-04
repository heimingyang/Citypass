package com.example.citypass.cotroller.fragment.information;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.information.Personal;
import com.example.citypass.model.bean.information.PersonalUp;
import com.example.citypass.model.biz.infor.IPersonalModel;
import com.example.citypass.model.biz.infor.PersonalModel;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LogUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.citypass.R.drawable.cancel;
import static com.example.citypass.R.drawable.login;
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
    private int sex=0;
    private Personal personal;
    private int id;

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
        id=intent.getIntExtra("id",0);
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
                Intent intent = new Intent(PersonalActivity.this,InforActivity.class);
                startActivity(intent);
                break;
            case R.id.personal_evaluate:
                break;
            case R.id.personal_guanzhu:
                Intent intentOne = new Intent(PersonalActivity.this,MailActivity.class);
                intentOne.putExtra("type",1);
                startActivityForResult(intentOne,200);
                break;
            case R.id.personal_fensi:
                Intent intentTwo = new Intent(PersonalActivity.this,MailActivity.class);
                intentTwo.putExtra("type",2);
                startActivityForResult(intentTwo,200);
                break;
            case R.id.personal_medal:
                Intent intent1=new Intent(PersonalActivity.this,PersonalTwoActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("bean",personal);
                intent1.putExtra("bundle",bundle);
                intent1.putExtra("type",1);
                intent1.putExtra("id",id);
                startActivity(intent1);
                break;
            case R.id.personal_gift:
                Intent intent2=new Intent(PersonalActivity.this,PersonalTwoActivity.class);
                Bundle bundle1=new Bundle();
                bundle1.putSerializable("bean",personal);
                intent2.putExtra("bundle",bundle1);
                intent2.putExtra("type",2);
                intent2.putExtra("id",id);
                startActivity(intent2);
                break;
            case R.id.personal_ziliao:
                Intent intent3=new Intent(PersonalActivity.this,PersonalTwoActivity.class);
                Bundle bundle2=new Bundle();
                bundle2.putSerializable("bean",personal);
                intent3.putExtra("bundle",bundle2);
                intent3.putExtra("type",3);
                intent3.putExtra("id",id);
                startActivity(intent3);
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
                new ShareAction(PersonalActivity.this).withText("hello")
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
                break;
            case R.id.personal_User:
                showPopupMenu(personalUser);
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
                personal = JSON.parseObject(result, Personal.class);
                int code = personal.getMessageList().getCode();
                if(code==1000){
                    setData(personal);
                }else {
                    return;
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
            sex=0;
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
            sex=1;
        }
        personalAddress.setText(per.getServerInfo().getAddress());
        personalIdentity.setText(per.getServerInfo().getHonorName());
        personalGuanzhu.setText("关注 "+per.getServerInfo().getFollowNum());
        personalFensi.setText("粉丝 "+per.getServerInfo().getFansNum());
        personalMedal.setText("勋章 "+per.getServerInfo().getMedalNum());
        personalGift.setText("礼物 "+per.getServerInfo().getGiftNum());

    }

    private void showPopupMenu(View view) {
        // View当前PopupMenu显示的相对View的位置
        PopupMenu popupMenu = new PopupMenu(this, view);
        // menu布局
        popupMenu.getMenuInflater().inflate(R.menu.personal_menu, popupMenu.getMenu());
        Menu menu = popupMenu.getMenu();
        setIconEnable(menu,true);
        // menu的item点击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId){
                    case R.id.ziliao_menu:
                        Intent intent=new Intent(PersonalActivity.this,InforActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.zaopian_menu:
                        break;
                }
                return false;
            }
        });
        // PopupMenu关闭事件
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
            }
        });
        popupMenu.show();
    }

    private void setIconEnable(Menu menu, boolean enable)
    {
        try
        {
            Class<?> clazz = Class.forName("com.android.internal.view.menu.MenuBuilder");
            Method m = clazz.getDeclaredMethod("setOptionalIconsVisible", boolean.class);
            m.setAccessible(true);

            //MenuBuilder实现Menu接口，创建菜单时，传进来的menu其实就是MenuBuilder对象(java的多态特征)
            m.invoke(menu, enable);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat","platform"+platform);

            Toast.makeText(PersonalActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(PersonalActivity.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if(t!=null){
                Log.d("throw","throw:"+t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(PersonalActivity.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };
}
