package com.minkov.navigationdemos.utis;

import java.io.Serializable;

public class DrawerItemInfo implements Serializable {
    private String title;
    private int id;

    public DrawerItemInfo(int id, String title) {
        this.setId(id);
        this.setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}