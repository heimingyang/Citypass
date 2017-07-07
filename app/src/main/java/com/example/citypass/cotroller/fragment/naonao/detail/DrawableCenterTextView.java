package com.example.citypass.cotroller.fragment.naonao.detail;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zhangzl
 * desc: 图片和文字居中显示
 * date: 2016/11/14 0014.
 */

public class DrawableCenterTextView extends TextView {
    public DrawableCenterTextView(Context context, AttributeSet attrs,
                                  int defStyle) {
        super(context, attrs, defStyle);
    }

    public DrawableCenterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawableCenterTextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();//left,top,right,bottom
        Drawable drawableRight = drawables[2];
        if(drawableRight != null){
            float textWidth = getPaint().measureText(getText().toString());
            int drawablePadding = getCompoundDrawablePadding();
            int drawableWidth  = drawableRight.getIntrinsicWidth();
            float bodyWidth = textWidth + drawableWidth + drawablePadding;
            setPadding(0, 0, (int)(getWidth() - bodyWidth), 0);
            canvas.translate((getWidth() - bodyWidth) / 2, 0);
        }
        super.onDraw(canvas);
    }
}
