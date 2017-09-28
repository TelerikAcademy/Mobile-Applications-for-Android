package com.minkov.demos.mvp.models;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public class ModelsModule {

    /**
     * Provider for Person.class
     *
     * @return the type for {@link Person}
     */
    @Provides
    Class<Person> providePersonClass() {
        return Person.class;
    }

    /**
     * Provider for Person[].class
     *
     * @return the type for array of {@link Person[]}
     */
    @Provides
    Class<Person[]> providePersonArrayClass() {
        return Person[].class;
    }
}
