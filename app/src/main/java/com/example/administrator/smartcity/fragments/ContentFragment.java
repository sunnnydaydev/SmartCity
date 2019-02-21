package com.example.administrator.smartcity.fragments;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
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
    private View view;
    @BindView(R.id.vp_content)
    public ViewPager mViewPager;

    @Override
    public View initView() {
        view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_content, null);
        return view;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this, view);
        //1  viewpager的操作
        List<BasePage> list = new ArrayList<>();
        list.add(new HomePage(mActivity));
        list.add(new NewsCenterPage(mActivity));
        list.add(new SmartServicePage(mActivity));
        list.add(new GovAffairsPage(mActivity));
        list.add(new SettingPage(mActivity));
        mViewPager.setAdapter(new ContentAadpter(list));

        //2  底部导航的操作
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.home, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.newscenter, "新闻中心"))
                .addItem(new BottomNavigationItem(R.drawable.smartservice, "智慧服务"))
                .addItem(new BottomNavigationItem(R.drawable.govaffairs, "政务"))
                .addItem(new BottomNavigationItem(R.drawable.setting, "设置"))
                .initialise();
    }

}
