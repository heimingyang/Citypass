package com.example.citypass.cotroller.fragment.naonao.detail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
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
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.naonao.detail.DetailMainBean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.UrlUtils;

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

public class SquareNaonaoDetailActivity extends BaseActivity implements MyGridLayout.onClicklisenter {
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
    ImageView NaoNaoDetailZan;
    @BindView(R.id.NaoNao_Detail_Add)
    ImageView NaoNaoDetailAdd;
    @BindView(R.id.NaoNao_Detail_butSendMsg)
    Button NaoNaoDetailButSendMsg;
    @BindView(R.id.linearLayout)
    RelativeLayout linearLayout;
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
    private List<String> strList = new ArrayList<>();
    private String images;
    private FragmentManager manager;
    private int mID;

    @Override
    protected int getLayoutId() {
        return R.layout.square_naonao_detail_item;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"id\":";
        int id = mID;
        Log.d("SquareNaonaoDetailActiv", "id:" + id);
        String value = ",\"userID\":30108866,\"siteID\":2422},\"requestTime\":\"2017-06-29 20:50:43\",\"customerKey\":\"96A942D2967795D409280E4DAFCDC4EE\",\"Method\":\"PHSocket_GetTiebaByID\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":30108866,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        map.put("param", str + id + value);

        HttpFacory.create().POST(UrlUtils.BaseUrl, map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("SquareNaonaoDetailActiv", result);
                DetailMainBean bean = JSON.parseObject(result, DetailMainBean.class);
                if (bean == null && result == null) {
                    return;
                }
                if (bean.getMessageList().getCode() != 1000) {
                    return;

                }
                DetailMainBean.ServerInfoBean infoBean = bean.getServerInfo();
                if (infoBean == null) {
                    return;
                }
                int hit = infoBean.getHit();
                TitleText.setText(hit + "");
                Textzan.setText(infoBean.getDingName() + "等" + infoBean.getDing() + "赞过" + "");
                ZanText.setText(infoBean.getDing() + "赞" + "");
                TextNewFragment.setText("最新 " + infoBean.getTchild() + "");

            }

            @Override
            public void onError(String errormsg) {

            }
        });

    }

    @Override
    protected void initView() {
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

    }


    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onMainThreadEvent(final SquareDetailBean detailBean) {

        String titleName = detailBean.getTitle();
        String body = detailBean.getBody();
        ItemName.setText(body);

        Shuatie.setText(titleName);

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

    }


    @OnClick({R.id.NaoNao_DetailBack, R.id.square_naonao_zanImage, R.id.square_naonao_shareImage, R.id.square_naonao_dashangImage, R.id.NaoNao_Detail_Add, R.id.NaoNao_Detail_butSendMsg
            , R.id.naonao_item_newFragment, R.id.naonao_item_SaidFragment, R.id.naonao_item_ShangFragment, R.id.naonao_detail_setting
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.NaoNao_DetailBack:
                onBackPressed();
                break;
            case R.id.square_naonao_zanImage:
                ZanImage.setBackgroundResource(R.drawable.ccoo_icon_zan_press1);
                NaoNaoDetailZan.setBackgroundResource(R.drawable.ccoo_icon_zan_press1);


                break;
            case R.id.square_naonao_shareImage:

                break;
            case R.id.square_naonao_dashangImage:

                break;
            case R.id.NaoNao_Detail_Add:

                break;
            case R.id.NaoNao_Detail_butSendMsg:
                String msg = mEdit.getText().toString().trim();
                if (msg.isEmpty()) {
                    Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
                } else {

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

        }


    }

    private void mPopuup(View view) {
        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_naonaodetail_popup, null);
        PopupWindow pop = new PopupWindow(v, LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        pop.setBackgroundDrawable(new ColorDrawable());
        pop.setTouchable(true);

        pop.showAsDropDown(view);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onItemClick(View v, int position) {
        Intent intent = new Intent(getApplicationContext(), DetailImageActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("image", (Serializable) strList);
        startActivity(intent);

    }


}
