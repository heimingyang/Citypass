package com.example.citypass.cotroller.fragment.faxian_belle;

import android.os.Handler;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.discover.Belle_Ly_Adapter;
import com.example.citypass.model.bean.beele.Belle_Ly_Bean;
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
 * 创建时间: 2017/6/23 0023 10:00
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

public class LengYan_Fragment extends BaseFragment {
    @BindView(R.id.Lengyan_recycle)
    MRecyclerView LengyanRecycle;
    Unbinder unbinder;

    private Handler handler = new Handler();
    private List<Belle_Ly_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean> mList = new ArrayList<>();
    private Belle_Ly_Adapter belle_ly_adapter;

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("param", "{\"appName\":\"CcooCity\",\"Param\":{\"ImName\":\"冷艳\",\"pageSize\":10,\"curPage\":1,\"siteID\":2422},\"requestTime\":\"2017-06-26 11:34:17\",\"customerKey\":\"C752E1F05FA58560DF85C6542C10B697\",\"Method\":\"PHSocket_GetImpressionTCoverInfo\",\"Statis\":{\"PhoneId\":\"133524541070404\",\"System_VersionNo\":\"Android 4.2.2\",\"UserId\":0,\"PhoneNum\":\"+8617646525761\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}");

        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Belle_Ly_Bean belle_ly_bean = JSON.parseObject(result, Belle_Ly_Bean.class);
                List<Belle_Ly_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean> coverPhotoDetailsInfo
                        = belle_ly_bean.getServerInfo().getCoverPhotoDetailsInfo().getCoverPhotoDetailsInfo();

                if (mList.size() == 0) {
                    mList.addAll(coverPhotoDetailsInfo);
                    belle_ly_adapter.notifyDataSetChanged();

                } else {
                    mList.addAll(coverPhotoDetailsInfo);
                    belle_ly_adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onError(String errormsg) {

            }
        });

    }

    @Override
    protected void initListener() {
        LengyanRecycle.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        LengyanRecycle.refreshComplete();

                    }
                }, 2000);

            }

            @Override
            public void onLoadMore() {


            }
        });

    }

    @Override
    protected void initView(View view) {
        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.no_content, null);

        LengyanRecycle.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        belle_ly_adapter = new Belle_Ly_Adapter(mList, getContext());
        LengyanRecycle.setAdapter(belle_ly_adapter);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.lengyan_fragment;
    }


}
