package com.example.citypass.cotroller.activity.shequ;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.fragment.information.IssuePostActivity;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.KeyEvent.KEYCODE_BACK;

/**
 * Created by 李艳东 on 2017/7/1  11:20
 */

public class CardDetailActivity extends BaseActivity {
    @BindView(R.id.WebView)
    android.webkit.WebView WebView;
    @BindView(R.id.bbs_inv_details_back)
    ImageView bbsInvDetailsBack;
    @BindView(R.id.bbs_inv_details_more)
    ImageView bbsInvDetailsMore;
    @BindView(R.id.bbs_inv_details_tzfb)
    ImageView bbsInvDetailsTzfb;
    @BindView(R.id.bbs_inv_details_too)
    RelativeLayout bbsInvDetailsToo;
    @BindView(R.id.seek_plan)
    ProgressBar seekPlan;
    @BindView(R.id.titless)
    RelativeLayout titless;
    @BindView(R.id.framlay)
    FrameLayout framlay;
    private Intent intent;
    private String ser_url;
    private PopupWindow popupWindow;
    private String[] st;
    private int re = 0;
    private boolean[] b = {true, false, false, false};

    @Override
    public void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_carddetail;
    }

    @Override
    public void initData() {
        /*st = this.getResources().getStringArray(R.array.report);*/
        intent = getIntent();
        ser_url = intent.getStringExtra("ser_url");
        WebView.loadUrl(ser_url);
        WebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {

                return true;
            }

            @Override
            public void onLoadResource(android.webkit.WebView view, String url) {

            }

            @Override
            public void onPageFinished(android.webkit.WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        WebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(android.webkit.WebView view, int newProgress) {

                if (newProgress == 100) {
                    seekPlan.setVisibility(View.INVISIBLE);
                } else {
                    if (View.INVISIBLE == seekPlan.getVisibility()) {
                        seekPlan.setVisibility(View.VISIBLE);
                    }
                    seekPlan.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        WebView.canGoBack();
        WebView.goBack();
        WebView.canGoForward();
        //前进网页
        WebView.goForward();
        //声明WebSettings子类
        WebSettings webSettings = WebView.getSettings();

        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);

        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
    }


    @Override
    public void initListener() {

    }



    //Back键控制网页后退
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && WebView.canGoBack()) {
            WebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick({R.id.bbs_inv_details_back, R.id.bbs_inv_details_more, R.id.bbs_inv_details_tzfb})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bbs_inv_details_back:
                onBackPressed();
                break;
            case R.id.bbs_inv_details_more:
                //popWindown
                //onShow(view);
                break;
            case R.id.bbs_inv_details_tzfb:
                //帖子发布
                Intent intent = new Intent(CardDetailActivity.this, IssuePostActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void onShow(View view) {
       /* View inflate = View.inflate(CardDetailActivity.this, R.layout.community_pop, null);
        LinearLayout share = (LinearLayout) inflate.findViewById(R.id.com_share);
        LinearLayout collect = (LinearLayout) inflate.findViewById(R.id.com_collect);
        LinearLayout louzhu = (LinearLayout) inflate.findViewById(R.id.com_louzhu);
        LinearLayout lookcard = (LinearLayout) inflate.findViewById(R.id.com_lookcard);
        LinearLayout report = (LinearLayout) inflate.findViewById(R.id.com_report);
        popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.showAsDropDown(view, 200, 0);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                Toast.makeText(CardDetailActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
            }
        });
        louzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        lookcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView.reload();
            }
        });*/
        /*report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showRaido();
            }
        });*/
    }

    private void showRaido() {
        new AlertDialog.Builder(CardDetailActivity.this).setTitle("举报原因").setSingleChoiceItems(st, 0,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        // TODO Auto-generated method stub
                        re = which;
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(CardDetailActivity.this, "举报成功", Toast.LENGTH_SHORT).show();
            }
        }).create().show();
    }
}
