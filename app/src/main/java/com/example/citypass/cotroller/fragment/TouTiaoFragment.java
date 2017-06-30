package com.example.citypass.cotroller.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.HomeActivity;
import com.example.citypass.cotroller.adapter.toutiao.HttpurecyclerviewAdapter;
import com.example.citypass.cotroller.adapter.toutiao.HttviewpagerAdapter;
import com.example.citypass.cotroller.adapter.toutiao.TtfourDjGridAdapter;
import com.example.citypass.cotroller.adapter.toutiao.TtpoupwindowDjGridAdapter;
import com.example.citypass.cotroller.fragment.information.CityActivity;
import com.example.citypass.cotroller.fragment.information.LevelActivity;
import com.example.citypass.cotroller.fragment.information.LoginActivity;
import com.example.citypass.cotroller.fragment.information.MedalActivity;
import com.example.citypass.cotroller.fragment.information.NotifyActivity;
import com.example.citypass.cotroller.fragment.information.PersonalActivity;
import com.example.citypass.cotroller.fragment.information.TaskActivity;
import com.example.citypass.cotroller.fragment.life.WebViewActivity;
import com.example.citypass.cotroller.fragment.toutiao.CityFoloActivity;
import com.example.citypass.cotroller.fragment.toutiao.FunctionActivity;
import com.example.citypass.cotroller.fragment.toutiao.GoodMannersActivity;
import com.example.citypass.cotroller.fragment.toutiao.HttlunbofourFragment;
import com.example.citypass.cotroller.fragment.toutiao.HttlunbooneFragment;
import com.example.citypass.cotroller.fragment.toutiao.HttlunbothreeFragment;
import com.example.citypass.cotroller.fragment.toutiao.HttlunbotwoFragment;
import com.example.citypass.cotroller.fragment.toutiao.MyProgressDialog;
import com.example.citypass.cotroller.fragment.toutiao.SignDialog;
import com.example.citypass.model.bean.information.Information;
import com.example.citypass.model.bean.toutiao.Signbean;
import com.example.citypass.model.bean.toutiao.Signresult;
import com.example.citypass.model.bean.toutiao.Touqiaolistview;
import com.example.citypass.model.bean.toutiao.Toutiao;
import com.example.citypass.model.bean.toutiao.TtPoupwindowbean;
import com.example.citypass.model.bean.toutiao.TtfourDJ;
import com.example.citypass.model.bean.toutiao.Ttpoupwindowinterbean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.DeviceUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.MyRunable;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.example.citypass.utils.UrlUtils;
import com.example.citypass.utils.WebViewUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

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

    @BindView(R.id.hdrawer_tv_no1)
    TextView hdrawerTvNo1;
    @BindView(R.id.hdrawer_tv_wealth_front)
    TextView hdrawerTvWealthFront;
    @BindView(R.id.hdrawer_tv_wealth)
    TextView hdrawerTvWealth;
    @BindView(R.id.hdrawer_tv_grade_front)
    TextView hdrawerTvGradeFront;
    @BindView(R.id.hdrawer_tv_grade)
    TextView hdrawerTvGrade;
    @BindView(R.id.hdrawer_resident)
    TextView hdrawerResident;
    @BindView(R.id.hdrawer_tv_medal_front)
    TextView hdrawerTvMedalFront;
    @BindView(R.id.hdrawer_tv_medal)
    TextView hdrawerTvMedal;
    @BindView(R.id.hdrawer_earnmoney)
    TextView hdrawerEarnmoney;
    @BindView(R.id.hdrawer_spendmoney)
    TextView hdrawerSpendmoney;
    @BindView(R.id.hdrawer_lin1)
    LinearLayout hdrawerLin1;
    @BindView(R.id.hdrawer_luckdraw)
    TextView hdrawerLuckdraw;
    @BindView(R.id.hdrawer_goodmanners)
    TextView hdrawerGoodmanners;
    Unbinder unbinder;
    @BindView(R.id.hdrawer_earnmoney_rin1)
    RelativeLayout hdrawerEarnmoneyRin1;
    @BindView(R.id.hdrawer_earnmoney_rin2)
    RelativeLayout hdrawerEarnmoneyRin2;
    @BindView(R.id.hdrawer_earnmoney_rin3)
    RelativeLayout hdrawerEarnmoneyRin3;
    @BindView(R.id.htt_drawer)
    RelativeLayout httDrawer;
    private int page = 1;
    private ArrayList<Touqiaolistview.ServerInfoBean.HeadTInfoListBean> list;
    private ArrayList<Fragment> fragments;
    private PullToRefreshRecyclerView httrecyclerview;
    private HttpurecyclerviewAdapter recyclerviewadapter;
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
    private SignDialog signDialog;
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
    private ImageView imageView;
    private GridView gridView;
    private TtpoupwindowDjGridAdapter poupwindowadapter;
    private RelativeLayout relativeLayout;
    private PopupWindow popupWindow;
    private ArrayList<TtfourDJ.ServerInfoBean> gridviewlist;
    private String siteName;
    private TextView honorname;
    private TtfourDjGridAdapter gridAdapter;
    private ArrayList<TtPoupwindowbean.ServerInfoBean.ConfigDataBean> poupwindowlist;
    private boolean login;
    private View inflate;
    private RelativeLayout httdrawer;
    private RelativeLayout httdrawer1;
    private boolean isfirst;
    private MyProgressDialog dialog;
    @Override
    protected void initData() {
        //登录状态
        loginstate();
    }

    @Override
    protected void initListener() {

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*
              *  gridview Item动画依次消失
             *    popupWindow消失
             *    控件动画
             * */

                if(isfirst){

                }else {
                    isfirst = true;
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {

                        @Override
                        public void run() {
                            isfirst = false;
                        }
                    }, 2520);
                    makepopupWindowdismiss();
                }


            }
        });


        //PullToRefreshRecyclerView  上拉下拉隐藏显示  drawer
        httrecyclerview.addOnScrollListener(new RecyclerViewScrollListener() {
            @Override
            public void hide() {
                httdrawer1.setVisibility(View.GONE);
//                httrecyclerview.animate().translationY(80).setInterpolator(new AccelerateDecelerateInterpolator());
                httdrawer.animate().translationY(-httdrawer.getHeight()).setInterpolator(new AccelerateDecelerateInterpolator());
                httdrawer.setVisibility(View.GONE);
            }

            @Override
            public void show() {
                httdrawer1.setVisibility(View.VISIBLE);
                httdrawer.setVisibility(View.VISIBLE);
//                httrecyclerview.animate().translationY(80).setInterpolator(new AccelerateDecelerateInterpolator());
                httdrawer.animate().translationY(0).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });
    }

    @Override
    protected void initView(View view) {


        httdrawer = (RelativeLayout) view.findViewById(R.id.htt_drawer);
        //准备poupwindow
        preparepoupwindow();
        relativeLayout = (RelativeLayout) inflate.findViewById(R.id.poponclick);

        httrecyclerview = (PullToRefreshRecyclerView) view.findViewById(R.id.htt_recyclerview);

        //得到头布局
        headerview = (RelativeLayout) LayoutInflater.from(getActivity()).inflate(R.layout.htoutiao_headrview, null);
        httdrawer1 = (RelativeLayout) headerview.findViewById(R.id.htt_drawer2);
        honorname = (TextView) headerview.findViewById(R.id.honorname);
        httNo1 = (TextView) headerview.findViewById(R.id.htt_no1);
        httEntry = (TextView) headerview.findViewById(R.id.htt_entry);
        httWelcome = (TextView) headerview.findViewById(R.id.htt_welcome);
        httBeforeEntry = (RelativeLayout) headerview.findViewById(R.id.htt_before_entry);
        httName = (TextView) headerview.findViewById(R.id.htt_name);
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
        gridAdapter = new TtfourDjGridAdapter(getActivity(), gridviewlist);

        list = new ArrayList<>();
        recyclerviewadapter = new HttpurecyclerviewAdapter(getActivity(), list);
        httgridview.setAdapter(gridAdapter);

        //加载recyclerview
        initrecyclerview();

        //加载轮播
        initlunbo();

        //gridview网络请求
        getgridviewdata();
        //recyclerview中gridview点击事件
        recyclerviewgridviewlistener();

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
        App.activity.getText().setText("延庆在线");
        App.activity.getImgOne().setImageResource(R.drawable.ccoo_icon_tuisong_noral);
        App.activity.getImgTwo().setImageResource(R.drawable.mall_changeadd);

        //题目中的点击事件
        titlelistener();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    //recyclerview中gridview点击事件
    private void recyclerviewgridviewlistener() {
        httgridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        WebViewUtils.UtilIntent(getContext(), UrlUtils.ZhaoGongZuo, "找工作");
                        break;
                    case 1:
                        WebViewUtils.UtilIntent(getContext(), UrlUtils.ZhaoFangZi, "房屋交易");
                        break;
                    case 2:
                        Intent intent=new Intent(getActivity(), FunctionActivity.class);
                        SpUtils.upSp().putString("htag","分类生活").commit();
                        getActivity().startActivity(intent);
                        break;
                    case 3:
                        Intent intent1=new Intent(getActivity(), FunctionActivity.class);
                        SpUtils.upSp().putString("htag","同城爆料").commit();
                        getActivity().startActivity(intent1);
                        break;
                }
            }
        });
    }

    //poupwindow
    private void preparepoupwindow() {
        //poupwindow的布局
        inflate = LayoutInflater.from(getActivity()).inflate(R.layout.pop, null);

        gridView = (GridView) inflate.findViewById(R.id.pp);
        poupwindowlist = new ArrayList<>();
        //加载poupwindow的数据
        getpoupwindowdata();
        poupwindowadapter = new TtpoupwindowDjGridAdapter(getActivity(), poupwindowlist);
        gridView.setAdapter(poupwindowadapter);
        popupWindow = new PopupWindow(inflate, LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT, false);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

    }

    //头部 图片点击事件
    private void titlelistener() {
        App.activity.getImgOne().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NotifyActivity.class);
                getActivity().startActivity(intent);
            }
        });


        App.activity.getImgTwo().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!popupWindow.isShowing()) {
                    // 显示窗口
                    showpopupWindow(v);
                }

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

    //recyclerview 加载数据
    private void gethttpdata(int page) {
        this.page = page;
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
                recyclerviewadapter.notifyDataSetChanged();
                // Log.e("list", list.size() + "");
            }

            @Override
            public void onError(String errormsg) {
                Log.e("onError", errormsg);
            }
        });
    }

    //轮播图
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

    //初始化recyclerview
    private void initrecyclerview() {


        //recyclerview网络请求
        gethttpdata(page);

        httrecyclerview.setAdapter(recyclerviewadapter);
        recyclerviewadapter.notifyDataSetChanged();
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

    //gridview 加载数据
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

    //展示poupwindow
    private void showpopupWindow(final View v) {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.showallimg);
        animation.setDuration(300);
        App.activity.getImgTwo().startAnimation(animation);
        animation.setFillAfter(true);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                gridView.setLayoutAnimation(getAnimationstart());
                popupWindow.showAsDropDown(v, 0, -150);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    //poupwindow 消失
    private void makepopupWindowdismiss() {
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(popupWindow.isShowing()){
                    popupWindow.dismiss();
                    Animation disanimation = AnimationUtils.loadAnimation(getActivity(), R.anim.disallimg);
                    disanimation.setDuration(300);
                    App.activity.getImgTwo().startAnimation(disanimation);
                    disanimation.setFillAfter(true);
                }

            }
        };



        handler.post(new Runnable() {
            @Override
            public void run() {
                if (popupWindow.isShowing()) {
                    gridView.setLayoutAnimation(getAnimationend());
                    poupwindowadapter.notifyDataSetChanged();
                    handler.postDelayed(runnable, 2000);
                }}
        });

    }

    /**
     * Layout开始动画
     *
     * @return
     */
    protected LayoutAnimationController getAnimationstart() {
        int duration = 500;
        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(duration);
        set.addAnimation(animation);

        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0.0f,
                Animation.RELATIVE_TO_SELF,
                0.0f,
                Animation.RELATIVE_TO_SELF,
                2.0f,
                Animation.RELATIVE_TO_SELF,
                -0.1f);
        animation.setDuration(duration);
        set.addAnimation(animation);

        LayoutAnimationController controller = new LayoutAnimationController(set, 0.5f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        return controller;
    }

    /**
     * Layout结束动画
     *
     * @return
     */
    protected LayoutAnimationController getAnimationend() {
        int duration = 400;
        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(duration);
        animation.setFillAfter(true);
        set.addAnimation(animation);

        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0.0f,
                Animation.RELATIVE_TO_SELF,
                0.0f,
                Animation.RELATIVE_TO_SELF,
                0.0f,
                Animation.RELATIVE_TO_SELF,
                1.0f);
        animation.setFillAfter(true);
        animation.setDuration(duration);
        set.addAnimation(animation);

        LayoutAnimationController controller = new LayoutAnimationController(set, 0.5f);
        controller.setOrder(LayoutAnimationController.ORDER_REVERSE);
        return controller;
    }

    //poupwindow中gridview加载数据
    public void getpoupwindowdata() {
        Ttpoupwindowinterbean.ParamBean param = new Ttpoupwindowinterbean.ParamBean();
        param.setSiteid(2422);

        Ttpoupwindowinterbean.StatisBean statis = new Ttpoupwindowinterbean.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(getActivity()));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(getActivity()));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        if (login) {
            statis.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, null)));
        } else {
            statis.setUserId(0);
        }

        Ttpoupwindowinterbean toutiao = new Ttpoupwindowinterbean();
        toutiao.setMethod("PHSocket_GetPubConfigInfo");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("7C2DA07E46429F1740C7CB843DB420C7");
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
                //Log.e("poupwindowlist", result.toString());
                TtPoupwindowbean f = JSON.parseObject(result, TtPoupwindowbean.class);
                poupwindowlist.addAll(f.getServerInfo().getConfigData());
                poupwindowadapter.notifyDataSetChanged();
                // Log.e("list", list.size() + "");
            }

            @Override
            public void onError(String errormsg) {
                Log.e("onError", errormsg);
            }
        });
    }

    //登录状态
    public void loginstate() {
        //创建dialog
        dialog = new MyProgressDialog(getActivity());
        signDialog = new SignDialog(getActivity());

        login = SpUtils.getSp().getBoolean(LoginUtils.LOGIN, true);
        Information information = LoginUtils.information;
        //Log.e("login", login +"");

        if (login && information != null) {
            httBeforeEntry.setVisibility(View.GONE);
            httAfterEntry.setVisibility(View.VISIBLE);
            Information.ServerInfoBean bean = information.getServerInfo();
            if (bean != null) {
                App.activity.getText().setText(bean.getSiteName());

                String sex = bean.getSex();

                httName.setText(bean.getNick());
                if (sex.equals("男")) {
                    httGenderMan.setImageResource(R.drawable.ccoo_icon_boy);
                    httGenderWoman.setVisibility(View.GONE);
                } else if (sex.equals("女")) {
                    httGenderMan.setImageResource(R.drawable.ccoo_icon_girl);
                    httGenderWoman.setVisibility(View.GONE);
                }

                httGrade.setText("Lv." + bean.getLevel());
                honorname.setText(bean.getHonorName());
                httRanking1.setText("排名：" + bean.getIntegralRank());

                // TODO: 2017/6/29
                //签到
                httSign.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //签到网络请求 dialog显示
                        signinter();
                        dialog.show();
                    }
                });

                httName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), PersonalActivity.class);
                        intent.putExtra("id",Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,null)));
                        getActivity().startActivity(intent);
                    }
                });
                httGrade.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), CityActivity.class);
                        getActivity().startActivity(intent);
                    }
                });
                httRanking1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), LevelActivity.class);
                        getActivity().startActivity(intent);
                    }
                });

            }

        } else {
            httBeforeEntry.setVisibility(View.VISIBLE);
            httAfterEntry.setVisibility(View.GONE);
            httBeforeEntry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    getActivity().startActivity(intent);
                }
            });
        }
    }

    //签到网络请求 dialog显示
    private void signinter() {
        if (login) {
            Signbean.ParamBean param = new Signbean.ParamBean();
            param.setSiteID(2422);
            param.setUserID(SpUtils.getSp().getString(LoginUtils.USERID, null));

            Signbean.StatisBean statis = new Signbean.StatisBean();
            statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(getActivity()));
            statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
            statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(getActivity()));
            statis.setSiteId(2422);
            statis.setSystemNo(2);
            DeviceUtils.getInstance();
            statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
            statis.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, null)));

            Signbean toutiao = new Signbean();
            toutiao.setMethod("PHSocket_GetUserSign");
            toutiao.setParam(param);
            toutiao.setStatis(statis);
            toutiao.setAppName("CcooCity");
            toutiao.setCustomerID(8001);
            toutiao.setCustomerKey("BE9EEC155A5D7B65FCA3380831ECBD8B");
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
                    //Log.e("Signresult", result);
                    Signresult signresult=JSON.parseObject(result,Signresult.class);
                    if(result==null){
                        return;
                    }
                    int code=signresult.getMessageList().getCode();
                    dialog.dismiss();
                    MyRunable.mainthread(new TimerTask() {
                        @Override
                        public void run() {
                            httSign.setText("已签到");
                            httSign.setTextColor(getResources().getColor(R.color.tv_black));
                            Drawable draw=getResources().getDrawable(R.drawable.already);
                            draw.setBounds(0, 0, draw.getMinimumWidth(), draw.getMinimumHeight());
                            httSign.setCompoundDrawables(draw,null,null,null);
                        }
                    });
                    if (code == 1000) {
                        int Coin=signresult.getExtend().getReTask().get(0).getCoin();
                        int Integral=signresult.getExtend().getReTask().get(0).getIntegral();
                        int UserSignday=signresult.getServerInfo().getSignInfo().getUserSignday();
                        int Continuous=signresult.getServerInfo().getSignInfo().getContinuous();
                        int LXCoin=signresult.getServerInfo().getSignInfo().getLXCoin();
                        signDialog.show();
                        signDialog.showDialog(Coin, Integral, UserSignday, "连续签到"
                                + Continuous + "天将额外获得" + LXCoin + "城市币", "第"
                                + (Continuous + 1) + "天开始重新计算签到天数");
                        Toast.makeText(getActivity(),"签到成功",Toast.LENGTH_LONG).show();
                    } else if (code == 1002) {
                        Toast.makeText(getActivity(),"非本站用户 签到失败",Toast.LENGTH_LONG).show();
                    } else if (code == 1003) {
                        Toast.makeText(getActivity(),"正在升级中...",Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getActivity(),"你今天已签过到了~",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onError(String errormsg) {
                    Log.e("onError", errormsg);
                }
            });
        }else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            getActivity().startActivity(intent);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.hdrawer_earnmoney_rin1, R.id.hdrawer_earnmoney_rin2, R.id.hdrawer_earnmoney_rin3, R.id.hdrawer_earnmoney, R.id.hdrawer_spendmoney, R.id.hdrawer_luckdraw, R.id.hdrawer_goodmanners})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hdrawer_earnmoney_rin1:
                Intent intent1=new Intent(getActivity(), CityActivity.class);
                getActivity().startActivity(intent1);
                break;
            case R.id.hdrawer_earnmoney_rin2:
                Intent intent2=new Intent(getActivity(), LevelActivity.class);
                getActivity().startActivity(intent2);
                break;
            case R.id.hdrawer_earnmoney_rin3:
                Intent intent3=new Intent(getActivity(), MedalActivity.class);
                getActivity().startActivity(intent3);
                break;
            case R.id.hdrawer_earnmoney:
                Intent intent4=new Intent(getActivity(), TaskActivity.class);
                getActivity().startActivity(intent4);
                break;
            case R.id.hdrawer_spendmoney:
