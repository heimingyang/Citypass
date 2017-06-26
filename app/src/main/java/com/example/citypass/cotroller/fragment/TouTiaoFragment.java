package com.example.citypass.cotroller.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.example.citypass.App;

import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.toutiao.HttpurecyclerviewAdapter;
import com.example.citypass.cotroller.adapter.toutiao.HttviewpagerAdapter;
import com.example.citypass.cotroller.adapter.toutiao.TtfourDjGridAdapter;
import com.example.citypass.cotroller.toutiao.CityFoloActivity;
import com.example.citypass.cotroller.toutiao.HttlunbofourFragment;
import com.example.citypass.cotroller.toutiao.HttlunbooneFragment;
import com.example.citypass.cotroller.toutiao.HttlunbothreeFragment;
import com.example.citypass.cotroller.toutiao.HttlunbotwoFragment;
import com.example.citypass.model.bean.Information;
import com.example.citypass.model.bean.toutiao.Touqiaolistview;
import com.example.citypass.model.bean.toutiao.Toutiao;
import com.example.citypass.model.bean.toutiao.TtfourDJ;
import com.example.citypass.model.bean.toutiao.Ttgrxx;
import com.example.citypass.model.bean.toutiao.Ttrecyclertz;
import com.example.citypass.model.bean.toutiao.Ttrecyclertzxq;
import com.example.citypass.model.biz.infor.IInforModel;
import com.example.citypass.model.biz.infor.InforModel;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.DeviceUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/20 0020 8:17
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

public class TouTiaoFragment extends BaseFragment {

    private int page=1;
    private ArrayList<Touqiaolistview.ServerInfoBean.HeadTInfoListBean> list;
    private ArrayList<Fragment> fragments;
    private PullToRefreshRecyclerView httrecyclerview;
    private HttpurecyclerviewAdapter adapter;
    private int pager = 5;
    private int item;
    private TextView httNo1;
    private TextView httEntry;
    private TextView httWelcome;
    private RelativeLayout httBeforeEntry;
    private TextView httName;
    private ImageView httGenderMan;
    private ImageView httGenderWoman;
    private TextView httGrade;
    private TextView httRanking;
    private TextView httRanking1;
    private TextView httNo2;
    private TextView httSign;
    private RelativeLayout httAfterEntry;
    private RelativeLayout httLin1;
    private ViewPager ttViewpager;
    private GridView httgridview;

