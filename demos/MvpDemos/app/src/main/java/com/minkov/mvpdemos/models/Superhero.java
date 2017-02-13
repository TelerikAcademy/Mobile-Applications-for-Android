package com.minkov.mvpdemos.models;

/**
 * Created by minkov on 2/12/17.
 */

public class Superhero extends ModelBase {
    private String name;

    public Superhero(String id, String name) {
        super(id);
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
