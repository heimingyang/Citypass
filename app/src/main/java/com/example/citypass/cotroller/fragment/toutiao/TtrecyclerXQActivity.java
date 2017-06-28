package com.example.citypass.cotroller.fragment.toutiao;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.toutiao.Ttrecycler;
import com.example.citypass.model.bean.toutiao.Ttrecyclerqq;
import com.example.citypass.model.bean.toutiao.Ttrecyclertz;
import com.example.citypass.model.bean.toutiao.Ttrecyclertzxq;
import com.example.citypass.model.biz.infor.IInforModel;
import com.example.citypass.model.biz.infor.InforModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.DeviceUtils;
import com.example.citypass.utils.TimeUtils;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TtrecyclerXQActivity extends BaseActivity {
    @BindView(R.id.ttxq_back)
    ImageView ttxqBack;
    @BindView(R.id.ttxq_more)
    ImageView ttxqMore;
    @BindView(R.id.ttxq_title)
    RelativeLayout ttxqTitle;
    @BindView(R.id.ttxq_webview)
    WebView ttxqWebview;
    @BindView(R.id.activity_ttrecycler_xq)
    RelativeLayout activityTtrecyclerXq;
    private String html;
    private int id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ttrecycler_xq;
    }

    @Override
    protected void initListener() {
        ttxqBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ttxqWebview.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        int type=intent.getIntExtra("type",0);
        // Log.e("onSuccess", type+"");

        if(type==1){
            gettz();
        }else if(type==13){
            gethtml();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public void gethtml() {
        Ttrecyclerqq.ParamBean param = new Ttrecyclerqq.ParamBean();
        param.setNewsID(id);
        param.setSiteID(2422);
        param.setUserID(0);

        Ttrecyclerqq.StatisBean statis = new Ttrecyclerqq.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(this));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(this));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        statis.setUserId(0);

        Ttrecyclerqq toutiao = new Ttrecyclerqq();
        toutiao.setMethod("PHSocket_GetCityNewsBody");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("FEBD7DF9A419351C5F2F97161FD1DF6A");
        toutiao.setRequestTime(TimeUtils.getdangqianshijian());
        toutiao.setVersion("4.5");
        Gson gson = new Gson();
        String s = gson.toJson(toutiao);
        Log.e("onSuccess", s);

        InforModel inforModel = new IInforModel();
        inforModel.UpLoad(s, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.e("onSuccess", "html"+result);
                Ttrecycler ttrecycler = JSON.parseObject(result, Ttrecycler.class);
                String url = ttrecycler.getExtend().getReShare().getUrl();
                Log.e("onSuccess", "html"+url);
                ttxqWebview.loadUrl(url);

            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    public void gettz() {
        Ttrecyclertz.ParamBean param = new Ttrecyclertz.ParamBean();
        param.setTopicID(id);
        param.setSiteID(2422);
        param.setUserName("");

        Ttrecyclertz.StatisBean statis = new Ttrecyclertz.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(this));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(this));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        statis.setUserId(0);


        Ttrecyclertz toutiao = new Ttrecyclertz();
        toutiao.setMethod("PHSocket_GetBBSTopicInfo");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("FEBD7DF9A419351C5F2F97161FD1DF6A");
        toutiao.setRequestTime(TimeUtils.getdangqianshijian());
        toutiao.setVersion("4.5");
        Gson gson = new Gson();
        String s = gson.toJson(toutiao);
        Log.e("onSuccess", s);

        InforModel inforModel = new IInforModel();
        inforModel.UpLoad(s, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.e("onSuccess", "TZ"+result);
                Ttrecyclertzxq ttrecycler = JSON.parseObject(result, Ttrecyclertzxq.class);
                String url = ttrecycler.getExtend().getReShare().getUrl();
                Log.e("onSuccess", "TZ"+url);
                ttxqWebview.loadUrl(url);
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
}
