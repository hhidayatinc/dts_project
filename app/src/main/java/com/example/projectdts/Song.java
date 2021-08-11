package com.example.projectdts;

import android.os.Parcel;
import android.os.Parcelable;

public class Song  {
    String title;
    String duration;
    String img;
    String artist;

    public Song(String title, String duration, String img, String artist) {
        this.title = title;
        this.duration = duration;
        this.img = img;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
