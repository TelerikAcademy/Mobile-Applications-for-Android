package com.minkov.demos.mvp.models;

/**
 * Created by minkov on 9/27/17.
 */

public class Person {
  private String name;

  public Person(String name) {
    setName(name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
