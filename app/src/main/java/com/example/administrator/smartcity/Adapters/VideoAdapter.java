package com.example.administrator.smartcity.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.activities.VideoActivity;
import com.example.administrator.smartcity.domain.VideoBeans;

import java.util.List;

/**
 * Create by SunnyDay on 2019/02/26
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.Holder> {
    private VideoBeans videoBeans;
    private Context mContext;

    public VideoAdapter(Context mContext, VideoBeans videoBeans) {
        this.mContext = mContext;
        this.videoBeans = videoBeans;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        view = LayoutInflater.from(mContext).inflate(R.layout.video_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        final String jumpurl = videoBeans.getVideo().get(i).getJumpurl();
        Glide
                .with(mContext)
                .load(videoBeans.getVideo().get(i).getPictureUrl())
                .into(holder.img);
        holder.title.setText(videoBeans.getVideo().get(i).getTitle());
        holder.time.setText(videoBeans.getVideo().get(i).getData());
        holder.from.setText(videoBeans.getVideo().get(i).getFrom());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo 跳转界面传递url
               // Toast.makeText(mContext, "跳转ing", Toast.LENGTH_SHORT).show();
               // 为了方便数据弄成了同一的url播放（参见json）
                Intent intent = new Intent(mContext,VideoActivity.class);
                intent.putExtra("jump_url",jumpurl);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        int size = videoBeans.getVideo().size();
        return videoBeans == null ? 0 : size;
    }

    class Holder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView title;
        private final TextView time;
        private final TextView from;
        private final RelativeLayout layout;

        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.desc);
            time = itemView.findViewById(R.id.time);
            from = itemView.findViewById(R.id.from);

            layout = itemView.findViewById(R.id.layout);
        }
    }
}
