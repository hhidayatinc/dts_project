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
    public RecyclerViewDetailActivity song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);

        setContentView(R.layout.activity_recyler_view);

        rv = findViewById(R.id.rvArtist);


        listArtist.add(new Artist("NCT DREAM",
                "NCT Dream is the third sub-unit of the South Korean boy band NCT, formed by SM Entertainment in 2016 as the then teen-aged unit of NCT. The group debuted on August 25, 2016 with the single",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.scmp.com%2Flifestyle%2Fk-pop%2Fnews%2Farticle%2F3132330%2Fk-pop-group-nct-dream-and-baby-shark-creators-team-dinosaurs-z&psig=AOvVaw1tZ84oPhF9cB1c7gUrny1h&ust=1628695328200000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCPDqyI3hpvICFQAAAAAdAAAAABAD",
                song.listSong
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