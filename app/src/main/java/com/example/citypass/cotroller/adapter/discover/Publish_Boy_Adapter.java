package com.example.citypass.cotroller.adapter.discover;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.citypass.R;


/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/3 0003 9:45
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

public class Publish_Boy_Adapter extends BaseAdapter {

    private Context context;
    private String[] str;
    int LastPosition;
    private View view;
    //    private List<String> mList;

    public Publish_Boy_Adapter(Context context, String[] str) {
        this.context = context;
        this.str = str;
    }


    public void setSeclection(int position) {
        this.LastPosition = position;
    }

    @Override
    public int getCount() {
        return str.length;
    }

    @Override
    public Object getItem(int position) {
        return str[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        final Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.publish_boy_selectitem, null);
            holder.boy_tv = (TextView) convertView.findViewById(R.id.boy_item_tv);
            holder.boy_img = (ImageView) convertView.findViewById(R.id.boy_item_img);

            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }
//        String str = mList.get(position);
        String s = str[position];
        holder.boy_tv.setText(s);

        holder.boy_img.setVisibility(View.GONE);

        if (LastPosition == position) {//最后选择的位置
            if (view == null) {
                holder.boy_img.setVisibility(View.VISIBLE);
                view = holder.boy_img;
            } else {

                view.setVisibility(View.GONE);
                holder.boy_img.setVisibility(View.VISIBLE);
                view = holder.boy_img;
            }


        } else {
            if (position == 0) {
                Drawable drawable = context.getResources().getDrawable(R.drawable.boy_0_bg);
                holder.boy_tv.setBackgroundDrawable(drawable);
            }
            if (position == 1) {
                Drawable drawable1 = context.getResources().getDrawable(R.drawable.boy_1_bg);
                holder.boy_tv.setBackgroundDrawable(drawable1);

            }
            if (position == 2) {
                Drawable drawable2 = context.getResources().getDrawable(R.drawable.boy_2_bg);
                holder.boy_tv.setBackgroundDrawable(drawable2);
            }
            if (position == 3) {
                Drawable drawable3 = context.getResources().getDrawable(R.drawable.boy_3_bg);
                holder.boy_tv.setBackgroundDrawable(drawable3);
            }
            if (position == 4) {
                Drawable drawable4 = context.getResources().getDrawable(R.drawable.boy_4_bg);
                holder.boy_tv.setBackgroundDrawable(drawable4);
            }


        }
        return convertView;
    }

    class Holder {
        private TextView boy_tv;
        private ImageView boy_img;
    }
}
