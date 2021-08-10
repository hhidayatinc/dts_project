package com.example.projectdts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class RecyclerViewDetailActivity extends AppCompatActivity implements SongAdapter.OnSongClickListener{

    public RecyclerView rv;
    public SongAdapter songAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Song> listSong = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);

        setContentView(R.layout.activity_recycler_view_detail);

        rv = findViewById(R.id.rv_detail_artist);

        listSong.add(new Song("Hot Sauce", "3:15",
                "https://i.pinimg.com/564x/84/53/cf/8453cf7f8fb55bc6626359e3b298a638.jpg"));

        songAdapter = new SongAdapter(listSong);
        songAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(songAdapter);
        rv.setLayoutManager(layoutManager);
    }

    @Override
    public void onCLick(View view, int position) {
        Song song = listSong.get(position);
        Toast.makeText(this, song.getTitle(), Toast.LENGTH_LONG).show();
    }
}