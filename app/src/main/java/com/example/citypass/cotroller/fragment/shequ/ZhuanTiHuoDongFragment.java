package com.example.citypass.cotroller.fragment.shequ;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.shequ.HuoDongAdapter;
import com.example.citypass.model.bean.shequ.HuoDongBean;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.model.http.OkHttpUtils;
import com.example.citypass.view.MRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/23 16:20
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class ZhuanTiHuoDongFragment extends BaseFragment {
    @BindView(R.id.shequ_recyclerview)
    MRecyclerView shequRecyclerview;
    Unbinder unbinder;
    private List<HuoDongBean.ServerInfoBean> list = new ArrayList<>();
    private HuoDongAdapter adapter;

    @Override
    protected void initData() {
        LinearLayoutManager man = new LinearLayoutManager(App.activity);
        init();
        man.setOrientation(LinearLayoutManager.VERTICAL);
        if (shequRecyclerview != null && shequRecyclerview.getId() != 0) {
            RecyclerView.LayoutManager manager = new LinearLayoutManager(App.activity);
            shequRecyclerview.setLayoutManager(manager);
            shequRecyclerview.setLoadingListener(new MRecyclerView.LoadingListener() {
                @Override
                public void onRvScrolled(int dx, int dy) {

                }

                @Override
                public void onRefresh() {
                    list.clear();
                    init();
                    shequRecyclerview.refreshComplete();
                }

                @Override
                public void onLoadMore() {
                    init();
                    shequRecyclerview.refreshComplete();
                }
            });
    }
    }

    private void init() {
        Map<String,String> map = new HashMap<>();
        String str = "{\"customerID\":8001,\"requestTime\":\"2017-06-23 19:01:44\",\"Method\":\"PHSocket_GetZthdInfoList\",\"customerKey\":\"EDCAD2A25101B2C690FA68D15DD60E3E\",\"appName\":\"CcooCity\",\"version\":\"4.5\",\"Param\":{\"siteID\":2422,\"classID\":0,\"categoryID\":0,\"boardID\":0,\"curPage\":1,\"pageSize\":10},\"Statis\":{\"SiteId\":2422,\"UserId\":30939591,\"PhoneNo\":\"vivo X7\",\"SystemNo\":2,\"System_VersionNo\":\"Android 5.1.1\",\"PhoneId\":\"862460032827563\",\"PhoneNum\":\"+8615735971710\"}}";
        map.put("param",str);
        OkHttpUtils.getInstance().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.e("aaa",result);
                HuoDongBean huoDongBean = JSON.parseObject(result,HuoDongBean.class);
                list.addAll(huoDongBean.getServerInfo());
                adapter = new HuoDongAdapter(App.activity,list);
                shequRecyclerview.setAdapter(adapter);
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.shequ_recycler;
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
