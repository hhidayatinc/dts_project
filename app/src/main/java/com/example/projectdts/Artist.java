package com.example.projectdts;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Artist implements Parcelable {
    String name;
    String desc;
    String imgUrl;
    List<Song> listSong;

    public Artist(String name, String desc, String imgUrl, List<Song> listSong) {
        this.name = name;
        this.desc = desc;
        this.imgUrl = imgUrl;
        this.listSong = listSong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Song> getListSong() {
        return listSong;
    }

    public void setListSong(List<Song> listSong) {
        this.listSong = listSong;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.desc);
        dest.writeString(this.imgUrl);
        dest.writeList(this.listSong);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.desc = source.readString();
        this.imgUrl = source.readString();
        this.listSong = new ArrayList<Song>();
        source.readList(this.listSong, Song.class.getClassLoader());
    }

    public Artist() {
    }

    protected Artist(Parcel in) {
        this.name = in.readString();
        this.desc = in.readString();
        this.imgUrl = in.readString();
        this.listSong = new ArrayList<Song>();
        in.readList(this.listSong, Song.class.getClassLoader());
    }

    public static final Parcelable.Creator<Artist> CREATOR = new Parcelable.Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel source) {
            return new Artist(source);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };
}
