package com.example.citypass.cotroller.fragment.faxian_belle;

import android.os.Handler;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.discover.Belle_zuixin_Adapter;
import com.example.citypass.model.bean.beele.Beele_Zuixin_Bean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LogUtils;
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

public class ZuiXin_Fragment extends BaseFragment {
    @BindView(R.id.Zuixin_recycleview)
    MRecyclerView ZuixinRecycleview;
    Unbinder unbinder;

    private Belle_zuixin_Adapter belle_zuixin_adapter;
    private int count = 1;
    private List<Beele_Zuixin_Bean.ServerInfoBean.NewTCoverInfoListBeanX.NewTCoverInfoListBean> mList=new ArrayList<>();

    private Handler handler = new Handler();

    @Override
    protected void initData() {

        Map mmap = new HashMap();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"ImName\":\"最新\",\"pageSize\":10,\"curPage\":";
        String str2 = ",\"siteID\":2422},\"requestTime\":\"2017-06-24 11:11:49\",\"customerKey\":\"4F75A9F25B707647648A0C1064F18A95\",\"Method\":\"PHSocket_GetNewTCoverInfo\",\"Statis\":{\"PhoneId\":\"133524541070404\",\"System_VersionNo\":\"Android 4.2.2\",\"UserId\":0,\"PhoneNum\":\"+8617646525761\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";


        mmap.put("param", str + count + str2);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", mmap, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                LogUtils.e("resule",result);
                Beele_Zuixin_Bean beele_zuixin_bean = JSON.parseObject(result, Beele_Zuixin_Bean.class);
                List<Beele_Zuixin_Bean.ServerInfoBean.NewTCoverInfoListBeanX.NewTCoverInfoListBean> newTCoverInfoList
                        = beele_zuixin_bean.getServerInfo().getNewTCoverInfoList().getNewTCoverInfoList();


                    mList.addAll(newTCoverInfoList);
                    belle_zuixin_adapter.notifyDataSetChanged();



            }

            @Override
            public void onError(String errormsg) {

            }
        });

    }

    @Override
    protected void initListener() {
        ZuixinRecycleview.setLoadingListener(new MRecyclerView.LoadingListener() {
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
                        ZuixinRecycleview.refreshComplete();
                    }
                }, 2000);

            }

            @Override
            public void onLoadMore() {
                count++;
                initData();
                ZuixinRecycleview.loadMoreComplete();

            }
        });

    }

    @Override
    protected void initView(View view) {
        ZuixinRecycleview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        belle_zuixin_adapter = new Belle_zuixin_Adapter(mList, getContext());
        ZuixinRecycleview.setAdapter(belle_zuixin_adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.zuixin_fragment;
    }

}
