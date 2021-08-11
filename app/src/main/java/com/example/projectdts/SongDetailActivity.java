package com.example.projectdts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class SongDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);

        setContentView(R.layout.activity_song_detail);

        String center = "https://image.flaticon.com/icons/png/512/13/13021.png";
        ImageView play = findViewById(R.id.img_play_song);
        Picasso.get().load(center).into(play);

        String right = "https://image.flaticon.com/icons/png/512/2088/2088519.png";
        ImageView next = findViewById(R.id.img_next_song);
        Picasso.get().load(right).into(next);

        String left = "https://image.flaticon.com/icons/png/512/2088/2088517.png";
        ImageView prev = findViewById(R.id.img_prev_song);
        Picasso.get().load(left).into(prev);


    }
}