package com.example.citypass.cotroller.fragment.toutiao;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.toutiao.HgoodmannerslAdapter;
import com.example.citypass.cotroller.fragment.toutiao.citymatter.HSociologyFragment;
import com.example.citypass.cotroller.fragment.toutiao.citymatter.HattitudeFragment;
import com.example.citypass.cotroller.fragment.toutiao.citymatter.HdivingFragment;
import com.example.citypass.cotroller.fragment.toutiao.citymatter.HentertainmentFragment;
import com.example.citypass.cotroller.fragment.toutiao.citymatter.HjustFragment;
import com.example.citypass.cotroller.fragment.toutiao.citymatter.HlifeFragment;
import com.example.citypass.cotroller.fragment.toutiao.citymatter.HnewestFragment;
import com.example.citypass.cotroller.fragment.toutiao.citymatter.HsoysauceFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/30 9:24
 * 修改人:
 * 修改内容:
 * 修改时间:
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */

public class HcitymatterFragment extends BaseFragment {
    @BindView(R.id.citymatter_tablayout)
    TabLayout citymatterTablayout;
    @BindView(R.id.citymatter_viewpager)
    ViewPager citymatterViewpager;
    Unbinder unbinder;
    private String[] title={"有态度","打酱油","爱潜水","最新","社会","正事","生活","娱乐"};

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {

        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new HattitudeFragment());
        fragments.add(new HsoysauceFragment());
        fragments.add(new HdivingFragment());
        fragments.add(new HnewestFragment());
        fragments.add(new HSociologyFragment());
        fragments.add(new HjustFragment());
        fragments.add(new HlifeFragment());
        fragments.add(new HentertainmentFragment());

        HgoodmannerslAdapter adapter=new HgoodmannerslAdapter(getChildFragmentManager(),fragments,title);
        citymatterViewpager.setAdapter(adapter);

        citymatterViewpager.setOffscreenPageLimit(8);
        citymatterTablayout.setupWithViewPager(citymatterViewpager);

        citymatterTablayout.setTabMode(TabLayout.GRAVITY_FILL);

        citymatterTablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getActivity(),R.color.red));
        citymatterTablayout.setTabTextColors
                (ContextCompat.getColor(getActivity(),R.color.black),ContextCompat.getColor(getActivity(),R.color.red));

        //默认选项
        citymatterTablayout.getTabAt(3).select();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.hcitymatter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
