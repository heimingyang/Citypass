package com.example.citypass.cotroller.fragment.information;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.information.Detail;
import com.example.citypass.model.bean.information.ShopDetail;
import com.example.citypass.model.biz.infor.IMedalModel;
import com.example.citypass.model.biz.infor.MedaModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.TimeUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/4 11:47
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ShopDetailActivity extends BaseActivity {
    @BindView(R.id.shopping_detail_back)
    ImageView shoppingDetailBack;
    @BindView(R.id.shopping_detail_share)
    ImageView shoppingDetailShare;
    @BindView(R.id.shopping_detail_Relative)
    RelativeLayout shoppingDetailRelative;
    @BindView(R.id.shopping_detail_Linear_TextOne)
    RelativeLayout shoppingDetailLinearTextOne;
    @BindView(R.id.shopping_detail_Linear_TextTwo)
    RelativeLayout shoppingDetailLinearTextTwo;
    @BindView(R.id.shopping_detail_Linear)
    LinearLayout shoppingDetailLinear;
    @BindView(R.id.shopping_detail_Image)
    ImageView shoppingDetailImage;
    @BindView(R.id.shopping_detail_Name)
    TextView shoppingDetailName;
    @BindView(R.id.shopping_detail_Stock)
    TextView shoppingDetailStock;
    @BindView(R.id.shopping_detail_Converted)
    TextView shoppingDetailConverted;
    @BindView(R.id.shopping_detail_RelativeOne)
    RelativeLayout shoppingDetailRelativeOne;
    @BindView(R.id.shopping_detail_Price)
    TextView shoppingDetailPrice;
    @BindView(R.id.shopping_detail_RelativeTwo)
    RelativeLayout shoppingDetailRelativeTwo;
    @BindView(R.id.shopping_detail_Time)
    TextView shoppingDetailTime;
    @BindView(R.id.shopping_detail_LastTime)
    TextView shoppingDetailLastTime;
    @BindView(R.id.shopping_detail_RelativeThree)
    RelativeLayout shoppingDetailRelativeThree;
    @BindView(R.id.shopping_detail_Exchange)
    TextView shoppingDetailExchange;
    @BindView(R.id.shopping_detail_RelativeFour)
    RelativeLayout shoppingDetailRelativeFour;
    @BindView(R.id.shopping_detail_RelativeFive)
    RelativeLayout shoppingDetailRelativeFive;
    @BindView(R.id.shopping_detail_exchange_Btn)
    Button shoppingDetailExchangeBtn;
    @BindView(R.id.shopping_detail_TextOne)
    TextView shoppingDetailTextOne;
    @BindView(R.id.shopping_detail_TextTwo)
    TextView shoppingDetailTextTwo;
    @BindView(R.id.shopping_detail_TextThree)
    TextView shoppingDetailTextThree;
    @BindView(R.id.shopping_detail_TextFour)
    TextView shoppingDetailTextFour;
    @BindView(R.id.shopping_detail_RelativeSix)
    RelativeLayout shoppingDetailRelativeSix;
    @BindView(R.id.shopping_detail_Guize)
    TextView shoppingDetailGuize;
    @BindView(R.id.shopping_detail_Money)
    TextView shoppingDetailCoinOne;
    private MedaModel model;
    private long eTime;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shopping_detail;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        model = new IMedalModel();
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        int Id = intent.getIntExtra("id", 0);
        ShopDetail detail = new ShopDetail();
        detail.setId(Id);
        detail.setSiteID(LoginUtils.information.getServerInfo().getSiteID());
        String param = LoginUtils.getParam(detail, "PHSocket_APP_CommodityDetail");
        model.getMedal(param, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Detail detail1 = JSON.parseObject(result, Detail.class);
                int code = detail1.getMessageList().getCode();
                if (code == 1000) {
                    Glide.with(ShopDetailActivity.this).load(detail1.getServerInfo().getCommodityInfo().getContent().get(0).getShowImages()).into(shoppingDetailImage);
                    shoppingDetailName.setText(detail1.getServerInfo().getCommodityInfo().getContent().get(0).getTitle());
                    shoppingDetailCoinOne.setText(detail1.getServerInfo().getCommodityInfo().getContent().get(0).getSCoin()+"币");
                    shoppingDetailStock.setText("商品库存：" + detail1.getServerInfo().getCommodityInfo().getContent().get(0).getRealSum());
                    shoppingDetailConverted.setText("已兑换" + detail1.getServerInfo().getCommodityInfo().getContent().get(0).getBuySum() + "个");
                    eTime = detail1.getServerInfo().getCommodityInfo().getContent().get(0).getETime();
                    handler.postDelayed(run, 1000);
                    shoppingDetailExchange.setText(detail1.getServerInfo().getCommodityInfo().getContent().get(0).getLevel());
                    shoppingDetailGuize.setText(detail1.getServerInfo().getCommodityInfo().getContent().get(0).getLimit());
                    shoppingDetailTextThree.setText(detail1.getServerInfo().getInstruction().getDescription());
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    private Runnable run = new Runnable() {
        @Override
        public void run() {
            handler.sendEmptyMessage(0);
            handler.postDelayed(run, 1000);
        }
    };

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    eTime -= 1000;
                    String time = TimeUtils.getStringTime(eTime, "dd天hh小时mm分ss秒");
                    shoppingDetailLastTime.setText(time);
                    break;
            }
        }
    };


    @OnClick({R.id.shopping_detail_back, R.id.shopping_detail_share, R.id.shopping_detail_exchange_Btn, R.id.shopping_detail_Linear_TextOne, R.id.shopping_detail_Linear_TextTwo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shopping_detail_back:
                onBackPressed();
                break;
            case R.id.shopping_detail_share:
                new ShareAction(ShopDetailActivity.this).withText("")
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
                break;
            case R.id.shopping_detail_exchange_Btn:
                break;
            case R.id.shopping_detail_Linear_TextOne:
                break;
            case R.id.shopping_detail_Linear_TextTwo:
                break;
        }
    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);

            Toast.makeText(ShopDetailActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ShopDetailActivity.this, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if (t != null) {
                Log.d("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ShopDetailActivity.this, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

}
