package com.example.administrator.smartcity.fragments;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.smartcity.Adapters.LeftMenuAdapter;
import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.activities.MainActivity;
import com.example.administrator.smartcity.domain.NewsCenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        // 注意setAdapter的位置  在此处 否则mNewsCenter 空值（此处可以直接使用newsCenter）
        recyclerView.setAdapter(new LeftMenuAdapter(mActivity, mNewsCenter));
    }

    @OnClick(R.id.btn_exit)
    public void btnExit() {
        getActivity().finish();
    }

    @OnClick(R.id.btn_setting)
    public void jump2Setting() {
        //Toast.makeText(mActivity, "跳转到setting模块", Toast.LENGTH_SHORT).show();
        MainActivity activity = (MainActivity) mActivity;
        ContentFragment contentFragment = activity.getContentFragment();
        //跳转
        if (contentFragment.mViewPager != null) {
            contentFragment.mViewPager.setCurrentItem(4);
        }
        // 关闭当前
        DrawerLayout drawerLayout = activity.findViewById(R.id.drawable_layout);
        drawerLayout.closeDrawer(Gravity.START);
    }
}
