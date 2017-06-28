package com.example.citypass.cotroller.fragment.faxian_belle;

import android.os.Handler;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.discover.Belle_Nhz_Adapter;
import com.example.citypass.model.bean.beele.Belle_Nhz_Bean;
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
 * 创建时间: 2017/6/23 0023 10:01
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

public class NvHanZi_Fragment extends BaseFragment {
    @BindView(R.id.Nvhanzi_recycle)
    MRecyclerView NvhanziRecycle;
    Unbinder unbinder;

    private Handler handler = new Handler();
    private List<Belle_Nhz_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean> mList = new ArrayList<>();
    private Belle_Nhz_Adapter belle_nhz_adapter;


    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("param", "{\"appName\":\"CcooCity\",\"Param\":{\"ImName\":\"女汉子\",\"pageSize\":10,\"curPage\":1,\"siteID\":2422},\"requestTime\":\"2017-06-26 14:36:15\",\"customerKey\":\"EAC7355B245815A7EFFE31B399BCCD52\",\"Method\":\"PHSocket_GetImpressionTCoverInfo\",\"Statis\":{\"PhoneId\":\"133524541070404\",\"System_VersionNo\":\"Android 4.2.2\",\"UserId\":0,\"PhoneNum\":\"+8617646525761\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}");

        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Belle_Nhz_Bean belle_nhz_bean = JSON.parseObject(result, Belle_Nhz_Bean.class);
                List<Belle_Nhz_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean> coverPhotoDetailsInfo
                        = belle_nhz_bean.getServerInfo().getCoverPhotoDetailsInfo().getCoverPhotoDetailsInfo();



                    mList.addAll(coverPhotoDetailsInfo);
                    belle_nhz_adapter.notifyDataSetChanged();






            }

            @Override
            public void onError(String errormsg) {

            }
        });

    }

    @Override
    protected void initListener() {
        NvhanziRecycle.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {
//
                NvhanziRecycle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Map<String, String> map = new HashMap<>();
                        map.put("param", "{\"appName\":\"CcooCity\",\"Param\":{\"ImName\":\"女汉子\",\"pageSize\":10,\"curPage\":1,\"siteID\":2422},\"requestTime\":\"2017-06-26 14:36:15\",\"customerKey\":\"EAC7355B245815A7EFFE31B399BCCD52\",\"Method\":\"PHSocket_GetImpressionTCoverInfo\",\"Statis\":{\"PhoneId\":\"133524541070404\",\"System_VersionNo\":\"Android 4.2.2\",\"UserId\":0,\"PhoneNum\":\"+8617646525761\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}");

                        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
                            @Override
                            public void onSuccess(String result) {
                                mList.clear();
                                Belle_Nhz_Bean belle_nhz_bean = JSON.parseObject(result, Belle_Nhz_Bean.class);
                                List<Belle_Nhz_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean> coverPhotoDetailsInfo
                                        = belle_nhz_bean.getServerInfo().getCoverPhotoDetailsInfo().getCoverPhotoDetailsInfo();



                                    mList.addAll(coverPhotoDetailsInfo);
                                    belle_nhz_adapter.notifyDataSetChanged();




                            }

                            @Override
                            public void onError(String errormsg) {

                            }
                        });

                        NvhanziRecycle.refreshComplete();

                    }
                }, 2000);

            }

            @Override
            public void onLoadMore() {
                NvhanziRecycle.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(getContext(), "没有更多数据", Toast.LENGTH_SHORT).show();

                    }
                }, 2000);


            }
        });

    }

    @Override
    protected void initView(View view) {
        try {
            NvhanziRecycle.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        } catch (Exception e) {
            Log.e("TAGBUG", e.getMessage());
        }
        belle_nhz_adapter = new Belle_Nhz_Adapter(mList, getContext());
        NvhanziRecycle.setAdapter(belle_nhz_adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.nvhanzi_fragment;
    }


}
