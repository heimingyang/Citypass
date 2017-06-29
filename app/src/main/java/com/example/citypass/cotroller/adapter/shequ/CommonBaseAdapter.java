package com.example.citypass.cotroller.adapter.shequ;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;



public abstract class CommonBaseAdapter<T> extends BaseAdapter {

    protected int layoutId;

    protected Context context;

    protected List<T> datas;
    public CommonBaseAdapter(Context context, List<T> datas, int layoutId) {

        this.layoutId=layoutId;

        this.context=context;

        this.datas=datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
