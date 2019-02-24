package com.example.administrator.smartcity.utils.net;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Create by SunnyDay on 2019/02/24
 */
public class HttpUtils {

    public static void OkHttp(String url, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(callback);
    }


}
