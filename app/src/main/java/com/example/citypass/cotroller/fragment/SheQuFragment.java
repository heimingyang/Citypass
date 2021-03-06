package com.example.citypass.cotroller.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.activity.shequ.SouSuoActivity;
import com.example.citypass.cotroller.adapter.shequ.MingRenTangFragment;
import com.example.citypass.cotroller.adapter.shequ.SheQuAdapter;
import com.example.citypass.cotroller.fragment.information.IssuePostActivity;
import com.example.citypass.cotroller.fragment.shequ.BanQuFragment;
import com.example.citypass.cotroller.fragment.shequ.PengChangWangFragment;
import com.example.citypass.cotroller.fragment.shequ.ReTieFragment;
import com.example.citypass.cotroller.fragment.shequ.TuShuoFragment;
import com.example.citypass.cotroller.fragment.shequ.ZhiDeYiKanFragment;
import com.example.citypass.cotroller.fragment.shequ.ZhuanTiHuoDongFragment;
import com.example.citypass.cotroller.fragment.shequ.ZuiXinFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/20 0020 8:21
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

public class SheQuFragment extends BaseFragment {

    @BindView(R.id.Community_Tablayout)
    TabLayout CommunityTablayout;
    @BindView(R.id.Community_ViewPager)
    ViewPager CommunityViewPager;
    Unbinder unbinder;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> strings = new ArrayList<>();
    private View view;
    int a = 0;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_shequ;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        if (a == 0) {
            fragments = new ArrayList<>();
            strings = new ArrayList<>();

            fragments.add(new PengChangWangFragment());
            fragments.add(new MingRenTangFragment());
            fragments.add(new BanQuFragment());
            fragments.add(new ZuiXinFragment());
            fragments.add(new ReTieFragment());
            fragments.add(new TuShuoFragment());
            fragments.add(new ZhuanTiHuoDongFragment());
            fragments.add(new ZhiDeYiKanFragment());
            strings.add("捧场王");
            strings.add("名人堂");
            strings.add("版区");
            strings.add("最新");
            strings.add("热帖");
            strings.add("图说");
            strings.add("专题活动");
            strings.add("值得一看");
            CommunityTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            SheQuAdapter adapter = new SheQuAdapter(getFragmentManager(), fragments, strings);
            CommunityViewPager.setAdapter(adapter);
            CommunityViewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(CommunityTablayout) {
                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);
                }
            });

            CommunityTablayout.setupWithViewPager(CommunityViewPager);
            a = 1;

        }

    }

    @Override
    protected void initListener() {

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        App.activity.getText().setText("社区");
        App.activity.getText().setCompoundDrawables(null, null, null, null);
        App.activity.getImgOne().setVisibility(View.VISIBLE);
        App.activity.getImgOne().setImageResource(R.drawable.chazhao_back_normal);
        App.activity.getImgOne().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SouSuoActivity.class);
                startActivity(intent);
            }
        });
        App.activity.getImgTwo().setImageResource(R.drawable.ccoo_icon_edit_tran);
        App.activity.getImgTwo().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), IssuePostActivity.class);
                startActivity(intent);
            }
        });
    }


}
