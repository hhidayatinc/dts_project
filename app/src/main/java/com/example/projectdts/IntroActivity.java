package com.example.projectdts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class IntroActivity extends AppCompatActivity {

    public RecyclerView rv;
    public ArtistAdapter artistAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Artist> listArtist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);

        rv = findViewById(R.id.rv)
    }

    public void clickArtist(View view) {

    }
}