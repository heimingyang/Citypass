package com.example.citypass.cotroller.adapter.life;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.citypass.R;
import com.example.citypass.model.bean.information.Medal;
import com.example.citypass.model.http.HttpFacory;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/27 9:03
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class MedalAdapter extends BaseAdapter {
    private List<Medal.ServerInfoBean.TMedalListBean.TMedalListBeans> mList;
    private Context context;

    public MedalAdapter(List<Medal.ServerInfoBean.TMedalListBean.TMedalListBeans> mList, Context context) {
        this.mList = mList;
        this.context = context;
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
        convertView= LayoutInflater.from(context).inflate(R.layout.medal_list_item,null);
        ImageView imageView= (ImageView) convertView.findViewById(R.id.medal_list_img);
        TextView textView= (TextView) convertView.findViewById(R.id.medal_list_Text);
        TextView textView1= (TextView) convertView.findViewById(R.id.medal_list_TextOne);
        Medal.ServerInfoBean.TMedalListBean.TMedalListBeans tMedalListBeans = mList.get(position);
        HttpFacory.create().loadImage(tMedalListBeans.getHImage(),imageView,true);
        textView.setText(tMedalListBeans.getSName());
        textView1.setText(tMedalListBeans.getCanBeLitCondition());
        return convertView;
    }
}
