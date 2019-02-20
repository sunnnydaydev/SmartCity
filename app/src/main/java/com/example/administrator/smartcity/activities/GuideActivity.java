package com.example.administrator.smartcity.activities;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.smartcity.Adapters.GuideAdapter;
import com.example.administrator.smartcity.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GuideActivity extends BaseActivity {
    @BindView(R.id.viewpager)
    public ViewPager viewPager;
    @BindView(R.id.start_experience)
    public Button startExperience;
    private int[] img;//引导页面的图片
    private List<ImageView> mlist;
    @Override
    public Object getLayout() {
        return R.layout.activity_guide;
    }

    @Override
    public void onCreate() {
        initData();
       // viewPager.setAdapter(new GuideAdapter(mlist));
    }

    /**
     * 初始化数据
     * 创建viewpage的页面
     */
    private void initData() {
        img = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
        mlist = new ArrayList<>();
        ImageView imageView = new ImageView(this);
        for (int i = 0; i < img.length; i++) {
            imageView.setBackgroundResource(img[i]);//可以使宽高填充布局
            //imageView.setImageResource() 根据图片宽高 填充（注意区别）
            mlist.add(imageView);
        }
    }
}
