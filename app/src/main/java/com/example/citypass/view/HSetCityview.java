package com.example.citypass.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/22 10:46
 * 修改人:
 * 修改内容:
 * 修改时间:
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */


public class HSetCityview extends View {
    public HSetCityview(Context context) {
        super(context);
    }

    public HSetCityview(Context context, AttributeSet attrs) {
        super(context, attrs);
        //画笔的创建
        wordsPaint=new Paint();
        wordsPaint.setTextSize(28);
        bgPaint=new Paint();
       // bgPaint.setColor(ContextCompat.getColor(context,R.color.blue));
        this.context=context;
    }

    public HSetCityview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //回值列表导航字母
     private String words[]={"A","B","C","D","E","F","G","H","I","J","Q","L",
             "M","N","O","P","Q","R","S","T","U","V","W","X", "Y","Z","#"
     };
    //字母画笔
    private Paint wordsPaint;
private Context context;
    //字幕背景画笔
    private Paint bgPaint;
    //每一个字母的宽度
    private int itemWidth;
    //每一个字母的高度
    private int itemHeigth;
    //手指按下的字母索引
    private int touchIndex=0;
    //手指按下的字母改变接口
    private onWordsChangeListener listener;

    //得到画布的宽度和每一个字母所站的高度
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        itemWidth=getMeasuredWidth();
        //使边距好看一些
        int heigth=getMeasuredHeight()-10;
        itemHeigth=heigth/27;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i=0;i<words.length;i++){
            //判断是不是我们按下的当前字母
            //绘制文字圆形背景
       if(touchIndex==i) {
               /* canvas.drawCircle(itemWidth / 2,
                        itemHeigth / 2 + i * itemHeigth,
                        23,
                        bgPaint);*/
                //wordsPaint.setColor(ContextCompat.getColor(context,R.color.blue));
            }
            else {
                wordsPaint.setColor(Color.GRAY);
            }
            wordsPaint.setColor(Color.GRAY);
           //获取文字的宽高
            Rect rect=new Rect();
            wordsPaint.getTextBounds(words[i],0,1,rect);
            int wordWidth=rect.width();
            //绘制字母
            float wordX=itemWidth/2-wordWidth/2;
            float wordY=itemHeigth/2+i*itemHeigth;
            canvas.drawText(words[i],wordX,wordY,wordsPaint);
        }
    }
//当手指触摸按下的时候改变字母的背景颜色
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                float y=event.getY();
                //关键点==获得我们获得的是哪个索引（字母）
                int index= (int) (y/itemHeigth);
                if(index!=touchIndex){
                    touchIndex=index;
                }

                //防止数组越界
                if(listener!=null&&0<=touchIndex&&touchIndex<words.length){
                    listener.wordsChange(words[touchIndex]);
                }

                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                //手指抬起时，不做操作
                break;
        }
        return true;
    }
    //手指按下了那个字母的回调接口
    public interface onWordsChangeListener{
        void wordsChange(String words);
    }
    //设置手指按下字母改变监听
    public void setOnWordsChangeListener(onWordsChangeListener listener){
        this.listener=listener;
    }
    /*设置当前按下的是那个字母*/
    public void setTouchIndex(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                touchIndex = i;
                invalidate();
                return;
            }
        }
    }
}
