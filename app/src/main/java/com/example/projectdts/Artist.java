package com.example.projectdts;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Artist  {
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


}