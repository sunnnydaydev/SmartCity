package com.example.administrator.smartcity.base.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.activities.VideoActivity;
import com.example.administrator.smartcity.base.BasePage;

/**
 * Create by SunnyDay on 2019/02/21
 */
public class VideoPage extends BasePage {
    public VideoPage(Activity activity) {
        super(activity);
    }
    @Override
    public void initData() {
        tvTitle.setText("快看");

        View view = View.inflate(activity,R.layout.video,null);

        Button btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity,VideoActivity.class));
            }
        });


        flLayout.addView(view);
        // 类似抖音短视屏使用
    }
}
