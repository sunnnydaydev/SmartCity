package com.example.administrator.smartcity.utils.SpUtil;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Create by SunnyDay on 2019/02/20
 * SharedPreferences 工具类
 */
public class SpUtil {
    private static final String CONFIG = "config";

     public static void putBoolean(Context context,String key,boolean value){
         SharedPreferences sp = context.getSharedPreferences(CONFIG,Context.MODE_PRIVATE);
         sp.edit().putBoolean(key,value).commit();
     }
     public static boolean getBoolean(Context context,String key,boolean defalutValue){
         SharedPreferences sp = context.getSharedPreferences(CONFIG,Context.MODE_PRIVATE);
         return sp.getBoolean(key,defalutValue);
     }
    public static void putString(Context context,String key,String value){
        SharedPreferences sp = context.getSharedPreferences(CONFIG,Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }
    public static String getString(Context context,String key,String defalutValue){
        SharedPreferences sp = context.getSharedPreferences(CONFIG,Context.MODE_PRIVATE);
        return sp.getString(key,defalutValue);
    }

}
