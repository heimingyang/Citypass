package com.example.citypass.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;

import com.alibaba.fastjson.JSON;
import com.example.citypass.model.bean.BaseParam;
import com.example.citypass.model.bean.BaseParamBean;
import com.example.citypass.model.bean.information.Information;
import com.example.citypass.model.bean.information.UpLoad;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * 项目名称: 血压卫士
 * 类描述: 一些登录后得到的参数的数据存放
 * 创建人: 马杰
 * 创建时间: 2017/6/21 15:46
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class LoginUtils {
    public static Information information;
    public static String LOGIN="login";//boolean
    public static String NAME="name";
    public static String USERID="userID";
    public static String USERNAME="userName";
    public static String USITEID="uSiteID";
    public static String OUSITEID="ouSiteID";
    public static String MYIMG="myImg";
    public static String PHONE="phone";
    //可选照片的最大数量
    public static final String PICTURE_NUM = "picture_num";
    //是否可以跳转到照片调整页面
    public static final String PICtURE_FLAG = "picture_flag";

    public static String upload(int keyID,String value){
        UpLoad load=new UpLoad();
        load.setCustomerID(8001);
        load.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"));
        load.setMethod("PHSocket_SetUserBaseInfo");
        load.setCustomerKey("D5607EBE573BE2B59A4D5A1CAE882615");
        load.setAppName("CcooCity");
        load.setVersion("4.5");
        UpLoad.ParamBean paramBean=new UpLoad.ParamBean();
        paramBean.setSiteID(information.getServerInfo().getSiteID());
        paramBean.setUserName(information.getServerInfo().getUserName());
        paramBean.setUserID(SpUtils.getSp().getString(USERID,""));
        paramBean.setUsiteID(information.getServerInfo().getSiteID());
        paramBean.setKeyID(keyID);
        paramBean.setValue(value);
        load.setParam(paramBean);
        UpLoad.StatisBean statisBean=new UpLoad.StatisBean();
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("+86"+information.getServerInfo().getTel());
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(USERID,"")));
        statisBean.setSiteId(information.getServerInfo().getSiteID());
        String  model= android.os.Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion+"");
        load.setStatis(statisBean);
        String s = JSON.toJSONString(load);
        return s;
    }

    public static String getParam(BaseParamBean bean,String type){
        BaseParam param=new BaseParam();
        param.setCustomerID(8001);
        param.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"));
        param.setMethod(type);
        param.setCustomerKey("D5607EBE573BE2B59A4D5A1CAE882615");
        param.setAppName("CcooCity");
        param.setVersion("4.5");
        param.setParam(bean);
        BaseParam.StatisBean statisBean=new BaseParam.StatisBean();
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("+86"+information.getServerInfo().getTel());
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(USERID,"")));
        statisBean.setSiteId(information.getServerInfo().getSiteID());
        String  model= android.os.Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion+"");
        param.setStatisBean(statisBean);
        String s = JSON.toJSONString(param);
        return s;
    }
    public static String getIPAddress(Context context) {
        NetworkInfo info = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }

            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());//得到IPV4地址
                return ipAddress;
            }
        } else {
            //当前无网络连接,请在设置中打开网络
        }
        return null;
    }

    /**
     * 将得到的int类型的IP转换为String类型
     *
     * @param ip
     * @return
     */
    public static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }

}
