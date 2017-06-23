package com.example.citypass.cotroller.fragment.naonao;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.naonao.Title_NaoNao_Recycle_Adapter;
import com.example.citypass.model.bean.Title_NaoNao_Bean;
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


public class Title_NaoNao_Fragment extends BaseFragment {
    @BindView(R.id.title_naonao_recycle)
    MRecyclerView titleNaonaoRecycle;
    Unbinder unbinder;
    private List<Title_NaoNao_Bean.ServerInfoBean> mList = new ArrayList<>();
    private int a=0;
    @Override
    protected void initData() {
        if(a==0) {
            LinearLayoutManager man = new LinearLayoutManager(App.activity);
            initParsing();
            titleNaonaoRecycle.setLayoutManager(man);
            a=1;
        }
    }

    private void initParsing() {
        Map<String,String> map = new HashMap<>();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"pageSize\":10,\"userID\":0,\"siteID\":2422,\"type\":1,\"curPage\":1},\"requestTime\":\"2017-06-19 11:52:02\",\"customerKey\":\"4FCF192587CBBF0D7BCEB4E1A73BEB05\",\"Method\":\"PHSocket_GetTieBaGambit\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":0,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        map.put("param",str);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("Title_NaoNao_Fragment", result);
                Title_NaoNao_Bean title_naoNao_bean = JSON.parseObject(result, Title_NaoNao_Bean.class);
                mList.addAll(title_naoNao_bean.getServerInfo());
                titleNaonaoRecycle.setAdapter(new Title_NaoNao_Recycle_Adapter(mList));

            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.title_naonao_fragment;
    }
}
