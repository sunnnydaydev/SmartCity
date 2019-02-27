package com.example.administrator.smartcity.activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.example.administrator.smartcity.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.sharesdk.onekeyshare.OnekeyShare;

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
     */
    public void setNoTitleBarAndFullScreen() {
        // requestWindowFeature(Window.FEATURE_NO_TITLE); 此句必须在setContent之前
        getSupportActionBar().hide();
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 沉浸式状态栏
     */
    public void setImmersionStatusBar() {
        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
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

    /**
     * shareSDK分享
     */
    public void showShare(String url) {
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();
        oks.setTitle("给你分享个好看的视屏");// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitleUrl(url);// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setText("给你分享个好看的视屏");// text是分享文本，所有平台都需要这个字段
       // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
       //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        oks.setUrl(url);// url仅在微信（包括好友和朋友圈）中使用
        oks.setComment("我是测试评论文本");// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setSite(getString(R.string.app_name));// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSiteUrl(url);// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.show(this);// 启动分享GUI
    }
}
