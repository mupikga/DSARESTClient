package com.example.restexample.API;
import java.io.Serializable;


public class Track implements  Serializable{
    String title;
    String singer;

    public Track(String title, String singer) {
        this.setSinger(singer);
        this.setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Track [title=" + title + ", singer=" + singer +"]";
    }

}
