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
import com.example.citypass.cotroller.adapter.shequ.ZhiDeYiKanAdapter;
import com.example.citypass.model.bean.shequ.ZhiDeYiKanBean;
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
 * 创建时间: 2017/6/20 19:27
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class ZhiDeYiKanFragment extends BaseFragment {


    @BindView(R.id.shequ_recyclerview)
    MRecyclerView shequRecyclerview;
    Unbinder unbinder;
    private ZhiDeYiKanAdapter adapter;
    private ZhiDeYiKanBean zhiDeYiKanBean;
    private List<ZhiDeYiKanBean.ServerInfoBean> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.shequ_recycler;
    }

    @Override
    protected void initView(View view) {

    }

    private void init() {
        Map<String, String> map = new HashMap<>();
        String str = "{\"customerID\":8001,\"requestTime\":\"2017-06-23 08:30:07\",\"Method\":\"PHSocket_GetTopicAllIsviewList\",\"customerKey\":\"6A313853AB3E6E9AE60F4E275D0E6CDA\",\"appName\":\"CcooCity\",\"version\":\"4.5\",\"Param\":{\"siteID\":2422,\"curPage\":1,\"pageSize\":10,\"userID\":30939591},\"Statis\":{\"SiteId\":2422,\"UserId\":30939591,\"PhoneNo\":\"vivo X7\",\"SystemNo\":2,\"System_VersionNo\":\"Android 5.1.1\",\"PhoneId\":\"862460032827563\",\"PhoneNum\":\"+8615735971710\"}}";
        map.put("param", str);
        OkHttpUtils.getInstance().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.e("aaa", result + "");
                zhiDeYiKanBean = JSON.parseObject(result, ZhiDeYiKanBean.class);
                list.addAll(zhiDeYiKanBean.getServerInfo());
                adapter = new ZhiDeYiKanAdapter(App.activity, list);
                shequRecyclerview.setAdapter(adapter);
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

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

    @Override
    protected void initListener() {

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
