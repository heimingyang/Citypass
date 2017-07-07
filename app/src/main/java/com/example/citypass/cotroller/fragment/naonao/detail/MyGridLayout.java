package com.example.citypass.cotroller.fragment.naonao.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;

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
    private onClicklisenter clicklisenter;
    private List<String> mList;

    public void setClicklisenter(onClicklisenter clicklisenter) {
        this.clicklisenter = clicklisenter;
    }

    public void setmList(List<String> mList) {
        this.mList = mList;
        size = mList.size();
        if (size == 1) {
            for (String s : mList) {
                init();
                addItem(s);
                Log.d("MyGridLayout ", "第一个是s" + s);
            }
//            mList.clear();  不应该清空集合，否则第一个没添加到集合，就没点击事件了
        } else {
            for (String s : mList) {
                size = 3;
                Log.d("MyGridLayout", "第二个是" + s);
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
    }

    private int margin = 5;

    public void addItem(final String str) {
        final ImageView image = new ImageView(getContext());
        LayoutParams lp = new LayoutParams();

        lp.width = getResources().getDisplayMetrics().widthPixels / 2;
//        lp.width = 200;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//


        image.setLayoutParams(lp);

        Glide.with(getContext()).load(str).error(R.drawable.ic_loading).into(image);
        lp.setMargins(margin, margin, margin, margin);
        addView(image);

        image.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < mList.size(); i++) {
                    if (mList.get(i).equals(str)) {
                        clicklisenter.onItemClick(v, i);
                        Log.d("MyGridLayout", "i:" + i);

                    }
                }
            }
        });

    }


    public void addItemTwo(final String str) {
        final ImageView image2 = new ImageView(getContext());
        LayoutParams lp = new LayoutParams();

        lp.width = getResources().getDisplayMetrics().widthPixels / 3 - margin * 2;

        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;

        image2.setLayoutParams(lp);
        Glide.with(getContext()).load(str).into(image2);
        lp.setMargins(margin, margin, margin, margin);
        addView(image2);

        image2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < mList.size(); i++) {
                    if (mList.get(i).equals(str)) {
                        clicklisenter.onItemClick(v, i);
                        Log.d("MyGridLayout", "i:" + i);

                    }
                }

            }
        });

    }


    public interface onClicklisenter {
        void onItemClick(View v, int position);
    }


}
