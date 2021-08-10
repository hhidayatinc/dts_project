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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);

        setContentView(R.layout.activity_recyler_view);

        rv = findViewById(R.id.rvArtist);


        listArtist.add(new Artist("NCT DREAM",
                "NCT Dream is the third sub-unit of the South Korean boy band NCT, formed by SM Entertainment in 2016. The group debuted on August 25, 2016 with the single Chewing Gum",
                "https://www.mainmain.id/uploads/post/2020/04/14/NCT_Dream_comeback_Reload_1.jpg"
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