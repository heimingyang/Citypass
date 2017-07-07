package com.example.citypass.cotroller.fragment.naonao.detail;

import android.content.Intent;
import android.graphics.Matrix;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.naonao.detail.NaoNao_ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/30 23:33
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DetailImageActivity extends BaseActivity {
    @BindView(R.id.NaoNao_ImageViewpager)
    ViewPager mViewpager;
    @BindView(R.id.NaoNao_viewpagerBack)
    ImageView NaoNaoViewpagerBack;
    @BindView(R.id.naonao_viewpagerTitle)
    RelativeLayout naonaoViewpagerTitle;
    @BindView(R.id.naonao_viewpagerText)
    TextView pagerText;
    private List<View> mlist;
    private NaoNao_ViewPager adapter;
    private List<String> strList;
    private int position;
    private ImageView image;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_naonao_viewpager;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        strList = new ArrayList<>();
        mlist = new ArrayList<>();
        Intent intent = getIntent();
        strList = (List<String>) intent.getSerializableExtra("image");
        position = intent.getIntExtra("position", 0);
        for (int i = 0; i < strList.size(); i++) {
            View v = LayoutInflater.from(this).inflate(R.layout.activity_naonaodetail_imageview, null);
            image = (ImageView) v.findViewById(R.id.NaoNao_ImageItem);
            Glide.with(this).load(strList.get(i)).placeholder(R.drawable.ic_loading).error(R.drawable.ic_loading).into(image);
            mlist.add(v);

        }
        //设置当前项目为传过来的图片，每个索引
        adapter = new NaoNao_ViewPager(mlist);
        mViewpager.setAdapter(adapter);
        mViewpager.setCurrentItem(position);

        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int size = strList.size();
                pagerText.setText(mViewpager.getCurrentItem() + 1 + "/" + size);

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @OnClick(R.id.NaoNao_viewpagerBack)
    public void onViewClicked() {
        onBackPressed();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN :////当屏幕检测到第一个触点按下之后就会触发到这个事件。
               if(num =true){
                   Matrix matrix = new Matrix();

                   matrix.postScale(scaleWidth,scaleHeight);

                   num=false;

               }




                break;
        }




        return super.onTouchEvent(event);
    }

   private float scaleWidth;
   private float scaleHeight;
    private int h;
    private boolean num = false;
    private void getmWindow(){
        DisplayMetrics dm = new DisplayMetrics();//创建矩阵
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = image.getWidth();
        int height = image.getHeight();

        int w = dm.widthPixels;//屏幕的宽度
        int h = dm.heightPixels;

        scaleWidth=((float)w)/width;
        scaleHeight=((float)h)/height;


    }


}
