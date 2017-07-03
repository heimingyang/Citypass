package com.example.citypass.cotroller.fragment.toutiao.citymatter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.toutiao.Att_Adapter;
import com.example.citypass.cotroller.adapter.toutiao.Diving_Adapter;
import com.example.citypass.cotroller.fragment.information.TaskActivity;
import com.example.citypass.model.bean.toutiao.Attbean;
import com.example.citypass.model.bean.toutiao.Attinter;
import com.example.citypass.model.bean.toutiao.Divingbean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.DeviceUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.example.citypass.view.MRecyclerView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/23 14:43
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

//爱潜水
public class HdivingFragment extends BaseFragment {

    @BindView(R.id.diving_racycler)
    MRecyclerView divingRacycler;
    @BindView(R.id.hnewest_onclick_tv1)
    TextView hnewestOnclickTv1;
    @BindView(R.id.hnewest_onclick_tv2)
    TextView hnewestOnclickTv2;
    @BindView(R.id.hnewest_onclick)
    RelativeLayout hnewestOnclick;
    Unbinder unbinder;
    private RelativeLayout onclick;
    private List<Divingbean.ServerInfoBean> mList;
    private boolean login;
    private int page = 1;
    private Diving_Adapter adapter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        onclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getActivity(), TaskActivity.class);
                getActivity().startActivity(intent4);
            }
        });
    }

    @Override
    protected void initView(View view) {
        onclick = (RelativeLayout) view.findViewById(R.id.hnewest_onclick);

        login = SpUtils.getSp().getBoolean(LoginUtils.LOGIN, true);
        View view1=LayoutInflater.from(getActivity()).inflate(R.layout.cityheaderview,null);
        View footview=LayoutInflater.from(getActivity()).inflate(R.layout.cityfootview,null);
        divingRacycler.setFootView(footview);
        divingRacycler.addHeaderView(view1);
        view1.findViewById(R.id.cityheader_tv).setBackgroundResource(R.drawable.news_topimage1);
        TextView headertv4= (TextView) view1.findViewById(R.id.cityheader_tv4);
        headertv4.setText("浏览");
        TextView headertv3= (TextView) view1.findViewById(R.id.cityheader_tv3);
        headertv3.setVisibility(View.GONE);


        mList  = new ArrayList<>();
        //请求数据
        getdata(page);
        adapter = new Diving_Adapter(mList,getActivity());
        divingRacycler.setAdapter(adapter);
        LinearLayoutManager man = new LinearLayoutManager(getActivity());
        divingRacycler.setLayoutManager(man);

        divingRacycler.setLoadingMoreEnabled(true);
        divingRacycler.setPullRefreshEnabled(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.hdivingfragment;
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

    public void getdata(int page) {
        this.page=page;
        Attinter.ParamBean param = new Attinter.ParamBean();
        param.setSiteID(2422);
        param.setCurPage(page);
        param.setPageSize(50);
        param.setType(3);

        Attinter.StatisBean statis = new Attinter.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(getActivity()));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(getActivity()));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());

        statis.setUserId(0);

        Attinter toutiao = new Attinter();
        toutiao.setMethod("PHSocket_GetCityNewsUserList");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("C46D364766F8243E6FD0B6522FE7CB0E");
        toutiao.setRequestTime(TimeUtils.getdangqianshijian());
        toutiao.setVersion("4.5");
        Gson gson = new Gson();
        String s = gson.toJson(toutiao);
        Map<String, String> map = new HashMap<>();
        map.put("param", s);

//        Log.e("result",s);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
            @Override
            public void onSuccess(String result) {

                //Log.e("result",result);
                Divingbean bean = JSON.parseObject(result, Divingbean.class);
                mList.addAll(bean.getServerInfo());
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onError(String errormsg) {
                Log.e("onError", errormsg);
            }
        });

    }
}
