package com.example.projectdts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class SongDetailActivity extends AppCompatActivity {
    TextView tvTitleSong, tvArtist;
    ImageView imgSong;
    public static final String Key_RegisterActivity = "Key_RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        tvTitleSong = findViewById(R.id.title_song_detail);
        tvArtist = findViewById(R.id.artist_detail);
        imgSong = findViewById(R.id.img_song_detail);

        Song song = getIntent().getParcelableExtra(Key_RegisterActivity);

        String center = "https://image.flaticon.com/icons/png/512/13/13021.png";
        ImageView play = findViewById(R.id.img_play_song);
        Picasso.get().load(center).into(play);

        String right = "https://image.flaticon.com/icons/png/512/2088/2088519.png";
        ImageView next = findViewById(R.id.img_next_song);
        Picasso.get().load(right).into(next);

        String left = "https://image.flaticon.com/icons/png/512/2088/2088517.png";
        ImageView prev = findViewById(R.id.img_prev_song);
        Picasso.get().load(left).into(prev);

        tvTitleSong.setText(song.getTitle());
        tvArtist.setText(song.getArtist());
        Picasso.get().load(song.img).into(imgSong);

    }
}