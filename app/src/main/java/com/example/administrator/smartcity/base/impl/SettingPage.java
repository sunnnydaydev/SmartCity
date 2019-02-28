package com.example.administrator.smartcity.base.impl;

import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.base.BasePage;
import com.example.administrator.smartcity.views.SettingView;

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
        // 设置界面的view  （内部使用自定义）
        View view = View.inflate(activity, R.layout.page_setting, null);
        SettingView accountManager = view.findViewById(R.id.account_manager);

        accountManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "测试", Toast.LENGTH_SHORT).show();
            }
        });
        flLayout.addView(view);

    }
}
