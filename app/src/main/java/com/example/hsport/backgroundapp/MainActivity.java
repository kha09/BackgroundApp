package com.example.hsport.backgroundapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.Manifest;
import android.app.WallpaperManager;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    AppCompatImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        imageView = findViewById(R.id.ivOne);
//        button = findViewById(R.id.setBtn);
//
//        PackageManager pm = getPackageManager();
//        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.cof);
//        if(pm.checkPermission(Manifest.permission.SET_WALLPAPER, getPackageName()) == PackageManager.PERMISSION_GRANTED){
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
//                    try{
//                        wallpaperManager.setResource(R.drawable.cof);
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }else{
//
//        }

    }
}
