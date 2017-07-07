package com.example.citypass.cotroller.fragment.shequ;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.shequ.ZuiXinAdapter;
import com.example.citypass.model.bean.shequ.ZuiXinBean;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.model.http.OkHttpUtils;
import com.example.citypass.view.MRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/20 19:26
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class ZuiXinFragment extends BaseFragment {


    Unbinder unbinder1;
    @BindView(R.id.shequ_recyclerview)
    MRecyclerView shequRecyclerview;
    Unbinder unbinder;
    private ZuiXinAdapter adapter;
    private ZuiXinBean zuiXinBean;
    private List<ZuiXinBean.ServerInfoBean> data = new ArrayList<>();




    @Override
    protected int getLayoutId() {
        return R.layout.shequ_recycler;
    }



    private void init(final boolean boo) {
        Map<String, String> map = new HashMap<>();
        String str = "{\"customerID\":8001,\"requestTime\":\"2017-06-22 14:34:03\",\"Method\":\"PHSocket_GetBBSTopicList\",\"customerKey\":\"F6E48AF7C237AF94F8EC2F5766407385\",\"appName\":\"CcooCity\",\"version\":\"4.5\",\"Param\":{\"siteID\":2422,\"flag\":2,\"boardID\":0,\"curPage\":1,\"pageSize\":10,\"oldTime\":\"\",\"userID\":30939591},\"Statis\":{\"SiteId\":2422,\"UserId\":30939591,\"PhoneNo\":\"vivo X7\",\"SystemNo\":2,\"System_VersionNo\":\"Android 5.1.1\",\"PhoneId\":\"862460032827563\",\"PhoneNum\":\"+8615735971710\"}}";
        map.put("param", str);
        OkHttpUtils.getInstance().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.i("aaa", result + "");
                try {
                    zuiXinBean = JSON.parseObject(result, ZuiXinBean.class);
                } catch (Exception e) {
                    throw new RuntimeException("出错");
                }
                data.addAll(zuiXinBean.getServerInfo());
                if(boo){
                    shequRecyclerview.refreshComplete();
                }else{
                    shequRecyclerview.loadMoreComplete();
                }
            }

            @Override
            public void onError(String errormsg) {
            }
        });
    }

    @Override
    protected void initData() {
        LinearLayoutManager man = new LinearLayoutManager(App.activity);
        man.setOrientation(LinearLayoutManager.VERTICAL);
        if (shequRecyclerview != null && shequRecyclerview.getId() != 0) {
            RecyclerView.LayoutManager manager = new LinearLayoutManager(App.activity);
            adapter = new ZuiXinAdapter(data,App.activity);
            shequRecyclerview.setAdapter(adapter);
            init(false);
            shequRecyclerview.setLayoutManager(manager);

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
}
