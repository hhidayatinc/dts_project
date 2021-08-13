package com.example.projectdts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class RecylerViewActivity extends AppCompatActivity implements PlaylistAdapter.OnArtistClickListener{

    public RecyclerView rv;
    public PlaylistAdapter playlistAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Playlist> listPlaylist = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);

        setContentView(R.layout.activity_recyler_view);

        rv = findViewById(R.id.rvArtist);




        playlistAdapter = new PlaylistAdapter(listPlaylist);
        playlistAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(playlistAdapter);
        rv.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View view, int i) {
        Playlist playlist = listPlaylist.get(i);
        Intent intent =new Intent(RecylerViewActivity.this, RecyclerViewDetailActivity.class);
        startActivity(intent);
    }
}