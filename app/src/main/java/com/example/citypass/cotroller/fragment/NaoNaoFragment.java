package com.example.citypass.cotroller.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.naonao.NaoNao_Tab_Adapter;
import com.example.citypass.cotroller.fragment.naonao.Di_NaoNao_Fragment;
import com.example.citypass.cotroller.fragment.naonao.Net_Friend_NaoNao_Fragment;
import com.example.citypass.cotroller.fragment.naonao.Picture_NaoNao_Fragment;
import com.example.citypass.cotroller.fragment.naonao.Recommond_NaoNao_Fragment;
import com.example.citypass.cotroller.fragment.naonao.Square_NaoNao_Fragment;
import com.example.citypass.cotroller.fragment.naonao.Star_NaoNao_Fragment;
import com.example.citypass.cotroller.fragment.naonao.Title_NaoNao_Fragment;
import com.example.citypass.cotroller.fragment.naonao.Wang_NaoNao_Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/20 0020 8:19
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

public class NaoNaoFragment extends BaseFragment {

    @BindView(R.id.naonao_tab)
    TabLayout naonaoTab;
    @BindView(R.id.NaoNao_viewpager)
    ViewPager naonaoViewpager;
    Unbinder unbinder;
    private List<Fragment> mFraList = new ArrayList<>();
    private List<String> mStrList = new ArrayList<>();

    @Override
    protected void initData() {

        mFraList.add(new Di_NaoNao_Fragment());
        mFraList.add(new Wang_NaoNao_Fragment());
        mFraList.add(new Star_NaoNao_Fragment());
        mFraList.add(new Square_NaoNao_Fragment());
        mFraList.add(new Title_NaoNao_Fragment());
        mFraList.add(new Recommond_NaoNao_Fragment());
        mFraList.add(new Picture_NaoNao_Fragment());
        mFraList.add(new Net_Friend_NaoNao_Fragment());
//        Map<String,String> map = new HashMap<>();
//        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"type\":1,\"siteID\":2422},\"requestTime\":\"2017-06-19 11:52:02\",\"customerKey\":\"B8ABEBF85C69DC0B7D33F4317B5AC0CB\",\"Method\":\"PHSocket_GetUseNavigationInfo\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":0,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
//        map.put("param",str);
//        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
//            @Override
//            public void onSuccess(String result) {
//                Log.d("NaoNaoFragment", result);
//                Gson gson = new Gson();
//                NaoNao_Bean bean =  gson.fromJson(result, NaoNao_Bean.class);
//                List<NaoNao_Bean.ServerInfoBean> mList = bean.getServerInfo();
//                for(int i = 0;i<mList.size();i++){
//                    mStrList.add(mList.get(i).getName());
//                }
//            }
//
//            @Override
//            public void onError(String errormsg) {
//                Log.d("NaoNaoFragment", errormsg);
//            }
//        });
        mStrList.add("闹闹帝");
        mStrList.add("闹闹王");
        mStrList.add("闹闹星");
        mStrList.add("广场");
        mStrList.add("话题");
        mStrList.add("推荐");
        mStrList.add("晒图");
        mStrList.add("网友自荐");
        naonaoTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        NaoNao_Tab_Adapter mAdapter = new NaoNao_Tab_Adapter(getActivity().getSupportFragmentManager(), mFraList, mStrList);
        naonaoViewpager.setAdapter(mAdapter);
        naonaoViewpager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(naonaoTab) {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });
        naonaoTab.setupWithViewPager(naonaoViewpager);
    }


    @Override
    protected void initListener() {

    }




    @Override
    protected void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_naonao;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        App.activity.getText().setText("闹闹");
        App.activity.getText().setCompoundDrawables(null, null, null, null);
        App.activity.getImgOne().setVisibility(View.INVISIBLE);
        App.activity.getImgTwo().setImageResource(R.drawable.mall_camera0);
    }


}
