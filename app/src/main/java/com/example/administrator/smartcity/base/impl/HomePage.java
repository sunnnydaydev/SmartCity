package com.example.administrator.smartcity.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.smartcity.base.BasePage;

/**
 * Create by SunnyDay on 2019/02/21
 * 首页
 */
public class HomePage extends BasePage {
    public HomePage(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        tvTitle.setText("智慧中心");
        btnMenu.setVisibility(View.GONE);
        // 直接使用的网页
        WebView webView = new WebView(activity);
        final ProgressBar progressBar = new ProgressBar(activity);
        progressBar.setVisibility(View.GONE);

        webView.loadUrl("https://open.iot.10086.cn/ocp/h5");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

         // 本界面加载
        webView.setWebViewClient(new WebViewClient());
//WebView加载网页监听，其进度和我们的进度条相绑定，然后显示出我们也想的效果
        webView.setWebChromeClient(new WebChromeClient(){
            //方法中的onProgressChanged就代表了其速度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //首先我们的进度条是隐藏的
                progressBar.setVisibility(View.VISIBLE);
                //把网页加载的进度传给我们的进度条
                progressBar.setProgress(newProgress);
                if (newProgress == 100){
                    //加载完毕让进度条消失
                    progressBar.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        flLayout.addView(webView);
    }
}
