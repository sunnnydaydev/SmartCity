package com.example.administrator.smartcity.Adapters;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Create by SunnyDay on 2019/02/20
 * <p>
 * GuideActivity  页面的viewpager的adapter
 */
public class GuideAdapter extends PagerAdapter {
    private List<ImageView> mlist;
    public GuideAdapter(List<ImageView> mlist){
        this.mlist=mlist;
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
        ImageView img  = mlist.get(position);
        container.addView(img);
        return mlist.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View)object);
    }
}