    private RadioButton httRadiobt1;
    private RadioButton httRadiobt2;
    private RadioButton httRadiobt3;
    private RadioButton httRadiobt4;
    private TextView httLin3;
    private RelativeLayout headerview;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 999:
                    item = pager % 4;
                    ttViewpager.setCurrentItem(item);
                    pager++;
                    break;
            }
        }
    };
    private ArrayList<TtfourDJ.ServerInfoBean> gridviewlist;
    private String siteName;
    private TextView honorname;
    private TtfourDjGridAdapter gridAdapter;
    private  Ttgrxx ttgrxx;

    @Override
    protected void initData() {

        getgrxx();



    }


    @Override
    protected void initListener() {
        App.activity.getImgOne().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        App.activity.getImgTwo().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        App.activity.getText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CityFoloActivity.class);
                getActivity().startActivity(intent);
            }
        });

    }

    @Override
    protected void initView(View view) {



        httrecyclerview = (PullToRefreshRecyclerView) view.findViewById(R.id.htt_recyclerview);

        //得到头布局
        headerview = (RelativeLayout) LayoutInflater.from(getActivity()).inflate(R.layout.htoutiao_headrview, null);
        honorname = (TextView) headerview.findViewById(R.id.honorname);
        httNo1 = (TextView) headerview.findViewById(R.id.htt_no1);
        httEntry = (TextView) headerview.findViewById(R.id.htt_entry);
        httWelcome = (TextView) headerview.findViewById(R.id.htt_welcome);
        httBeforeEntry = (RelativeLayout) headerview.findViewById(R.id.htt_before_entry);
        httName= (TextView) headerview.findViewById(R.id.htt_name);
        httGenderMan = (ImageView) headerview.findViewById(R.id.htt_gender_man);
        httGenderWoman = (ImageView) headerview.findViewById(R.id.htt_gender_woman);
        httGrade = (TextView) headerview.findViewById(R.id.htt_grade);
        httRanking1 = (TextView) headerview.findViewById(R.id.htt_ranking);
        httNo2 = (TextView) headerview.findViewById(R.id.htt_no2);
        httSign = (TextView) headerview.findViewById(R.id.htt_sign);
        httAfterEntry = (RelativeLayout) headerview.findViewById(R.id.htt_after_entry);
        httLin1 = (RelativeLayout) headerview.findViewById(R.id.htt_lin1);
        ttViewpager = (ViewPager) headerview.findViewById(R.id.tt_viewpager);
        httgridview = (GridView) headerview.findViewById(R.id.htt_gridview);
        httRadiobt1 = (RadioButton) headerview.findViewById(R.id.htt_radiobt1);
        httRadiobt2 = (RadioButton) headerview.findViewById(R.id.htt_radiobt2);
        httRadiobt3 = (RadioButton) headerview.findViewById(R.id.htt_radiobt3);
        httRadiobt4 = (RadioButton) headerview.findViewById(R.id.htt_radiobt4);
        httLin3 = (TextView) headerview.findViewById(R.id.htt_lin3);
        gridviewlist = new ArrayList<>();
        gridAdapter = new TtfourDjGridAdapter(getActivity(),gridviewlist);

        list = new ArrayList<>();
        adapter = new HttpurecyclerviewAdapter(getActivity(), list);
        httgridview.setAdapter(gridAdapter);
        //加载recyclerview
        initrecyclerview();

        //加载轮播
        initlunbo();

        //gridview网络请求
        getgridviewdata();

        //加载gridview;

    }



    @Override
    public int getLayoutId() {
        return R.layout.fragment_toutiao;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        App.activity.getImgOne().setVisibility(View.VISIBLE);
        App.activity.getImgTwo().setVisibility(View.VISIBLE);
        App.activity.getText().setVisibility(View.VISIBLE);
        Drawable drawable = App.activity.getResources().getDrawable(R.drawable.user_set_rigth_down);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        App.activity.getText().setCompoundDrawables(null, null, drawable, null);
        App.activity.getImgOne().setImageResource(R.drawable.ccoo_icon_mes);
        App.activity.getImgTwo().setImageResource(R.drawable.mall_changeadd);

    }


    private void gethttpdata(int page) {
        this.page=page;
        Toutiao.ParamBean param = new Toutiao.ParamBean();
        param.setSiteID(2422);
        param.setPageSize(10);
        param.setPage(page);

        Toutiao.StatisBean statis = new Toutiao.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(getActivity()));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(getActivity()));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        statis.setUserId(0);


        Toutiao toutiao = new Toutiao();
        toutiao.setMethod("PHSocket_GetHeadlinesInfoT");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("BC3BE051462325B907AD613D4A4AD8CE");
        toutiao.setRequestTime(TimeUtils.getdangqianshijian());
        toutiao.setVersion("4.5");
        Gson gson = new Gson();
        String s = gson.toJson(toutiao);
        Map<String, String> map = new HashMap<>();
        map.put("param", s);
        //Log.e("TTTTTTTTT",s);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                // Log.e("onSuccess", result.toString());
                Touqiaolistview ttt = JSON.parseObject(result, Touqiaolistview.class);
                list.addAll(ttt.getServerInfo().getHeadTInfoList());
                adapter.notifyDataSetChanged();
                // Log.e("list", list.size() + "");
            }

            @Override
            public void onError(String errormsg) {
                Log.e("onError", errormsg);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }


    private void initlunbo() {
        fragments = new ArrayList<>();
        fragments.add(new HttlunbooneFragment());
        fragments.add(new HttlunbotwoFragment());
        fragments.add(new HttlunbothreeFragment());
        fragments.add(new HttlunbofourFragment());
        HttviewpagerAdapter adapter1 = new HttviewpagerAdapter(getChildFragmentManager(), fragments);
        ttViewpager.setAdapter(adapter1);
        ttViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                item = position;
                String id = String.valueOf(position);
                if (id.equals("0")) {
                    httRadiobt1.setChecked(true);
                } else if (id.equals("1")) {
                    httRadiobt2.setChecked(true);
                } else if (id.equals("2")) {
                    httRadiobt3.setChecked(true);
                } else if (id.equals("3")) {
                    httRadiobt4.setChecked(true);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //轮播图send message
        sendlunbomessage();

    }

    private void sendlunbomessage() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(999);

            }
        }, 2000, 2000);
    }
    private void initrecyclerview() {


        //recyclerview网络请求
        gethttpdata(page);

        httrecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        httrecyclerview.addHeaderView(headerview);
        //设置布局格式
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        httrecyclerview.setLayoutManager(manager);

        //设置下拉刷新下拉加载
        httrecyclerview.setLoadingMoreEnabled(true);
        httrecyclerview.setPullRefreshEnabled(false);
        httrecyclerview.displayLastRefreshTime(true);

        httrecyclerview.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                httrecyclerview.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        gethttpdata(page);
                        httrecyclerview.setLoadMoreComplete();
                    }
                }, 2000);
            }
        });
    }


    public void getgridviewdata() {
        Toutiao.ParamBean param = new Toutiao.ParamBean();
        param.setSiteID(2422);

        Toutiao.StatisBean statis = new Toutiao.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(getActivity()));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(getActivity()));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        statis.setUserId(0);

        Toutiao toutiao = new Toutiao();
        toutiao.setMethod("PHSocket_GetHomeNavigationInfo");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("BC3BE051462325B907AD613D4A4AD8CE");
        toutiao.setRequestTime(TimeUtils.getdangqianshijian());
        toutiao.setVersion("4.5");
        Gson gson = new Gson();
        String s = gson.toJson(toutiao);
        Map<String, String> map = new HashMap<>();
        map.put("param", s);
        //Log.e("TTTTTTTTT",s);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                //Log.e("gridview", result.toString());
                TtfourDJ f = JSON.parseObject(result, TtfourDJ.class);
                for (int i = 0; i < f.getServerInfo().size(); i++) {
                    gridviewlist.add(f.getServerInfo().get(i));
                }
