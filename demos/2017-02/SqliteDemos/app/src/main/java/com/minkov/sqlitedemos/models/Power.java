package com.minkov.sqlitedemos.models;

import com.orm.SugarRecord;

/**
 * Created by minkov on 2/10/17.
 */

public class Power extends SugarRecord {
    private String name;

    public Power(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
