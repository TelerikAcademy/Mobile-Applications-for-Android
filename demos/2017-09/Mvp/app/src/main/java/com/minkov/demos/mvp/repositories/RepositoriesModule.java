package com.minkov.demos.mvp.repositories;

import com.minkov.demos.mvp.http.HttpRequester;
import com.minkov.demos.mvp.http.Url;
import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.base.BaseRepository;
import com.minkov.demos.mvp.utils.JsonParser;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public class RepositoriesModule {
    /**
     * Provides a {@link BaseRepository} instance
     *
     * @param httpRequester create HTTP requests
     * @param jsonParser    parses strings to <T> objects
     * @param url           the url wrapper
     * @return a concrete instance of {@link BaseRepository}
     */
    @Provides
    BaseRepository<Person> providesData(HttpRequester httpRequester,
                                        JsonParser<Person> jsonParser,
                                        Url<Person> url) {
        return new GenericHttpRepository<>(httpRequester, jsonParser, url);
    }
}
