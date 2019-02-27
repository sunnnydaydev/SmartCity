package com.example.administrator.smartcity.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.smartcity.R;

/**
 * Create by SunnyDay on 2019/02/27
 * <p>
 * 设置界面的通用view    自定义view
 */
public class SettingView extends LinearLayout {
    public SettingView(Context context) {
        this(context, null);
    }

    public SettingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view  = LayoutInflater.from(context).inflate(R.layout.view_setting_page,null);

    }

}
