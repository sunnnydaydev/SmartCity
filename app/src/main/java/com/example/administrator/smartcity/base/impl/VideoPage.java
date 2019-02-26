package com.example.administrator.smartcity.base.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.activities.VideoActivity;
import com.example.administrator.smartcity.base.BasePage;
import com.example.administrator.smartcity.utils.net.HttpUtils;

/**
 * Create by SunnyDay on 2019/02/21
 *     视屏界面开发
 */
public class VideoPage extends BasePage {
    public VideoPage(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        tvTitle.setText("快看");
        View view = View.inflate(activity, R.layout.video, null);
        RecyclerView recyclerView = view.findViewById(R.id.recycle_video);
        LinearLayoutManager manager = new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        // 请求网络
        //HttpUtils.OkHttp();
        flLayout.addView(view);

    }
}
