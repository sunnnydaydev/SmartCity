package com.example.administrator.smartcity.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.administrator.smartcity.R;

/**
 * Create by SunnyDay on 2019/02/21
 * 5个标签页面的基类
 */
public class BasePage {
    public Activity activity;
    public final View rootView;
    public TextView tvTitle;
    public ImageButton btnMenu;
    public FrameLayout flLayout;

    public BasePage(Activity activity) {
        this.activity = activity;
        rootView = initView();
        initData();
    }

    public View initView() {
        View view = View.inflate(activity, R.layout.base_page, null);
        tvTitle = view.findViewById(R.id.tv_title);
        btnMenu = view.findViewById(R.id.menu);
        flLayout = view.findViewById(R.id.fl_layout);
        return view;
    }

    public void initData() {

    }
}
