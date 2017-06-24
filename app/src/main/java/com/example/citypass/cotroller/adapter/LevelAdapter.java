package com.example.citypass.cotroller.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.model.bean.Levels;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述: 当你使用listview的优化的时候，因为是复用视图在下方加载，所以索引会跟着复用的视图一起走，然后，就会出现重新加载时候视图复用的情况
 * 创建人: 马杰
 * 创建时间: 2017/6/24 10:15
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class LevelAdapter extends BaseAdapter {
    private List<Levels.ServerInfoBean.TLevelListBeans.TLevelListBean> mList;
    private Context mContext;
    private int a;

    public LevelAdapter(List<Levels.ServerInfoBean.TLevelListBeans.TLevelListBean> mList, Context mContext,int a) {
        this.mList = mList;
        this.mContext = mContext;
        this.a=a;
    }

    @Override
    public int getCount() {
        return mList.size();
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
//        if(convertView==null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.level_list_item,null);
            holder.one= (TextView) convertView.findViewById(R.id.level_item_textOne);
            holder.two= (TextView) convertView.findViewById(R.id.level_item_textTwo);
            holder.three= (TextView) convertView.findViewById(R.id.level_item_textThree);
            holder.rela= (RelativeLayout) convertView.findViewById(R.id.level_item_relative);
//            convertView.setTag(holder);
//        }else{
//            holder= (ViewHolder) convertView.getTag();
//        }
        Levels.ServerInfoBean.TLevelListBeans.TLevelListBean tLevelListBean = mList.get(position);
        String level = tLevelListBean.getLevel();
        int i = Integer.parseInt(level);
        holder.two.setText(tLevelListBean.getTName());
        holder.three.setText(tLevelListBean.getIntegral());
        if(i<=10){
            holder.one.setText("Lv."+level);
        }else if(i<=20&&i>10){
            holder.one.setBackgroundResource(R.drawable.ccoo_bg_dengji2);
            holder.one.setText("Lv."+level);
        }else if(i<=30&&i>20){
            holder.one.setBackgroundResource(R.drawable.ccoo_bg_dengji3);
            holder.one.setText("Lv."+level);
        }
            if (position == a) {
                Log.e("a",a+"");
                Log.e("position",position+"");
                holder.rela.setBackgroundResource(R.drawable.list_two);
            }
        return convertView;
    }
    class ViewHolder{
        private TextView one,two,three;
        private RelativeLayout rela;
    }
}
