package com.example.citypass.cotroller.fragment.toutiao;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.fragment.information.LoginActivity;
import com.example.citypass.model.bean.toutiao.Dianzanbean;
import com.example.citypass.model.bean.toutiao.Dzanhtmlbean;
import com.example.citypass.model.bean.toutiao.Justbean;
import com.example.citypass.model.bean.toutiao.Justinter;
import com.example.citypass.model.biz.infor.IInforModel;
import com.example.citypass.model.biz.infor.InforModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.DeviceUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CityjustActivity extends BaseActivity {


    @BindView(R.id.ttxq_back)
    ImageView ttxqBack;
    @BindView(R.id.ttxq_more)
    ImageView ttxqMore;
    @BindView(R.id.ttxq_title)
    RelativeLayout ttxqTitle;
    @BindView(R.id.xq_lin1_title)
    TextView xqLin1Title;
    @BindView(R.id.xq_lin1_address)
    TextView xqLin1Address;
    @BindView(R.id.xq_lin1_data)
    TextView xqLin1Data;
    @BindView(R.id.xq_lin1_number)
    TextView xqLin1Number;
    @BindView(R.id.xq_lin1)
    RelativeLayout xqLin1;
    @BindView(R.id.ttxq_webview)
    WebView ttxqWebview;
    @BindView(R.id.xq_lin2_title)
    TextView xqLin2Title;
    @BindView(R.id.xq_lin2_tvno1)
    TextView xqLin2Tvno1;
    @BindView(R.id.xq_lin2_tv1)
    TextView xqLin2Tv1;
    @BindView(R.id.xq_lin2_tv2)
    TextView xqLin2Tv2;
    @BindView(R.id.xq_lin2_tv3)
    TextView xqLin2Tv3;
    @BindView(R.id.xq_lin2)
    RelativeLayout xqLin2;
    @BindView(R.id.activity_ttrecycler_xq)
    RelativeLayout activityTtrecyclerXq;
private int id;
    private  boolean login;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_ttrecycler_xq;
    }

    @Override
    protected void initListener() {
        ttxqWebview.setWebViewClient(new WebViewClient() {

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

        login = SpUtils.getSp().getBoolean(LoginUtils.LOGIN, true);

        Intent intent = getIntent();
         id = intent.getIntExtra("id", 0);
        int type = intent.getIntExtra("type", 0);
        getjust();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ttxq_back)
    public void onViewClicked() {
        finish();
    }
    public void getjust() {
        Justinter.ParamBean param = new Justinter.ParamBean();
        param.setNewsID(id);
        param.setSiteID(2422);
        param.setUserID(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));

        Justinter.StatisBean statis = new Justinter.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(this));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(this));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        statis.setUserId(0);


        Justinter toutiao = new Justinter();
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
//        Log.e("onSuccess", s);

        InforModel inforModel = new IInforModel();
        inforModel.UpLoad(s, new MyCallBack() {



            @Override
            public void onSuccess(String result) {
//                Log.e("onSuccess", "TZ" + result);
                Justbean ttrecycler = JSON.parseObject(result, Justbean.class);
                String url = ttrecycler.getServerInfo().getNewsInfo().get(0).getBody();
                ttxqWebview.loadDataWithBaseURL(null, url.toString(), "text/html", "utf-8", null);
                Justbean.ServerInfoBean.NewsInfoBean bean=ttrecycler.getServerInfo().getNewsInfo().get(0);

                xqLin1Title.setText(bean.getTitle());
                xqLin1Address.setText(bean.getWapSiteName());

                xqLin1Data.setText(bean.getShowTime());
                xqLin1Number.setText(bean.getBrowse()+"");

                String s=bean.getDingName();

                if(!s.equals("")){
                    xqLin2Title.setText(bean.getDingName()+"人赞过");

                }else {
                    xqLin2Title.setText("觉得不错就给个赞吧--");
                }
                if (bean.getDing()!=0) {
                    xqLin2Tv1.setText(bean.getDing()+"赞");
                }

                if (bean.getCount1()!=0) {
                    xqLin2Tv2.setText(bean.getCount1()+"评论");
                }
                xqLin2Tv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(login){
                            htmldianzan();
                        }else {
                            Intent intent=new Intent(CityjustActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }

                    }
                });
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
    private void htmldianzan() {
        Dzanhtmlbean.ParamBean param = new Dzanhtmlbean.ParamBean();
        param.setNewsID(id);
        param.setNick(SpUtils.getSp().getString(LoginUtils.NAME,""));
        param.setReplyID(0);
        param.setSiteID(2422);
        param.setType(0);
        param.setUserID(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));
        param.setUsiteID(2422);

        Dzanhtmlbean.StatisBean statis = new Dzanhtmlbean.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(this));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(this));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        statis.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));

        Dzanhtmlbean toutiao = new Dzanhtmlbean();
        toutiao.setMethod("PHSocket_SetCityNewsReplyDing");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("7B45C90A427C6B67140A4D3ED8715DA8");
        toutiao.setRequestTime(TimeUtils.getdangqianshijian());
        toutiao.setVersion("4.5");
        Gson gson = new Gson();

        String s = gson.toJson(toutiao);
//        Log.e("onSuccess", s);

        InforModel inforModel = new IInforModel();
        inforModel.UpLoad(s, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
//                Log.e("onSuccess",result);

                Dianzanbean dianzanbean = JSON.parseObject(result, Dianzanbean.class);
                int code = dianzanbean.getMessageList().getCode();
                if(code==1000){
                    Toast.makeText(CityjustActivity.this,dianzanbean.getMessageList().getMessage(),Toast.LENGTH_LONG).show();
                }else if(code==1002){
                    Toast.makeText(CityjustActivity.this,dianzanbean.getMessageList().getMessage(),Toast.LENGTH_LONG).show();
                }

                Drawable draw=CityjustActivity.this.getResources().getDrawable(R.drawable.ccoo_icon_zan_press1);
                draw.setBounds(0, 0, draw.getMinimumWidth(), draw.getMinimumHeight());
                xqLin2Tv1.setCompoundDrawables(null,draw,null,null);
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
}
