package com.example.administrator.smartcity.activities;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.VideoView;

import com.example.administrator.smartcity.R;

import io.vov.vitamio.Vitamio;

public class VideoActivity extends AppCompatActivity {

    private VideoView videoView;
    private String url2 = "http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.video_view);

    }
}
