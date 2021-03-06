package com.example.citypass.cotroller.fragment.life;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.HomeActivity;
import com.example.citypass.utils.DialogUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/22 16:20
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class WebViewActivity extends BaseActivity {
    @BindView(R.id.Life_WebView)
    WebView LifeWebView;
    @BindView(R.id.Life_Webview_Back)
    ImageView LifeWebviewBack;
    @BindView(R.id.Life_WebView_Guanbi)
    TextView LifeWebViewGuanbi;
    @BindView(R.id.Life_WebView_Shared)
    ImageView LifeWebViewShared;
    @BindView(R.id.Life_Framlayout)
    FrameLayout LifeFramlayout;
    @BindView(R.id.Life_WebView_Title)
    TextView LifeWebViewTitle;
    @BindView(R.id.Life_WebView_Progress)
    ProgressBar mProgress;
    @BindView(R.id.WebView_Relative)
    RelativeLayout WebViewRelative;
    private RelativeLayout relativeOne;
    private RelativeLayout relativeTwo;
    private RelativeLayout relativeThree;
    private PopupWindow mPop;
    private String url;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_life_webview;
    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {


        mProgress();


    }

    private void mProgress() {

        mProgress.setProgress(20);
        //点击弹出popupwindow
        LifeWebViewShared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow(v);

            }
        });

        //显示进度条

        LifeWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mProgress.setVisibility(View.INVISIBLE);
                } else {
                    if (View.INVISIBLE == mProgress.getVisibility()) {
                        mProgress.setVisibility(View.VISIBLE);//显示加载网页
                    }
                    mProgress.setMax(newProgress);//设置最大值

                }
                super.onProgressChanged(view, newProgress);
            }
        });

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        LifeWebView.loadUrl(url);

        String title = intent.getStringExtra("webview_title");

        LifeWebViewTitle.setText(title);

        //在内部加载网页
        LifeWebView.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                LifeWebView.loadUrl(request.getUrl().toString());

                return true;
            }
        });

//        String htmlString = "<h1>Title</h1><p>This is HTML text<br /><i>Formatted in italics</i><br />Anothor Line</p>";
//// 载入这个html页面
//        LifeWebView.loadData(htmlString, "text/html", "utf-8");
        WebSettings settings = LifeWebView.getSettings();
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setJavaScriptEnabled(true);

    }


    //监听webview返回键
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == keyEvent.KEYCODE_BACK) {
            if (LifeWebView.canGoBack()) {
                LifeWebView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, keyEvent);
    }


    @OnClick({R.id.Life_Webview_Back, R.id.Life_WebView_Guanbi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Life_Webview_Back:
                onBackPressed();
                break;
            case R.id.Life_WebView_Guanbi:
                onBackPressed();
                break;

        }
    }

    private Handler handler = new Handler();

    private void mPopupWindow(View v) {
        View view1 = LayoutInflater.from(WebViewActivity.this).inflate(R.layout.activity_lifewebview_popup, null);
        relativeOne = (RelativeLayout) view1.findViewById(R.id.Popup_ShouYe);

        //跳转到首页
        relativeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebViewActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });


        relativeTwo = (RelativeLayout) view1.findViewById(R.id.Popup_ShuaXin);
        relativeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.dialog();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        LifeWebView.loadUrl(url);
                        DialogUtils.dismiss();
                        Toast.makeText(WebViewActivity.this, "刷新成功", Toast.LENGTH_SHORT).show();
                    }
                }, 1500);
            }
        });
        relativeThree = (RelativeLayout) view1.findViewById(R.id.Popup_Share);

        relativeThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMWeb web = new UMWeb("http://appnew.ccoo.cn/appserverapi.ashx");
                web.setTitle("伪摄影师的杰作");//标题
                web.setDescription("新版本上线，一起来露露脸吧，用小视频打个招呼~");//描述
                new ShareAction(WebViewActivity.this).withText("hello")
                        .withMedia(web)
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
            }
        });

        mPop = new PopupWindow(view1, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);

        mPop.setBackgroundDrawable(new ColorDrawable());
        mPop.setTouchable(true);//设置popupwindow可触摸
        if (mPop.isShowing()) {
            mPop.dismiss();
        } else {
            mPop.showAsDropDown(v);

//            mPop.showAtLocation(v, Gravity.BOTTOM,0,0);
        }


    }
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat","platform"+platform);

            Toast.makeText(WebViewActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(WebViewActivity.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if(t!=null){
                Log.d("throw","throw:"+t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(WebViewActivity.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }



}
