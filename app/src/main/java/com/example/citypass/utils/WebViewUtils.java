package com.example.citypass.utils;

import android.content.Context;
import android.content.Intent;

import com.example.citypass.App;
import com.example.citypass.cotroller.fragment.webview.WebViewActivity;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/23 9:56
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class WebViewUtils {


    //跳转到WebView页面

    public static void UtilIntent(Context context,  String url,String title) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("webview_title",title);
        App.activity.startActivity(intent);

    }

}
