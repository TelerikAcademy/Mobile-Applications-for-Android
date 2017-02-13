package com.minkov.mvpdemos.utils;

import com.minkov.mvpdemos.models.Superhero;
import com.minkov.mvpdemos.utils.base.IParser;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 2/13/17.
 */

@Module
public class UtilsModule {

    @Provides
    @Named("json")
    IParser<Superhero> provideSuperheroesJsonParser(Class<Superhero> klass, Class<Superhero[]> klassMany) {
        return new JsonParser<>(klass, klassMany);
    }
}
