package com.minkov.demos.mvp.PersonsLists;

import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.base.BaseRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by minkov on 9/27/17.
 */

public class PersonsListPresenter implements PersonsListContracts.Presenter {
    private final BaseRepository<Person> mRepository;
    private PersonsListContracts.View mView;
    private Person[] mPersons;
    private PersonsListContracts.Router mRouter;

    /**
     * Initializes a new {@link PersonsListPresenter}
     *
     * @param repository a {@link BaseRepository} instance for loading repository
     */
    public PersonsListPresenter(BaseRepository<Person> repository) {
        mRepository = repository;
    }

    @Override
    public void subscribe(PersonsListContracts.View view) {
        mView = view;

        mRepository.getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<Person[]>() {
                    @Override
                    public void accept(Person[] persons) throws Exception {
                        mPersons = persons;
                        mView.setPersons(persons);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public void onPersonSelect(int index) {
        mRouter.showDetails(mPersons[index]);
    }

    @Override
    public void setRouter(PersonsListContracts.Router router) {
        mRouter = router;
    }
}
