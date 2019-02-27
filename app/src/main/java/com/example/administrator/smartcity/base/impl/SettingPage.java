package com.example.administrator.smartcity.base.impl;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.base.BasePage;

/**
 * Create by SunnyDay on 2019/02/21
 */
public class SettingPage extends BasePage {
    public SettingPage(Activity activity) {
        super(activity);
    }
    @Override
    public void initData() {
        tvTitle.setText("设置");
        btnMenu.setVisibility(View.GONE);
        View view = View.inflate(activity,R.layout.page_setting,null);


        flLayout.addView(view);


    }
}
