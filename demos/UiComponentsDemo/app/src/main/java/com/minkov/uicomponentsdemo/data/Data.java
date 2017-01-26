package com.minkov.uicomponentsdemo.data;

import com.minkov.uicomponentsdemo.models.Superhero;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Data {
    private static ArrayList<Superhero> superheroes;

    static {
        superheroes = new ArrayList<>();
    }

    public List<Superhero> getAllSuperheroes() {
        return new ArrayList<>(superheroes);
    }

    public Superhero addSuperhero(String name, String secretIdentity, String imgUrl) {
        String id = String.format("Superhero-id-%d", superheroes.size());
        Superhero newSuperhero = new Superhero(id, name, secretIdentity, imgUrl);
        superheroes.add(newSuperhero);
        return newSuperhero;
    }

    public Superhero getSuperheroById(String id) {
        for (Superhero superhero : superheroes) {
            if (superhero.getId().equals(id)) {
                return superhero;
            }
        }
        return null;
    }
}
