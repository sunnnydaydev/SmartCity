package com.example.administrator.smartcity.Adapters;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.smartcity.base.BasePage;

import java.util.List;

/**
 * Create by SunnyDay on 2019/02/21
 * <p>
 * 主界面底部导航上面的viewpager的adapter
 */
public class ContentAadpter extends PagerAdapter {
    private List<BasePage>mlist;
    public ContentAadpter(List<BasePage>mlist){
        this.mlist = mlist;
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mlist.get(position).rootView);
        return mlist.get(position).rootView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View)object);
    }
}
