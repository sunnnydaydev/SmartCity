package com.example.administrator.smartcity.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.activities.MainActivity;
import com.example.administrator.smartcity.base.BasePage;
import com.example.administrator.smartcity.domain.NewsCenter;
import com.example.administrator.smartcity.fragments.LeftMenuFragment;
import com.example.administrator.smartcity.utils.Constant.GlobalConstant;
import com.example.administrator.smartcity.utils.loader.GlideLoader;
import com.example.administrator.smartcity.utils.net.HttpUtils;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Create by SunnyDay on 2019/02/21
 */
public class NewsCenterPage extends BasePage {
    public List<String> list = new ArrayList<>();
    public List<String> title = new ArrayList<>();

    public NewsCenterPage(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        tvTitle.setText("新闻中心");
        // 请求网络数据
        HttpUtils.OkHttp(GlobalConstant.CATEGORY_URL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                // 解析网络数据 ---传递给侧边栏
                // Log.i(TAG, "onResponse: "+response.body().string());
                final String json = response.body().string();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        NewsCenter newCenter = gson.fromJson(json, NewsCenter.class);
                        // 数据给侧边栏
                        MainActivity mainActivity = (MainActivity) activity;
                        LeftMenuFragment leftMenuFragment = mainActivity.getLeftMenuFragment();
                        leftMenuFragment.setMenuData(newCenter);


                        // 当前界面使用一些数据
                        View view = View.inflate(activity, R.layout.newscenter, null);
                        Banner banner = (Banner) view.findViewById(R.id.banner);
                        banner.setImageLoader(new GlideLoader());
                        //设置图片集合
                        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551075225452&di=985ba8355808afbbf6881ab03c57a82c&imgtype=0&src=http%3A%2F%2Fimg3.3lian.com%2F2013%2Fc2%2F5%2Fd%2F3.jpg");
                        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551075225454&di=2c0431c9f2870069b26c04c70d24c879&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Faa18972bd40735fa176b9d9495510fb30f240800.jpg");
                        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551075225163&di=aa8c7124936af99d142417790356ef19&imgtype=0&src=http%3A%2F%2Fphoto.16pic.com%2F00%2F13%2F08%2F16pic_1308605_b.jpg");
                        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551075225451&di=b56af4dbee0b540d6d9318fce6fa8a75&imgtype=0&src=http%3A%2F%2Fpic32.photophoto.cn%2F20140829%2F0020033077533476_b.jpg");

                        title.add("中秋");
                        title.add("中秋快乐");
                        title.add("千里共婵娟");
                        title.add("花好月圆");
                        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                        banner.setBannerAnimation(Transformer.Default);
                        banner.setBannerTitles(title);
                        banner.setImages(list);
                        banner.setOnBannerListener(new OnBannerListener() {
                            @Override
                            public void OnBannerClick(int position) {
                                Toast.makeText(activity, "待续！！！", Toast.LENGTH_SHORT).show();
                            }
                        });
                        banner.start();
                        flLayout.addView(view);
                    }
                });
            }
        });

    }
}
// https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551075225454&di=2c0431c9f2870069b26c04c70d24c879&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Faa18972bd40735fa176b9d9495510fb30f240800.jpg
// https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551075225452&di=985ba8355808afbbf6881ab03c57a82c&imgtype=0&src=http%3A%2F%2Fimg3.3lian.com%2F2013%2Fc2%2F5%2Fd%2F3.jpg

// https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551075225163&di=aa8c7124936af99d142417790356ef19&imgtype=0&src=http%3A%2F%2Fphoto.16pic.com%2F00%2F13%2F08%2F16pic_1308605_b.jpg

// https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551075225451&di=b56af4dbee0b540d6d9318fce6fa8a75&imgtype=0&src=http%3A%2F%2Fpic32.photophoto.cn%2F20140829%2F0020033077533476_b.jpg