package com.example.citypass.cotroller.fragment.faxian_belle;

import android.os.Handler;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.citypass.MyLayout;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.discover.Belle_XG_Adapter;
import com.example.citypass.model.bean.beele.Belle_XG_Bean;
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

public class XingGan_Fragment extends BaseFragment {
    @BindView(R.id.Belle_xinggan_recycle)
    MRecyclerView BelleXingganRecycle;
    Unbinder unbinder;

    private List<Belle_XG_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean> mlist = new ArrayList<>();
    private Handler handler = new Handler();
    private Belle_XG_Adapter belle_xg_adapter;
    private int count = 1;
    private String str1;
    private String str2;

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        str1 = "{\"appName\":\"CcooCity\",\"Param\":{\"ImName\":\"性感\",\"pageSize\":10,\"curPage\":";
        str2 = ",\"siteID\":2422},\"requestTime\":\"2017-06-26 09:03:17\",\"customerKey\":\"8101A8DFD96C2B332796E6761BF80A43\",\"Method\":\"PHSocket_GetImpressionTCoverInfo\",\"Statis\":{\"PhoneId\":\"133524541070404\",\"System_VersionNo\":\"Android 4.2.2\",\"UserId\":0,\"PhoneNum\":\"+8617646525761\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";

        map.put("param", str1 + count + str2);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Belle_XG_Bean belle_xg_bean = JSON.parseObject(result, Belle_XG_Bean.class);
                List<Belle_XG_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean> coverPhotoDetailsInfo
                        = belle_xg_bean.getServerInfo().getCoverPhotoDetailsInfo().getCoverPhotoDetailsInfo();
                if (mlist.size() == 0) {
                    mlist.addAll(coverPhotoDetailsInfo);
                    belle_xg_adapter.notifyDataSetChanged();

                } else {
                    mlist.addAll(coverPhotoDetailsInfo);
                    belle_xg_adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onError(String errormsg) {

            }
        });

    }

    @Override
    protected void initListener() {
        BelleXingganRecycle.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mlist.clear();
                        initData();
                        BelleXingganRecycle.refreshComplete();
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
                        BelleXingganRecycle.loadMoreComplete();
                        Toast.makeText(getContext(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);


            }
        });

    }

    @Override
    protected void initView(View view) {
//        BelleXingganRecycle.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        BelleXingganRecycle.setLayoutManager(new MyLayout(2, StaggeredGridLayoutManager.VERTICAL));
        belle_xg_adapter = new Belle_XG_Adapter(mlist, getContext());
        BelleXingganRecycle.setAdapter(belle_xg_adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.xinggan_fragment;
    }


}
