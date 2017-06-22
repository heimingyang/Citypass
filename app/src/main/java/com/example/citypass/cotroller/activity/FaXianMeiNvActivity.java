package com.example.citypass.cotroller.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.LoginActivity;
import com.example.citypass.model.bean.Information;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/21 0021 15:36
 * 修改人:
 * 修改内容:
 * 修改时间:
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */

public class FaXianMeiNvActivity extends BaseActivity {
    @BindView(R.id.Belle_back)
    ImageView BelleBack;
    @BindView(R.id.Belle_title)
    TextView BelleTitle;
    @BindView(R.id.Belle_camera)
    ImageView BelleCamera;
    @BindView(R.id.Belle_relative)
    RelativeLayout BelleRelative;
    @BindView(R.id.Belle_Tablayout)
    TabLayout BelleTablayout;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_faxianmeinv;
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


    @OnClick({R.id.Belle_back, R.id.Belle_camera})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //返回键
            case R.id.Belle_back:
                onBackPressed();
                break;
            case R.id.Belle_camera:
                cameraClicked();

                break;
        }
    }

    //点击右上角的相机
    private void cameraClicked() {

        //判断是否登录
        if (SpUtils.getSp().getBoolean(LoginUtils.LOGIN, false)) {
            Information.ServerInfoBean serverInfo = LoginUtils.information.getServerInfo();
            //男生弹出dialog
            if (LoginUtils.information.getServerInfo().getSex().equals("男")) {
                Toast.makeText(this, "男", Toast.LENGTH_SHORT).show();
                showMyDialog();
            } else {
                Toast.makeText(this, "女", Toast.LENGTH_SHORT).show();
                //女生再判断 资料有没有完善
                if (serverInfo.getName().isEmpty() || serverInfo.getJob().isEmpty() || serverInfo.getInfo().isEmpty()) {
                    //没有完善就跳转去完善

                } else {
                    //完善了就去发表


                }
            }

            //没登录，跳转到登录
        } else {
            Intent intent = new Intent(FaXianMeiNvActivity.this, LoginActivity.class);
            startActivityForResult(intent, 200);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 200:
                switch (resultCode) {
                    case 111:
                        cameraClicked();
                        break;


                }

                break;

        }
    }

    private TextView gotoBoy;

    //本页面男生的dialog
    private void showMyDialog() {

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        View inflate = LayoutInflater.from(this).inflate(R.layout.boy_dialog_item, null);
        gotoBoy = (TextView) inflate.findViewById(R.id.dialog_gotoboy);
        //点击去帅男秀场
        gotoBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FaXianMeiNvActivity.this, "进入帅男秀场", Toast.LENGTH_SHORT).show();

            }
        });

        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.setView(inflate);
        alertDialog.show();


    }
}
