package com.example.citypass.cotroller.activity.naonao;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.naonao.Carmer_FaBu_AiTe_NaoNao_Adapter;
import com.example.citypass.model.bean.naonao.Carmer_FaBu_AiTe_NaoNao_Bean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/7/5 0005 15:22
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


public class Carmer_FaBu_AiTe_NaoNao_Activity extends BaseActivity {

    @BindView(R.id.carmer_fabu_aite_naonao_cancel)
    ImageView carmerFabuAiteNaonaoCancel;
    @BindView(R.id.carmer_fabu_aite_naonao_listView)
    ListView carmerFabuAiteNaonaoListView;
    @BindView(R.id.cooperation_Relative)
    RelativeLayout cooperationRelative;
    @BindView(R.id.carmer_photo_naonao_ok)
    Button carmerPhotoNaonaoOk;
    @BindView(R.id.carmer_photo_naonao_add)
    LinearLayout carmerPhotoNaonaoAdd;
    @BindView(R.id.carmer_photo_naonao_scroll)
    HorizontalScrollView carmerPhotoNaonaoScroll;
    @BindView(R.id.carmer_photo_naonao_dibu)
    RelativeLayout carmerPhotoNaonaoDibu;
    private List<Carmer_FaBu_AiTe_NaoNao_Bean.ServerInfoBean> mList = new ArrayList<>();
    private Carmer_FaBu_AiTe_NaoNao_Adapter adapter;
    private ImageView img;

    @Override
    protected int getLayoutId() {
        return R.layout.carmer_fabu_aite_naonao_activity;
    }

    @Override
    protected void initListener() {
        carmerFabuAiteNaonaoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                img = (ImageView) carmerFabuAiteNaonaoListView.getChildAt(position).findViewById(R.id.carmer_fabu_aite_naonao_item_xuan);
                img.setImageResource(R.drawable.btn_choose_photo_s);
            }
        });

    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"pageSize\":50,\"userName\":\"sid094756353406476\",\"curPage\":1,\"siteID\":2422},\"requestTime\":\"2017-07-05 15:17:47\",\"customerKey\":\"E79DA6B45555866FE5C94F3C5A25F083\",\"Method\":\"PHSocket_GetBBSFriendList\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":31363437,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        map.put("param", str);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("Carmer_FaBu_AiTe_NaoNao", result);
                Carmer_FaBu_AiTe_NaoNao_Bean carmer_faBu_aiTe_naoNao_activity = JSON.parseObject(result, Carmer_FaBu_AiTe_NaoNao_Bean.class);
                if (carmer_faBu_aiTe_naoNao_activity.getMessageList().getCode() != 1000) {
                    return;
                }
                mList.addAll(carmer_faBu_aiTe_naoNao_activity.getServerInfo());


                if (adapter == null) {
                    adapter = new Carmer_FaBu_AiTe_NaoNao_Adapter(mList, Carmer_FaBu_AiTe_NaoNao_Activity.this);
                    carmerFabuAiteNaonaoListView.setAdapter(adapter);
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
    protected void initView() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.carmer_fabu_aite_naonao_cancel, R.id.carmer_photo_naonao_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.carmer_fabu_aite_naonao_cancel:
                finish();
                break;
            case R.id.carmer_photo_naonao_ok:
                onBackPressed();
                break;
        }
    }
}
