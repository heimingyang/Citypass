package com.example.citypass.cotroller.fragment.naonao;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.base.CircleImageView;
import com.example.citypass.cotroller.adapter.naonao.DiNaoNao_Recycle_Adapter;
import com.example.citypass.model.bean.naonao.Di_NaoNao_Bean;
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


public class Di_NaoNao_Fragment extends BaseFragment {
    @BindView(R.id.di_naonao_recycle)
    MRecyclerView diNaonaoRecycle;
    CircleImageView diNaonaoImageSecond;
    TextView diNaonaoNameSecond;
    CircleImageView diNaonaoImageFirst;
    TextView diNaonaoNameFirst;
    CircleImageView diNaonaoImageThird;
    TextView diNaonaoNameThird;
    TextView diNaonaoCountSecond;
    TextView diNaonaoCountFirst;
    TextView diNaonaoCountThird;
    Unbinder unbinder;
    private DiNaoNao_Recycle_Adapter adapter;
    private List<Di_NaoNao_Bean.ServerInfoBean.InfoBean> mList = new ArrayList<>();
    private int a=0;

    @Override
    protected void initData() {
        if(a==0) {
            View v = LayoutInflater.from(App.activity).inflate(R.layout.di_naonao_tou, null);
            diNaonaoImageSecond = (CircleImageView) v.findViewById(R.id.di_naonao_image_second);
            diNaonaoCountThird = (TextView) v.findViewById(R.id.di_naonao_count_third);
            diNaonaoCountFirst = (TextView) v.findViewById(R.id.di_naonao_count_first);
            diNaonaoCountSecond = (TextView) v.findViewById(R.id.di_naonao_count_second);
            diNaonaoNameThird = (TextView) v.findViewById(R.id.di_naonao_name_third);
            diNaonaoImageThird = (CircleImageView) v.findViewById(R.id.di_naonao_image_third);
            diNaonaoNameSecond = (TextView) v.findViewById(R.id.di_naonao_name_second);
            diNaonaoImageFirst = (CircleImageView) v.findViewById(R.id.di_naonao_image_first);
            diNaonaoNameFirst = (TextView) v.findViewById(R.id.di_naonao_name_first);
            LinearLayoutManager man = new LinearLayoutManager(App.activity);
            diNaonaoRecycle.addHeaderView(v);
            initParsing();
            diNaonaoRecycle.setLayoutManager(man);
            diNaonaoRecycle.setLoadingListener(new MRecyclerView.LoadingListener() {
                @Override
                public void onRvScrolled(int dx, int dy) {

                }

                @Override
                public void onRefresh() {
                    diNaonaoRecycle.refreshComplete();
                }

                @Override
                public void onLoadMore() {

                }
            });
            a=1;
        }
    }

    private void initParsing() {
        Map<String,String> map = new HashMap<>();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"userID\":0,\"siteID\":2422},\"requestTime\":\"2017-06-19 11:52:02\",\"customerKey\":\"586802D0212E23BDA21DCFAD76CF5257\",\"Method\":\"PHSocket_GetTieBaTopicRank\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":0,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        map.put("param",str);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
    public void onSuccess(String result) {
        Log.d("Di_NaoNao_Fragment", result);
        Di_NaoNao_Bean di_naoNao_fragment = JSON.parseObject(result, Di_NaoNao_Bean.class);
        diNaonaoCountFirst.setText(di_naoNao_fragment.getServerInfo().getInfo().get(0).getSum());
        diNaonaoCountSecond.setText(di_naoNao_fragment.getServerInfo().getInfo().get(1).getSum());
        diNaonaoCountThird.setText(di_naoNao_fragment.getServerInfo().getInfo().get(2).getSum());
        diNaonaoNameFirst.setText(di_naoNao_fragment.getServerInfo().getInfo().get(0).getNick());
        diNaonaoNameSecond.setText(di_naoNao_fragment.getServerInfo().getInfo().get(1).getNick());
        diNaonaoNameThird.setText(di_naoNao_fragment.getServerInfo().getInfo().get(2).getNick());
        Glide.with(App.activity).load(di_naoNao_fragment.getServerInfo().getInfo().get(0).getUserFace()).into(diNaonaoImageFirst);
        Glide.with(App.activity).load(di_naoNao_fragment.getServerInfo().getInfo().get(1).getUserFace()).into(diNaonaoImageSecond);
        Glide.with(App.activity).load(di_naoNao_fragment.getServerInfo().getInfo().get(2).getUserFace()).into(diNaonaoImageThird);

                    mList.addAll(di_naoNao_fragment.getServerInfo().getInfo());
                if(adapter==null){
                    adapter = new DiNaoNao_Recycle_Adapter(mList);
                    diNaonaoRecycle.setAdapter(adapter);
                }else {
                    adapter.setNewData(mList);
                }

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
        return R.layout.di_naonao_fragment;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
