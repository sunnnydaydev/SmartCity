package com.example.administrator.smartcity.fragments;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.smartcity.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create by SunnyDay on 2019/02/21
 */
public class ContentFragment extends BaseFragment {
    @BindView(R.id.bottom_navigation)
    public BottomNavigationBar bottomNavigationBar;
    private View view;

    @Override
    public View initView() {
        view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_content, null);
        return view;
    }
    @Override
    public void initData() {
        // 绑定view
        ButterKnife.bind(this,view);
        // 添加按钮文字 及其图标
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.home_press, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.newscenter, "新闻中心"))
                .addItem(new BottomNavigationItem(R.drawable.smartservice, "智慧服务"))
                .addItem(new BottomNavigationItem(R.drawable.govaffairs, "政务"))
                .addItem(new BottomNavigationItem(R.drawable.setting, "设置"))
                .initialise();
        // 点击事件
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position){
                    case 0:
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

}
