package com.example.citypass.utils;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/19 15:59
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


public class TimeUtils {
    public static String getStringTime(long time, String geshi) {
        SimpleDateFormat sdf = new SimpleDateFormat(geshi);
        Date date = new Date(time);
        return sdf.format(date);
    }

    public static Long getLongTime(String strTime, String geshi) {
        SimpleDateFormat sdf = new SimpleDateFormat(geshi);
        try {
            return sdf.parse(strTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    @SuppressLint("SimpleDateFormat")
    public static String getTime(String time) {
        if ( time == null || time.equals("")) {
            return "";
        }

        if (time.contains("/")) time = time.replace("/", "-");

        Date lastime = null;
        Date date = new Date();
        try {
            lastime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
        } catch (ParseException e) {
            return time;
        }
        if (date == null || lastime == null) {
            return "";
        }
        long longi = date.getTime() - lastime.getTime();
        long day = longi / (24 * 60 * 60 * 1000);
        long hour = (longi / (60 * 60 * 1000) - day * 24);
        long min = ((longi / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (longi / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

        if (day > 0) {
            String str = null;
            SimpleDateFormat f = new SimpleDateFormat("yyyy");
            Date d = new Date();
            str = f.format(d);
            if (time.subSequence(0, 4).equals(str)) {
                return (String) time.subSequence(5, time.lastIndexOf(":"));
            } else {
                return (String) time.subSequence(0, time.lastIndexOf(":"));
            }
        } else if (hour > 0) {
            return hour + "小时前";
        } else if (min > 0) {
            return min + "分钟前";
        } else {
            if (Math.abs(s) < 5) {
                return "刚刚";
            }
            return Math.abs(s) + "秒前";
        }
    }
}
