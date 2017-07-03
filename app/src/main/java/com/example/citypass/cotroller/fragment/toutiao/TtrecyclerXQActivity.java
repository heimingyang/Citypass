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

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.toutiao.Justbean;
import com.example.citypass.model.bean.toutiao.Justinter;
import com.example.citypass.model.bean.toutiao.Ttrecycler;
import com.example.citypass.model.bean.toutiao.Ttrecyclerqq;
import com.example.citypass.model.bean.toutiao.Ttrecyclertz;
import com.example.citypass.model.bean.toutiao.Ttrecyclertzxq;
import com.example.citypass.model.bean.toutiao.Ttxqbean;
import com.example.citypass.model.biz.infor.IInforModel;
import com.example.citypass.model.biz.infor.InforModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.DeviceUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.google.gson.Gson;

import java.util.List;

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
    private String html;
    private int id;
    private StringBuffer buffer;
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
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        int type = intent.getIntExtra("type", 0);
        String hotflag=intent.getStringExtra("hotflag");
            if (type == 1) {
                gettz();
            } else if (type == 13) {
                gethtml();
            } else if(hotflag.equals("1")){
                gethtml();
            }else if(hotflag.equals("0")){
                gettz();
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
//        Log.e("onSuccess", s);

        InforModel inforModel = new IInforModel();
        inforModel.UpLoad(s, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
               // Log.e("onSuccess", "html" + result);
                Ttrecycler ttrecycler = JSON.parseObject(result, Ttrecycler.class);
                Ttrecycler.ServerInfoBean.NewsInfoBean bean=ttrecycler.getServerInfo().getNewsInfo().get(0);
                String url = ttrecycler.getServerInfo().getNewsInfo().get(0).getBody();
               // Log.e("onSuccess", "html" + url);
                ttxqWebview.loadDataWithBaseURL(null, url.toString(), "text/html", "utf-8", null);
                xqLin1Title.setText(bean.getTitle());
                xqLin1Address.setText(bean.getWapSiteName());
                String s=bean.getShowTime();
                xqLin1Data.setText(TimeUtils.getTime(s));
                xqLin1Number.setText(bean.getBrowse()+"");
                String d=bean.getDingName();
                if(!d.equals("")){
                    xqLin2Title.setText(d);
                }else {
                    xqLin2Title.setText("觉得不错就给个赞吧--");
                }
                if(bean.getCount1()!=0){
                    xqLin2Tv2.setText(bean.getCount1()+"评论");
                }else {
                    xqLin2Tv2.setText("评论");

                }
                if(bean.getDing()!=0){
                    xqLin2Tv1.setText(bean.getDing()+"赞");
                }else {
                    xqLin2Tv1.setText("赞");
                }
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
//          Log.e("onSuccess", s);

        InforModel inforModel = new IInforModel();
        inforModel.UpLoad(s, new MyCallBack() {



            @Override
            public void onSuccess(String result) {
//                Log.e("onSuccess", "TZ" + result);
                Ttxqbean ttrecycler = JSON.parseObject(result, Ttxqbean.class);
                String url = ttrecycler.getServerInfo().getTopicInfo().getTbody();
                ttxqWebview.loadDataWithBaseURL(null, url.toString(), "text/html", "utf-8", null);
                Ttxqbean.ServerInfoBean.TopicInfoBean bean=ttrecycler.getServerInfo().getTopicInfo();

                xqLin1Title.setText(bean.getTitle());
                xqLin1Address.setText(bean.getBoardName());

                xqLin1Data.setVisibility(View.GONE);
                xqLin1Number.setText(bean.getHits()+"");
                List<Ttxqbean.ServerInfoBean.DingUserListBean> d =
                        ttrecycler.getServerInfo().getDingUserList();

                if(d.size()!=0){
                    xqLin2Title.setText(bean.getSUP()+"人赞过");

                }else {
                    xqLin2Title.setText("觉得不错就给个赞吧--");
                }
                if(bean.getSUP()!=0){
                    xqLin2Tv2.setText(bean.getSUP()+"赞");
                }else {
                    xqLin2Tv2.setText("赞");
                }
                Drawable draw1=TtrecyclerXQActivity.this.getResources().getDrawable(R.drawable.ccoo_icon_zan_noral1);
                draw1.setBounds(0, 0,150, 150);
                xqLin2Tv2.setCompoundDrawables(null,draw1,null,null);

                Drawable draw2=TtrecyclerXQActivity.this.getResources().getDrawable(R.drawable.ccoo_icon_shang_noral1);
                draw2.setBounds(0, 0, draw2.getIntrinsicWidth(), draw2.getIntrinsicHeight());
                xqLin2Tv1.setCompoundDrawables(null,draw2,null,null);
                xqLin2Tv1.setText("打赏");
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }


}
