package com.minkov.demos.mvp.http;

import com.minkov.demos.mvp.models.Person;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public class HttpModule {
    static final String PEOPLE_URL_SUFFIX = "api/people/";

    private Map<String, Url> mUrls;

    /**
     * @param baseUrl the url base of the RESTful API
     * @param klass   used only so the Dagger can differentiate urls for different RESTful API endpoints
     * @return the wrapper url for the person entity
     */

    @Provides
    Url<Person> providePersonsUrl(@Named("base-url") String baseUrl, Class<Person> klass) {
        if (mUrls == null) {
            mUrls = new HashMap<>();
        }

        if (mUrls.containsKey(PEOPLE_URL_SUFFIX) == false) {
            mUrls.put(PEOPLE_URL_SUFFIX, new Url<>(baseUrl + PEOPLE_URL_SUFFIX));
        }

        return mUrls.get(PEOPLE_URL_SUFFIX);
    }
}
