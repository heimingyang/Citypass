package com.example.citypass.cotroller.fragment.naonao.detail;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.activity.naonao.Carmer_FaBu_AiTe_NaoNao_Activity;
import com.example.citypass.cotroller.activity.naonao.Carmer_Photo_NaoNao_Activity;
import com.example.citypass.cotroller.activity.shequ.Emoji;
import com.example.citypass.cotroller.adapter.naonao.detail.DetailNewAdapter;
import com.example.citypass.cotroller.adapter.shequ.MyEmojiAdapter;
import com.example.citypass.cotroller.adapter.shequ.MyPagerAdapter;
import com.example.citypass.cotroller.fragment.information.TaskActivity;
import com.example.citypass.model.bean.naonao.detail.DetailHuiFuBean;
import com.example.citypass.model.bean.naonao.detail.DetailMainBean;
import com.example.citypass.model.bean.naonao.detail.DetailNewBean;
import com.example.citypass.model.bean.naonao.detail.HuiFuEnentBean;
import com.example.citypass.model.bean.naonao.detail.IsLikeBean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.EmojiUtils;
import com.example.citypass.utils.GetDbUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.UrlUtils;
import com.example.citypass.utils.Zan;
import com.example.citypass.utils.ZanDao;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/26 11:21
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class SquareNaonaoDetailActivity extends BaseActivity implements MyGridLayout.onClicklisenter, View.OnClickListener {
    @BindView(R.id.square_naonao_TitleText)
    TextView TitleText;
    @BindView(R.id.square_naonao_recycle_item_touxiang)
    ImageView Touxiang;
    @BindView(R.id.square_naonao_recycle_item_name)
    TextView ItemName;
    @BindView(R.id.square_naonao_recycle_item_level)
    TextView squareNaonaoRecycleItemLevel;
    @BindView(R.id.square_naonao_recycle_item_time)
    TextView ItemTime;
    @BindView(R.id.square_naonao_guanzhu_btn)
    Button GuanzhuBtn;
    @BindView(R.id.square_naonao_detail_shuatie)
    TextView Shuatie;
    @BindView(R.id.square_naonao_detail_ImageLinear)
    MyGridLayout myGridView;
    @BindView(R.id.square_naonao_recycle_item_address)
    TextView ItemAddress;
    @BindView(R.id.square_naonao_Textzan)
    TextView Textzan;
    @BindView(R.id.square_naonao_zanImage)
    ImageView ZanImage;
    @BindView(R.id.square_naonao_shareImage)
    ImageView ShareImage;
    @BindView(R.id.square_naonao_dashangImage)
    ImageView DashangImage;
    @BindView(R.id.square_naonao_zanText)
    TextView ZanText;
    @BindView(R.id.NaoNao_DetailBack)
    ImageView NaoNaoDetailBack;
    @BindView(R.id.NaoNao_Relative)
    RelativeLayout NaoNaoRelative;
    @BindView(R.id.NaoNao_Detail_Zan)
    ImageView DetailZan;
    @BindView(R.id.NaoNao_Detail_Add)
    ImageView NaoNaoDetailAdd;
    @BindView(R.id.NaoNao_Detail_butSendMsg)
    Button ButSendMsg;
    @BindView(R.id.NaoNao_DetailEdit)
    EditText mEdit;
    @BindView(R.id.naonao_item_newFragment)
    RadioButton TextNewFragment;
    @BindView(R.id.naonao_item_SaidFragment)
    RadioButton TextSaidFragment;
    @BindView(R.id.naonao_item_ShangFragment)
    RadioButton TextShangFragment;
    @BindView(R.id.naonao_item_Fragmelayout)
    FrameLayout mFragmelayout;
    @BindView(R.id.NaoNao_Detail_Scroll)
    ScrollView NaoNaoDetailScroll;
    @BindView(R.id.NaoNao_ItemMainRelative)
    RelativeLayout MainRelative;
    @BindView(R.id.naonao_detail_setting)
    ImageView naonaoDetailSetting;
    @BindView(R.id.RelativeLayout)
    android.widget.RelativeLayout RelativeLayout;
    @BindView(R.id.naonao_detail_Biaoqing)
    ImageView Biaoqing;
    @BindView(R.id.naonao_detail_mainCamera)
    ImageView DetailCamera;
    @BindView(R.id.naonao_detail_MainAite)
    ImageView naonaoDetailAite;
    @BindView(R.id.NaoNao_Detail_LinearGone)
    LinearLayout LinearGone;
    @BindView(R.id.NaoNao_detail_HuiFuNum)
    TextView HuiFuNum;
    @BindView(R.id.naonao_detail_yuyin)
    ImageView DetailYuyin;
    @BindView(R.id.NaoNao_Detail_YiHuiFu)
    TextView YiHuiFu;
    @BindView(R.id.NaoNao_detail_viewpager)
    ViewPager NaoNaoDetailViewpager;
    @BindView(R.id.naonao_huixian)
    TextView naonaoHuixian;

    private List<String> strList = new ArrayList<>();
    private String images;
    private FragmentManager manager;
    private int mID;
    private String userName;
    private boolean isZan = false; //判断是否点赞
    private DetailMainBean.ServerInfoBean infoBean;
    private IsLikeBean isLikeBean;
    private Dialog dialog;
    private int flag = 0;
    private List<DetailNewBean.ServerInfoBean> mList;
    private DetailNewAdapter adapter;
    private int infoBeanId;
    private Dialog juBaodialog;
    private RelativeLayout jubao;
    private PopupWindow pop;
    private ImageView chick1;
    private ImageView chick2;
    private ImageView chick3;
    private ImageView chick4;
    private ImageView chick5;
    private ImageView chick6;
    private TextView text_daShang;
    private Dialog moneydialog;
    private Zan zan;
    private ZanDao zanDao;
    private String titleName;
    private ArrayList<Emoji> emojiList;
    private List<View> viewList;
    private int rowCount = 3;
    private int columCount = 6;
    private MyPagerAdapter myPagerAdapter;
    private TextView textShouCang;
    private ImageView shouImage;
    private android.widget.RelativeLayout shouRelative;
    private TextView textShare;

    @Override
    protected int getLayoutId() {
        return R.layout.square_naonao_detail_item;
    }

    @Override
    protected void initListener() {

    }

    //一进来就进行的请求
    @Override
    protected void initData() {
        SquarePost();

    }

    private void SquarePost() {
        Map<String, String> map = new HashMap<>();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"id\":";
        int id = mID;
        String value = ",\"userID\":30108866,\"siteID\":2422},\"requestTime\":\"2017-06-29 20:50:43\",\"customerKey\":\"96A942D2967795D409280E4DAFCDC4EE\",\"Method\":\"PHSocket_GetTiebaByID\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":30108866,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";

        String mmp = str + id + value;
        map.put("param", mmp);
        Log.d("SquareNaonaoDetailActiv", "详情的网址是" + mmp);
        HttpFacory.create().POST(UrlUtils.BaseUrl, map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                DetailMainBean bean = JSON.parseObject(result, DetailMainBean.class);
                if (bean == null && result == null) {
                    return;
                }
                if (bean.getMessageList().getCode() != 1000) {
                    return;

                }
                infoBean = bean.getServerInfo();
                if (infoBean == null) {
                    return;
                }
                int hit = infoBean.getHit();
                TitleText.setText(hit + "");

                Textzan.setText(infoBean.getDingName() + "等" + infoBean.getDing() + "人赞过" + "");
                int ding = infoBean.getDing();
                if (ding == 0) {
                    ZanText.setText("赞" + "");
                } else {
                    ZanText.setText(infoBean.getDing() + "赞" + "");
                }
                TextNewFragment.setText("最新 " + infoBean.getTchild() + "");

                TextSaidFragment.setText("大咖说" + infoBean.getDakaNum() + "");

                infoBeanId = infoBean.getId();

                HuiFuNum.setText(infoBean.getTchild() + "");

                if (infoBean.getTchild() == 0) {
                    HuiFuNum.setText("");
                    YiHuiFu.setText("抢板凳");
                }


                if (infoBean.getDingName().contains(LoginUtils.information.getServerInfo().getNick())) {
                    ZanImage.setImageResource(R.drawable.ccoo_icon_zan_press1);
                    DetailZan.setImageResource(R.drawable.ccoo_icon_zan_press1);
                } else {

                }

            }

            @Override
            public void onError(String errormsg) {

            }
        });

    }


    @Override
    protected void initView() {
        //greendao数据库
        zanDao = GetDbUtils.getdao(this).getZanDao();


        mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HuiFuNum.setText("");
                YiHuiFu.setText("");
            }
        });

        Foucs();

        myGridView.setClicklisenter(this);

        MainRelative.setFocusable(true);
        MainRelative.setFocusableInTouchMode(true);
        MainRelative.requestFocus();
        NaoNaoDetailScroll.smoothScrollTo(0, 20);
        NaoNaoDetailScroll.setFocusable(true);
        EventBus.getDefault().register(this);

        //得到每个图片，进行截取 。遍历出来，传入集合，在gridview里面进行解析
        String[] splite = images.split("\\|");
        for (String s : splite) {
            strList.add(s);

        }
        myGridView.setmList(strList);
        myGridView.setClicklisenter(this);
        init();

    }

    //初始化
    private void init() {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.naonao_item_Fragmelayout, new DetailNewFragment());
        transaction.commit();
        TextNewFragment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TextNewFragment.setTextColor(getResources().getColor(R.color.red));
                } else {
                    TextNewFragment.setTextColor(getResources().getColor(R.color.tv_black));
                }

            }
        });

        TextSaidFragment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TextSaidFragment.setTextColor(getResources().getColor(R.color.red));
                } else {
                    TextSaidFragment.setTextColor(getResources().getColor(R.color.tv_black));
                }
            }
        });
        TextShangFragment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TextShangFragment.setTextColor(getResources().getColor(R.color.red));
                } else {
                    TextShangFragment.setTextColor(getResources().getColor(R.color.tv_black));
                }
            }
        });

        //点击回复


    }

    // TODO: 2017/7/5  eventbus 得值
    //eventbus 得值
    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onMainThreadEvent(final SquareDetailBean detailBean) {

        titleName = detailBean.getTitle();
        Shuatie.setText(titleName);

        String body = detailBean.getBody();
        ItemName.setText(body);


        String image = detailBean.getImage();

        Glide.with(this).load(image).asBitmap().centerCrop().into(new BitmapImageViewTarget(Touxiang) {
            @Override
            protected void setResource(Bitmap resource) {
                super.setResource(resource);
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), resource);

                drawable.setCircular(true);

                Touxiang.setImageDrawable(drawable);
            }
        });

        String address = detailBean.getAddress();
        ItemAddress.setText(address);

        String time = detailBean.getTime();

        ItemTime.setText(time);

        images = detailBean.getImages();

        mID = detailBean.getId();

        userName = detailBean.getUserName();

    }


    @OnClick({R.id.NaoNao_DetailBack, R.id.square_naonao_zanImage, R.id.square_naonao_shareImage, R.id.square_naonao_dashangImage, R.id.NaoNao_Detail_Add, R.id.NaoNao_Detail_butSendMsg
            , R.id.naonao_item_newFragment, R.id.naonao_item_SaidFragment, R.id.naonao_item_ShangFragment, R.id.naonao_detail_setting
            , R.id.naonao_detail_Biaoqing, R.id.naonao_detail_mainCamera, R.id.naonao_detail_MainAite
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.NaoNao_DetailBack:
                onBackPressed();
                break;
            case R.id.square_naonao_zanImage:
                IsLike();
                break;
            case R.id.NaoNao_Detail_Add:

                if (flag == 0) {
                    //第一点击做的操作
                    LinearGone.setVisibility(View.VISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(this, R.anim.showallimg);
                    animation.setDuration(300);
                    NaoNaoDetailAdd.startAnimation(animation);
                    animation.setFillAfter(true);
                    flag = 1;
                } else {
                    //进行第二次点击
                    LinearGone.setVisibility(View.GONE);
                    NaoNaoDetailViewpager.setVisibility(View.GONE);
                    Animation animation = AnimationUtils.loadAnimation(this, R.anim.disallimg);
                    animation.setDuration(300);
                    NaoNaoDetailAdd.startAnimation(animation);
                    animation.setFillAfter(true);
                    flag = 0;

                }


                break;
            case R.id.square_naonao_shareImage:
                UMWeb web = new UMWeb("http://appnew.ccoo.cn/appserverapi.ashx");
                new ShareAction(SquareNaonaoDetailActivity.this).withText("hello")
                        .withMedia(web)
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();


                break;
            case R.id.square_naonao_dashangImage:
                mShowDialog();
                if (dialog.isShowing()) {
                    dialog.show();

                } else {
                    dialog.dismiss();
                }
                break;

            case R.id.NaoNao_Detail_butSendMsg:
                String msg = mEdit.getText().toString().trim();
                if (msg.isEmpty()) {
                    Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
                } else {
                    ReplyEdit();
                    mEdit.setText("");
                }
                break;

            case R.id.naonao_item_newFragment:
                //最新
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.naonao_item_Fragmelayout, new DetailNewFragment());
                transaction.commit();

                break;
            case R.id.naonao_item_SaidFragment:
                //大咖说
                FragmentTransaction transaction1 = manager.beginTransaction();
                transaction1.replace(R.id.naonao_item_Fragmelayout, new DetailHigherSend());
                transaction1.commit();


                break;
            case R.id.naonao_item_ShangFragment:
                //打赏

                FragmentTransaction transaction2 = manager.beginTransaction();
                transaction2.replace(R.id.naonao_item_Fragmelayout, new Detail_Exceptional());

                transaction2.commit();
                break;
            case R.id.naonao_detail_setting:
                mPopuup(view);

                break;

            case R.id.naonao_detail_mainCamera:
                Intent intent = new Intent(SquareNaonaoDetailActivity.this, Carmer_Photo_NaoNao_Activity.class);
                startActivity(intent);

                break;
            case R.id.naonao_detail_Biaoqing:
                if (flag == 0) {
                    NaoNaoDetailViewpager.setVisibility(View.VISIBLE);
                    setBottmView();
                    flag = 1;
                } else {
                    NaoNaoDetailViewpager.setVisibility(View.GONE);
                    flag = 0;
                }
                break;
            case R.id.naonao_detail_MainAite:
                Intent intent1 = new Intent(this, Carmer_FaBu_AiTe_NaoNao_Activity.class);
                startActivity(intent1);
                break;


        }


    }

    // TODO: 2017/7/7 分享
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);

            Toast.makeText(SquareNaonaoDetailActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(SquareNaonaoDetailActivity.this, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if (t != null) {
                Log.d("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(SquareNaonaoDetailActivity.this, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }


    private void Foucs() {

        if (GuanzhuBtn.getText().equals("点击关注")) {
            GuanzhuBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (flag == 0) {
                        GuanzhuBtn.setText("已关注");
                        Toast.makeText(SquareNaonaoDetailActivity.this, "关注成功", Toast.LENGTH_SHORT).show();
                        flag = 1;
                    } else {
                        if (GuanzhuBtn.getText().equals("已关注")) {
                            GuanzhuBtn.setText("点击关注");
                            Toast.makeText(SquareNaonaoDetailActivity.this, "取消关注成功", Toast.LENGTH_SHORT).show();
                            flag = 0;
                        }
                    }

                }
            });
        }

    }

    // TODO: 2017/7/4 popupwindow 
    //点击弹出popupwindow
    private void mPopuup(View view) {
        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_naonaodetail_popup, null);

        jubao = (RelativeLayout) v.findViewById(R.id.Popup_JuBao);

        shouImage = (ImageView) v.findViewById(R.id.NaoNao_popupwindow_ImageShouCang);

        shouRelative = (RelativeLayout) v.findViewById(R.id.Popup_ShouCang);

        textShare = (TextView) v.findViewById(R.id.NaoNao_Popupwindow_Share);
        textShare.setOnClickListener(this);

        shouRelative.setOnClickListener(this);
        jubao.setOnClickListener(this);
        pop = new PopupWindow(v, LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        pop.setBackgroundDrawable(new ColorDrawable());
        pop.setTouchable(true);
        pop.showAsDropDown(view);

    }


    //销毁eventbus
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    // TODO: 2017/7/5 每张图片的点击事件
    @Override
    public void onItemClick(View v, int position) {
        Intent intent = new Intent(getApplicationContext(), DetailImageActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("image", (Serializable) strList);
        startActivity(intent);

    }

    // TODO: 2017/7/4 回复帖子

    private void ReplyEdit() {
        String content = mEdit.getText().toString().trim();
        if (content.isEmpty()) {
            Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
        }
        Map<String, String> map = new HashMap<>();
        String a = "{\"customerID\":8001,\"requestTime\":\"2017-07-03 09:06:39\",\"Method\":\"PHSocket_SetTieBaReplyAdd\",\"customerKey\":\"4CE526F5DFA439705892DA52CCC50F95\",\"appName\":\"CcooCity\",\"version\":\"4.5\",\"Param\":{\"siteID\":2422,\"tid\":";

        String tid = String.valueOf(infoBeanId) + ",\"pid\":0,\"luserID\":\"";

        String luserID = userName;
        String b = "\",\"louID\":0,\"image\":\"\",\"content\":\"";
        String editContent = content;
        String c = "\",\"uID\":\"";
        String mID = SpUtils.getSp().getString(LoginUtils.USERID, "");
        String d = "\",\"userName\":\"sid105524270160091\",\"nick\":\"超哥在昌平\",\"userFace\":\"http:\\/\\/p9.pccoo.cn\\/app_avatar\\/20170619\\/2017061910545246831007_780_780.jpg\",\"source\":2,\"mapName\":\"北京吉利大学\",\"mapPoint\":\"40.183401,116.172281\",\"atname\":\"\",\"usiteID\":2422,\"audio\":\"\",\"audioTime\":0},\"Statis\":{\"SiteId\":2422,\"UserId\":30938715,\"PhoneNo\":\"OPPO R9m\",\"SystemNo\":2,\"System_VersionNo\":\"Android 5.1\",\"PhoneId\":\"862609032748977\",\"PhoneNum\":\"+8618833628372\"}}";

        String str = a + tid + luserID + b + editContent + c + mID + d;

        map.put("param", str);

        HttpFacory.create().POST(UrlUtils.BaseUrl, map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("SquareNaonaoDetailActiv", result);
                DetailHuiFuBean huiFuBean = JSON.parseObject(result, DetailHuiFuBean.class);
                if (huiFuBean == null) {
                    return;
                }

                List<DetailHuiFuBean.ServerInfoBean.ReplyListBean> replyList = huiFuBean.getServerInfo().getReplyList();


                HuiFuEnentBean bean = new HuiFuEnentBean(replyList);


                EventBus.getDefault().postSticky(bean);


            }

            @Override
            public void onError(String errormsg) {

            }
        });


    }

    // TODO: 2017/7/5 点赞的解析
    //点赞
    private void IsLike() {
        if (isZan) {
            Toast.makeText(this, "你已经点赞过了，不可再重复点赞", Toast.LENGTH_SHORT).show();
        }
        isZan = true;

        Map map = new HashMap();
        String str = "{\"customerID\":8001,\"requestTime\":\"2017-07-03 16:40:09\",\"Method\":\"PHSocket_SetTieBaLike\",\"customerKey\":\"8C6D2D16C3B9E3F46EEA81CB042068D4\",\"appName\":\"CcooCity\",\"version\":\"4.5\",\"Param\":{\"siteID\":2422,\"tid\":";

        String tId = String.valueOf(infoBeanId) + ",\"uID\":\"";

        String uID = SpUtils.getSp().getString(LoginUtils.USERID, "");
        String a = "\",\"userName\":\"sid105524270160091\",\"nick\":\"超哥在昌平\",\"userFace\":\"http:\\/\\/p9.pccoo.cn\\/app_avatar\\/20170619\\/2017061910545246831007_780_780.jpg\",\"toUserID\":\"";

        String toUserId = userName;

        String b = "\",\"usiteID\":2422},\"Statis\":{\"SiteId\":2422,\"UserId\":30938715,\"PhoneNo\":\"OPPO R9m\",\"SystemNo\":2,\"System_VersionNo\":\"Android 5.1\",\"PhoneId\":\"862609032748977\",\"PhoneNum\":\"+8618833628372\"}}";

        String mmp = str + tId + uID + a + toUserId + b;

        map.put("param", mmp);

        HttpFacory.create().POST(UrlUtils.BaseUrl, map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("SquareNaonaoDetailActiv", "是否点赞" + result);
                isLikeBean = JSON.parseObject(result, IsLikeBean.class);
                if (isLikeBean.getMessageList().getCode() == 1000) {
                    ZanImage.setImageResource(R.drawable.ccoo_icon_zan_press1);
                    Toast.makeText(SquareNaonaoDetailActivity.this, isLikeBean.getMessageList().getMessage(), Toast.LENGTH_SHORT).show();
                    Textzan.setText(infoBean.getDingName() + "等" + infoBean.getDing() + "人赞过" + "");
                } else {
                    Toast.makeText(SquareNaonaoDetailActivity.this, isLikeBean.getMessageList().getMessage(), Toast.LENGTH_SHORT).show();
                    ZanImage.setImageResource(R.drawable.ccoo_icon_zan_press1);

                }


            }

            @Override
            public void onError(String errormsg) {

            }
        });



    }

    // TODO: 2017/7/5 弹出dialog
    private void mShowDialog() {


        View v = LayoutInflater.from(this).inflate(R.layout.dialog_dashang, null);

        TextView mTVname = (TextView) v.findViewById(R.id.name_tv);

        text_daShang = (TextView) v.findViewById(R.id.dashang_Text);
        text_daShang.setOnClickListener(this);
        final ImageView image = (ImageView) v.findViewById(R.id.head_iv);

        String nick = infoBean.getNick();

        mTVname.setText(nick);

        String userFace = infoBean.getUserFace();

        Glide.with(this).load(userFace).asBitmap().centerCrop().into(new BitmapImageViewTarget(image) {
            @Override
            protected void setResource(Bitmap resource) {
                super.setResource(resource);
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), resource);

                drawable.setCircular(true);

                image.setImageDrawable(drawable);
            }
        });
        dialog = new AlertDialog.Builder(this)
                .setView(v)
                .create();
        dialog.show();

    }


    //定义的点击事件
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.Popup_JuBao:
                //点击举报弹出的dialog，
                View view = LayoutInflater.from(this).inflate(R.layout.tieba_jubao_layout, null);
                juBaoFindviewId(view);

                juBaodialog = new AlertDialog.Builder(this)
                        .setView(view).create();
                juBaodialog.show();
                pop.dismiss();
                break;

            case R.id.JuBao_but1:

                break;
            case R.id.JuBao_but2:

                break;
            case R.id.JuBao_but3:

                break;
            case R.id.JuBao_but4:

                break;
            case R.id.JuBao_but5:

                break;
            case R.id.JuBao_but6:

                break;
            case R.id.cancle_textview:
                juBaodialog.dismiss();

                break;

            case R.id.submit_textview:
                Toast.makeText(this, "举报成功", Toast.LENGTH_SHORT).show();
                juBaodialog.dismiss();
                break;
            case R.id.dashang_Text:
                //点击弹出框，进行打赏，判断跳转到赚钱页面去，并把上个弹出框关闭掉
                View Dv = LayoutInflater.from(this).inflate(R.layout.activity_dialog_zhuangmoney, null);

                TextView Money_textCance = (TextView) Dv.findViewById(R.id.money_cancle_textview);
                Money_textCance.setOnClickListener(this);
                TextView Money_submit = (TextView) Dv.findViewById(R.id.money_submit_textview);
                Money_submit.setOnClickListener(this);
                moneydialog = new AlertDialog.Builder(this).setView(Dv)
                        .create();
                moneydialog.show();

                dialog.dismiss();
                break;
            case R.id.money_cancle_textview:
                moneydialog.dismiss();
                break;

            case R.id.money_submit_textview:
                //跳转到去赚钱页面
                Intent intent = new Intent(this, TaskActivity.class);
                startActivity(intent);

                break;

            case R.id.Popup_ShouCang:
                if (flag == 0) {
                    shouImage.setImageResource(R.drawable.ccoo_icon_collect_press);
                    Toast.makeText(this, "收藏成功", Toast.LENGTH_SHORT).show();

                    flag = 1;
                } else {
                    shouImage.setImageResource(R.drawable.ccoo_icon_collect_noral);
                    Toast.makeText(this, "取消收藏", Toast.LENGTH_SHORT).show();
                    flag = 0;
                }

                break;
            case R.id.NaoNao_Popupwindow_Share:
                UMWeb web = new UMWeb("http://appnew.ccoo.cn/appserverapi.ashx");
                new ShareAction(SquareNaonaoDetailActivity.this).withText("hello")
                        .withMedia(web)
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();

                break;

        }

    }


    private void juBaoFindviewId(View view) {
        TextView cancle_textview = (TextView) view.findViewById(R.id.cancle_textview);
        cancle_textview.setOnClickListener(this);

        TextView commit_tv = (TextView) view.findViewById(R.id.submit_textview);

        commit_tv.setOnClickListener(this);
    }


    // TODO: 2017/7/6 添加表情

    private void setBottmView() {
        handler.post(runnable);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            viewList = new ArrayList<>();
            emojiList = EmojiUtils.getEmojiList();
            for (int i = 0; i < getPagerCount(emojiList.size()); i++) {
                GridView gridView = getPagerItem(i);
                viewList.add(gridView);
            }
            handler.sendEmptyMessage(0);
        }
    };
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    NaoNaoDetailViewpager.setVisibility(View.VISIBLE);
                    myPagerAdapter = new MyPagerAdapter(viewList);
                    NaoNaoDetailViewpager.setAdapter(myPagerAdapter);
                    break;
            }
        }
    };

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

        MyEmojiAdapter adapter = new MyEmojiAdapter(this, subEmojiList, R.layout.fragment_comment_grid_item1, mEdit);

        gridView.setAdapter(adapter);

        return gridView;
    }


}
