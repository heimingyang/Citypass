package com.example.citypass.cotroller.fragment.naonao;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.naonao.Picture_NaoNao_Recycle_Adapter;
import com.example.citypass.model.bean.naonao.Picture_NaoNao_Bean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.view.MRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/20 0020 17:02
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


public class Picture_NaoNao_Fragment extends BaseFragment {
    @BindView(R.id.picture_naonao_recycle)
    MRecyclerView pictureNaonaoRecycle;
    private List<Picture_NaoNao_Bean.ServerInfoBean> mList = new ArrayList<>();
    private Picture_NaoNao_Recycle_Adapter adapter;

    // TODO: 2017/6/26 0026 晒图的加载数据 
    @Override
    protected void initData() {
        initParsing();
        pictureNaonaoRecycle.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {
                pictureNaonaoRecycle.refreshComplete();
            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    // TODO: 2017/6/26 0026 晒图 的网络请求数据
    private void initParsing() {
        Map<String, String> map = new HashMap<>();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"pageSize\":10,\"userID\":0,\"siteID\":2422,\"flag\":2,\"type\":1,\"gambitid\":0,\"curPage\":1},\"requestTime\":\"2017-06-19 11:52:02\",\"customerKey\":\"B77E5EE861C72727546387CAD3EFDFA9\",\"Method\":\"PHSocket_GetTieBaList\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":0,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        map.put("param", str);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("Picture_NaoNao_Fragment", result);
                Picture_NaoNao_Bean picture_naoNao_bean = JSON.parseObject(result, Picture_NaoNao_Bean.class);
                List<Picture_NaoNao_Bean.ServerInfoBean> serverInfo = new ArrayList<Picture_NaoNao_Bean.ServerInfoBean>();

                    serverInfo.addAll(picture_naoNao_bean.getServerInfo());
                Log.d("Picture_NaoNao_Fragment", "serverInfo.size():" + serverInfo.size());
                if(adapter==null){
                    adapter = new Picture_NaoNao_Recycle_Adapter(serverInfo);
                    pictureNaonaoRecycle.setAdapter(adapter);
                }else {
                    adapter.setNewData(mList);
                }
                TextView tv = new TextView(getActivity());
                tv.setText("没有更多内容啦~");
                pictureNaonaoRecycle.setFootView(tv);
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    @Override
    protected void initListener() {

    }

    // TODO: 2017/6/26 0026 晒图的初始化数据 
    @Override
    protected void initView(View view) {
        StaggeredGridLayoutManager man = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        
        pictureNaonaoRecycle.setLayoutManager(man);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.picture_naonao_fragment;
    }


}
