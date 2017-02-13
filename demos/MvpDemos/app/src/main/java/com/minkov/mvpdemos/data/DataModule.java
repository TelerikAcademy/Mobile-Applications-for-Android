package com.minkov.mvpdemos.data;

import com.minkov.mvpdemos.data.base.IData;
import com.minkov.mvpdemos.http.HttpRequester;
import com.minkov.mvpdemos.models.Superhero;
import com.minkov.mvpdemos.http.ApiUrl;
import com.minkov.mvpdemos.utils.base.IParser;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 2/13/17.
 */

@Module
public class DataModule {
    @Provides
    IData<Superhero> provideSuperheroData(HttpRequester httpRequester, @Named("json") IParser<Superhero> jsonParser, ApiUrl<Superhero> apiUrl) {
        return new HttpData<>(httpRequester, jsonParser, apiUrl);
    }
}
