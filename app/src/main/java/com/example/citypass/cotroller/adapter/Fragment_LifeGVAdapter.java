package com.example.citypass.cotroller.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/21 17:08
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class Fragment_LifeGVAdapter extends PagerAdapter {
    private List<GridView> gridList;


    public Fragment_LifeGVAdapter( List<GridView> mList) {
        this.gridList = mList;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.removeView(gridList.get(position%gridList.size()));
        container.addView(gridList.get(position%gridList.size()));


        return gridList.get(position%gridList.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }



}
