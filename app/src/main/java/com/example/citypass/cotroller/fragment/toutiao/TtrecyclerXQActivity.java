package com.example.citypass.cotroller.fragment.toutiao;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.activity.naonao.Carmer_FaBu_AiTe_NaoNao_Activity;
import com.example.citypass.cotroller.activity.naonao.Carmer_Photo_NaoNao_Activity;
import com.example.citypass.cotroller.activity.shequ.Emoji;
import com.example.citypass.cotroller.activity.shequ.ReleaseActivity;
import com.example.citypass.cotroller.adapter.shequ.MyEmojiAdapter;
import com.example.citypass.cotroller.adapter.shequ.MyPagerAdapter;
import com.example.citypass.cotroller.adapter.toutiao.HgoodmannerslAdapter;
import com.example.citypass.cotroller.fragment.information.LoginActivity;
import com.example.citypass.cotroller.fragment.toutiao.ttitem.HdakaFragment;
import com.example.citypass.cotroller.fragment.toutiao.ttitem.HhostFragment;
import com.example.citypass.cotroller.fragment.toutiao.ttitem.HnewFragment;
import com.example.citypass.model.bean.toutiao.Commentbean;
import com.example.citypass.model.bean.toutiao.Dianzanbean;
import com.example.citypass.model.bean.toutiao.Dzanhtmlbean;
import com.example.citypass.model.bean.toutiao.Idbean;
import com.example.citypass.model.bean.toutiao.Ttrecycler;
import com.example.citypass.model.bean.toutiao.Ttrecyclerqq;
import com.example.citypass.model.bean.toutiao.Ttrecyclertz;
import com.example.citypass.model.bean.toutiao.Ttxqbean;
import com.example.citypass.model.bean.toutiao.Tzaommentinter;
import com.example.citypass.model.bean.toutiao.Tzhueofuinter;
import com.example.citypass.model.biz.infor.IInforModel;
import com.example.citypass.model.biz.infor.InforModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.DeviceUtils;
import com.example.citypass.utils.EmojiUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.example.citypass.view.KeyboardUtils;
import com.example.citypass.view.MyViewPager;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
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
    @BindView(R.id.xq_tablayout)
    TabLayout xqTablayout;
    @BindView(R.id.xq_viewpager)
    MyViewPager xqViewpager;
    @BindView(R.id.activity_ttrecycler_xq)
    RelativeLayout activityTtrecyclerXq;
    @BindView(R.id.xq_lin3_img)
    ImageView xqLin3Img;
    @BindView(R.id.xq_lin3_tv1)
    TextView xqLin3Tv1;
    @BindView(R.id.xq_lin3_edt)
    EditText xqLin3Edt;
    @BindView(R.id.xq_lin3)
    RelativeLayout xqLin3;
    @BindView(R.id.xq_scrollview)
    ScrollView xqScrollview;
    @BindView(R.id.xq_lin3_img2)
    ImageView xqLin3Img2;
    @BindView(R.id.xq_lin3_img3)
    ImageView xqLin3Img3;
    @BindView(R.id.xq_lin3_img4)
    ImageView xqLin3Img4;
    @BindView(R.id.xq_lin3_img5)
    ImageView xqLin3Img5;
    private String html;
    private int id;
    private StringBuffer buffer;
    private String[] title = {"最新", "大咖说", "热门"};
    private boolean login;
    private HnewFragment hnewFragment;
    private HdakaFragment hdakaFragment;
    private HhostFragment hhostFragment;
    private int mid;
    private int type;
    private String hotflag;
    private HgoodmannerslAdapter adapter;
    private  boolean isimg=true;
    private  boolean isviewpager=true;;
    private PopupWindow window1;
    private ViewPager viewPager;
    private List<View> viewList;
    private ArrayList<Emoji> emojiList;
    private MyPagerAdapter myPagerAdapter;
    private int rowCount = 3;
    private int columCount = 6;
    private RelativeLayout ttxq;
    private  String lastString = "";
    private ViewPager myViewPager;
    private TextView pouptv1;
    private TextView pouptv2;
    private boolean  iscollect=true;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_ttrecycler_xq;
    }

    @Override
    protected void initListener() {

        ttxqMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window1.showAsDropDown(v,0,25);
            }
        });
        xqLin2Tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //分享

            }
        });
        pouptv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //分享

            }
        });
        pouptv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(iscollect){
                    Drawable draw1=TtrecyclerXQActivity.this.getResources().getDrawable(R.drawable.ccoo_icon_collect_press);
                    draw1.setBounds(0, 0, draw1.getMinimumWidth(), draw1.getMinimumHeight());
                    pouptv2.setCompoundDrawables(draw1,null,null,null);
                    pouptv2.setText("取消收藏");
                    Toast.makeText(TtrecyclerXQActivity.this,"收藏成功",Toast.LENGTH_LONG).show();
                    iscollect=false;
                }else {
                    Drawable draw1=TtrecyclerXQActivity.this.getResources().getDrawable(R.drawable.ccoo_icon_collect_noral);
                    draw1.setBounds(0, 0, draw1.getMinimumWidth(), draw1.getMinimumHeight());
                    pouptv2.setCompoundDrawables(draw1,null,null,null);
                    pouptv2.setText("我要收藏");
                    Toast.makeText(TtrecyclerXQActivity.this,"取消收藏",Toast.LENGTH_LONG).show();
                    iscollect=true;
                }

            }
        });



        xqLin3Img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isimg){
                    Animation animation = AnimationUtils.loadAnimation(TtrecyclerXQActivity.this, R.anim.showallimg);
                    animation.setDuration(300);
                    xqLin3Img2.startAnimation(animation);
                    animation.setFillAfter(true);
                    xqLin3Img3.setVisibility(View.VISIBLE);
                    xqLin3Img4.setVisibility(View.VISIBLE);
                    xqLin3Img5.setVisibility(View.VISIBLE);
                    myViewPager.setVisibility(View.VISIBLE);
                    isimg=false;
                }else {
                    Animation animation = AnimationUtils.loadAnimation(TtrecyclerXQActivity.this, R.anim.disallimg);
                    animation.setDuration(300);
                    xqLin3Img2.startAnimation(animation);
                    animation.setFillAfter(true);
                    xqLin3Img3.setVisibility(View.GONE);
                    xqLin3Img4.setVisibility(View.GONE);
                    xqLin3Img5.setVisibility(View.GONE);
                    myViewPager.setVisibility(View.GONE);
                    isimg=true;
                }
            }
        });
        xqLin3Img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TtrecyclerXQActivity.this,Carmer_Photo_NaoNao_Activity.class);
                startActivity(intent);
            }
        });
        xqLin3Img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TtrecyclerXQActivity.this,Carmer_FaBu_AiTe_NaoNao_Activity.class);
                startActivity(intent);
            }
        });
        xqLin3Img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                window1.showAtLocation(TtrecyclerXQActivity.this.findViewById(R.id.ttxq),
//                        Gravity.BOTTOM, 0, 0);
                if(isviewpager){
                    myViewPager.setVisibility(View.VISIBLE);
                    isviewpager=false;
                }else {
                    myViewPager.setVisibility(View.GONE);
                    isviewpager=true;
                }

            }
        });



        xqLin3Tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(login){
                    String commentdata = xqLin3Edt.getText().toString().trim();
                    if (!commentdata.equals("")) {
                        if (type == 1) {
                            gettzcomment(commentdata);
                        } else if (type == 13) {
                            getcomment(commentdata);
                        } else if (hotflag.equals("1")) {
                            getcomment(commentdata);
                        } else if (hotflag.equals("0")) {
                            getcomment(commentdata);
                        }
                        judgetype(type, hotflag);
                    } else {
                        Toast.makeText(TtrecyclerXQActivity.this, "评论内容不能为空！", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Intent intent=new Intent(TtrecyclerXQActivity.this,LoginActivity.class);
                    startActivity(intent);
                }

            }
        });
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



        xqLin3Edt.addTextChangedListener(new TextWatcher() {
            int start;
            boolean isDelete;
            int count;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("FragmentComment", "start:" + start + ",before=" + before + "count=" + count);
                if (!lastString.equals(s.toString())) {
                    this.start = start;
                    this.count = count;
                    if (lastString.length() > s.toString().length()) {
                        isDelete = true;
                    } else {
                        isDelete = false;
                    }
                    lastString = s.toString();
                    EmojiUtils.showEmojiTextView(App.activity, xqLin3Edt, s.toString());

                } else {
                    if (isDelete) {
                        xqLin3Edt.setSelection(this.start);
                    } else {
                        xqLin3Edt.setSelection(this.start + this.count);
                    }
                }
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void gettzcomment(String commentdata) {
        Tzhueofuinter.ParamBean param = new Tzhueofuinter.ParamBean();
        param.setContent(commentdata);
        param.setImages("");
        param.setIsMobile(2);
        param.setLastTime(TimeUtils.getdangqianshijian());
        param.setMapPoint("40.183373,116.172241");
        param.setReplyID(0);
        param.setReplyUser("");
        param.setReplyUserLou(0);
        param.setRoleName(SpUtils.getSp().getString(LoginUtils.NAME, ""));
        param.setSiteID(2422);
        param.setTopicID(id);
        param.setUserName(SpUtils.getSp().getString(LoginUtils.USERNAME, ""));
        param.setUsiteID("2422");
        Tzhueofuinter.StatisBean statis = new Tzhueofuinter.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(this));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(this));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        statis.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));

        Tzhueofuinter toutiao = new Tzhueofuinter();
        toutiao.setMethod("PHSocket_SetTopicInfoReply");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("7B45C90A427C6B67140A4D3ED8715DA8");
        toutiao.setRequestTime(TimeUtils.getdangqianshijian());
        toutiao.setVersion("4.5");
        Gson gson = new Gson();

        String s = gson.toJson(toutiao);
