package com.example.citypass.cotroller.fragment.shequ;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.App;
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
    private TuShuoBean tuShuoBean;
    private List<TuShuoBean.ServerInfoBean> data = new ArrayList<>();


    private void init(final boolean boo) {
        Map<String, String> map = new HashMap<>();
        String str = "{\"customerID\":8001,\"requestTime\":\"2017-06-24 10:30:22\",\"Method\":\"PHSocket_GetHotListNew\",\"customerKey\":\"75E7E0553A1C75C984BB6F03FA6E5AF3\",\"appName\":\"CcooCity\",\"version\":\"4.5\",\"Param\":{\"siteID\":2422,\"curPage\":1,\"pageSize\":10,\"userName\":\"sid110249370682305\",\"userID\":30939591},\"Statis\":{\"SiteId\":2422,\"UserId\":30939591,\"PhoneNo\":\"vivo X7\",\"SystemNo\":2,\"System_VersionNo\":\"Android 5.1.1\",\"PhoneId\":\"862460032827563\",\"PhoneNum\":\"+8615735971710\"}}";
        map.put("param", str);
        OkHttpUtils.getInstance().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.i("aaa", result + "");
                try {
                    tuShuoBean = JSON.parseObject(result, TuShuoBean.class);
                } catch (Exception e) {
                    throw new RuntimeException("出错");
                }
                data.addAll(tuShuoBean.getServerInfo());
                if(boo){
                    shequRecyclerview.refreshComplete();
                }else{
                    shequRecyclerview.loadMoreComplete();
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
    protected void initData() {

        StaggeredGridLayoutManager man = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        if (shequRecyclerview != null && shequRecyclerview.getId() != 0) {
            adapter = new TuShuoAdapter(App.activity,data);
            shequRecyclerview.setAdapter(adapter);
            init(false);
            shequRecyclerview.setLayoutManager(man);

            shequRecyclerview.setLoadingListener(new MRecyclerView.LoadingListener() {
                @Override
                public void onRvScrolled(int dx, int dy) {

                }

                @Override
                public void onRefresh() {
                    init(true);

                }

                @Override
                public void onLoadMore() {
                    init(false);

                }
            });

        }

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