//                gridviewlist.addAll(f.getServerInfo());
                gridAdapter.notifyDataSetChanged();
                // Log.e("list", list.size() + "");
            }

            @Override
            public void onError(String errormsg) {
                Log.e("onError", errormsg);
            }
        });
    }

    public void getgrxx() {
        Ttrecyclertz.ParamBean param = new Ttrecyclertz.ParamBean();
        param.setSiteID(2422);
        param.setUserName("sid094756353406476");

        Ttrecyclertz.StatisBean statis = new Ttrecyclertz.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(getActivity()));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(getActivity()));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        statis.setUserId(0);


        Ttrecyclertz toutiao = new Ttrecyclertz();
        toutiao.setMethod("PHSocket_GetBBSUsersInfoNew");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("6A03DD7EF1340C00C2F34480A980C2E7");
        toutiao.setRequestTime(TimeUtils.getdangqianshijian());
        toutiao.setVersion("4.5");
        Gson gson = new Gson();
        String s = gson.toJson(toutiao);
        // Log.e("onSuccess", s);

        InforModel inforModel = new IInforModel();
        inforModel.UpLoad(s, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                //Log.e("getgrxx", "TZ"+result);
                ttgrxx=JSON.parseObject(result,Ttgrxx.class);
                Log.e("getgrxx", "TZ"+ttgrxx.toString());
                if (ttgrxx!=null) {
                    httBeforeEntry.setVisibility(View.GONE);
                    httAfterEntry.setVisibility(View.VISIBLE);

                    Ttgrxx.ServerInfoBean bean= ttgrxx.getServerInfo();
                    if(bean!=null){

                        App.activity.getText().setText(bean.getSiteName());

                        String sex=bean.getSex();

                        httName.setText(bean.getNick());
                        if(sex.equals("男")){
                            httGenderMan.setImageResource(R.drawable.ccoo_icon_boy);
                            httGenderWoman.setVisibility(View.GONE);
                        }else if(sex.equals("女")){
                            httGenderMan.setImageResource(R.drawable.ccoo_icon_girl);
                            httGenderWoman.setVisibility(View.GONE);
                        }

                        httGrade.setText("Lv."+bean.getLevel());
                        honorname.setText(bean.getHonorName());
                        httRanking1.setText("排名："+bean.getIntegralRank());
                    }

                } else {
                    httBeforeEntry.setVisibility(View.VISIBLE);
                    httAfterEntry.setVisibility(View.GONE);
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
}
