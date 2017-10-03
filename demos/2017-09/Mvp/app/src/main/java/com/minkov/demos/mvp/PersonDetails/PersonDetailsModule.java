package com.minkov.demos.mvp.PersonDetails;

import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.base.BaseRepository;
import com.minkov.demos.mvp.utils.schedulers.BaseSchedulerProvider;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public class PersonDetailsModule {
    /**
     * Provides a concrete presenter for {@link com.minkov.demos.mvp.PersonDetails.PersonDetailsContacts.Presenter}
     *
     * @param repository {@link BaseRepository} instance for loading the data
     * @param schedulerProvider {@link BaseSchedulerProvider} instance for control of the async operations
     * @return an instance of {@link PersonDetailsContacts.Presenter}
     */
    @Provides
    PersonDetailsContacts.Presenter providePersonDetailsPresenter(
            @Named("remote") BaseRepository<Person> repository,
            BaseSchedulerProvider schedulerProvider) {
        return new PersonDetailsPresenter(repository, schedulerProvider);
    }
}
