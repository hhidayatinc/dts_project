package com.example.projectdts;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.duration);
        dest.writeString(this.img);
        dest.writeString(this.artist);
    }

    public void readFromParcel(Parcel source) {
        this.title = source.readString();
        this.duration = source.readString();
        this.img = source.readString();
        this.artist = source.readString();
    }

    protected Song(Parcel in) {
        this.title = in.readString();
        this.duration = in.readString();
        this.img = in.readString();
        this.artist = in.readString();
    }

    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel source) {
            return new Song(source);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
}
