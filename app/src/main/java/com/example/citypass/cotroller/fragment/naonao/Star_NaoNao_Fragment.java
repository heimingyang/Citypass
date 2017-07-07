package com.example.citypass.cotroller.fragment.naonao;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.naonao.DiNaoNao_Recycle_Adapter;
import com.example.citypass.cotroller.fragment.information.LoginActivity;
import com.example.citypass.cotroller.fragment.information.PersonalActivity;
import com.example.citypass.model.bean.naonao.Di_NaoNao_Bean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
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


public class Star_NaoNao_Fragment extends BaseFragment implements View.OnClickListener {
    ImageView diNaonaoImageSecond;
    TextView diNaonaoNameSecond;
    ImageView diNaonaoImageFirst;
    TextView diNaonaoNameFirst;
    ImageView diNaonaoImageThird;
    TextView diNaonaoNameThird;
    TextView diNaonaoCountSecond;
    TextView diNaonaoCountFirst;
    TextView diNaonaoCountThird;
    @BindView(R.id.star_naonao_recycle)
    MRecyclerView starNaonaoRecycle;
    private DiNaoNao_Recycle_Adapter adapter;
    private int a = 0;
    private Di_NaoNao_Bean di_naoNao_fragment;
    Unbinder unbinder;


    private List<Di_NaoNao_Bean.ServerInfoBean.InfoBean> mList = new ArrayList<>();

