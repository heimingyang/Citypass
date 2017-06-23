package com.example.citypass.cotroller.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/22 10:28
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mList;
    private Context context;

    public FragmentAdapter(FragmentManager fm, Context context, List<Fragment> mList) {
        super(fm);
        this.context = context;
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
