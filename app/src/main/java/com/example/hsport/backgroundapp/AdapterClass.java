package com.example.hsport.backgroundapp;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;

import java.io.IOException;
import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
    ArrayList<Wallpaper> list;

    public AdapterClass(ArrayList<Wallpaper> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pic_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final String url;
        url = list.get(position).getWallpaper();
        Glide.with(holder.imageView).load(url).into(holder.imageView);

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), " Nember : " + position, Toast.LENGTH_SHORT).show();
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(view.getContext());

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        View view;
        AppCompatImageView imageView;
        Button btn;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            imageView = view.findViewById(R.id.ivTwo);
            btn = view.findViewById(R.id.btnDownload);


        }

    }
}

