package com.example.administrator.smartcity.activities;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.smartcity.Adapters.GuideAdapter;
import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.fragments.ContentFragment;
import com.example.administrator.smartcity.fragments.LeftMenuFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @Override
    public Object getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate() {
        setImmersionStatusBar();
        initFragment();
    }

    /**
     * 动态添加fragment
     */
    public void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_main, new ContentFragment(), "CONTENT_FRAGMENT");
        fragmentTransaction.replace(R.id.layout_left_menu, new LeftMenuFragment(), "LEFT_FRAGMENT");
        fragmentTransaction.commit();
    }

    /**
     * 提供侧边栏的方法   activity为桥梁
     */
    public LeftMenuFragment getLeftMenuFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        LeftMenuFragment leftMenuFragment = (LeftMenuFragment) fragmentManager.findFragmentByTag("LEFT_FRAGMENT");
        return leftMenuFragment;
    }

    /**
     * 主界面的fragment实例
     */
    public ContentFragment getContentFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        ContentFragment contentFragment = (ContentFragment) fragmentManager.findFragmentByTag("CONTENT_FRAGMENT");
        return contentFragment;
    }
}
