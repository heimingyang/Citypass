package com.example.citypass.cotroller.fragment.naonao;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.base.CircleImageView;
import com.example.citypass.cotroller.fragment.information.LoginActivity;
import com.example.citypass.cotroller.fragment.information.PersonalActivity;
import com.example.citypass.cotroller.adapter.naonao.DiNaoNao_Recycle_Adapter;
import com.example.citypass.model.bean.naonao.Di_NaoNao_Bean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.view.MRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/20 0020 17:02
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


public class Di_NaoNao_Fragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.di_naonao_recycle)
    MRecyclerView diNaonaoRecycle;
    CircleImageView diNaonaoImageSecond;
    TextView diNaonaoNameSecond;
    CircleImageView diNaonaoImageFirst;
    TextView diNaonaoNameFirst;
    CircleImageView diNaonaoImageThird;
    TextView diNaonaoNameThird;
    TextView diNaonaoCountSecond;
    TextView diNaonaoCountFirst;
    TextView diNaonaoCountThird;
    Unbinder unbinder;
    private DiNaoNao_Recycle_Adapter adapter;
    private List<Di_NaoNao_Bean.ServerInfoBean.InfoBean> mList = new ArrayList<>();
    private int a = 0;
    private Di_NaoNao_Bean di_naoNao_fragment;
    private View v;

    // TODO: 2017/6/26 0026  找布局
    @Override
    protected int getLayoutId() {
        return R.layout.di_naonao_fragment;
    }

    // TODO: 2017/6/26 0026 找id 
    private void initViews() {
        diNaonaoImageSecond = (CircleImageView) v.findViewById(R.id.di_naonao_image_second);
        diNaonaoCountThird = (TextView) v.findViewById(R.id.di_naonao_count_third);
        diNaonaoCountFirst = (TextView) v.findViewById(R.id.di_naonao_count_first);
        diNaonaoCountSecond = (TextView) v.findViewById(R.id.di_naonao_count_second);
        diNaonaoNameThird = (TextView) v.findViewById(R.id.di_naonao_name_third);
        diNaonaoImageThird = (CircleImageView) v.findViewById(R.id.di_naonao_image_third);
        diNaonaoNameSecond = (TextView) v.findViewById(R.id.di_naonao_name_second);
        diNaonaoImageFirst = (CircleImageView) v.findViewById(R.id.di_naonao_image_first);
        diNaonaoNameFirst = (TextView) v.findViewById(R.id.di_naonao_name_first);
    }

    // TODO: 2017/6/26 0026 加载数据
    @Override
    protected void initData() {
        if (a == 0) {


            initParsing();
            //上拉加载下拉刷新的监听
            diNaonaoRecycle.setLoadingListener(new MRecyclerView.LoadingListener() {
                @Override
                public void onRvScrolled(int dx, int dy) {

                }

                //刷新
                @Override
                public void onRefresh() {
                    diNaonaoRecycle.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            initParsing();
                            diNaonaoRecycle.refreshComplete();
                        }
                    },2000);
                }

                //加载
                @Override
                public void onLoadMore() {
                    diNaonaoRecycle.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            initParsing();
                            diNaonaoRecycle.loadMoreComplete();
                        }
                    },2000);
                }
            });
            a = 1;
        }
    }

    // TODO: 2017/6/26 0026 请求网络 返回数据 
    private void initParsing() {
        Map<String, String> map = new HashMap<>();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"userID\":0,\"siteID\":2422},\"requestTime\":\"2017-06-19 11:52:02\",\"customerKey\":\"586802D0212E23BDA21DCFAD76CF5257\",\"Method\":\"PHSocket_GetTieBaTopicRank\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":0,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        map.put("param", str);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("Di_NaoNao_Fragment", result);
                di_naoNao_fragment = JSON.parseObject(result, Di_NaoNao_Bean.class);
                diNaonaoCountFirst.setText(di_naoNao_fragment.getServerInfo().getInfo().get(0).getSum());
                diNaonaoCountSecond.setText(di_naoNao_fragment.getServerInfo().getInfo().get(1).getSum());
                diNaonaoCountThird.setText(di_naoNao_fragment.getServerInfo().getInfo().get(2).getSum());
                diNaonaoNameFirst.setText(di_naoNao_fragment.getServerInfo().getInfo().get(0).getNick());
                diNaonaoNameSecond.setText(di_naoNao_fragment.getServerInfo().getInfo().get(1).getNick());
                diNaonaoNameThird.setText(di_naoNao_fragment.getServerInfo().getInfo().get(2).getNick());
                Glide.with(App.activity).load(di_naoNao_fragment.getServerInfo().getInfo().get(0).getUserFace()).into(diNaonaoImageFirst);
                Glide.with(App.activity).load(di_naoNao_fragment.getServerInfo().getInfo().get(1).getUserFace()).into(diNaonaoImageSecond);
                Glide.with(App.activity).load(di_naoNao_fragment.getServerInfo().getInfo().get(2).getUserFace()).into(diNaonaoImageThird);

                 mList.clear();
                mList.addAll(di_naoNao_fragment.getServerInfo().getInfo());
                //判断是否已经加载过
                if (adapter == null) {
                    adapter = new DiNaoNao_Recycle_Adapter(mList);
                    diNaonaoRecycle.setAdapter(adapter);
                } else {
                    adapter.setNewData(mList);
                }

            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    // TODO: 2017/6/26 0026 跳转详情 
    private void getIntents(int id) {
        //跳转详情之前先判断是否登录
        if (SpUtils.getSp().getBoolean(LoginUtils.LOGIN, false)) {
            //如果登录就带着UserId跳转详情页面
            Intent ins = new Intent(App.activity, PersonalActivity.class);
            ins.putExtra("id", id);
            App.activity.startActivity(ins);
        } else {
            //未登录就跳转到登录页面
            Intent ina = new Intent(App.activity, LoginActivity.class);
            App.activity.startActivity(ina);
        }
    }

    // TODO: 2017/6/26 0026 闹闹帝的跳转监听 
    @Override
    protected void initListener() {
        diNaonaoImageFirst.setOnClickListener(this);
        diNaonaoImageSecond.setOnClickListener(this);
        diNaonaoImageThird.setOnClickListener(this);
    }

    // TODO: 2017/6/26 0026 闹闹帝的初始化数据 
    @Override
    protected void initView(View view) {
        v = LayoutInflater.from(App.activity).inflate(R.layout.di_naonao_tou, null);
        initViews();
        LinearLayoutManager man = new LinearLayoutManager(App.activity);
        diNaonaoRecycle.addHeaderView(v);
        diNaonaoRecycle.setLayoutManager(man);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    // TODO: 2017/6/26 0026 闹闹帝的头像监听 
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.di_naonao_image_first:
                getIntents(di_naoNao_fragment.getServerInfo().getInfo().get(0).getUserID());
                break;
            case R.id.di_naonao_image_second:
                getIntents(di_naoNao_fragment.getServerInfo().getInfo().get(1).getUserID());
                break;
            case R.id.di_naonao_image_third:
                getIntents(di_naoNao_fragment.getServerInfo().getInfo().get(2).getUserID());
                break;
        }
    }
}
