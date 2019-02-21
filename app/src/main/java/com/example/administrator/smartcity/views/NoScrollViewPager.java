package com.example.administrator.smartcity.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Create by SunnyDay on 2019/02/21
 * 不允许viewpager滑动
 */
public class NoScrollViewPager extends ViewPager {
    public NoScrollViewPager(@NonNull Context context) {
        super(context);
    }

    public NoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 直接消费事件
     * */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }
}
