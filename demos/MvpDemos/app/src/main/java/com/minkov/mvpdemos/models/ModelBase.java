package com.minkov.mvpdemos.models;

import java.io.Serializable;

/**
 * Created by minkov on 2/12/17.
 */

public class ModelBase implements Serializable {
    private String id;

    public ModelBase(String id) {
        this.setId(id);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
