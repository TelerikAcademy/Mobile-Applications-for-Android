package com.minkov.dagger2demos.models;

/**
 * Created by minkov on 2/10/17.
 */

public class Superhero {
    private String name;

    public Superhero(String name){
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
