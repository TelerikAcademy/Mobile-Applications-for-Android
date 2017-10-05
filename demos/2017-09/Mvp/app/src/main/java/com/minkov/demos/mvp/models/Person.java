package com.minkov.demos.mvp.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Model for storing Person information
 * Contains Id and name
 */

@Entity(nameInDb = "person")
public class Person {
    @SuppressWarnings("CheckStyle")
    @Id
    private String id;

    @SuppressWarnings("CheckStyle")
    @Property(nameInDb = "name")
    private String name;

    /**
     * Empty constructor is necessary for GreenDao
     */
    public Person() {
        this("");
    }

    /**
     * Creates a Person instance
     * @param name a {@link String}
     */
    public Person(String name) {
        setName(name);
    }


    @Generated(hash = 376276960)
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
