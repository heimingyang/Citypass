package com.example.citypass.cotroller.fragment.toutiao;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CityFoloActivity extends BaseActivity {
    @BindView(R.id.hcityfolo_back)
    ImageView hcityfoloBack;
    @BindView(R.id.hcityfolo_title)
    ImageView hcityfoloTitle;
    @BindView(R.id.hcityfolo_set)
    TextView hcityfoloSet;
    @BindView(R.id.hcityfolo_lin1)
    RelativeLayout hcityfoloLin1;
    @BindView(R.id.hcityfolo_commoncity)
    TextView hcityfoloCommoncity;
    @BindView(R.id.hcf_img1)
    ImageView hcfImg1;
    @BindView(R.id.hcf_tv1)
    TextView hcfTv1;
    @BindView(R.id.hcf_lin1)
    RelativeLayout hcfLin1;
    @BindView(R.id.hcf_tvno1)
    TextView hcfTvno1;
    @BindView(R.id.hcf_img2)
    ImageView hcfImg2;
    @BindView(R.id.hcf_tv2)
    TextView hcfTv2;
    @BindView(R.id.hcf_lin2)
    RelativeLayout hcfLin2;
    @BindView(R.id.hcf_tvno2)
    TextView hcfTvno2;
    @BindView(R.id.hcf_img3)
    ImageView hcfImg3;
    @BindView(R.id.hcf_tv3)
    TextView hcfTv3;
    @BindView(R.id.hcf_lin3)
    RelativeLayout hcfLin3;
    @BindView(R.id.hcityfolo_lin2)
    RelativeLayout hcityfoloLin2;
    @BindView(R.id.hcf_tvno3)
    TextView hcfTvno3;
    @BindView(R.id.hcf_botton_title)
    TextView hcfBottonTitle;
    @BindView(R.id.hcf_tvno4)
    TextView hcfTvno4;
    @BindView(R.id.hct_lin1)
    RelativeLayout hctLin1;
    @BindView(R.id.hcf_tueijian_tv1)
    TextView hcfTueijianTv1;
    @BindView(R.id.hcf_tueijian_tv2)
    TextView hcfTueijianTv2;
    @BindView(R.id.hcf_tueijian_tv3)
    TextView hcfTueijianTv3;
    @BindView(R.id.hcf_tueijian_tv4)
    TextView hcfTueijianTv4;
    @BindView(R.id.hcf_tueijian_tv5)
    TextView hcfTueijianTv5;
    @BindView(R.id.hcf_tueijian_tv6)
    TextView hcfTueijianTv6;
    @BindView(R.id.hct_lin2)
    RelativeLayout hctLin2;
    @BindView(R.id.morecity)
    Button morecity;
    @BindView(R.id.hct_lin3)
    RelativeLayout hctLin3;
    @BindView(R.id.activity_city_folo)
    ScrollView activityCityFolo;
    private boolean isfirst=true;
    private RelativeLayout allcity;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_city_folo;
    }

    @Override
    protected void initListener() {
        hcityfoloBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        allcity = (RelativeLayout) findViewById(R.id.allcity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.hcityfolo_set, R.id.hcf_lin1, R.id.hcf_lin2, R.id.hcf_lin3, R.id.hcf_tueijian_tv1, R.id.hcf_tueijian_tv2, R.id.hcf_tueijian_tv3, R.id.hcf_tueijian_tv4, R.id.hcf_tueijian_tv5, R.id.hcf_tueijian_tv6, R.id.morecity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hcityfolo_set:
                if(isfirst){
                    hcityfoloSet.setText("完成");
                    hcityfoloCommoncity.setText("设置常用城市");
                    hcfImg1.setImageResource(R.drawable.city_choice_pen);
                    hcfImg2.setImageResource(R.drawable.city_choice_pen);
                    hcfImg3.setImageResource(R.drawable.city_choice_pen);
                    allcity.setBackgroundResource(R.drawable.hcityfolo_set_after);
                    isfirst=false;
                }else {
                    hcityfoloSet.setText("设置");
                    hcityfoloCommoncity.setText("常用城市");
                    hcfImg1.setImageResource(R.drawable.ccoo_icon_jiantou_right);
                    hcfImg2.setImageResource(R.drawable.ccoo_icon_jiantou_right);
                    hcfImg3.setImageResource(R.drawable.ccoo_icon_jiantou_right);
                    allcity.setBackgroundResource(R.drawable.hcityfolo_set);
                    isfirst=true;
                }
                break;
            case R.id.hcf_lin1:
                String s1=hcityfoloSet.getText().toString().trim();
                if(s1.equals("完成")){
                    Intent intent=new Intent(this,SetCityActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this,"未设置城市，请点击左上角的设置",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.hcf_lin2:
                String s2=hcityfoloSet.getText().toString().trim();
                if(s2.equals("完成")){
                    Intent intent=new Intent(this,SetCityActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this,"未设置城市，请点击左上角的设置",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.hcf_lin3:
                String s3=hcityfoloSet.getText().toString().trim();
                if(s3.equals("完成")){
                    Intent intent=new Intent(this,SetCityActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this,"未设置城市，请点击左上角的设置",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.hcf_tueijian_tv1:
                break;
            case R.id.hcf_tueijian_tv2:
                break;
            case R.id.hcf_tueijian_tv3:
                break;
            case R.id.hcf_tueijian_tv4:
                break;
            case R.id.hcf_tueijian_tv5:
                break;
            case R.id.hcf_tueijian_tv6:
                break;
            case R.id.morecity:
                Intent intent=new Intent(this,SetCityActivity.class);
                startActivity(intent);
                break;
        }
    }
}
