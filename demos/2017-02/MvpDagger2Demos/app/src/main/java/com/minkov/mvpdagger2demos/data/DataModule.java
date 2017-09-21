package com.minkov.mvpdagger2demos.data;

import com.minkov.mvpdagger2demos.models.Superhero;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {
    @Provides
    LocalData<Superhero> provideSuperheroesData() {
        LocalData<Superhero> data = new LocalData<>();

        data.add(new Superhero("id-1", "Pesho"));
        data.add(new Superhero("id-2", "Gosho"));
        data.add(new Superhero("id-3", "John"));
        data.add(new Superhero("id-4", "Jane"));

        return data;
    }
}
