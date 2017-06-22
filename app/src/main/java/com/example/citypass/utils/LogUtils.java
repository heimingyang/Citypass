package com.example.citypass.utils;

import android.util.Log;

/**
 * Created by 黑明阳 on 2017/4/28.
 */

public class LogUtils {
    public static boolean isdebug=true;

    public static void e(String tag,String msg){
          if(isdebug){
              Log.e(tag,msg);
          }
    }
}
