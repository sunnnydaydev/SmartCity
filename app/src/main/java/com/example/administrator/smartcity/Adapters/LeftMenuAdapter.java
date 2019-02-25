package com.example.administrator.smartcity.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.domain.NewsCenter;

/**
 * Create by SunnyDay on 2019/02/24
 */
public class LeftMenuAdapter extends RecyclerView.Adapter<LeftMenuAdapter.MyViewHolder> {
    private Context mContext;
    private NewsCenter mNewsCenter;

    public LeftMenuAdapter(Context mContext, NewsCenter mNewsCenter) {
        this.mNewsCenter = mNewsCenter;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.leftmenu_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.textView.setText(mNewsCenter.getData().get(i).getTitle());
        myViewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,  myViewHolder.textView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mNewsCenter.getData().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public final TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_text);
        }
    }
}