//        Log.e("comment", s);

        InforModel inforModel = new IInforModel();
        inforModel.UpLoad(s, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
//              Log.e("comment",result);
                xqLin3Edt.setText("");
                KeyboardUtils.closeKeyboard(xqLin3Edt, TtrecyclerXQActivity.this);
                Toast.makeText(TtrecyclerXQActivity.this, "评论成功！", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    private void getcomment(String commentdata) {
        Commentbean.ParamBean param = new Commentbean.ParamBean();
        param.setContent(commentdata);
        param.setNewsID(id);
        param.setReplyID(0);
        param.setSiteID(2422);
        param.setUserID(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));
        param.setUserName(SpUtils.getSp().getString(LoginUtils.NAME, ""));
        param.setUsiteID(2422);

        Commentbean.StatisBean statis = new Commentbean.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(this));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(this));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        statis.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));

        Commentbean toutiao = new Commentbean();
        toutiao.setMethod("PHSocket_SetCityNewsReplyInfo");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("7B45C90A427C6B67140A4D3ED8715DA8");
        toutiao.setRequestTime(TimeUtils.getdangqianshijian());
        toutiao.setVersion("4.5");
        Gson gson = new Gson();

        String s = gson.toJson(toutiao);
//        Log.e("comment", s);

        InforModel inforModel = new IInforModel();
        inforModel.UpLoad(s, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
//              Log.e("comment",result);
                xqLin3Edt.setText("");
                Toast.makeText(TtrecyclerXQActivity.this, "评论成功！", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    @Override
    protected void initData() {
        String nuwnumber = SpUtils.getSp().getString("nuwnumber", "");
        String dakanumber = SpUtils.getSp().getString("dakanumber", "");
        if (!nuwnumber.equals("")) {
            for (int i = 0; i < title.length; i++) {
                if (i == 0) {
                    title[i].replace("最新0", "最新" + nuwnumber);
                }
            }
        }
        if (!dakanumber.equals("")) {
            for (int i = 0; i < title.length; i++) {
                if (i == 1) {
                    title[i].replace("大咖说0", "大咖说" + dakanumber);
                }
            }
        }

        adapter.notifyDataSetChanged();

    }

    private void judgetype(int type, String hotflag) {
        if (type == 1) {
            xqLin3Img2.setVisibility(View.VISIBLE);
            gettz();
            xqLin3Img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (login) {
                        tzdianzan();
                        xqLin3Img.setImageResource(R.drawable.ccoo_icon_zan_press1);
                    } else {
                        Intent intent = new Intent(TtrecyclerXQActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }
            });
        } else if (type == 13) {
            xqLin3Img2.setVisibility(View.GONE);

            xqLin3Img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (login) {
                        htmldianzan();
                        xqLin3Img.setImageResource(R.drawable.ccoo_icon_zan_press1);
                    } else {
                        Intent intent = new Intent(TtrecyclerXQActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }
            });
            gethtml();
        } else if (hotflag.equals("1")) {
            xqLin3Img2.setVisibility(View.GONE);

            xqLin3Img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (login) {
                        htmldianzan();
                        xqLin3Img.setImageResource(R.drawable.ccoo_icon_zan_press1);
                    } else {
                        Intent intent = new Intent(TtrecyclerXQActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }
            });
            gethtml();
        } else if (hotflag.equals("0")) {
            xqLin3Img2.setVisibility(View.GONE);

            xqLin3Img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (login) {
                        htmldianzan();
                        xqLin3Img.setImageResource(R.drawable.ccoo_icon_zan_press1);
                    } else {
                        Intent intent = new Intent(TtrecyclerXQActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }
            });
            gethtml();
        }
    }


    @Override
    protected void initView() {
        login = SpUtils.getSp().getBoolean(LoginUtils.LOGIN, true);
        myViewPager = (ViewPager) findViewById(R.id.tt_mviewpager);
        ttxq = (RelativeLayout) findViewById(R.id.att_item);
        showPopupWindow();
        showtitlePopupWindow();
        KeyboardUtils.closeKeyboard(xqLin3Edt, this);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        type = intent.getIntExtra("type", 0);
        hotflag = intent.getStringExtra("hotflag");

        //通过type值判断应该加载的页面
        judgetype(type, hotflag);


        hnewFragment = new HnewFragment();
        hdakaFragment = new HdakaFragment();
        hhostFragment = new HhostFragment();

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(hnewFragment);
        fragments.add(hdakaFragment);
        fragments.add(hhostFragment);

        adapter = new HgoodmannerslAdapter(getSupportFragmentManager(), fragments, title);
        xqViewpager.setAdapter(adapter);
        xqViewpager.setOffscreenPageLimit(3);
        xqTablayout.setupWithViewPager(xqViewpager);
        xqTablayout.setTabMode(TabLayout.MODE_FIXED);

        xqTablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.red));
        xqTablayout.setTabTextColors
                (ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.red));

    }

    private void showtitlePopupWindow() {
        View view = getLayoutInflater().inflate(R.layout.xq_poup_title, null);
        pouptv1 = (TextView) view.findViewById(R.id.xq_poup_tv1);
        pouptv2 = (TextView) view.findViewById(R.id.xq_poup_tv2);

        window1 = new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT,  WindowManager.LayoutParams.WRAP_CONTENT);
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window1.setFocusable(true);
        window1.setOutsideTouchable(true);
        window1.setBackgroundDrawable(new ColorDrawable());

        // 设置popWindow的显示和消失动画
        //window1.setAnimationStyle(R.style.Animation);
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
        toutiao.setVersion("4.6");
        Gson gson = new Gson();

        String s = gson.toJson(toutiao);
