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


    public Artist(String name, String desc, String imgUrl) {
        this.name = name;
        this.desc = desc;
        this.imgUrl = imgUrl;

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




}