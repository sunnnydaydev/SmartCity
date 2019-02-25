package com.example.administrator.smartcity.base.impl;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.smartcity.Adapters.PhotoAdapter;
import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.activities.MainActivity;
import com.example.administrator.smartcity.base.BasePage;
import com.example.administrator.smartcity.domain.NewsCenter;
import com.example.administrator.smartcity.domain.Photo;
import com.example.administrator.smartcity.fragments.LeftMenuFragment;
import com.example.administrator.smartcity.utils.Constant.GlobalConstant;
import com.example.administrator.smartcity.utils.net.HttpUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Create by SunnyDay on 2019/02/21
 */
public class SmartServicePage extends BasePage {
    public SmartServicePage(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        tvTitle.setText("组图");
        // 组图模块开发
        final RecyclerView recyclerView = new RecyclerView(activity);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        // 请求数据
        HttpUtils.OkHttp(GlobalConstant.PHOTO, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String json = response.body().string();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        Photo photo = gson.fromJson(json, Photo.class);
                        recyclerView.setAdapter(new PhotoAdapter(photo, activity));
                        flLayout.addView(recyclerView);
                    }
                });
            }
        });


    }
}