//                Intent intent5=new Intent(getActivity(), ShoppingActivity.class);
//                getActivity().startActivity(intent5);
                break;
            case R.id.hdrawer_luckdraw:
                Intent intentTwo = new Intent(getActivity(), WebViewActivity.class);
                intentTwo.putExtra("url","http://m.yanqing.ccoo.cn/choujiang.aspx");
                intentTwo.putExtra("webview_title","抽奖活动");
                startActivity(intentTwo);
                break;
            case R.id.hdrawer_goodmanners:
                Intent intent7=new Intent(getActivity(), GoodMannersActivity.class);
                getActivity().startActivity(intent7);
                break;
        }
    }

    //重写recyclerview的滑动监听
    public abstract class RecyclerViewScrollListener extends RecyclerView.OnScrollListener {
        private static final int SCROLL_DISTANCE = 50;
        private int totalScrollDistance;
        private boolean isShow = true;

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int firstVisableItem = ((LinearLayoutManager) recyclerView
                    .getLayoutManager()).findFirstCompletelyVisibleItemPosition();

            // Log.e("firstVisableItem", firstVisableItem + "");
            if ((dy > 0 && isShow) || (dy < 0 && !isShow)) {
                totalScrollDistance += dy;
            }
            //当第一个item存在界面上时就不触发隐藏、显示操作
            if (firstVisableItem == 1) {
                //show();
                if (totalScrollDistance < -SCROLL_DISTANCE && !isShow) {
                    show();
                    isShow = true;
                    totalScrollDistance = 0;
                }
            } else {
                if (totalScrollDistance > SCROLL_DISTANCE && isShow) {
                    hide();
                    isShow = false;
                    totalScrollDistance = 0;
                }
                //hide();
            }

        }

        public abstract void hide();

        public abstract void show();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (signDialog != null) {
            signDialog.dismiss();
        }
    }
}
