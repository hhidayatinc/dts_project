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

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder> {

    private List<Artist> listArtist = new ArrayList<>();

    public ArtistAdapter(List<Artist> listArtist) {
        this.listArtist = listArtist;
    }

    private OnArtistClickListener listener;

    public interface OnArtistClickListener {
        public void onClick(View view, int i);
    }

    public void setListener(OnArtistClickListener listener) { this.listener = listener;}
    @NonNull
    @Override
    public ArtistAdapter.ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_artist, parent, false);

        ArtistViewHolder artVh = new ArtistViewHolder(v);
        return artVh;
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistViewHolder holder, int position) {
        Artist artist = listArtist.get(position);
        holder.txtArtistName.setText(artist.getName());
        holder.txtDesc.setText(artist.getDesc());
        Picasso.get().load(artist.getImgUrl())
                .into(holder.imgArtist);

    }

    @Override
    public int getItemCount() {
        return listArtist.size();
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
