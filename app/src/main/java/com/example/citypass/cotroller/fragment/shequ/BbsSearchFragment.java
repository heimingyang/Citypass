package com.example.citypass.cotroller.fragment.shequ;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.shequ.SearchAdapter;
import com.example.citypass.model.bean.shequ.SerachBeans;
import com.example.citypass.model.biz.infor.BbSimp;
import com.example.citypass.model.biz.infor.Ibbs;
import com.example.citypass.model.http.MyCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 李艳东 on 2017/6/30  09:06
 */

public class BbsSearchFragment extends BaseFragment {


    @BindView(R.id.serach_titie)
    TextView serachTitie;
    @BindView(R.id.ll_bbs)
    LinearLayout llBbs;
    @BindView(R.id.bbs_PullToRecycleView)
    PullToRefreshRecyclerView bbsPullToRecycleView;
    private SharedPreferences mShared;
    private String bbsname;
    private Ibbs ibbs;
    private String params;
    private List<SerachBeans.ServerInfoBean> serverInfoBeen;
    private SearchAdapter searchAdapter;
    private JSONObject jsonObject;
    private int i = 1;
    Dialog dialog;
    private JSONObject param;

    @Override
    public void initView(View view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        bbsPullToRecycleView.setLayoutManager(layoutManager);
        bbsPullToRecycleView.setLoadingMoreEnabled(true);
        bbsPullToRecycleView.setPullRefreshEnabled(true);
        bbsPullToRecycleView.displayLastRefreshTime(true);
        bbsPullToRecycleView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                bbsPullToRecycleView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        searchAdapter.notifyDataSetChanged();
                        bbsPullToRecycleView.setRefreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                bbsPullToRecycleView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (serverInfoBeen.size() >= 10) {
                            searchAdapter.notifyDataSetChanged();

                            searchAdapter.notifyDataSetChanged();
                        }
                        bbsPullToRecycleView.setLoadMoreComplete();
                    }
                }, 2000);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragmentbbs_search;
    }

    @Override
    public void initData() {
        mShared = getActivity().getSharedPreferences("bbsdata", Context.MODE_PRIVATE);
        bbsname = mShared.getString("bbsname", "");
        //  param = "{\"customerID\":8001,\"requestTime\":\"2017-06-30 10:46:34\",\"Method\":\"PHSocket_GetBBSTopicList\",\"customerKey\":\"47BF72B5C485298B47884FCE3B6A733F\",\"appName\":\"CcooCity\",\"version\":\"4.5\",\"Param\":{\"siteID\":2422,\"flag\":2,\"boardID\":0,\"curPage\":1,\"pageSize\":10,\"userID\":30940828},\"Statis\":{\"SiteId\":2422,\"UserId\":30940828,\"PhoneNo\":\"Le X620\",\"SystemNo\":2,\"System_VersionNo\":\"Android 6.0\",\"PhoneId\":\"862728037145631\",\"PhoneNum\":\"18710069145\"}}";
        serachTitie.setText(bbsname);
        ibbs = new BbSimp();
        serverInfoBeen = new ArrayList<>();
        jsonObject = new JSONObject();
        try {
            jsonObject.put("customerID", 8001);
            jsonObject.put("requ estTime", "2017-06-30 14:58:42");
            jsonObject.put("Method", "PHSocket_GetBBSTopicList");
            jsonObject.put("customerKey", "A8F9E6C7A6C9474493EC6B1D17CD3DED");
            jsonObject.put("appName", "CcooCity");
            jsonObject.put("version", "4.5");
            param = new JSONObject();
            param.put("siteID", 2422);
            param.put("flag", 2);
            param.put("boardID", 0);
            param.put("curPage", i++);
            param.put("pageSize", 10);
            param.put("keyword", bbsname);
            param.put("userID", 30940828);
            jsonObject.put("Param", param);
            JSONObject statis = new JSONObject();
            statis.put("SiteId", 2422);
            statis.put("UserId", 30940828);
            statis.put("PhoneNo", "Le X620");
            statis.put("SystemNo", 2);
            statis.put("System_VersionNo", "Android 6.0");
            statis.put("PhoneId", "862728037145631");
            statis.put("PhoneNum", "18710069145");
            jsonObject.put("Statis", statis);
            params = jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ibbs.loadSearch(new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.e("数据为",result);
                if (TextUtils.isEmpty(result)) {
                    return;
                }
                SerachBeans serachBeans = JSON.parseObject(result, SerachBeans.class);
                List<SerachBeans.ServerInfoBean> serverInfo = serachBeans.getServerInfo();
                try {
                    serverInfoBeen.addAll(serverInfo);
                    searchAdapter = new SearchAdapter(getActivity(), serverInfoBeen);
                    bbsPullToRecycleView.setAdapter(searchAdapter);
                } catch (NullPointerException e) {

                }
            }

            @Override
            public void onError(String errormsg) {

            }
        },params);

    }


    @Override
    public void initListener() {

    }


}
