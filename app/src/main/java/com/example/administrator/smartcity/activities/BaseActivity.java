package com.example.administrator.smartcity.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Create by SunnyDay on 2019/02/20
 *
 * 基类的设计
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder mBinder;
    private View mConvertView;
    /**
     *  加 final 不让子类实现此方法，只能父类进行，子类传递过来交给父类处理
     *  */
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
     * 根据实现类实现的view 此处进行处理
     */
    public View convertView() {
        View view = null;
        if (getLayout() instanceof Integer) {
            view = LayoutInflater.from(this).inflate((Integer) getLayout(), null, false);
        }
        if (getLayout() instanceof View) {
            view = (View) getLayout();
        }
        return view;
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
