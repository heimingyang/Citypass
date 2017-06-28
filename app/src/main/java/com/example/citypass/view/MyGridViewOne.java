package com.example.citypass.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/28 16:05
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class MyGridViewOne extends GridView {
    public MyGridViewOne(Context context) {
        super(context);
    }

    public MyGridViewOne(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridViewOne(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
