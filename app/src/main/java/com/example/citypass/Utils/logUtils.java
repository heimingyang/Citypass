package com.example.citypass.Utils;

import android.util.Log;

/**
 * Created by 黑明阳 on 2017/4/28.
 */

public class logUtils {
    public static boolean isdebug=true;

    public static void e(String tag,String msg){
          if(isdebug){
              Log.e(tag,msg);
          }
    }
}
