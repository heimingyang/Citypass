package com.example.citypass.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/24 14:42
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class SheQuImageView extends ImageView{
    public SheQuImageView(Context context) {
        super(context);
    }

    public SheQuImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
        int childWidthSize = getMeasuredWidth();
        //高度和宽度一样
        heightMeasureSpec = widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec + 5, heightMeasureSpec + 5);
    }
}
