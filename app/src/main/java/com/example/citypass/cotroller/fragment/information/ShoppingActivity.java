package com.example.citypass.cotroller.fragment.information;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.HomeAdapter;
import com.example.citypass.cotroller.adapter.life.ShopViewAdapter;
import com.example.citypass.model.bean.information.Guangbo;
import com.example.citypass.model.bean.information.Shop;
import com.example.citypass.model.bean.information.TextParam;
import com.example.citypass.model.biz.infor.IMedalModel;
import com.example.citypass.model.biz.infor.MedaModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.example.citypass.view.Mylistview;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.mode;
import static com.example.citypass.R.id.view;
import static com.umeng.socialize.utils.ContextUtil.getContext;

/**
 * 项目名称: 血压卫士
 * 类描述: 简单的商城（只是页面）
 * 创建人: 马杰
 * 创建时间: 2017/6/29 10:38
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ShoppingActivity extends BaseActivity {
    @BindView(R.id.shopping_back)
    ImageView shoppingBack;
    @BindView(R.id.shopping_Relative)
    RelativeLayout shoppingRelative;
    @BindView(R.id.shopping_Linear_TextOne)
    RelativeLayout shoppingLinearTextOne;
    @BindView(R.id.shopping_Linear_TextTwo)
    RelativeLayout shoppingLinearTextTwo;
    @BindView(R.id.shopping_Linear)
    LinearLayout shoppingLinear;
    @BindView(R.id.shopping_rollpager)
    RollPagerView shoppingRollpager;
    @BindView(R.id.shopping_guangbo)
    TextView shoppingGuangbo;
    @BindView(R.id.shopping_paihang)
    TextView shoppingPaihang;
    @BindView(R.id.shopping_RelativeOne)
    RelativeLayout shoppingRelativeOne;
    @BindView(R.id.shopping_tuijian)
    TextView shoppingTuijian;
    @BindView(R.id.shopping_tuijian_list)
    Mylistview shoppingTuijianList;
    @BindView(R.id.shopping_all)
    TextView shoppingAll;
    @BindView(R.id.shopping_ButtonOne)
    RadioButton shoppingButtonOne;
    @BindView(R.id.shopping_ButtonTwo)
    RadioButton shoppingButtonTwo;
    @BindView(R.id.shopping_ButtonThree)
    RadioButton shoppingButtonThree;
    @BindView(R.id.shopping_RadioGroup)
    RadioGroup shoppingRadioGroup;
    @BindView(R.id.shopping_ButtonOne_text)
    TextView shoppingButtonOneText;
    @BindView(R.id.shopping_ButtonTwo_text)
    TextView shoppingButtonTwoText;
    @BindView(R.id.shopping_ButtonThree_text)
    TextView shoppingButtonThreeText;
    @BindView(R.id.shopping_Viewpager)
    ViewPager shoppingViewpager;
    private List<Fragment> mList=new ArrayList<>();
    private List<Guangbo.ServerInfoBean.OrderListBean.ContentBean> mStrList;
    private MedaModel model;
    private int a=0;
    private ObjectAnimator invisToVis;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shopping;
    }

    @Override
    protected void initListener() {
        shoppingViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    shoppingButtonOne.setChecked(true);
                    shoppingButtonOneText.setVisibility(View.VISIBLE);
                    shoppingButtonTwoText.setVisibility(View.INVISIBLE);
                    shoppingButtonThreeText.setVisibility(View.INVISIBLE);
                }else if(position==1){
                    shoppingButtonTwo.setChecked(true);
                    shoppingButtonOneText.setVisibility(View.INVISIBLE);
                    shoppingButtonTwoText.setVisibility(View.VISIBLE);
                    shoppingButtonThreeText.setVisibility(View.INVISIBLE);
                }else if(position==2){
                    shoppingButtonThree.setChecked(true);
                    shoppingButtonOneText.setVisibility(View.INVISIBLE);
                    shoppingButtonTwoText.setVisibility(View.INVISIBLE);
                    shoppingButtonThreeText.setVisibility(View.VISIBLE);
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
        initAnim();
        model=new IMedalModel();
        shoppingRollpager.setPlayDelay(3000);
        shoppingRollpager.setAnimationDurtion(500);
        ShopViewAdapter adapter=new ShopViewAdapter(ShoppingActivity.this);
        shoppingRollpager.setAdapter(adapter);
        shoppingRollpager.setHintView(new ColorPointHintView(ShoppingActivity.this, Color.YELLOW, Color.WHITE));
        getGuangbo();
        ShoppingFragment fragOne=new ShoppingFragment();
        fragOne.setOrderby(0);
        ShoppingFragment fragTwo=new ShoppingFragment();
        fragOne.setOrderby(1);
        ShoppingFragment fragThree=new ShoppingFragment();
        fragOne.setOrderby(2);
        mList.add(fragTwo);
        mList.add(fragOne);
        mList.add(fragThree);
        HomeAdapter adapterOne=new HomeAdapter(getSupportFragmentManager(),mList);
        shoppingViewpager.setAdapter(adapterOne);
    }

    private void getGuangbo(){
        model.getMedal(getparamText(), new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Guangbo guangbo = JSON.parseObject(result, Guangbo.class);
                int code = guangbo.getMessageList().getCode();
                if(code==1000){
                    mStrList = guangbo.getServerInfo().getOrderList().getContent();
                    if(mStrList.size()>0){
                        handler.postDelayed(runnable,2000);
                    }
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
    private void initAnim(){
        invisToVis = ObjectAnimator.ofFloat(shoppingGuangbo, "rotationX",
                -90f, 0f);
        invisToVis.setStartDelay(300);
        invisToVis.setDuration(600);
        invisToVis.clone();
        invisToVis.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                shoppingGuangbo.setText(mStrList.get(a).getOrderMessage());
            }
        });
    }

    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            invisToVis.start();
            if(a<mStrList.size()-1) {
                handler.sendEmptyMessage(1);
                a++;
            }else if(a==mStrList.size()-1){
                handler.sendEmptyMessage(1);
                a=0;
            }
            handler.postDelayed(runnable,2000);
        }
    };

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    break;
            }
        }
    };


    @OnClick({R.id.shopping_back, R.id.shopping_Linear_TextOne, R.id.shopping_Linear_TextTwo, R.id.shopping_guangbo, R.id.shopping_paihang, R.id.shopping_ButtonOne, R.id.shopping_ButtonTwo, R.id.shopping_ButtonThree})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shopping_back:
                onBackPressed();
                break;
            case R.id.shopping_Linear_TextOne:
                Intent intent=new Intent(ShoppingActivity.this,ExchangeActivity.class);
                startActivity(intent);
                break;
            case R.id.shopping_Linear_TextTwo:
                Intent intentOne=new Intent(ShoppingActivity.this,ExchangeActivity.class);
                startActivity(intentOne);
                break;
            case R.id.shopping_guangbo:
                break;
            case R.id.shopping_paihang:
                Intent intentTwo=new Intent(ShoppingActivity.this,GongActivity.class);
                startActivity(intentTwo);
                break;
            case R.id.shopping_ButtonOne:
                shoppingViewpager.setCurrentItem(0);
                shoppingButtonOneText.setVisibility(View.VISIBLE);
                shoppingButtonTwoText.setVisibility(View.INVISIBLE);
                shoppingButtonThreeText.setVisibility(View.INVISIBLE);
                break;
            case R.id.shopping_ButtonTwo:
                shoppingViewpager.setCurrentItem(1);
                shoppingButtonOneText.setVisibility(View.INVISIBLE);
                shoppingButtonTwoText.setVisibility(View.VISIBLE);
                shoppingButtonThreeText.setVisibility(View.INVISIBLE);
                break;
            case R.id.shopping_ButtonThree:
                shoppingViewpager.setCurrentItem(2);
                shoppingButtonOneText.setVisibility(View.INVISIBLE);
                shoppingButtonTwoText.setVisibility(View.INVISIBLE);
                shoppingButtonThreeText.setVisibility(View.VISIBLE);
                break;
        }
    }

    private String getparamText(){
        TextParam param=new TextParam();
        param.setCustomerID(8001);
        param.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"));
        param.setMethod("PHSocket_APP_TCommodityIndex");
        param.setCustomerKey("B757752C64514CB5B3F8B17330024493");
        param.setAppName("CcooCity");
        param.setVersion("4.5");
        TextParam.ParamBean paramBean=new TextParam.ParamBean();
        paramBean.setSiteID(LoginUtils.information.getServerInfo().getSiteID());
        param.setParam(paramBean);
        TextParam.StatisBean statisBean=new TextParam.StatisBean();
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("+86"+LoginUtils.information.getServerInfo().getTel());
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));
        statisBean.setSiteId(LoginUtils.information.getServerInfo().getSiteID());
        String  model= android.os.Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion+"");
        param.setStatis(statisBean);
        String s = JSON.toJSONString(param);
        return s;
    }
}
