package com.example.administrator.smartcity.activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Create by SunnyDay on 2019/02/20
 * <p>
 * 基类的设计
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder mBinder;
    private View mConvertView;
    // 不让子类重写（只让子类实现onCreate）
    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mConvertView = convertView();
        if (mConvertView == null) {
            throw new ClassCastException("setLayout only be View or be Resource Id");
        }
        setContentView(mConvertView);
        mBinder = ButterKnife.bind(this);
        onCreate();
    }

    // 强制子类实现的两个方法
    public abstract Object getLayout();

    public abstract void onCreate();

    /**
     * 布局处理
     */
    private View convertView() {
        View view = null;
        if (getLayout() instanceof Integer) {
            view = LayoutInflater.from(this).inflate((Integer) getLayout(), null, false);
        }
        if (getLayout() instanceof View) {
            view = (View) getLayout();
        }
        return view;
    }

    /**
     * 全屏 且隐藏标题栏
     * （子类需要直接使用）
     * */
    public void setNoTitleBarAndFullScreen() {
        // requestWindowFeature(Window.FEATURE_NO_TITLE); 此句必须在setContent之前
        getSupportActionBar().hide();
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    /**
     *沉浸式状态栏
     * */
    public void setImmersionStatusBar(){
        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }
    @Override
    protected void onDestroy() {
        // 解绑
        if (mBinder != null) {
            mBinder.unbind();
            mBinder = null;
        }
        mConvertView = null; // call gc
        super.onDestroy();
    }
}
