package com.example.citypass.cotroller.adapter.shequ;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.citypass.cotroller.activity.shequ.CommonViewHolder;

import java.util.List;



public abstract class MyCommonBaseAdapter<T> extends CommonBaseAdapter<T> {
    public MyCommonBaseAdapter(Context context, List<T> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommonViewHolder holder=CommonViewHolder.getInstance(context,convertView,layoutId);

        display(holder,datas.get(position));

        return holder.getConvertView();
    }

    protected  abstract void display(CommonViewHolder holder,T t);
}
