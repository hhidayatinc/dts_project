package com.example.projectdts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

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

//        getSupportActionBar().hide();
//        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);

        setContentView(R.layout.activity_recycler_view_detail);


        rv = findViewById(R.id.rv_detail_artist);

        listSong.add(new Song("Hot Sauce", "3:15",
                "https://i.pinimg.com/564x/84/53/cf/8453cf7f8fb55bc6626359e3b298a638.jpg",
                "NCT Dream"));

        listSong.add(new Song("Hello Future", "3:40",
                "https://i.pinimg.com/236x/98/9a/73/989a736e6e33ca7d428f606201ccc5a9.jpg",
                "NCT Dream"));

        listSong.add(new Song("Slow Motion","3:54",
                "https://i1.sndcdn.com/artworks-000114511443-qnrt2d-t500x500.jpg",
                "Karina Pasian"));

        listSong.add(new Song("The Only Exception", "4:27",
                "https://cdns-images.dzcdn.net/images/cover/1346bb36e5d61b9fea447a9b3ea50f54/350x350.jpg",
                "Paramore"));

        listSong.add(new Song("You Were Beautiful(예뻤어)", "4:43",
                "https://cdn.shopify.com/s/files/1/0275/5991/9694/products/s-l1600-3_1024x1024_50423a6c-baff-41f7-ba1c-721f9e7753de_1024x.png?v=1588923816",
                "DAY6"));

        listSong.add(new Song("Butter", "2:44",
                "https://static.wikia.nocookie.net/the-bangtan-boys/images/2/27/Butter_Cover.jpeg/revision/latest/scale-to-width-down/2000?cb=20210426151107",
                "BTS"));

        listSong.add(new Song("10,000 Hours", "2:48",
                "https://upload.wikimedia.org/wikipedia/commons/b/bf/Dan_%2B_Shay_and_Justin_Bieber_-_10%2C000_Hours.png", "Dan+Shay,Justin Bieber"));

        listSong.add(new  Song("Robbers", "4:15", "https://www.groove.pl/files/albums/big/the_1975_351995.jpg", "The 1975"));

        listSong.add(new Song("Man In The Mirror", "5:19",
                "https://i1.sndcdn.com/artworks-000206393695-gtqwch-t500x500.jpg", "Michael Jackson"));

        listSong.add(new Song("Blue Jeans", "3:31",
                "https://blue.kumparan.com/image/upload/fl_progressive,fl_lossy,c_fill,q_auto:best,w_640/v1591329897/zum8stw9cf5ojbgqwcem.jpg",
                "GANGGA"));

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