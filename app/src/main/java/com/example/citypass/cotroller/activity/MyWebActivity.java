package com.example.citypass.cotroller.activity;

import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;

public class MyWebActivity extends BaseActivity {


    @BindView(R.id.my_webview)
    WebView myWebview;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_web;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String urll = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");



        myWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;// 返回false
            }
        });
        if (urll.contains("http")) {
            myWebview.loadUrl(urll);

        } else {
            myWebview.loadUrl("http://m.yanqing.ccoo.cn" + urll);
        }

    }

    @Override
    protected void initView() {

    }


}
