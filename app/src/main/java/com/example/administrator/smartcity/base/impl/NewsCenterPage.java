package com.example.administrator.smartcity.base.impl;

import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.example.administrator.smartcity.activities.MainActivity;
import com.example.administrator.smartcity.base.BasePage;
import com.example.administrator.smartcity.domain.NewsCenter;
import com.example.administrator.smartcity.fragments.LeftMenuFragment;
import com.example.administrator.smartcity.utils.Constant.GlobalConstant;
import com.example.administrator.smartcity.utils.net.HttpUtils;
import com.google.gson.Gson;


import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Create by SunnyDay on 2019/02/21
 */
public class NewsCenterPage extends BasePage {
    public NewsCenterPage(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        TextView tv = new TextView(activity);
        tv.setText("新闻中心");
        tv.setGravity(Gravity.CENTER);
        flLayout.addView(tv);
        tvTitle.setText("新闻中心");


        HttpUtils.OkHttp(GlobalConstant.CATEGORY_URL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                // 解析网络数据 ---传递给侧边栏
                // Log.i(TAG, "onResponse: "+response.body().string());
                final String json = response.body().string();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        NewsCenter newCenter = gson.fromJson(json, NewsCenter.class);
                        MainActivity mainActivity = (MainActivity) activity;
                        LeftMenuFragment leftMenuFragment = mainActivity.getLeftMenuFragment();
                        // 数据给侧边栏
                        leftMenuFragment.setMenuData(newCenter);
                    }
                });
            }
        });

    }
}
