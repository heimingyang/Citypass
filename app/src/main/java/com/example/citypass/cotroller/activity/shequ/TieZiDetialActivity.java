package com.example.citypass.cotroller.activity.shequ;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/7/1 16:31
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class TieZiDetialActivity extends BaseActivity {


    @BindView(R.id.carmer_fabu_naonao_title_cancel)
    ImageView carmerFabuNaonaoTitleCancel;
    @BindView(R.id.cooperation_Relative)
    RelativeLayout cooperationRelative;
    @BindView(R.id.tz_webview)
    WebView tzWebview;
    @BindView(R.id.naonao_detail_setting)
    ImageView naonaoDetailSetting;
    @BindView(R.id.NaoNao_Detail_Zan)
    ImageView NaoNaoDetailZan;
    @BindView(R.id.NaoNao_Detail_Add)
    ImageView NaoNaoDetailAdd;
    @BindView(R.id.NaoNao_Detail_butSendMsg)
    Button NaoNaoDetailButSendMsg;
    @BindView(R.id.NaoNao_DetailEdit)
    EditText NaoNaoDetailEdit;
    @BindView(R.id.linearLayout)
    RelativeLayout linearLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.shequ_tiezi_detial;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        tzWebview.loadUrl("http://m.yanqing.ccoo.cn/bbs/shareinfo.aspx?id=" + id);
        tzWebview.setWebViewClient(new WebViewClient());
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.carmer_fabu_naonao_title_cancel,R.id.naonao_detail_setting, R.id.NaoNao_Detail_Zan, R.id.NaoNao_Detail_Add, R.id.NaoNao_Detail_butSendMsg, R.id.NaoNao_DetailEdit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.carmer_fabu_naonao_title_cancel:
                onBackPressed();
                break;
            case R.id.naonao_detail_setting:
                mPopuup(view);
                break;
            case R.id.NaoNao_Detail_Zan:
                NaoNaoDetailZan.setBackgroundResource(R.drawable.ccoo_icon_zan_press1);
                NaoNaoDetailZan.setBackgroundResource(R.drawable.ccoo_icon_zan_press1);
                break;
            case R.id.NaoNao_Detail_Add:
                break;
            case R.id.NaoNao_Detail_butSendMsg:
                String msg = NaoNaoDetailEdit.getText().toString().trim();
                if (msg.isEmpty()) {
                    Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
                } else {

                }
                break;
            case R.id.NaoNao_DetailEdit:
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
}
