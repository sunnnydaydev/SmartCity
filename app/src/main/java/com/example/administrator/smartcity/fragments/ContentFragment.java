package com.example.administrator.smartcity.fragments;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.smartcity.Adapters.ContentAadpter;
import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.base.BasePage;
import com.example.administrator.smartcity.base.impl.GovAffairsPage;
import com.example.administrator.smartcity.base.impl.HomePage;
import com.example.administrator.smartcity.base.impl.NewsCenterPage;
import com.example.administrator.smartcity.base.impl.SettingPage;
import com.example.administrator.smartcity.base.impl.SmartServicePage;
import com.example.administrator.smartcity.views.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create by SunnyDay on 2019/02/21
 */
public class ContentFragment extends BaseFragment {
    @BindView(R.id.bottom_navigation)
    public BottomNavigationBar bottomNavigationBar;
    @BindView(R.id.vp_content)
    public NoScrollViewPager mViewPager;
    private View view;
    private List<BasePage> list;

    @Override
    public View initView() {
        view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_content, null);
        return view;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this, view);
        initViewPager();
        initNavagation();
    }

    /**
     * viewpager的操作
     */
    public void initViewPager() {
        list = new ArrayList<>();
        list.add(new HomePage(mActivity));
        list.add(new NewsCenterPage(mActivity));
        list.add(new SmartServicePage(mActivity));
        list.add(new GovAffairsPage(mActivity));
        list.add(new SettingPage(mActivity));
        mViewPager.setAdapter(new ContentAadpter(list));
    }

    /**
     * 底部导航的操作
     */
    public void initNavagation() {
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.home, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.newscenter, "新闻中心"))
                .addItem(new BottomNavigationItem(R.drawable.smartservice, "智慧服务"))
                .addItem(new BottomNavigationItem(R.drawable.govaffairs, "政务"))
                .addItem(new BottomNavigationItem(R.drawable.setting, "设置"))
                .initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                mViewPager.setCurrentItem(position, false);// false表示去掉滑动动画
                if (position == 0 || position == list.size() - 1) {
                    // 首页和设置页面禁用侧边栏  也就是关闭手势滑动即可
                    setLeftMenuEnable(false);
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

    /**
     * 设置侧边栏是否可首饰滑动
     * */
    public void setLeftMenuEnable(boolean enable) {
        DrawerLayout drawerLayout = mActivity.findViewById(R.id.drawable_layout);
        if (!enable){
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }
    }
}
