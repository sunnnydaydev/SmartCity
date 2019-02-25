package com.example.administrator.smartcity.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.smartcity.R;
import com.example.administrator.smartcity.domain.Photo;

/**
 * Create by SunnyDay on 2019/02/25
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyViewHolder> {
    private Photo photo;
    private Context context;

    public PhotoAdapter(Photo photo, Context context) {
        this.photo = photo;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_photo, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(photo.getResults().get(i).getWho());
        myViewHolder.desc.setText(photo.getResults().get(i).getDesc());
        Glide.with(context)
                .load(photo.getResults().get(i).getUrl())
                .into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        int size = photo.getResults().size();
        return photo.getResults() == null ? 0 : size;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView name;
        private final TextView desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.desc);
        }
    }
}
