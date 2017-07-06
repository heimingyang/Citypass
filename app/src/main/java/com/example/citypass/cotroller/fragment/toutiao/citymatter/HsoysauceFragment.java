package com.example.citypass.cotroller.fragment.toutiao.citymatter;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.toutiao.Att_Adapter;
import com.example.citypass.cotroller.adapter.toutiao.Hsoc_Adapter;
import com.example.citypass.cotroller.fragment.information.TaskActivity;
import com.example.citypass.model.bean.toutiao.Attbean;
import com.example.citypass.model.bean.toutiao.Attinter;
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

//打酱油
public class HsoysauceFragment extends BaseFragment {


    @BindView(R.id.att_recycler)
    MRecyclerView newestRecycle;
    private List<Attbean.ServerInfoBean> mList;
    private boolean login;
    private int page=1;
    private Hsoc_Adapter adapter;
    private RelativeLayout onclick;

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

        onclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(getActivity(), TaskActivity.class);
                getActivity().startActivity(intent4);
            }
        });
    }

    @Override
    protected void initView(View view) {
        onclick = (RelativeLayout) view.findViewById(R.id.hnewest_onclick);
        onclick.setBackgroundResource(R.drawable.news_bigfire2);

        login = SpUtils.getSp().getBoolean(LoginUtils.LOGIN, true);
        View view1= LayoutInflater.from(getActivity()).inflate(R.layout.cityheaderview,null);
        View footview=LayoutInflater.from(getActivity()).inflate(R.layout.cityfootview,null);
        newestRecycle.setFootView(footview);
        newestRecycle.addHeaderView(view1);
        view1.findViewById(R.id.cityheader_tv).setBackgroundResource(R.drawable.news_topimage2);


        mList  = new ArrayList<>();
        //请求数据
        getdata(page);
        adapter = new Hsoc_Adapter(mList,getActivity());
        newestRecycle.setAdapter(adapter);
        LinearLayoutManager man = new LinearLayoutManager(getActivity());
        newestRecycle.setLayoutManager(man);

        newestRecycle.setLoadingMoreEnabled(true);
        newestRecycle.setPullRefreshEnabled(true);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.hattitudefragment;
    }


    public void getdata(int page) {
        this.page=page;


        Attinter.ParamBean param = new Attinter.ParamBean();
        param.setSiteID(2422);
        param.setCurPage(page);
        param.setPageSize(50);
        param.setType(2);

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
                Attbean bean = JSON.parseObject(result, Attbean.class);
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
