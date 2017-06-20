package com.example.citypass.Utils;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.example.citypass.App;
import com.example.citypass.R;

/**
 * Created by dell on 2017/5/30.
 */

public class NetWorkUtils {
    private static NetWorkUtils netWorkUtils=null;
    private NetWorkUtils(){};
    private ConnectivityManager manager;
    public static synchronized NetWorkUtils getInstance(){
        if(netWorkUtils==null){
            netWorkUtils=new NetWorkUtils();
        }
        return netWorkUtils;
    }
    /**
     * 检测网络是否连接
     * @return
     */
    public  boolean checkNetworkState() {
        boolean flag = false;
        //得到网络连接信息
        manager = (ConnectivityManager) App.activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        //去进行判断网络是否连接
        if (manager.getActiveNetworkInfo() != null) {
            flag = manager.getActiveNetworkInfo().isAvailable();
        }
        if (!flag) {
            setNetwork();
        } else {

        }

        return flag;
    }


    /**
     * 网络未连接时，调用设置方法
     */
    private  void setNetwork(){
        Toast.makeText(App.activity, "wifi is closed!", Toast.LENGTH_SHORT).show();

        AlertDialog.Builder builder = new AlertDialog.Builder(App.activity);
                 builder.setIcon(R.mipmap.ic_launcher);
                 builder.setTitle("网络提示信息");
                 builder.setMessage("网络不可用，如果继续，请先设置网络！");
                 builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                Intent intent = null;
                /**
                 * 判断手机系统的版本！如果API大于10 就是3.0+
                 * 因为3.0以上的版本的设置和3.0以下的设置不一样，调用的方法不同
                 */
                if (android.os.Build.VERSION.SDK_INT > 10) {
                    intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
                } else {
                    intent = new Intent();
                    ComponentName component = new ComponentName(
                            "com.android.settings",
                            "com.android.settings.WirelessSettings");
                    intent.setComponent(component);
                    intent.setAction("android.intent.action.VIEW");
                }
                App.activity.startActivity(intent);
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create();
        builder.show();
    }


}
