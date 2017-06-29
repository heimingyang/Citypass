package com.example.citypass.cotroller.adapter.shequ;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/29 9:55
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class MyPagerAdapter extends PagerAdapter {
    private List<View> viewList;

    public MyPagerAdapter(List<View> viewList){
        this.viewList=viewList;
    }


    public Object instantiateItem(ViewGroup container, int position) {
        View view = viewList.get(position);
        if (view.getParent()!=null){
            ((ViewGroup)view.getParent()).removeView(view);
        }
        container.addView(view);
        return view;
    }


    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public int getCount() {
        return viewList.size();
    }


    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
