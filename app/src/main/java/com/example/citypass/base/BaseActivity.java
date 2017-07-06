package com.example.citypass.base;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.citypass.App;
import com.example.citypass.R;

import butterknife.ButterKnife;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/19 14:21
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


public abstract class BaseActivity extends AppCompatActivity{
    //需要获取的权限
    private String[] permissions = {Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_WIFI_STATE,Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.CHANGE_WIFI_STATE,Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE,Manifest.permission.BLUETOOTH,
            Manifest.permission.BLUETOOTH_ADMIN,Manifest.permission.ACCESS_FINE_LOCATION,
             Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

//        RxPermissions rxPermissions = new RxPermissions(this);
//
//        rxPermissions
//                .request(Manifest.permission.INTERNET);
        //关键代码

        super.onCreate(savedInstanceState);


        App.activity = this;
        setContentView(getLayoutId());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for(int a = 0;a<permissions.length;a++){
                int i = ContextCompat.checkSelfPermission(this, permissions[a]);
                if (i != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,permissions,1);
                }
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(R.color.red));
        }
        ButterKnife.bind(this);
        initView();
        initListener();
    }
    //加载布局
    protected abstract int getLayoutId();

    //点击事件·
    protected abstract void initListener();

    //加载数据
    protected abstract void initData();
    //寻找控件

    protected abstract void initView();

    public TextView getText() {
        return null;
    }

    public ImageView getImgOne() {
        return null;
    }

    public ImageView getImgTwo() {
        return null;
    }

    public ImageView getImg(){
        return null;
    }
    public RadioGroup getGroup(){return null;}
    @Override
    protected void onResume() {
        super.onResume();
        App.activity = this;
        initData();
    }


}
