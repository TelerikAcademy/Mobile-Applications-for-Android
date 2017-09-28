package com.minkov.demos.mvp.models;

/**
 * Created by minkov on 9/27/17.
 */

@SuppressWarnings("checkstyle:all")
public class Person {
    private String name;
    private String id;
    //CHECKSTYLE:ON

    /**
     * Creates a person
     * @param name a {@link String}
     */
    public Person(String name) {
        this(null, name);
    }

    /**
     * Creates a person
      * @param id a {@link String}
     * @param name a {@link String}
     */
    public Person(String id, String name) {
        setId(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
