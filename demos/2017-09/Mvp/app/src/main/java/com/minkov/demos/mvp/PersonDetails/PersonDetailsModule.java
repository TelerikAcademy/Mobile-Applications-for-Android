package com.minkov.demos.mvp.PersonDetails;

import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.base.BaseRepository;

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
     * @return an instance of {@link PersonDetailsContacts.Presenter}
     */
    @Provides
    PersonDetailsContacts.Presenter providePersonDetailsPresenter(BaseRepository<Person> repository) {
        return new PersonDetailsPresenter(repository);
    }
}
