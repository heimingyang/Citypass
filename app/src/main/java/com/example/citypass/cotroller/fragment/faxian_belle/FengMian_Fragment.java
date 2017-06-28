package com.example.citypass.cotroller.fragment.faxian_belle;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.discover.Belle_Fm_Adapter;
import com.example.citypass.model.bean.beele.Belle_FM_Bean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
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
 * 创建人: Administrator
 * 创建时间: 2017/6/23 0023 9:58
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

public class FengMian_Fragment extends BaseFragment {
    @BindView(R.id.fengmian_recycle)
    MRecyclerView fengmianRecycle;
    Unbinder unbinder;

    private Belle_Fm_Adapter belle_fm_adapter;
    private Handler handler = new Handler();
    private List<Belle_FM_Bean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> mList = new ArrayList<>();

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("param", "{\"appName\":\"CcooCity\",\"Param\":{\"pageSize\":10,\"curPage\":1,\"siteID\":2422},\"requestTime\":\"2017-06-24 17:28:18\",\"customerKey\":\"9AD8E7FB4AECFE372283D316F93982BE\",\"Method\":\"PHSocket_GetFigureTCoverInfo\",\"Statis\":{\"PhoneId\":\"133524541070404\",\"System_VersionNo\":\"Android 4.2.2\",\"UserId\":0,\"PhoneNum\":\" 8617646525761\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}");
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Belle_FM_Bean belle_fm_bean = JSON.parseObject(result, Belle_FM_Bean.class);

                List<Belle_FM_Bean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> figureTCoverInfoList
                        = belle_fm_bean.getServerInfo().getFigureTCoverInfoList().getFigureTCoverInfoList();

                    mList.addAll(figureTCoverInfoList);
                    belle_fm_adapter.notifyDataSetChanged();




            }

            @Override
            public void onError(String errormsg) {

            }
        });


    }

    @Override
    protected void initListener() {
        fengmianRecycle.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {
                fengmianRecycle.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Map<String, String> map = new HashMap<>();
                        map.put("param", "{\"appName\":\"CcooCity\",\"Param\":{\"pageSize\":10,\"curPage\":1,\"siteID\":2422},\"requestTime\":\"2017-06-24 17:28:18\",\"customerKey\":\"9AD8E7FB4AECFE372283D316F93982BE\",\"Method\":\"PHSocket_GetFigureTCoverInfo\",\"Statis\":{\"PhoneId\":\"133524541070404\",\"System_VersionNo\":\"Android 4.2.2\",\"UserId\":0,\"PhoneNum\":\" 8617646525761\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}");
                        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
                            @Override
                            public void onSuccess(String result) {

                                mList.clear();
                                Belle_FM_Bean belle_fm_bean = JSON.parseObject(result, Belle_FM_Bean.class);

                                List<Belle_FM_Bean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> figureTCoverInfoList
                                        = belle_fm_bean.getServerInfo().getFigureTCoverInfoList().getFigureTCoverInfoList();

                                    mList.addAll(figureTCoverInfoList);
                                    belle_fm_adapter.notifyDataSetChanged();



                            }

                            @Override
                            public void onError(String errormsg) {

                            }
                        });


                        fengmianRecycle.refreshComplete();

                    }
                }, 2000);


            }

            @Override
            public void onLoadMore() {
                fengmianRecycle.loadMoreComplete();

            }
        });

    }

    @Override
    protected void initView(View view) {
        fengmianRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        belle_fm_adapter = new Belle_Fm_Adapter(getContext(), mList);
        fengmianRecycle.setAdapter(belle_fm_adapter);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fengmian_fragment;
    }


}
