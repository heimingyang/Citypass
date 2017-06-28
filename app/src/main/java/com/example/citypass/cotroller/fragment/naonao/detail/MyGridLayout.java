package com.example.citypass.cotroller.fragment.naonao.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/26 20:10
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class MyGridLayout extends GridLayout {

    private int size;

    public void setmList(List<String> mList) {
        size = mList.size();
        Log.d("MyGridLayout", "size:" + size);

        if (size == 1) {
            for (String s : mList) {
                init();
                addItem(s);
                Log.d("MyGridLayout ", "第一个是s" + s);
            }
            mList.clear();
        }
//        else  if(size>1){
//            for (String s : mList) {
//                init();
//                size = 2;
//                addItemOne(s);
//            }
//        }
        else {
            for (String s : mList) {
                size = 3;
                init();
                addItemTwo(s);
            }
        }
    }


    public MyGridLayout(Context context) {
        this(context, null);
    }

    public MyGridLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //设置当前Gridlayout每个条目个数
        setColumnCount(size);
        //设置动画
//        setLayoutTransition(new LayoutTransition());
    }

    private int margin = 5;

    public void addItem(String str) {
        ImageView image = new ImageView(getContext());
        LayoutParams lp = new LayoutParams();

        lp.width = getResources().getDisplayMetrics().widthPixels / 2;
//        lp.width = 200;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//


        image.setLayoutParams(lp);


//        image.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT) );
//        image.setScaleType(ImageView.ScaleType.FIT_XY);


        Glide.with(getContext()).load(str).into(image);
        lp.setMargins(margin, margin, margin, margin);
        addView(image);
    }


    public void addItemOne(String str) {
        Log.d("MyGridLayout str", str);
        ImageView image1 = new ImageView(getContext());
        LayoutParams lp = new LayoutParams();

        lp.width = getResources().getDisplayMetrics().widthPixels / 2 - margin * 2;

        lp.height = LayoutParams.WRAP_CONTENT;

        image1.setLayoutParams(lp);

        lp.setGravity(Gravity.CENTER);

        Glide.with(getContext()).load(str).into(image1);
        lp.setMargins(margin, margin, margin, margin);
        addView(image1);
    }

    public void addItemTwo(String str) {
        Log.d("MyGridLayout str", str);
        ImageView image2 = new ImageView(getContext());
        LayoutParams lp = new LayoutParams();

        lp.width = getResources().getDisplayMetrics().widthPixels / 3 - margin * 2;

        lp.height = LayoutParams.WRAP_CONTENT;

        image2.setLayoutParams(lp);
        lp.setGravity(Gravity.CENTER);
//        image2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT) );
//        image2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(getContext()).load(str).into(image2);
        lp.setMargins(margin, margin, margin, margin);
        addView(image2);
    }


}
