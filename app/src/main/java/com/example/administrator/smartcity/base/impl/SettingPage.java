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

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Create by SunnyDay on 2019/02/21
 */
public class SettingPage extends BasePage implements View.OnClickListener {
    public SettingPage(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        tvTitle.setText("设置");
        btnMenu.setVisibility(View.GONE);
        // 设置界面的view  （内部使用自定义）
        View view = View.inflate(activity, R.layout.page_setting, null);

        view.findViewById(R.id.account_manager).setOnClickListener(this);
        view.findViewById(R.id.share).setOnClickListener(this);
        view.findViewById(R.id.about).setOnClickListener(this);
        view.findViewById(R.id.remove_cache).setOnClickListener(this);
        view.findViewById(R.id.amost_setting).setOnClickListener(this);


        flLayout.addView(view);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.account_manager:
                Toast.makeText(activity, "登录功能暂未开发，待续", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                showShare("https://github.com/sunnnydaydev/SmartCity");
                break;
            case R.id.about:
                // todo 用户协议html页面
                Toast.makeText(activity, "明天开发", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_cache:
                Toast.makeText(activity, "待续!!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.amost_setting:
                Toast.makeText(activity, "以下功能待续!!!", Toast.LENGTH_LONG).show();
                break;
        }
    }
    public void showShare(String url) {
        OnekeyShare oks = new OnekeyShare();
        oks.disableSSOWhenAuthorize();
        oks.setTitle("给你分享个开源项目");
        oks.setTitleUrl(url);
        oks.setText("给你分享个开源项目");
        oks.setUrl(url);
        oks.setComment("给你分享个开源项目");
        oks.setSite(activity.getString(R.string.app_name));
        oks.setSiteUrl(url);
        oks.show(activity);
    }
}
