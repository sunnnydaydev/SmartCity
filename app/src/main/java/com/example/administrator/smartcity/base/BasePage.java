package com.example.administrator.smartcity.base;

import android.app.Activity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.administrator.smartcity.R;

/**
 * Create by SunnyDay on 2019/02/21
 * 首页 新闻中心 设置 智慧服务 政务  这几个标签页的基类  普通的class
 *
 * 本类的核心 提供个 rootView
 */
public class BasePage {
    public Activity activity;
    public final View rootView;
    public TextView tvTitle;
    public ImageButton btnMenu;
    public FrameLayout flLayout;

    /**
     * 构建对象时 获得Context，并进行view的初始化，数据的加载
     *
     * view是五个标签页面的通用view ，有共同的特征。
     * */
    public BasePage(Activity activity) {
        this.activity = activity;
        rootView = initView();//根view 5个子view的大题框架一样，具体差异各自实现。
        initData();
    }

    public View initView() {
        View view = View.inflate(activity, R.layout.base_page, null);
        tvTitle = view.findViewById(R.id.tv_title);
        btnMenu = view.findViewById(R.id.menu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             DrawerLayout drawerLayout = activity.findViewById(R.id.drawable_layout);
             drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        flLayout = view.findViewById(R.id.fl_layout);
        return view;
    }

    public void initData() {

    }
}
