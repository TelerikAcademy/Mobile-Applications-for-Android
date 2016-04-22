package com.minkov.thetwitterapp.models;

import java.io.Serializable;

/**
 * Created by dminkov on 4/22/2016.
 */
public class Tweet implements Serializable {
    private int id;
    private String text;

    public Tweet(int id, String text){
        this.setId(id);
        this.setText(text);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
