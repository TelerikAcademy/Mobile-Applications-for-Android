package com.minkov.sqlitedemos.models;

import com.orm.SugarRecord;

public class Superhero extends SugarRecord {
    private String name;

    private Power[] powers;

    public Superhero() {

    }

    public Superhero(String name, Power[] powers) {
        this.name = name;
        this.powers = powers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Power[] getPowers() {
        return powers;
    }

    public void setPowers(Power[] powers) {
        this.powers = powers;
    }
}
