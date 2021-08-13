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

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ArtistViewHolder> {

    private List<Playlist> listPlaylist = new ArrayList<>();

    public PlaylistAdapter(List<Playlist> listPlaylist) {
        this.listPlaylist = listPlaylist;
    }

    private OnArtistClickListener listener;

    public interface OnArtistClickListener {
        public void onClick(View view, int i);
    }

    public void setListener(OnArtistClickListener listener) { this.listener = listener;}
    @NonNull
    @Override
    public PlaylistAdapter.ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_artist, parent, false);

        ArtistViewHolder artVh = new ArtistViewHolder(v);
        return artVh;
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistViewHolder holder, int position) {
        Playlist playlist = listPlaylist.get(position);
        holder.txtArtistName.setText(playlist.getName());
        holder.txtDesc.setText(playlist.getDesc());
        Picasso.get().load(playlist.getImgUrl())
                .into(holder.imgArtist);

    }

    @Override
    public int getItemCount() {
        return listPlaylist.size();
    }

    public class ArtistViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgArtist;
        public TextView txtArtistName, txtDesc;


        public ArtistViewHolder(@NonNull View itemView) {
            super(itemView);

            imgArtist = itemView.findViewById(R.id.img_artist);
            txtArtistName = itemView.findViewById(R.id.artist);
            txtDesc = itemView.findViewById(R.id.artist_desc);
            itemView.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    listener.onClick(v, getAdapterPosition());
                }
            });
        }
    }
}
