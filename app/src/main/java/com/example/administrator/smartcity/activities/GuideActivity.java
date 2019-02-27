package com.example.administrator.smartcity.activities;


import android.content.Intent;
import android.support.v4.view.ViewPager;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.smartcity.Adapters.GuideAdapter;
import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.utils.SpUtil.SpUtil;


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
       boolean isfirst = SpUtil.getBoolean(this,"first",true);
       if (isfirst){
           setNoTitleBarAndFullScreen();
           initData();
           viewPager.setAdapter(new GuideAdapter(mlist));
           viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
               @Override
               public void onPageScrolled(int i, float v, int i1) {}
               @Override
               public void onPageSelected(int i) {
                   if (i == mlist.size()-1) {
                       startExperience.setVisibility(View.VISIBLE);
                       startExperience.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               startActivity(new Intent(GuideActivity.this,MainActivity.class));
                               finish();
                           }
                       });
                   }
               }

               @Override
               public void onPageScrollStateChanged(int i) {}
           });
           SpUtil.putBoolean(this,"first",false);
       }else{
           finish();
       }

    }

    /**
     * 初始化数据
     * 创建viewpage的页面
     */
    private void initData() {
        img = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
        mlist = new ArrayList<>();
        //  ImageView imageView = new ImageView(this);写在此处时 踩过的坑
        //java.lang.IllegalStateException: The specified child already has a parent. You must call removeView() on the child's parent first.
        for (int i = 0; i < img.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(img[i]);
            mlist.add(imageView);
        }
    }

}
