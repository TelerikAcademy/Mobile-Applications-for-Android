package com.minkov.mvpdemos.http;

import com.minkov.mvpdemos.http.base.IHttpRequester;
import com.minkov.mvpdemos.models.Superhero;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 2/13/17.
 */

@Module
public class HttpModule {

    @Provides
    Class<Superhero> provideSuperheroClass() {
        return Superhero.class;
    }

    @Provides
    Class<Superhero[]> provideSuperheroesArrayClass() {
        return Superhero[].class;
    }

    @Provides
    @Named("baseApiUrl")
    String provideBaseApiUrl() {
        return "http://192.168.153.31:3001";
    }

    @Provides
    ApiUrl<Superhero> provideSuperheroesApiUrl(@Named("baseApiUrl") String baseApiUrl) {
        return new ApiUrl<>(baseApiUrl, "superheroes");
    }

    @Provides
    IHttpRequester provideHttpRequester() {
        return new HttpRequester();
    }
}
