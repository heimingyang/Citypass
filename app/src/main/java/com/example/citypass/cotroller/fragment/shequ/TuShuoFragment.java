package com.example.citypass.cotroller.fragment.shequ;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.shequ.TuShuoAdapter;
import com.example.citypass.model.bean.shequ.TuShuoBean;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.model.http.OkHttpUtils;
import com.example.citypass.view.MRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/23 16:19
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class TuShuoFragment extends BaseFragment {


    @BindView(R.id.shequ_recyclerview)
    MRecyclerView shequRecyclerview;
    private TuShuoAdapter adapter;
    private List<TuShuoBean.ServerInfoBean> mList = new ArrayList<>();

    @Override
    protected void initData() {
        StaggeredGridLayoutManager man = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        init();
        shequRecyclerview.setLayoutManager(man);
        shequRecyclerview.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {
                shequRecyclerview.refreshComplete();
            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    private void init() {
        Map<String, String> map = new HashMap<>();
        String str = "{\"customerID\":8001,\"requestTime\":\"2017-06-24 10:30:22\",\"Method\":\"PHSocket_GetHotListNew\",\"customerKey\":\"75E7E0553A1C75C984BB6F03FA6E5AF3\",\"appName\":\"CcooCity\",\"version\":\"4.5\",\"Param\":{\"siteID\":2422,\"curPage\":1,\"pageSize\":10,\"userName\":\"sid110249370682305\",\"userID\":30939591},\"Statis\":{\"SiteId\":2422,\"UserId\":30939591,\"PhoneNo\":\"vivo X7\",\"SystemNo\":2,\"System_VersionNo\":\"Android 5.1.1\",\"PhoneId\":\"862460032827563\",\"PhoneNum\":\"+8615735971710\"}}";
        map.put("param", str);
        OkHttpUtils.getInstance().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.e("abc", result);
                TuShuoBean tuShuoBean = JSON.parseObject(result, TuShuoBean.class);
                List<TuShuoBean.ServerInfoBean> info = new ArrayList<TuShuoBean.ServerInfoBean>();
                info.addAll(tuShuoBean.getServerInfo());
                if (adapter == null) {
                    adapter = new TuShuoAdapter(getContext(), info);
                    shequRecyclerview.setAdapter(adapter);
                } else {
                    adapter.setNewData(mList);
                }
                TextView tv = new TextView(getActivity());
                tv.setText("没有更多内容啦~");
                shequRecyclerview.setFootView(tv);

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


}
