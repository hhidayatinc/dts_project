package com.example.projectdts;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Playlist implements Parcelable {
    String name;
    String imgUrl;
    List<Song> song;

    public Playlist(String name, String imgUrl, List<Song> song) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.song = song;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.imgUrl);
        dest.writeTypedList(this.song);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.imgUrl = source.readString();
        this.song = source.createTypedArrayList(Song.CREATOR);
    }

    protected Playlist(Parcel in) {
        this.name = in.readString();
        this.imgUrl = in.readString();
        this.song = in.createTypedArrayList(Song.CREATOR);
    }

    public static final Parcelable.Creator<Playlist> CREATOR = new Parcelable.Creator<Playlist>() {
        @Override
        public Playlist createFromParcel(Parcel source) {
            return new Playlist(source);
        }

        @Override
        public Playlist[] newArray(int size) {
            return new Playlist[size];
        }
    };
}