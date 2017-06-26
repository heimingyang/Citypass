package com.example.citypass.cotroller.adapter.shequ;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.citypass.base.BaseFragment;

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
public class SheQuAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;
    private List<String> strings;
    private int itemCount;

    public SheQuAdapter(FragmentManager fm,List<BaseFragment> fragments,List<String> strings) {
        super(fm);
        this.fragments = fragments;
        this.strings = strings;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        if (fragments.size() != 0) {

            return fragments.size();

        }else {
            return 0;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}
