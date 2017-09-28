package com.minkov.demos.mvp.PersonsLists;

import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.base.BaseRepository;

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
     * @param repository {@link BaseRepository} instance for loading the data
     * @return an instance of {@link com.minkov.demos.mvp.PersonsLists.PersonsListContracts.Presenter}
     */
    @Provides
    PersonsListContracts.Presenter providePersonsListPresenter(BaseRepository<Person> repository) {
        return new PersonsListPresenter(repository);
    }
}
