package com.example.citypass.cotroller.fragment.information;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.model.bean.information.Personal;
import com.example.citypass.model.http.HttpFacory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/28 15:14
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class PersonalTwoActivity extends BaseActivity {
    @BindView(R.id.personalOne_Private_letter)
    TextView personalOnePrivateLetter;
    @BindView(R.id.personalOne_Gifts)
    TextView personalOneGifts;
    @BindView(R.id.personalOne_impression)
    TextView personalOneImpression;
    @BindView(R.id.personalOne_follow)
    TextView personalOneFollow;
    @BindView(R.id.personalOne_bottom)
    LinearLayout personalOneBottom;
    @BindView(R.id.personalOne_Img)
    ImageView personalOneImg;
    @BindView(R.id.personalOne_Age)
    TextView personalOneAge;
    @BindView(R.id.personalOne_Address)
    TextView personalOneAddress;
    @BindView(R.id.personalOne_Level)
    TextView personalOneLevel;
    @BindView(R.id.personalOne_identity)
    TextView personalOneIdentity;
    @BindView(R.id.personalOne_evaluate)
    TextView personalOneEvaluate;
    @BindView(R.id.personalOne_guanzhu)
    TextView personalOneGuanzhu;
    @BindView(R.id.personalOne_fensi)
    TextView personalOneFensi;
    @BindView(R.id.personalOne_medal)
    TextView personalOneMedal;
    @BindView(R.id.personalOne_gift)
    TextView personalOneGift;
    @BindView(R.id.personalOne_ziliao)
    TextView personalOneZiliao;
    @BindView(R.id.personalOne_Relative)
    RelativeLayout personalOneRelative;
    @BindView(R.id.personal_frame_name)
    TextView personalFrameName;
    @BindView(R.id.personalOne_RelativeTwo)
    RelativeLayout personalOneRelativeTwo;
    @BindView(R.id.personalOne_frame)
    FrameLayout personalOneFrame;
    @BindView(R.id.personalOne_back)
    ImageView personalOneBack;
    @BindView(R.id.personalOne_Name)
    TextView personalOneName;
    @BindView(R.id.personalOne_Share)
    ImageView personalOneShare;
    @BindView(R.id.personalOne_User)
    ImageView personalOneUser;
    @BindView(R.id.personalOne_RelativeThree)
    RelativeLayout personalOneRelativeThree;
    private int sex=0;
    private BaseFragment lastFragment;
    private ModelFragment model;
    private LifesFragment lifes;
    private InformationTwoFragment infor;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_fram;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent=getIntent();
        int type = intent.getIntExtra("type", 1);
        Bundle bundle = intent.getBundleExtra("bundle");
        Personal per= (Personal) bundle.getSerializable("bean");
        setData(per);
        setFragment(type);
    }

    private void setFragment(int type){
        if(type==1){
           personalFrameName.setText("勋章");
            if(model==null) {
                model = new ModelFragment();
            }
            startFragment(model,false);
        }else if(type==2){
            personalFrameName.setText("礼物");
            if(lifes==null) {
                lifes = new LifesFragment();
            }
            startFragment(lifes,false);
        }else if(type==3){
            personalFrameName.setText("资料");
            if(infor==null) {
                infor = new InformationTwoFragment();
            }
            startFragment(infor,false);
        }
    }


    @OnClick({R.id.personalOne_Private_letter, R.id.personalOne_Gifts, R.id.personalOne_impression, R.id.personalOne_follow, R.id.personalOne_Img, R.id.personalOne_guanzhu, R.id.personalOne_fensi, R.id.personalOne_medal, R.id.personalOne_gift, R.id.personalOne_ziliao, R.id.personalOne_back, R.id.personalOne_Share, R.id.personalOne_User})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personalOne_Private_letter:
                break;
            case R.id.personalOne_Gifts:
                break;
            case R.id.personalOne_impression:
                break;
            case R.id.personalOne_follow:
                break;
            case R.id.personalOne_Img:
                Intent intent = new Intent(PersonalTwoActivity.this,InforActivity.class);
                startActivity(intent);
                break;
            case R.id.personalOne_guanzhu:
                Intent intentOne = new Intent(PersonalTwoActivity.this,MailActivity.class);
                intentOne.putExtra("type",1);
                startActivityForResult(intentOne,200);
                break;
            case R.id.personalOne_fensi:
                Intent intentTwo = new Intent(PersonalTwoActivity.this,MailActivity.class);
                intentTwo.putExtra("type",2);
                startActivityForResult(intentTwo,200);
                break;
            case R.id.personalOne_medal:
                personalFrameName.setText("勋章");
                if(model==null) {
                    model = new ModelFragment();
                }
                startFragment(model,false);
                break;
            case R.id.personalOne_gift:
                personalFrameName.setText("礼物");
                if(lifes==null) {
                    lifes = new LifesFragment();
                }
                startFragment(lifes,false);
                break;
            case R.id.personalOne_ziliao:
                personalFrameName.setText("资料");
                if(infor==null) {
                    infor = new InformationTwoFragment();
                }
                startFragment(infor,false);
                break;
            case R.id.personalOne_back:
                onBackPressed();
                break;
            case R.id.personalOne_Share:
                break;
            case R.id.personalOne_User:
                break;
        }
    }

    private void setData(Personal per){
        personalOneName.setText(per.getServerInfo().getUserNick());
        HttpFacory.create().loadImage(per.getServerInfo().getUserFace(),personalOneImg,true);
        int level = Integer.parseInt(per.getServerInfo().getLevel());
        if(level<=10) {
            personalOneLevel.setBackgroundResource(R.drawable.di_naonao_recycle_item_level);
        }else if(level<=20&&level>10){
            personalOneLevel.setBackgroundResource(R.drawable.task_mylevel_bg2);
        }else if(level<=30&&level>20){
            personalOneLevel.setBackgroundResource(R.drawable.task_mylevel_bg3);
        }
        personalOneLevel.setText("Lv."+level);
        String gender = per.getServerInfo().getGender();
        if(gender.equals("男")) {
            personalOneAge.setText(per.getServerInfo().getAge());
            sex=0;
        }else{
            personalOneRelative.setBackgroundResource(R.drawable.girl_top_bg);
            personalOneRelativeTwo.setBackgroundResource(R.drawable.girl_bottom_bg);
            personalOneUser.setVisibility(View.GONE);
            personalOneBottom.setVisibility(View.VISIBLE);
            Drawable draw=getResources().getDrawable(R.drawable.ccoo_icon_girl1);
            draw.setBounds( 0 ,  0 , draw.getMinimumWidth(), draw.getMinimumHeight());
            personalOneAge.setCompoundDrawables(draw,null,null,null);
            personalOneAge.setText(per.getServerInfo().getAge());
            personalOneAge.setBackgroundResource(R.color.colorAccent);
            sex=1;
        }
        personalOneAddress.setText(per.getServerInfo().getAddress());
        personalOneIdentity.setText(per.getServerInfo().getHonorName());
        personalOneGuanzhu.setText("关注 "+per.getServerInfo().getFollowNum());
        personalOneFensi.setText("粉丝 "+per.getServerInfo().getFansNum());
        personalOneMedal.setText("勋章 "+per.getServerInfo().getMedalNum());
        personalOneGift.setText("礼物 "+per.getServerInfo().getGiftNum());
    }

    public void startFragment(BaseFragment targetFragment, boolean isBack){

        if(targetFragment == null)
            return;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();


        //隐藏上一个fragment
        if(lastFragment != null)
            transaction.hide(lastFragment);

        //判断是否已经添加 如果没有添加过就添加
        if(!targetFragment.isAdded())
            transaction.add(R.id.personalOne_frame,targetFragment, targetFragment.getClass().getSimpleName());

        //已经添加就调用show方法显示
        transaction.show(targetFragment);

        //添加到回退栈
        if (isBack)
            transaction.addToBackStack(null);

        transaction.commit();

        //记录上一个fragment
        lastFragment = targetFragment;
    }
}
