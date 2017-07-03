package com.example.citypass.cotroller.fragment.toutiao;


import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.activity.find.MyWebActivity;
import com.example.citypass.cotroller.activity.naonao.NaoNao_Carmer_Activity;
import com.example.citypass.cotroller.activity.shequ.ReleaseActivity;
import com.example.citypass.cotroller.activity.shequ.SouSuoActivity;
import com.example.citypass.cotroller.fragment.LifeFragment;
import com.example.citypass.cotroller.fragment.NaoNaoFragment;
import com.example.citypass.cotroller.fragment.SheQuFragment;
import com.example.citypass.cotroller.fragment.information.LoginActivity;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FunctionActivity extends BaseActivity {


    @BindView(R.id.function_title_tv)
    TextView functionTitleTv;
    @BindView(R.id.function_back)
    ImageView functionBack;
    @BindView(R.id.function_two)
    ImageView functionTwo;
    @BindView(R.id.function_one)
    ImageView functionOne;
    @BindView(R.id.function_title)
    RelativeLayout functionTitle;
    @BindView(R.id.function_framelaout)
    FrameLayout functionFramelaout;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private PopupWindow pop;
    private View view;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_function;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {


        String htag = SpUtils.getSp().getString("htag", "");
        //Log.e("htag", htag);

        //开起事物
        manager = FunctionActivity.this.getSupportFragmentManager();
        transaction = manager.beginTransaction();

        if (htag.equals("分类生活")) {
            functionTitleTv.setText("分类");
            functionOne.setVisibility(View.GONE);
            functionTwo.setVisibility(View.VISIBLE);
            functionTwo.setImageResource(R.drawable.ccoo_icon_edit_tran);
            functionTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String url = "http://m.yanqing.ccoo.cn/post/fabu/";
                    Intent in = new Intent(FunctionActivity.this, MyWebActivity.class);
                    in.putExtra("url", url);
                    startActivity(in);
                }
            });
            transaction.replace(R.id.function_framelaout, new LifeFragment(), "LifeFragment");
            transaction.commit();
        } else if (htag.equals("同城爆料")) {
            functionOne.setVisibility(View.VISIBLE);
            functionTwo.setVisibility(View.VISIBLE);

            functionOne.setImageResource(R.drawable.chazhao_back_normal);
            functionTwo.setImageResource(R.drawable.ccoo_icon_edit_tran);

            functionOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FunctionActivity.this, SouSuoActivity.class);
                    startActivity(intent);
                }
            });
            functionTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FunctionActivity.this, ReleaseActivity.class);
                    startActivity(intent);
                }
            });
            functionTitleTv.setText("社区");
            transaction.replace(R.id.function_framelaout, new SheQuFragment(), "SheQuFragment");
            transaction.commit();
        }else if(htag.equals("闹闹")){
            functionTitleTv.setText("闹闹");
            functionOne.setVisibility(View.GONE);
            functionTwo.setVisibility(View.VISIBLE);
            functionTwo.setImageResource(R.drawable.mall_camera0);
            functionTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //是否登录
                    if (SpUtils.getSp().getBoolean(LoginUtils.LOGIN, false)) {
                        initPop();
                        pop.showAsDropDown(view, 0, 0, Gravity.BOTTOM);
                    } else {
                        Intent in = new Intent(FunctionActivity.this, LoginActivity.class);
                        startActivity(in);
                    }
                }
            });
            transaction.replace(R.id.function_framelaout, new NaoNaoFragment(), "NaoNaoFragment");
            transaction.commit();
        }else if(htag.equals("城事")){
            functionTitleTv.setText("城事");
            functionOne.setVisibility(View.GONE);
            functionTwo.setVisibility(View.GONE);
            transaction.replace(R.id.function_framelaout, new HcitymatterFragment(), "HcitymatterFragment");
            transaction.commit();
        }else if(htag.equals("秀场")){
            functionTitleTv.setText("秀场");
            functionOne.setVisibility(View.GONE);
            functionTwo.setVisibility(View.GONE);
            transaction.replace(R.id.function_framelaout, new HshowFragment(), "HshowFragment");
            transaction.commit();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.function_back)
    public void onViewClicked() {
        finish();
    }
    // TODO: 2017/6/26 0026 弹出popupWindow
    private void initPop() {
        view = LayoutInflater.from(FunctionActivity.this).inflate(R.layout.carmer_naonao_popupwindow_activity, null);
        pop = new PopupWindow(view, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT);
        //popupWindow的背景透明度
        view.getBackground().setAlpha(230);
        //popupWindow的外部点击
        pop.setOutsideTouchable(true);
        //颜色
        pop.setBackgroundDrawable(new ColorDrawable());
        //返回
        LinearLayout mCancel = (LinearLayout) view.findViewById(R.id.carmer_naonao_popupwindow_activity_cancel);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        LinearLayout mVideo  = (LinearLayout) view.findViewById(R.id.carmer_naonao_popupwindow_activity_video);
        //小视频的点击事件
        mVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(FunctionActivity.this, NaoNao_Carmer_Activity.class);
                startActivity(in);
            }
        });
        LinearLayout mPhoto = (LinearLayout) view.findViewById(R.id.carmer_naonao_popupwindow_activity_photo);
        mPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//             Intent intent=new Intent(FunctionActivity.this,NaoNao_Carmer_Activity.class);
//                startActivity(intent);
            }
        });

    }
}
