package com.minkov.demos.httpasyncdemos.models;

/**
 * Created by minkov on 9/25/17.
 */

public class Person {
  private String name;
  private int age;

  public Person() {

  }

  public Person(String name, int age) {
    setName(name);
    setAge(age);
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }
}
