package com.example.citypass.cotroller.adapter.naonao.detail;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/1 10:11
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class NaoNao_ViewPager extends PagerAdapter {
    private List<View> viewList;

    public NaoNao_ViewPager(List<View> viewList) {
        this.viewList = viewList;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

//        super.destroyItem(container, position, object);
        container.removeView(viewList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        if (container != null) {
//            container.removeView(viewList.get(position));
//        }
        container.addView(viewList.get(position));

        return viewList.get(position);
    }
}
