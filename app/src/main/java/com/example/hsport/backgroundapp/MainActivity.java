package com.example.hsport.backgroundapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.WallpaperManager;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private ArrayList<Wallpaper>list;
    private RecyclerView recyclerView;
    private AdapterClass adapterClass;
    private static final String TAG = "firelog";
    AppCompatImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvOne);
        list = new ArrayList<>();
        adapterClass = new AdapterClass(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapterClass);
        firebaseFirestore = firebaseFirestore.getInstance();

        firebaseFirestore.collection("Wallpaper").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e != null){
                    Log.d(TAG, "Error :" + e.getMessage());
                }
                for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()){
                    if(doc.getType()== DocumentChange.Type.ADDED){
                        Wallpaper wallpaper = doc.getDocument().toObject(Wallpaper.class);
                        list.add(wallpaper);

                        adapterClass.notifyDataSetChanged();
                    }
                }
            }
        });

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
