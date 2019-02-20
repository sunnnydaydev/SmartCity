package com.example.administrator.smartcity.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.utils.SpUtil.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 闪屏页面
 */
public class SplashActivity extends BaseActivity {
    @BindView(R.id.layout_splash)
    public RelativeLayout splashLayout;//private static的类型时使用注解报错

    @Override
    public Object getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void onCreate() {
        setNoTitleBarAndFullScreen();
        initAnimation();
    }


    /**
     * view 动画
     */
    private void initAnimation() {
        // 旋转动画  起始角度，旋转的xy相对点
        RotateAnimation ra = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(2000);
        ra.setFillAfter(true);
        //缩放动画 xy缩放比例   相对缩放点
        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(2000);
        sa.setFillAfter(true);
        //透明动画
        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setDuration(2000);
        aa.setFillAfter(true);

        // 添加到动画集合
        AnimationSet as = new AnimationSet(true);
        as.addAnimation(ra);
        as.addAnimation(sa);
        as.addAnimation(aa);
        splashLayout.startAnimation(as);
        AnimationListener(as);
    }

    /**
     * 动画监听
     *
     * @param as 动画集合
     */
    private void AnimationListener(AnimationSet as) {
        as.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                boolean isFirstEnter = SpUtil.getBoolean(SplashActivity.this, "is_first_enter", true);
                //判断是否第一次进入
                startActivity(new Intent(SplashActivity.this, GuideActivity.class));
//                if (isFirstEnter) {
//                    startActivity(new Intent(SplashActivity.this, GuideActivity.class));
//                    SpUtil.putBoolean(SplashActivity.this, "is_first_enter", false);
//                } else {
//                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
//                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    /**
     * 全屏 且隐藏标题栏
     * */
    private void setNoTitleBarAndFullScreen() {
        // requestWindowFeature(Window.FEATURE_NO_TITLE); 此句必须在setContent之前
        getSupportActionBar().hide();
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}
