package com.example.projectdts;

import android.os.Parcel;
import android.os.Parcelable;

public class Song  {
    String title;
    String duration;
    String img;

    public Song(String title, String duration, String img) {
        this.title = title;
        this.duration = duration;
        this.img = img;
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


}
