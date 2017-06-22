package com.example.citypass.cotroller.fragment.naonao;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.naonao.Square_NaoNao_Recycle_Adapter;
import com.example.citypass.model.bean.naonao.Square_NaoNao_Bean;
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


public class Square_NaoNao_Fragment extends BaseFragment {

    @BindView(R.id.square_naonao_recycle)
    MRecyclerView squareNaonaoRecycle;
    Unbinder unbinder;
    private List<Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean> mList = new ArrayList<>();
    @Override
   protected void initData() {
        LinearLayoutManager man= new LinearLayoutManager(App.activity);
        initParsing();
        squareNaonaoRecycle.setLayoutManager(man);
    }

    private void initParsing() {
        Map<String,String> map = new HashMap<>();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"userID\":0,\"siteID\":2422,\"order\":0,\"gambitid\":0,\"curPage\":1,\"pageSize\":10,\"oldTime\":\"\",\"type\":1},\"requestTime\":\"2017-06-21 20:56:33\",\"customerKey\":\"935A33F592C9C6509BAF3C887F29C205\",\"Method\":\"PHSocket_GetNewTieBaList\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":0,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        map.put("param",str);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("Square_NaoNao_Fragment", result);
                Square_NaoNao_Bean square_naoNao_bean = JSON.parseObject(result, Square_NaoNao_Bean.class);
                mList.addAll(square_naoNao_bean.getServerInfo().getGetPostWorkList().getGetPostWorkList());
                squareNaonaoRecycle.setAdapter(new Square_NaoNao_Recycle_Adapter(mList));
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
        return R.layout.square_naonao_fragment;
    }


}