package com.example.administrator.smartcity.fragments;

import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.smartcity.R;

/**
 * Create by SunnyDay on 2019/02/21
 */
public class LeftMenuFragment extends BaseFragment {
    @Override
    public View initView() {
        View view  = LayoutInflater.from(mActivity).inflate(R.layout.fragment_left,null);
        return view;
    }
}
