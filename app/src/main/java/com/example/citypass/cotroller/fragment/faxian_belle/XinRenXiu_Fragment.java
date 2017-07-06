package com.example.citypass.cotroller.fragment.faxian_belle;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.discover.Belle_Xrx_Adapter;
import com.example.citypass.model.bean.beele.Belle_Xrx_Bean;
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
 * 创建时间: 2017/6/23 0023 9:59
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

public class XinRenXiu_Fragment extends BaseFragment {
    @BindView(R.id.xinrenxiu_recycle)
    MRecyclerView xinrenxiuRecycle;
    Unbinder unbinder;

    private int count = 1;
    private Belle_Xrx_Adapter belle_xrx_adapter;
    private Handler handler = new Handler();
    private List<Belle_Xrx_Bean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> mList = new ArrayList<>();

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        String str1 = "{\"appName\":\"CcooCity\",\"Param\":{\"pageSize\":10,\"curPage\":";
        String str2 = ",\"siteID\":2422},\"requestTime\":\"2017-06-26 09:03:17\",\"customerKey\":\"B52F13E041F4125CBD3333617E15F089\",\"Method\":\"PHSocket_GetNewGirlTCoverInfo\",\"Statis\":{\"PhoneId\":\"133524541070404\",\"System_VersionNo\":\"Android 4.2.2\",\"UserId\":0,\"PhoneNum\":\" 8617646525761\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";

        map.put("param", str1 + count + str2);
        try {
            HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
                @Override
                public void onSuccess(String result) {
//                    mList.clear();

                    Belle_Xrx_Bean belle_xrx_bean = JSON.parseObject(result, Belle_Xrx_Bean.class);
                    List<Belle_Xrx_Bean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> figureTCoverInfoList
                            = belle_xrx_bean.getServerInfo().getFigureTCoverInfoList().getFigureTCoverInfoList();

                    if (mList.size() == 0) {
                        mList.addAll(figureTCoverInfoList);
                        belle_xrx_adapter.notifyDataSetChanged();

                    } else {
                        mList.addAll(figureTCoverInfoList);
                        belle_xrx_adapter.notifyDataSetChanged();

                    }

                }

                @Override
                public void onError(String errormsg) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void initListener() {
        xinrenxiuRecycle.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mList.clear();
                        initData();
                        xinrenxiuRecycle.refreshComplete();

                    }
                }, 2000);


            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        count++;
                        initData();
                        xinrenxiuRecycle.loadMoreComplete();

                    }
                }, 2000);

            }
        });

    }

    @Override
    protected void initView(View view) {
        xinrenxiuRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        belle_xrx_adapter = new Belle_Xrx_Adapter(mList, getContext());
        xinrenxiuRecycle.setAdapter(belle_xrx_adapter);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.xinrenxiu_fragment;
    }


}
