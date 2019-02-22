package com.example.administrator.smartcity.base.impl;

import android.app.Activity;
import android.view.Gravity;
import android.widget.TextView;

import com.example.administrator.smartcity.base.BasePage;

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

        // 请求网络数据

        // 解析网络数据 ---传递给侧边栏
    }
}
