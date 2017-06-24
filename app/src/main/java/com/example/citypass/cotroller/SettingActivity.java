package com.example.citypass.cotroller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.fragment.FeedBackActivity;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.utils.ClearDateUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;

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
    RelativeLayout settingClear;
    @BindView(R.id.setting_message)
    TextView settingMessage;
    @BindView(R.id.setting_blacklist)
    TextView settingBlacklist;
    @BindView(R.id.setting_pwd)
    TextView settingPwd;
    @BindView(R.id.setting_version)
    RelativeLayout settingVersion;
    @BindView(R.id.setting_suggested)
    TextView settingSuggested;
    @BindView(R.id.setting_about)
    TextView settingAbout;
    @BindView(R.id.setting_back_login)
    Button settingBackLogin;
    @BindView(R.id.setting_clearTwo)
    TextView settingClearTwo;
    @BindView(R.id.setting_versionOne)
    TextView settingVersionTwo;

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
        String url = SpUtils.getSp().getString(LoginUtils.MYIMG, "");
        HttpFacory.create().loadImage(url, settingImg, true);
        try {
            settingClearTwo.setText(ClearDateUtils.getTotalCacheSize(SettingActivity.this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @OnClick({R.id.setting_back, R.id.setting_img, R.id.setting_name, R.id.setting_clear, R.id.setting_message, R.id.setting_blacklist, R.id.setting_pwd, R.id.setting_version, R.id.setting_suggested, R.id.setting_about, R.id.setting_back_login
            , R.id.setting_clearTwo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_back:
                onBackPressed();
                break;
            case R.id.setting_img:
                break;
            case R.id.setting_name:
                Intent intent = new Intent(SettingActivity.this, InforActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_clear:
                AlertDialog dialog = new AlertDialog.Builder(SettingActivity.this)
                        .setTitle("确定要清除缓存么")
                        .setMessage("清楚缓存可能导致你在没有网络的时候无法查看信息或者图片，你确定操作吗？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ClearDateUtils.cleanInternalCache(SettingActivity.this);
                                try {
                                    settingClearTwo.setText(ClearDateUtils.getTotalCacheSize(SettingActivity.this));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                Toast.makeText(SettingActivity.this, "清理成功", Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                dialog.show();
                break;
            case R.id.setting_message:
                Intent intentOne = new Intent(SettingActivity.this, ReminberActivity.class);
                startActivity(intentOne);
                break;
            case R.id.setting_blacklist:
                Intent intent1=new Intent(SettingActivity.this,BlackActivity.class);
                startActivity(intent1);
                break;
            case R.id.setting_pwd:
                Intent intentTwo = new Intent(SettingActivity.this, ModifyActivity.class);
                startActivity(intentTwo);
                break;
            case R.id.setting_version:
                Toast.makeText(SettingActivity.this, "已是最新版本~", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_suggested:
                Intent intentThree = new Intent(SettingActivity.this, FeedBackActivity.class);
                startActivity(intentThree);
                break;
            case R.id.setting_about:
                Intent intentFour = new Intent(SettingActivity.this, AboutActivity.class);
                startActivity(intentFour);
                break;
            case R.id.setting_back_login:
                backLoginDialog();
                break;
            case R.id.setting_clearTwo:
                break;

        }
    }

    private void backLoginDialog() {
        AlertDialog dialog = new AlertDialog.Builder(SettingActivity.this)
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
                        SpUtils.upSp().putBoolean(LoginUtils.LOGIN, false);
                        SpUtils.upSp().commit();
                        setResult(201);
                        Toast.makeText(SettingActivity.this, "退出成功", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                }).create();
        dialog.show();
    }


}
