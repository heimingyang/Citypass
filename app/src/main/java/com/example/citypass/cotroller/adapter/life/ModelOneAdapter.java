package com.example.citypass.cotroller.adapter.life;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.citypass.R;
import com.example.citypass.model.bean.information.Medal;
import com.example.citypass.model.http.HttpFacory;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/28 15:51
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ModelOneAdapter extends BaseAdapter {
    private List<Medal.ServerInfoBean.TMedalListBean.TMedalListBeans> mList;
    private Context context;

    public ModelOneAdapter(List<Medal.ServerInfoBean.TMedalListBean.TMedalListBeans> mList, Context context) {
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
        convertView= LayoutInflater.from(context).inflate(R.layout.medal_grid_item,null);
        ImageView img= (ImageView) convertView.findViewById(R.id.grid_medal_item);
        HttpFacory.create().loadImage(mList.get(position).getHImage(),img,false);
        return convertView;
    }
}
