package com.example.citypass.cotroller.adapter.naonao;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/28 21:55
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class NaoNaoDetailAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mList;
    private List<String> strList;

    public NaoNaoDetailAdapter(FragmentManager fm, List<Fragment> mList, List<String> strList) {
        super(fm);
        this.mList = mList;
        this.strList = strList;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }



    @Override
    public CharSequence getPageTitle(int position) {
        return strList.get(position);
    }
}
