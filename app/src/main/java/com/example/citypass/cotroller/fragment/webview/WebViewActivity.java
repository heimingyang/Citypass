package com.example.citypass.cotroller.fragment.webview;

import android.content.Intent;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;

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
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        LifeWebView.loadUrl(url);
        LifeWebView.setWebViewClient(new WebViewClient());
        WebSettings settings = LifeWebView.getSettings();
        settings.setJavaScriptEnabled(true);
    }

    //监听webview返回键
    public boolean onKeyDown(int keyCode ,KeyEvent keyEvent){
        if(keyCode==keyEvent.KEYCODE_BACK){
            if(LifeWebView.canGoBack()){
                LifeWebView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, keyEvent);
    }


}
