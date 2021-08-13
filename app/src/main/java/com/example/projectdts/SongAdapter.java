package com.example.projectdts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private List<Song> listSong = new ArrayList<>();

    public SongAdapter(List<Song> listSong){this.listSong = listSong;}

    private OnSongClickListener listener;

    public interface OnSongClickListener {
        public void onCLick(View view, int position);
    }

    public void setListener(OnSongClickListener listener) {this.listener = listener;}

    @NonNull
    @Override
    public SongAdapter.SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.playlist_detail, parent, false);

        SongViewHolder vh = new SongViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder songViewHolder, int i) {
        Song item = listSong.get(i);
        songViewHolder.txtSongTitle.setText(item.getTitle());
        songViewHolder.txtSongDuration.setText(item.getDuration());
        songViewHolder.txtSongArtist.setText(item.getArtist());
        Picasso.get().load(item.getImg()).into(songViewHolder.imgSong);
    }

    @Override
    public int getItemCount() {
        return listSong.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgSong;
        public TextView txtSongTitle, txtSongDuration, txtSongArtist;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);

            imgSong = itemView.findViewById(R.id.imgSong);
            txtSongTitle = itemView.findViewById(R.id.song_title);
            txtSongDuration = itemView.findViewById(R.id.song_duration);
            txtSongArtist = itemView.findViewById(R.id.song_artist);
            itemView.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    listener.onCLick(v, getAdapterPosition());
                }
            });
        }
    }
}
