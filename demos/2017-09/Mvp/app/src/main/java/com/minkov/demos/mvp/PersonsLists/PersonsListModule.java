package com.minkov.demos.mvp.PersonsLists;

import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.base.BaseRepository;
import com.minkov.demos.mvp.utils.schedulers.BaseSchedulerProvider;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module()
public class PersonsListModule {
    /**
     * Provides a concrete presenter for {@link com.minkov.demos.mvp.PersonsLists.PersonsListContracts.Presenter }
     *
     * @param httpRepository {@link BaseRepository} instance for loading the data from HTTP
     * @param cacheRepository {@link BaseRepository} instance for loading the data from the cache
     * @param schedulerProvider {@link BaseSchedulerProvider} instance for control of the async operations
     * @return an instance of {@link com.minkov.demos.mvp.PersonsLists.PersonsListContracts.Presenter}
     */
    @Provides
    PersonsListContracts.Presenter providePersonsListPresenter(
            @Named("remote") BaseRepository<Person> httpRepository,
            @Named("cache") BaseRepository<Person> cacheRepository,
            BaseSchedulerProvider schedulerProvider
    ) {
        return new PersonsListPresenter(httpRepository, cacheRepository, schedulerProvider);
    }
}
