package com.minkov.demos.mvp.PersonDetails;

import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.base.BaseRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by minkov on 9/27/17.
 */

public class PersonDetailsPresenter implements PersonDetailsContacts.Presenter {
    private PersonDetailsContacts.View mView;

    private final BaseRepository<Person> mRepository;
    private String mPersonId;

    /**
     * Initializes a new {@link PersonDetailsPresenter}
     * @param repository a {@link BaseRepository} instance for loading data
     */
    @Inject
    public PersonDetailsPresenter(BaseRepository<Person> repository) {
        mRepository = repository;
    }

    @Override
    public void subscribe(PersonDetailsContacts.View view) {
        mView = view;
        reload();
    }

    private void reload() {
        if (mPersonId == null) {
            return;
        }
        
        mRepository.getById(mPersonId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<Person>() {
                    @Override
                    public void accept(Person person) throws Exception {
                        mView.setPerson(person);
                    }
                });
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public void setPersonId(String id) {
        mPersonId = id;
        reload();
    }
}
