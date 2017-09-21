package com.minkov.mvpdagger2demos.models;

import com.minkov.mvpdagger2demos.models.base.ModelBase;

/**
 * Created by minkov on 2/15/17.
 */

public class Superhero implements ModelBase {
    private String id;
    private String name;

    public Superhero(String name) {
        this(null, name);
    }

    public Superhero(String id, String name) {
        this.setId(id);
        this.setName(name);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
