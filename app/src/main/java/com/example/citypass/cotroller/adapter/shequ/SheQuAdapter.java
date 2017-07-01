package com.example.citypass.cotroller.adapter.shequ;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/23 14:27
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class SheQuAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;
    private List<String> strings;

    public SheQuAdapter(FragmentManager fm, List<Fragment> mFraList, List<String> mStrList) {
        super(fm);
        this.fragments = mFraList;
        this.strings = mStrList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.isEmpty()?0:fragments.size();
    }

    @Override
    public void destroyItem(View container, int position, Object object) {

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
