package com.example.administrator.smartcity.utils.net;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Create by SunnyDay on 2019/02/24
 */
public class MyHandler extends Handler {
    private WeakReference<Activity> mactivity;

    public MyHandler(Activity activity) {
        mactivity = new WeakReference<Activity>(activity);
    }

    @Override
    public void handleMessage(Message msg) {
        Activity activity = mactivity.get();
        if (activity != null) {
            // 下面进行消息处理
           // 更新UI即可
        }
    }
}
