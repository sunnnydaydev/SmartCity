package com.example.administrator.smartcity.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.smartcity.Adapters.LeftMenuAdapter;
import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.domain.NewsCenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create by SunnyDay on 2019/02/21
 */
public class LeftMenuFragment extends BaseFragment {

    private View view;
    @BindView(R.id.recycle_view)
    public RecyclerView recyclerView;
    private NewsCenter mNewsCenter;

    @Override
    public View initView() {
        view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_left, null);
        return view;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this, view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    public void setMenuData(NewsCenter newsCenter) {
        mNewsCenter = newsCenter;
        // 注意setAdapter的位置
        recyclerView.setAdapter(new LeftMenuAdapter(mActivity,mNewsCenter));
    }
}
