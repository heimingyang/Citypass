package com.example.citypass.cotroller.activity.naonao;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.naonao.Carmer_FaBu_Naonao_Title_Adapter;
import com.example.citypass.model.bean.naonao.Carmer_FaBu_Naonao_Title_Bean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * /**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/7/2 0002 20:17
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


public class Carmer_FaBu_NaoNao_Title_Activity extends BaseActivity {


    @BindView(R.id.carmer_fabu_naonao_title_cancel)
    ImageView carmerFabuNaonaoTitleCancel;
    @BindView(R.id.cooperation_Relative)
    RelativeLayout cooperationRelative;
    @BindView(R.id.carmer_fabu_naonao_title_edit)
    EditText carmerFabuNaonaoTitleEdit;
    @BindView(R.id.carmer_fabu_naonao_title_recycle)
    RecyclerView carmerFabuNaonaoTitleRecycle;
    private List<Carmer_FaBu_Naonao_Title_Bean.ServerInfoBean> mList = new ArrayList<>();
    private Carmer_FaBu_Naonao_Title_Adapter mAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.carmer_fabu_naonao_title_activity;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        initParsing();
    }

    private void initParsing() {
        Map<String,String> map = new HashMap<>();
        String str ="{\"appName\":\"CcooCity\",\"Param\":{\"pageSize\":10,\"userID\":30108866,\"siteID\":2422,\"type\":4,\"curPage\":1,\"keyword\":\"\"},\"requestTime\":\"2017-07-02 20:12:45\",\"customerKey\":\"0D0DF7C57B64EB2D41174B2AB0C00A5A\",\"Method\":\"PHSocket_GetTieBaGambitList\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":30108866,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        map.put("param",str);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("Title_NaoNao_Fragment", result);
                Carmer_FaBu_Naonao_Title_Bean title_naoNao_bean = JSON.parseObject(result, Carmer_FaBu_Naonao_Title_Bean.class);
                if (mList.size() < 0) {
                    return;
                }
                mList.addAll(title_naoNao_bean.getServerInfo());
                if (mAdapter == null) {
                    mList.addAll(title_naoNao_bean.getServerInfo());
                    if (mAdapter == null) {
                        mAdapter = new Carmer_FaBu_Naonao_Title_Adapter(mList,Carmer_FaBu_NaoNao_Title_Activity.this);
                        carmerFabuNaonaoTitleRecycle.setAdapter(mAdapter);
                    } else {
                        mAdapter.setNewData(mList);
                    }

                }
                mAdapter.setOnItemClickListener(new Carmer_FaBu_Naonao_Title_Adapter.OnRecyclerViewItemClickListener() {
                    @Override
                    public void onItemClick(View view, String data) {

                        finish();
                    }
                });
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    @Override
    protected void initView() {
        LinearLayoutManager man = new LinearLayoutManager(this);
        initParsing();
        carmerFabuNaonaoTitleRecycle.setLayoutManager(man);
    }


}
