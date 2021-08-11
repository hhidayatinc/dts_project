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

public class RecylerViewActivity extends AppCompatActivity implements ArtistAdapter.OnArtistClickListener{

    public RecyclerView rv;
    public ArtistAdapter artistAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Artist> listArtist = new ArrayList<>();
    Song song;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getSupportActionBar().hide();
//        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);

        setContentView(R.layout.activity_recyler_view);

        rv = findViewById(R.id.rvArtist);


        listArtist.add(new Artist("Teman Belajar",
                "",
                "https://image.flaticon.com/icons/png/512/747/747086.png", (List<Song>) song
        ));

        listArtist.add(new Artist("Ya Gitu",
                "",
                "https://image.flaticon.com/icons/png/512/747/747086.png", (List<Song>) song
        ));

        artistAdapter = new ArtistAdapter(listArtist);
        artistAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(artistAdapter);
        rv.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View view, int i) {
        Artist artist = listArtist.get(i);
        Intent intent =new Intent(RecylerViewActivity.this, RecyclerViewDetailActivity.class);
        startActivity(intent);
    }
}