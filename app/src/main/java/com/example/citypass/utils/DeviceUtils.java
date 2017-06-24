package com.example.citypass.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by 黑明阳 on 2017/6/22.
 */

public class DeviceUtils {

    private DeviceUtils(){

    }

    private static DeviceUtils deviceUtils;

    public static DeviceUtils getInstance(){
        if (deviceUtils == null){
            synchronized (DeviceUtils.class){
                if (deviceUtils == null)
                    deviceUtils = new DeviceUtils();
            }
        }
        return deviceUtils;
    }

    /**
     * 获取设备的唯一标识，deviceId
     *
     * @param context
     * @return
     */
    public String getDeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        if (deviceId == null) {
            return 1+"";
        } else {
            return deviceId;
        }
    }

//     获取手机品牌
    public String getPhoneBrand() {
        return android.os.Build.BRAND;
    }

//   获取手机型号
    public String getPhoneModel() {
        return android.os.Build.MODEL;
    }

//  获取手机Android API等级（22、23 ...）
    public int getBuildLevel() {
        return android.os.Build.VERSION.SDK_INT;
    }

//  获取手机Android 版本（4.4、5.0、5.1 ...）
    public static String getBuildVersion() {
        return "Android "+android.os.Build.VERSION.RELEASE;
    }

    public String getDevicenumber(Context context) {
        //获取本机对象
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        //获取本机手机号
        String number=tm.getLine1Number();
       return number;
    }
}
