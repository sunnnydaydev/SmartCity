package com.example.administrator.smartcity.base.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.smartcity.Adapters.VideoAdapter;
import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.activities.VideoActivity;
import com.example.administrator.smartcity.base.BasePage;
import com.example.administrator.smartcity.domain.VideoBeans;
import com.example.administrator.smartcity.utils.Constant.GlobalConstant;
import com.example.administrator.smartcity.utils.net.HttpUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Create by SunnyDay on 2019/02/21
 * 视屏界面开发
 */
public class VideoPage extends BasePage {
    public VideoPage(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        tvTitle.setText("快看");
        View view = View.inflate(activity, R.layout.video, null);
        final RecyclerView recyclerView = view.findViewById(R.id.recycle_video);
        LinearLayoutManager manager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        // 请求网络
        HttpUtils.OkHttp(GlobalConstant.VIDEO, new Callback() {
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
                        VideoBeans videoBeans = gson.fromJson(json, VideoBeans.class);
                        recyclerView.setAdapter(new VideoAdapter(activity,videoBeans));
                    }
                });
            }
        });

        flLayout.addView(view);

    }
}
