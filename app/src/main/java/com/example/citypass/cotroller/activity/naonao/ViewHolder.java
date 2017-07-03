package com.example.citypass.cotroller.activity.naonao;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;

import java.util.HashMap;
import java.util.Map;

/**
 * /**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/29 0029 10:58
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


class ViewHolder {
    //存放View的
    private Map<Integer, View> map;
    //这个放上下文对象
    private Context context;
    //这个放的是ListView的item的布局 就是每个小View
    private View itemView;

    private ViewHolder(Context context, View itemView) {
        //这里初始化数据源
        this.context = context;
        this.itemView = itemView;
        map = new HashMap<>();

    }

    private static ViewHolder viewHolder;

    /**
     *
     * @param context  上下文对象
     * @param convertView  这个每个item的布局
     * @param LayoutID    哪个item布局 通过id找布局文件 R.layout.xx
     * @return
     */
    public static ViewHolder getInstance(Context context, View convertView, int LayoutID) {
        //一开始这个convertView是空的
        if (convertView == null) {
            //给他找布局
            convertView = LayoutInflater.from(context).inflate(LayoutID, null);
            //把布局放到ViewHolder里面存起来
            viewHolder = new ViewHolder(context, convertView);
            //利用View的tag标签放进去
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return viewHolder;
    }

    /**
     *
     * @param itemID   这个就是item里面的小组件 比如TextView ImageView
     * @return
     */
    public View getView(int itemID) {
        //一开始集合是空的 所以这个view=null
        View view = map.get(itemID);
        if (view == null) {
            //通过View.findViewById的形式找ID
            view = itemView.findViewById(itemID);
            //找到后放到集合里面 这样的话你只需要找一次ID就可以
            map.put(itemID, view);
        }
        //把这个View   retun出来
        return view;
    }

    /**
     *
     * 下面的所有方法都是用来赋值的
     */
    /**
     *
     * @param itemID   这个是item里面的小组件id
     * @param text      内容
     * @return
     */
    public ViewHolder settext(int itemID, String text) {
        //通过getView这个方法 先看这个组件有没有找到id 没有就给id  最后得到一个View
        TextView tvView = (TextView) getView(itemID);
        //为了防止代码逻辑错误致使程序崩溃
        if (tvView != null) {
            tvView.setText(text);
        }
        return this;
    }

    public ViewHolder setResouse(int itemID, int ImageRes) {
        ImageView imageView = (ImageView) map.get(itemID);
        if (imageView != null) {
            imageView.setImageResource(ImageRes);
        }
        return this;
    }
    public ViewHolder setNetImage(int itemID,String IamgeUrl){
        ImageView imageView = (ImageView) map.get(itemID);
        Glide.with(context).load(IamgeUrl).into(imageView);
        return this;
    }
    public Bitmap setImageLoader(int itemID, String url){
        ImageView imageView = (ImageView) getView(itemID);
        imageView.setImageResource(R.mipmap.ic_launcher);
        Bitmap bitmap = ImageLoader.getInstance(3, ImageLoader.Type.LIFO).loadImage(url, imageView);
        return bitmap;
    }
    /**
     *    这个是为了ListView适配器可以return
     * @return
     */
    public View getItemView() {
        return itemView;
    }

    public void setItemView(View itemView) {
        this.itemView = itemView;
    }
}
