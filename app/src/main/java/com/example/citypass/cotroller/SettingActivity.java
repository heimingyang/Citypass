package com.example.citypass.cotroller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citypass.R;
import com.example.citypass.Utils.LoginUtils;
import com.example.citypass.Utils.SpUtils;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述: 设置页面
 * 创建人: 马杰
 * 创建时间: 2017/6/21 14:33
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class SettingActivity extends BaseActivity {
    @BindView(R.id.setting_back)
    ImageView settingBack;
    @BindView(R.id.setting_Relative)
    RelativeLayout settingRelative;
    @BindView(R.id.setting_right)
    ImageView settingRight;
    @BindView(R.id.setting_img)
    ImageView settingImg;
    @BindView(R.id.setting_name)
    RelativeLayout settingName;
    @BindView(R.id.setting_clear)
    TextView settingClear;
    @BindView(R.id.setting_message)
    TextView settingMessage;
    @BindView(R.id.setting_blacklist)
    TextView settingBlacklist;
    @BindView(R.id.setting_pwd)
    TextView settingPwd;
    @BindView(R.id.setting_version)
    TextView settingVersion;
    @BindView(R.id.setting_suggested)
    TextView settingSuggested;
    @BindView(R.id.setting_about)
    TextView settingAbout;
    @BindView(R.id.setting_back_login)
    Button settingBackLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }


    @OnClick({R.id.setting_back, R.id.setting_img, R.id.setting_name, R.id.setting_clear, R.id.setting_message, R.id.setting_blacklist, R.id.setting_pwd, R.id.setting_version, R.id.setting_suggested, R.id.setting_about, R.id.setting_back_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_back:
                onBackPressed();
                break;
            case R.id.setting_img:
                break;
            case R.id.setting_name:
                break;
            case R.id.setting_clear:
                break;
            case R.id.setting_message:
                break;
            case R.id.setting_blacklist:
                break;
            case R.id.setting_pwd:
                break;
            case R.id.setting_version:
                break;
            case R.id.setting_suggested:
                break;
            case R.id.setting_about:
                break;
            case R.id.setting_back_login:
                backLoginDialog();
                break;
        }
    }
    private void backLoginDialog(){
        AlertDialog dialog=new AlertDialog.Builder(SettingActivity.this)
                .setTitle("确定要退出登录吗？")
                .setMessage("退出登录讲清空您的用户名信息，您确定要退出吗")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNeutralButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SpUtils.upSp().putBoolean(LoginUtils.LOGIN,false);
                SpUtils.upSp().commit();
                setResult(201);
                Toast.makeText(SettingActivity.this,"退出成功",Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        }).create();
        dialog.show();
    }
}
