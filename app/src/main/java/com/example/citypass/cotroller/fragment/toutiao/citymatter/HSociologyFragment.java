package com.example.citypass.cotroller.fragment.toutiao.citymatter;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.toutiao.Newest_Adapter;
import com.example.citypass.cotroller.adapter.toutiao.Soc_Adapter;
import com.example.citypass.cotroller.fragment.toutiao.MyProgressDialog;
import com.example.citypass.model.bean.toutiao.NewestBean;
import com.example.citypass.model.bean.toutiao.Newestinter;
import com.example.citypass.model.bean.toutiao.Socbean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.DeviceUtils;
import com.example.citypass.utils.TimeUtils;
import com.example.citypass.view.MRecyclerView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
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

//社会
public class HSociologyFragment extends BaseFragment {

    @BindView(R.id.soc_recycler)
    MRecyclerView socRecycler;
    Unbinder unbinder;
   private int page=1;
    private List<Socbean.ServerInfoBean.ReplyInfoBean> mList;
    private Soc_Adapter adapter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        View view1=LayoutInflater.from(getActivity()).inflate(R.layout.citymatter_headerview,null);
        socRecycler.addHeaderView(view1);


        mList = new ArrayList<>();
        //请求数据
        getdata(page);
        adapter = new Soc_Adapter(mList,getActivity());
        socRecycler.setAdapter(adapter);
        LinearLayoutManager man = new LinearLayoutManager(getActivity());
        socRecycler.setLayoutManager(man);

        socRecycler.setLoadingMoreEnabled(true);
        socRecycler.setPullRefreshEnabled(true);


        socRecycler.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {
                mList.clear();
                getdata(1);
                socRecycler.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                getdata(page);
                socRecycler.loadMoreComplete();
            }
        });

    }
    public void getdata(int page) {
        this.page=page;
        Newestinter.ParamBean param = new Newestinter.ParamBean();
        param.setSiteID(2422);
        param.setCurPage(page);
        param.setPageSize(10);
        param.setType(1);

        Newestinter.StatisBean statis = new Newestinter.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(getActivity()));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(getActivity()));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
      /*  if (login) {
            statis.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));
        } else {*/
        statis.setUserId(0);
//        }

        Newestinter toutiao = new Newestinter();
        toutiao.setMethod("PHSocket_GetCityNewsInfo");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("86E2E1B8F1CA4BF23116E9BE3A815116");
        toutiao.setRequestTime(TimeUtils.getdangqianshijian());
        toutiao.setVersion("4.5");
        Gson gson = new Gson();
        String s = gson.toJson(toutiao);
        Map<String, String> map = new HashMap<>();
        map.put("param", s);
//        Log.e("TTTTTTTTT",s);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                //Log.e("newestBean", result.toString());
                Socbean newestBean = JSON.parseObject(result, Socbean.class);
                mList.addAll(newestBean.getServerInfo().getReplyInfo());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String errormsg) {
                Log.e("onError", errormsg);
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.hsociologyfragment;
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