    @Override
    protected void initData() {
        if (a == 0) {
            initParsing();
            starNaonaoRecycle.setLoadingListener(new MRecyclerView.LoadingListener() {
                @Override
                public void onRvScrolled(int dx, int dy) {

                }

                @Override
                public void onRefresh() {
                    starNaonaoRecycle.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            initParsing();
                            starNaonaoRecycle.refreshComplete();
                        }
                    }, 2000);
                }

                @Override
                public void onLoadMore() {
                    starNaonaoRecycle.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            initParsing();
                            starNaonaoRecycle.loadMoreComplete();
                        }
                    }, 2000);
                }
            });
            a = 1;
        }
    }

    private void initParsing() {
        Map<String, String> map = new HashMap<>();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"userID\":0,\"siteID\":2422},\"requestTime\":\"2017-06-29 17:21:33\",\"customerKey\":\"1075C03DA2A62B806314DA31FC043639\",\"Method\":\"PHSocket_GetTieBaToReplyRank\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 5.1\",\"UserId\":0,\"PhoneNum\":\"+8618833628372\",\"SystemNo\":2,\"PhoneNo\":\"OPPO R9\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        map.put("param", str);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("Star_NaoNao_Fragment", result);
                 di_naoNao_fragment = JSON.parseObject(result, Di_NaoNao_Bean.class);
                if (di_naoNao_fragment == null && result == null && di_naoNao_fragment.getMessageList().getCode() != 1000) {
                    return;
                }
                if (di_naoNao_fragment.getServerInfo() == null) {
                    return;
                }

                diNaonaoCountFirst.setText(di_naoNao_fragment.getServerInfo().getInfo().get(0).getSum());
                diNaonaoCountSecond.setText(di_naoNao_fragment.getServerInfo().getInfo().get(1).getSum());
                diNaonaoCountThird.setText(di_naoNao_fragment.getServerInfo().getInfo().get(2).getSum());
                diNaonaoNameFirst.setText(di_naoNao_fragment.getServerInfo().getInfo().get(0).getNick());
                diNaonaoNameSecond.setText(di_naoNao_fragment.getServerInfo().getInfo().get(1).getNick());
                diNaonaoNameThird.setText(di_naoNao_fragment.getServerInfo().getInfo().get(2).getNick());
//                Glide.with(App.activity).load(di_naoNao_fragment.getServerInfo().getInfo().get(0).getUserFace()).into(diNaonaoImageFirst);
//                Glide.with(App.activity).load(di_naoNao_fragment.getServerInfo().getInfo().get(1).getUserFace()).into(diNaonaoImageSecond);
//                Glide.with(App.activity).load(di_naoNao_fragment.getServerInfo().getInfo().get(2).getUserFace()).into(diNaonaoImageThird);

                Glide.with(getContext()).load(di_naoNao_fragment.getServerInfo().getInfo().get(0).getUserFace()).asBitmap().centerCrop().into(new BitmapImageViewTarget(diNaonaoImageFirst) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                        ciDrawable.setCircular(true);
                        diNaonaoImageFirst.setImageDrawable(ciDrawable);
                    }
                });
                Glide.with(getContext()).load(di_naoNao_fragment.getServerInfo().getInfo().get(1).getUserFace()).asBitmap().centerCrop().into(new BitmapImageViewTarget(diNaonaoImageSecond) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                        ciDrawable.setCircular(true);
                        diNaonaoImageSecond.setImageDrawable(ciDrawable);
                    }
                });
                Glide.with(getContext()).load(di_naoNao_fragment.getServerInfo().getInfo().get(2).getUserFace()).asBitmap().centerCrop().into(new BitmapImageViewTarget(diNaonaoImageThird) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                        ciDrawable.setCircular(true);
                        diNaonaoImageThird.setImageDrawable(ciDrawable);
                    }
                });

                starNaonaoRecycle.setVisibility(View.VISIBLE);
                mList.clear();
                mList.addAll(di_naoNao_fragment.getServerInfo().getInfo());
                if (adapter == null) {
                    adapter = new DiNaoNao_Recycle_Adapter(mList);
                    starNaonaoRecycle.setAdapter(adapter);
                } else {
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
        diNaonaoImageFirst.setOnClickListener(this);
        diNaonaoImageSecond.setOnClickListener(this);
        diNaonaoImageThird.setOnClickListener(this);
    }

    @Override
    protected void initView(View view) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.star_naonao_tou, null);
        diNaonaoImageSecond = (ImageView) v.findViewById(R.id.star_naonao_image_second);
        diNaonaoNameSecond = (TextView) v.findViewById(R.id.star_naonao_name_second);
        diNaonaoImageFirst = (ImageView) v.findViewById(R.id.star_naonao_image_first);
        diNaonaoNameFirst = (TextView) v.findViewById(R.id.star_naonao_name_first);
        diNaonaoImageThird = (ImageView) v.findViewById(R.id.star_naonao_image_third);
        diNaonaoNameThird = (TextView) v.findViewById(R.id.star_naonao_name_third);
        diNaonaoCountSecond = (TextView) v.findViewById(R.id.star_naonao_count_second);
        diNaonaoCountFirst = (TextView) v.findViewById(R.id.star_naonao_count_first);
        diNaonaoCountThird = (TextView) v.findViewById(R.id.star_naonao_count_third);
        LinearLayoutManager man = new LinearLayoutManager(App.activity);
        starNaonaoRecycle.addHeaderView(v);

        starNaonaoRecycle.setLayoutManager(man);
    }

    // TODO: 2017/6/26 0026 跳转详情
    private void getIntents(int id) {
        //跳转详情之前先判断是否登录
        if (SpUtils.getSp().getBoolean(LoginUtils.LOGIN, false)) {
            //如果登录就带着UserId跳转详情页面
            Intent ins = new Intent(App.activity, PersonalActivity.class);
            ins.putExtra("id", id);
            ins.putExtra("type",1);
            App.activity.startActivity(ins);
        } else {
            //未登录就跳转到登录页面
            Intent ina = new Intent(App.activity, LoginActivity.class);
            App.activity.startActivity(ina);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.star_naonao_fragment;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.star_naonao_image_first:
                getIntents(di_naoNao_fragment.getServerInfo().getInfo().get(0).getUserID());
                break;
            case R.id.star_naonao_image_second:
                getIntents(di_naoNao_fragment.getServerInfo().getInfo().get(1).getUserID());
                break;
            case R.id.star_naonao_image_third:
                getIntents(di_naoNao_fragment.getServerInfo().getInfo().get(2).getUserID());
                break;
        }
    }
}
