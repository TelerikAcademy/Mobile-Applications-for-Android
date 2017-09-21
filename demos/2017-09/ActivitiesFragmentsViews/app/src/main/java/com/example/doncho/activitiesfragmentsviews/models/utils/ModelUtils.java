package com.example.doncho.activitiesfragmentsviews.models.utils;

import com.example.doncho.activitiesfragmentsviews.models.Person;

/**
 * Created by doncho on 9/21/17.
 */

public class ModelUtils {
    public static Person[] getRandomPeople(int peopleCount) {
        Person[] people = new Person[peopleCount];
        for (int i = 0; i < peopleCount; i++) {
            String name = String.format("Person %d", i + 1);
            int age = (i + 10) % 100;
            people[i] = new Person(name, age);
        }

        return people;
    }
}
