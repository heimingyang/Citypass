package com.example.citypass.cotroller.activity.find;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PublishActivity extends BaseActivity {


    @BindView(R.id.Publish_back)
    ImageView PublishBack;
    @BindView(R.id.Publish_relativelayout)
    RelativeLayout PublishRelativelayout;
    @BindView(R.id.Publish_img)
    ImageView PublishImg;
    @BindView(R.id.publish_checket)
    ImageView publishChecket;
    @BindView(R.id.publish_scrollview)
    HorizontalScrollView publishScrollview;
    @BindView(R.id.Publish_relativelayout1)
    RelativeLayout PublishRelativelayout1;
    @BindView(R.id.publishi_content)
    EditText publishiContent;
    @BindView(R.id.publish_content_checket)
    TextView publishContentChecket;
    @BindView(R.id.publish_ok)
    Button publishOk;
    //上个页面传过来的值
    private String name;
    private String birthday;
    private String job;
    private String qinggan;
    private String from;
    private String wx;
    private String qq;
    private String info;
    private String stringExtra;
    //dialog的组件
    private TextView tv_paizhao;
    private TextView tv_xiangce;
    private TextView tv_quxiao;
    private Dialog dialog;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_publish;


    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        birthday = intent.getStringExtra("birthday");
        job = intent.getStringExtra("job");
        qinggan = intent.getStringExtra("qinggan");
        from = intent.getStringExtra("from");
        wx = intent.getStringExtra("wx");
        qq = intent.getStringExtra("qq");
        info = intent.getStringExtra("info");
        stringExtra = intent.getStringExtra("");

    }

    @Override
    protected void initView() {

    }


    @OnClick({R.id.Publish_back, R.id.publish_checket, R.id.publish_content_checket, R.id.publish_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Publish_back:
                finish();

                break;
            //选择图片
            case R.id.publish_checket:
                showPublishDialog();


                break;
            //选择展示区域
            case R.id.publish_content_checket:


                break;
            //提交
            case R.id.publish_ok:


                break;
        }
    }

    private void showPublishDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.publish_dialog, null);
        dialog = new AlertDialog.Builder(this).setView(view).create();


        dialog.show();

        tv_paizhao = (TextView) view.findViewById(R.id.publish_dlog_paizhao);
        tv_xiangce = (TextView) view.findViewById(R.id.publish_dlog_xiangce);
        tv_quxiao = (TextView) view.findViewById(R.id.publish_dlog_quxiao);
        //拍照
        tv_paizhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        //相册
        tv_xiangce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        tv_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });


    }
}