//        Log.e("onSuccess", s);

        InforModel inforModel = new IInforModel();
        inforModel.UpLoad(s, new MyCallBack() {
            @Override
            public void onSuccess(String result) {


                // Log.e("onSuccess", "html" + result);
                Ttrecycler ttrecycler = JSON.parseObject(result, Ttrecycler.class);
                Ttrecycler.ServerInfoBean.NewsInfoBean bean = ttrecycler.getServerInfo().getNewsInfo().get(0);
                String url = ttrecycler.getServerInfo().getNewsInfo().get(0).getBody();
                ttxqWebview.loadDataWithBaseURL(null, url.toString(), "text/html", "utf-8", null);
                xqLin1Title.setText(bean.getTitle());
                xqLin1Address.setText(bean.getWapSiteName());
                String s = bean.getShowTime();
                xqLin1Data.setText(TimeUtils.getTime(s));
                xqLin1Number.setText(bean.getBrowse() + "");
                String d = bean.getDingName();
                if (!d.equals("")) {
                    xqLin2Title.setText(d);
                } else {
                    xqLin2Title.setText("觉得不错就给个赞吧--");
                }
                if (bean.getCount1() != 0) {
                    xqLin2Tv2.setText(bean.getCount1() + "评论");
                } else {
                    xqLin2Tv2.setText("评论");

                }
                if (bean.getDing() != 0) {
                    xqLin2Tv1.setText(bean.getDing() + "赞");
                } else {
                    xqLin2Tv1.setText("赞");
                }
                xqLin2Tv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (login) {
                            htmldianzan();
                            xqLin3Img.setImageResource(R.drawable.ccoo_icon_zan_press1);
                        } else {
                            Intent intent = new Intent(TtrecyclerXQActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    }
                });
                xqLin2Tv2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        KeyboardUtils.openKeyboard(xqLin3Edt, TtrecyclerXQActivity.this);
                    }
                });

                Idbean idbean = new Idbean();
                idbean.setId(bean.getNewsID());
                idbean.setType("html");
                EventBus.getDefault().postSticky(idbean);
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    private void htmldianzan() {
        Dzanhtmlbean.ParamBean param = new Dzanhtmlbean.ParamBean();
        param.setNewsID(id);
        param.setNick(SpUtils.getSp().getString(LoginUtils.NAME, ""));
        param.setReplyID(0);
        param.setSiteID(2422);
        param.setType(0);
        param.setUserID(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));
        param.setUsiteID(2422);

        Dzanhtmlbean.StatisBean statis = new Dzanhtmlbean.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(this));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(this));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        statis.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));

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
                if (code == 1000) {
                    Toast.makeText(TtrecyclerXQActivity.this, dianzanbean.getMessageList().getMessage(), Toast.LENGTH_LONG).show();
                } else if (code == 1002) {
                    Toast.makeText(TtrecyclerXQActivity.this, dianzanbean.getMessageList().getMessage(), Toast.LENGTH_LONG).show();
                }

                Drawable draw = TtrecyclerXQActivity.this.getResources().getDrawable(R.drawable.ccoo_icon_zan_press1);
                draw.setBounds(0, 0, draw.getMinimumWidth(), draw.getMinimumHeight());
                xqLin2Tv1.setCompoundDrawables(null, draw, null, null);
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
        param.setUserName(SpUtils.getSp().getString(LoginUtils.USERNAME, ""));

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
//        Log.e("onSuccess", s);

        InforModel inforModel = new IInforModel();
        inforModel.UpLoad(s, new MyCallBack() {


            @Override
            public void onSuccess(String result) {
//                Log.e("onSuccess", "TZ" + result);

                Ttxqbean ttrecycler = JSON.parseObject(result, Ttxqbean.class);
                String url = ttrecycler.getServerInfo().getTopicInfo().getTbody();
                ttxqWebview.loadDataWithBaseURL(null, url.toString(), "text/html", "utf-8", null);
                Ttxqbean.ServerInfoBean.TopicInfoBean bean = ttrecycler.getServerInfo().getTopicInfo();

                xqLin1Title.setText(bean.getTitle());
                xqLin1Address.setText(bean.getBoardName());

                xqLin1Data.setVisibility(View.GONE);
                xqLin1Number.setText(bean.getHits() + "");
                List<Ttxqbean.ServerInfoBean.DingUserListBean> d =
                        ttrecycler.getServerInfo().getDingUserList();

                if (d.size() != 0) {
                    xqLin2Title.setText(bean.getSUP() + "人赞过");
                } else {
                    xqLin2Title.setText("觉得不错就给个赞吧--");
                }
                if (bean.getSUP() != 0) {
                    xqLin2Tv2.setText(bean.getSUP() + "赞");
                } else {
                    xqLin2Tv2.setText("赞");
                }

                Drawable draw1 = TtrecyclerXQActivity.this.getResources().getDrawable(R.drawable.ccoo_icon_zan_noral1);
                draw1.setBounds(0, 0, draw1.getIntrinsicWidth(), draw1.getIntrinsicHeight());
                xqLin2Tv2.setCompoundDrawables(null, draw1, null, null);

                Drawable draw2 = TtrecyclerXQActivity.this.getResources().getDrawable(R.drawable.ccoo_icon_shang_noral1);
                draw2.setBounds(0, 0, draw2.getIntrinsicWidth(), draw2.getIntrinsicHeight());
                xqLin2Tv1.setCompoundDrawables(null, draw2, null, null);
                xqLin2Tv1.setText("打赏");

                xqLin2Tv2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (login) {
                            tzdianzan();
                        } else {
                            Intent intent = new Intent(TtrecyclerXQActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    }
                });

                Idbean idbean = new Idbean();
                idbean.setId(bean.getUserID());
                idbean.setType("帖子");
                EventBus.getDefault().postSticky(idbean);
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    private void tzdianzan() {
        Dzanhtmlbean.ParamBean param = new Dzanhtmlbean.ParamBean();
        param.setNewsID(id);
        param.setNick(SpUtils.getSp().getString(LoginUtils.NAME, ""));
        param.setReplyID(0);
        param.setSiteID(2422);
        param.setType(0);
        param.setUserID(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));
        param.setUsiteID(2422);

        Dzanhtmlbean.StatisBean statis = new Dzanhtmlbean.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(this));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(this));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        statis.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));

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
                if (code == 1000) {
                    Toast.makeText(TtrecyclerXQActivity.this, dianzanbean.getMessageList().getMessage(), Toast.LENGTH_LONG).show();
                } else if (code == 1002) {
                    Toast.makeText(TtrecyclerXQActivity.this, dianzanbean.getMessageList().getMessage(), Toast.LENGTH_LONG).show();
                }
                Drawable draw = TtrecyclerXQActivity.this.getResources().getDrawable(R.drawable.ccoo_icon_zan_press1);
                draw.setBounds(0, 0, draw.getMinimumWidth(), draw.getMinimumHeight());
                xqLin2Tv2.setCompoundDrawables(null, draw, null, null);
                xqLin3Img.setImageResource(R.drawable.ccoo_icon_zan_press1);
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
    private void showPopupWindow() {
//        View view = getLayoutInflater().inflate(R.layout.fabu_biaoqing_popwindow, null);
//        viewPager = (ViewPager) view.findViewById(R.id.mViewPager);
        addBiaoQing();
//        window1 = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 400);
//        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
//        window1.setFocusable(true);
//        window1.setOutsideTouchable(true);
//        window1.setBackgroundDrawable(new ColorDrawable());
//
//        // 设置popWindow的显示和消失动画
//        window1.setAnimationStyle(R.style.Animation);
    }
    private void addBiaoQing() {
        viewList = new ArrayList<>();
        emojiList = EmojiUtils.getEmojiList();
        for (int i = 0; i < getPagerCount(emojiList.size()); i++) {
            GridView gridView = getPagerItem(i);
            viewList.add(gridView);
        }
        myPagerAdapter = new MyPagerAdapter(viewList);
        myViewPager.setAdapter(myPagerAdapter);
    }
    private int getPagerCount(int length) {
        return length % (rowCount * columCount) == 0 ? length / (rowCount * columCount) : length / (rowCount * columCount) + 1;
    }
    private GridView getPagerItem(int position) {
        View view = LayoutInflater.from(App.activity).inflate(R.layout.fragment_item_comment1, null);
        GridView gridView = (GridView) view.findViewById(R.id.mGrid);
        List<Emoji> subEmojiList = new ArrayList<>();
        for (int i = 0; i < (columCount * rowCount) - 1; i++) {
            if (columCount * rowCount * (position + 1) <= 52) {
                subEmojiList.add(emojiList.get(i + position * (columCount * rowCount)));
            } else {
                if (i <= 2) {
                    subEmojiList.add(emojiList.get(i + position * (columCount * rowCount)));
                }
            }

        }
        subEmojiList.add(new Emoji("[删除]", R.mipmap.face_delete));

        MyEmojiAdapter adapter = new MyEmojiAdapter(App.activity, subEmojiList, R.layout.fragment_comment_grid_item1, xqLin3Edt);

        gridView.setAdapter(adapter);

        return gridView;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
