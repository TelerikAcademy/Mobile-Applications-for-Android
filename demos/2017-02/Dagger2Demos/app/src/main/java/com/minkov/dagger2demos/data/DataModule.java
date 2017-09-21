package com.minkov.dagger2demos.data;

import android.content.Context;

import com.minkov.dagger2demos.data.base.BaseData;
import com.minkov.dagger2demos.models.Faction;
import com.minkov.dagger2demos.models.Superhero;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    Class<Superhero> provideSuperheroType() {
        return Superhero.class;
    }

    @Provides
    Class<Superhero[]> provideSuperheroesArrayType() {
        return Superhero[].class;
    }

    @Provides
    Class<Faction> provideFactionType() {
        return Faction.class;
    }

    @Provides
    Class<Faction[]> provideFactionsArrayType() {
        return Faction[].class;
    }

    @Provides
    ApiUrl<Superhero> provideSuperheroesApiUrl(@Named("baseApiUrl") String baseApiUrl) {
        ApiUrl<Superhero> apiUrl = new ApiUrl<>(baseApiUrl, "superheroes");
        return apiUrl;
    }

    @Provides
    ApiUrl<Faction> provideFactionsApiUrl(@Named("baseApiUrl") String baseApiUrl) {
        ApiUrl<Faction> apiUrl = new ApiUrl<>(baseApiUrl, "factions");
        return apiUrl;
    }

    @Provides
    BaseData<Superhero> providerSuperheroesData(ApiUrl<Superhero> apiUrl, Class<Superhero> klass, Class<Superhero[]> klassArray) {
        return new HttpData<>(apiUrl, klass, klassArray);
    }

    @Provides
    BaseData<Faction> provideFactionsData(ApiUrl<Faction> apiUrl, Class<Faction> klass, Class<Faction[]> klassArray) {
        return new HttpData<>(apiUrl, klass, klassArray);
    }
}
