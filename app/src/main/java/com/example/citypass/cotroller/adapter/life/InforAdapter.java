package com.example.citypass.cotroller.adapter.life;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;

/**
 * 项目名称: 血压卫士
 * 类描述: 这是给个人页面的选项的适配器
 * 创建人: 马杰
 * 创建时间: 2017/6/19 21:09
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class InforAdapter extends BaseAdapter {
    private Context context;

    public InforAdapter(Context context) {
        this.context = context;
    }

    private String[] str={"消息通知","我的主页","我的宝宝","等级头衔特权","我的勋章",
    "我的城市币","城市币商城","任务中心","我的帖子","我的分类","我的活动","我的收藏"};
    private int[] img={R.drawable.main_left1,R.drawable.main_left2,R.drawable.main_left3,
            R.drawable.main_left4,R.drawable.main_left5,R.drawable.main_left6,
            R.drawable.main_left7,R.drawable.main_left8,R.drawable.main_left9,
            R.drawable.main_left10,R.drawable.main_left11,R.drawable.main_left12,};
    @Override
    public int getCount() {
        return str.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
            holder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.list_infor_item,null);
            holder.mText= (TextView) convertView.findViewById(R.id.list_item_text);
            holder.view= (TextView) convertView.findViewById(R.id.list_item_textOne);
            convertView.setTag(holder);
        if(position==3||position==8){
            holder.view.setVisibility(View.VISIBLE);
        }
            holder.mText.setText(str[position]);
            Drawable drawable = context.getResources().getDrawable(img[position]);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            Drawable drawable1 = context.getResources().getDrawable(R.drawable.newlife_arrow);
            drawable1.setBounds(0, 0, drawable1.getMinimumWidth(), drawable1.getMinimumHeight());
            holder.mText.setCompoundDrawables(drawable, null, drawable1, null);
        return convertView;
    }
    class ViewHolder{
        private TextView mText;
        private TextView view;
    }
}
