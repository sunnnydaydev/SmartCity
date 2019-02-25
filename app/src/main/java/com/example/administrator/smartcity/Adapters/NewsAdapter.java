package com.example.administrator.smartcity.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.domain.News;

/**
 * Create by SunnyDay on 2019/02/25
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Holder> {
    private News news;
    private Context context;

    public NewsAdapter(News news, Context context) {
        this.news = news;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_news, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        Glide
                .with(context)
                .load(news.getData().get(i).getPicture())
                .into(holder.imageView);
        holder.desc.setText(news.getData().get(i).getTitle());
        holder.time.setText(news.getData().get(i).getDate());
        final String jumpUrl = news.getData().get(i).getUrl();
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(jumpUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        int size = news.getData().size();
        return news.getData() == null ? 0 : size;
    }

    class Holder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView desc;
        private final TextView time;
        private final RelativeLayout layout;

        public Holder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout);
            imageView = itemView.findViewById(R.id.img);
            desc = itemView.findViewById(R.id.desc);
            time = itemView.findViewById(R.id.time);
        }
    }
}
