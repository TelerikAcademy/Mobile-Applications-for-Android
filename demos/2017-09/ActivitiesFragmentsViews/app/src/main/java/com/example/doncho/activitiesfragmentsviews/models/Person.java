package com.example.doncho.activitiesfragmentsviews.models;

import java.io.Serializable;

/**
 * Created by doncho on 9/21/17.
 */

public class Person implements Serializable {
    private String mName;
    private int mAge;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setAge(int age) {
        this.mAge = age;
    }

    public int getAge() {
        return mAge;
    }
}
