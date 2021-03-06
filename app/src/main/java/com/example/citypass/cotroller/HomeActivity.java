package com.example.citypass.cotroller;


import android.content.Intent;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.base.MyViewPager;
import com.example.citypass.cotroller.fragment.FaXianFragment;
import com.example.citypass.cotroller.fragment.LifeFragment;
import com.example.citypass.cotroller.fragment.NaoNaoFragment;
import com.example.citypass.cotroller.fragment.SheQuFragment;
import com.example.citypass.cotroller.fragment.TouTiaoFragment;
import com.example.citypass.cotroller.fragment.information.LoginActivity;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.main_The_headlines)
    RadioButton mainTheHeadlines;
    @BindView(R.id.main_Community)
    RadioButton mainCommunity;
    @BindView(R.id.main_Show)
    RadioButton mainShow;
    @BindView(R.id.main_Life)
    RadioButton mainLife;
    @BindView(R.id.main_find)
    RadioButton mainFind;
    @BindView(R.id.main_group)
    RadioGroup mainGroup;
    @BindView(R.id.main_Viewpager)
    MyViewPager mainViewpager;
    @BindView(R.id.main_drawlayout)
    DrawerLayout mainDrawlayout;
    @BindView(R.id.main_Img)
    ImageView mainImg;
    @BindView(R.id.main_Title)
    TextView mainTitle;
    @BindView(R.id.main_right_img)
    ImageView mainRightImg;
    @BindView(R.id.main_right_imgTwo)
    ImageView mainRightImgTwo;
    private HomeAdapter homeAdapter;
    private List<Fragment> mflist = new ArrayList<>();
    //分别为头条、闹闹、社区、生活、发现的Fragment
    public static TouTiaoFragment touTiaoFragment;
    private NaoNaoFragment naoNaoFragment;
    private SheQuFragment sheQuFragment;
    private LifeFragment lifeFragment;
    private FaXianFragment faXianFragment;
    private Fragment fragment;
    //这是用来判断是否登录的值，在SharedPreferences中以login参数保存
    private boolean login;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    // TODO: 2017/6/27 主页面的监听事件
    @Override
    public void initListener() {
        mainDrawlayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerStateChanged(int newState) {
                Log.i("lenve", "onDrawerStateChanged");
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                slideAnim(drawerView, slideOffset);
                Log.i("lenve", "onDrawerSlide");
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Log.i("lenve", "onDrawerOpened");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Log.i("lenve", "onDrawerClosed");
            }
        });
    }

    @Override
    public void initData() {
        App.activity=this;
        login = SpUtils.getSp().getBoolean(LoginUtils.LOGIN, false);

    }

    @Override
    public void initView() {
        touTiaoFragment = new TouTiaoFragment();
        naoNaoFragment = new NaoNaoFragment();
        sheQuFragment = new SheQuFragment();
        lifeFragment = new LifeFragment();
        faXianFragment = new FaXianFragment();
        mflist.add(touTiaoFragment);
        mflist.add(naoNaoFragment);
        mflist.add(sheQuFragment);
        mflist.add(lifeFragment);
        mflist.add(faXianFragment);
        homeAdapter = new HomeAdapter(getSupportFragmentManager(), mflist);
        mainViewpager.setAdapter(homeAdapter);

    }


    @OnClick({R.id.main_The_headlines, R.id.main_Community, R.id.main_Show, R.id.main_Life, R.id.main_find
            , R.id.main_Img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_The_headlines:
                changeView(0);

                break;
            case R.id.main_Community:
                changeView(1);

                break;
            case R.id.main_Show:
                changeView(2);

                break;
            case R.id.main_Life:
                changeView(3);

                break;
            case R.id.main_find:
                changeView(4);

                break;
            case R.id.main_Img:
                if (login) {
                    mainDrawlayout.openDrawer(Gravity.LEFT);
                } else {
                    Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    public TextView getText() {
        return this.mainTitle;
    }

    @Override
    public RadioGroup getGroup() {
        return this.mainGroup;
    }

    @Override
    public ImageView getImgOne() {
        return this.mainRightImgTwo;
    }

    @Override
    public ImageView getImgTwo() {
        return this.mainRightImg;
    }

    @Override
    public ImageView getImg() {
        return this.mainImg;
    }

    private void changeView(int desTab) {
        mainViewpager.setCurrentItem(desTab, true);
    }


    private void slideAnim(View drawerView, float slideOffset) {
        View contentView = mainDrawlayout.getChildAt(0);
        // slideOffset表示菜单项滑出来的比例，打开菜单时取值为0->1,关闭菜单时取值为1->0
        float scale = 1 - slideOffset;
        float rightScale = 0.8f + scale * 0.2f;
        float leftScale = 1 - 0.3f * scale;

        ViewHelper.setScaleX(drawerView, leftScale);
        ViewHelper.setScaleY(drawerView, leftScale);
        ViewHelper.setAlpha(drawerView, 0.6f + 0.4f * (1 - scale));
        ViewHelper.setTranslationX(contentView, drawerView.getMeasuredWidth()
                * (1 - scale));
        ViewHelper.setPivotX(contentView, 0);
        ViewHelper.setPivotY(contentView, contentView.getMeasuredHeight() / 2);
        contentView.invalidate();
        ViewHelper.setScaleX(contentView, rightScale);
        ViewHelper.setScaleY(contentView, rightScale);
    }

    public static final int REQUEST_CODE = 0x0000c0de; // Only use bottom 16 bits

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100:

                break;
            case 200:
                switch (resultCode) {
                    case 201:
                        mainImg.setImageResource(R.drawable.login_icon_accounta);
                        break;
                }
                break;
            case REQUEST_CODE:
                IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
                if (result != null) {
                    //扫描成功
                    if (result.getContents() == null) {
                        //结束扫码
                        Toast.makeText(this, "取消", Toast.LENGTH_SHORT).show();
                    } else {
                        //扫码出结果
                        Toast.makeText(this, "扫码结果：" + result.getContents(), Toast.LENGTH_SHORT).show();

//                Toast.makeText(this, "扫码成功", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    super.onActivityResult(requestCode, resultCode, data);
                }
                break;
        }
    }

     private boolean isfirst;
    @Override
    public void onBackPressed() {
        //双击退出
        if(!isfirst){
            isfirst = true;
            Toast.makeText(HomeActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {

                @Override
                public void run() {
                    isfirst = false;
                }
            }, 2000);
        }else {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }
}
