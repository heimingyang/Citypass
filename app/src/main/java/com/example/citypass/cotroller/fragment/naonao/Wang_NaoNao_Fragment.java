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


public class Wang_NaoNao_Fragment extends BaseFragment {
    CircleImageView wangNaonaoImageSecond;
    TextView wangNaonaoNameSecond;
    CircleImageView wangNaonaoImageFirst;
    TextView wangNaonaoNameFirst;
    CircleImageView wangNaonaoImageThird;
    TextView wangNaonaoNameThird;
    TextView wangNaonaoCountSecond;
    TextView wangNaonaoCountFirst;
    TextView wangNaonaoCountThird;
    @BindView(R.id.wang_naonao_recycle)
    MRecyclerView wangNaonaoRecycle;
    private List<Di_NaoNao_Bean.ServerInfoBean.InfoBean> mList = new ArrayList<>();
    private int a=0;

    @Override
    protected void initData() {
        if(a==0) {
            View v = LayoutInflater.from(App.activity).inflate(R.layout.wang_naonao_tou, null);
            wangNaonaoImageSecond = (CircleImageView) v.findViewById(R.id.wang_naonao_image_second);
            wangNaonaoNameSecond = (TextView) v.findViewById(R.id.wang_naonao_name_second);
            wangNaonaoImageFirst = (CircleImageView) v.findViewById(R.id.wang_naonao_image_first);
            wangNaonaoNameFirst = (TextView) v.findViewById(R.id.wang_naonao_name_first);
            wangNaonaoImageThird = (CircleImageView) v.findViewById(R.id.wang_naonao_image_third);
            wangNaonaoNameThird = (TextView) v.findViewById(R.id.wang_naonao_name_third);
            wangNaonaoCountSecond = (TextView) v.findViewById(R.id.wang_naonao_count_second);
            wangNaonaoCountFirst = (TextView) v.findViewById(R.id.wang_naonao_count_first);
            wangNaonaoCountThird = (TextView) v.findViewById(R.id.wang_naonao_count_third);
            LinearLayoutManager man = new LinearLayoutManager(App.activity);
            wangNaonaoRecycle.addHeaderView(v);
            initParsing();
            wangNaonaoRecycle.setLayoutManager(man);
            wangNaonaoRecycle.setLoadingListener(new MRecyclerView.LoadingListener() {
                @Override
                public void onRvScrolled(int dx, int dy) {

                }

                @Override
                public void onRefresh() {
                    mList.clear();
                    initParsing();
                    wangNaonaoRecycle.refreshComplete();
                }

                @Override
                public void onLoadMore() {
                    initParsing();
                    wangNaonaoRecycle.refreshComplete();
                }
            });
            a=1;
        }
    }

    private void initParsing() {
        Map<String, String> map = new HashMap<>();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"userID\":0,\"siteID\":2422},\"requestTime\":\"2017-06-19 11:52:02\",\"customerKey\":\"2819FD59556E2179E51C49720317A1B7\",\"Method\":\"PHSocket_GetTieBaReplyRank\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":0,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        map.put("param", str);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("Wang_NaoNao_Fragment", result);
                Di_NaoNao_Bean di_naoNao_fragment = JSON.parseObject(result, Di_NaoNao_Bean.class);
                wangNaonaoCountFirst.setText(di_naoNao_fragment.getServerInfo().getInfo().get(0).getSum());
                wangNaonaoCountSecond.setText(di_naoNao_fragment.getServerInfo().getInfo().get(1).getSum());
                wangNaonaoCountThird.setText(di_naoNao_fragment.getServerInfo().getInfo().get(2).getSum());
                wangNaonaoNameFirst.setText(di_naoNao_fragment.getServerInfo().getInfo().get(0).getNick());
                wangNaonaoNameSecond.setText(di_naoNao_fragment.getServerInfo().getInfo().get(1).getNick());
                wangNaonaoNameThird.setText(di_naoNao_fragment.getServerInfo().getInfo().get(2).getNick());
                Glide.with(App.activity).load(di_naoNao_fragment.getServerInfo().getInfo().get(0).getUserFace()).into(wangNaonaoImageFirst);
                Glide.with(App.activity).load(di_naoNao_fragment.getServerInfo().getInfo().get(1).getUserFace()).into(wangNaonaoImageSecond);
                Glide.with(App.activity).load(di_naoNao_fragment.getServerInfo().getInfo().get(2).getUserFace()).into(wangNaonaoImageThird);
                mList.addAll(di_naoNao_fragment.getServerInfo().getInfo());
                wangNaonaoRecycle.setAdapter(new DiNaoNao_Recycle_Adapter(mList));
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
        return R.layout.wang_naonao_fragment;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }



}
