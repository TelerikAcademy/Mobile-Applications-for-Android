package com.minkov.demos.mvp.models;

/**
 * Created by minkov on 9/27/17.
 */

public class Person {
  private String name;
  private String id;

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
