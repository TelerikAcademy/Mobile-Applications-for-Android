package com.minkov.demos.mvp.PersonsLists;

import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.base.BaseRepository;
import com.minkov.demos.mvp.utils.schedulers.BaseSchedulerProvider;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Implementation of {@link com.minkov.demos.mvp.PersonsLists.PersonsListContracts.Presenter}
 * Created by minkov on 9/27/17.
 */

public class PersonsListPresenter implements PersonsListContracts.Presenter {
    private final BaseRepository<Person> mHttpRepository;
    private final BaseRepository<Person> mCacheRepository;

    private final BaseSchedulerProvider mScheduleProvider;

    private PersonsListContracts.View mView;
    private PersonsListContracts.Router mRouter;

    private PersonsListContracts.ViewState mViewState;

    /**
     * Creates a {@link PersonsListPresenter} instance
     *
     * @param httpRepository    - instance of {@link BaseRepository} to providing persons from http
     * @param cacheRepository   - instance of {@link BaseRepository} to providing persons from cache
     * @param schedulerProvider - instance of {@link BaseSchedulerProvider} for providing types of async operations
     */
    public PersonsListPresenter(
            BaseRepository<Person> httpRepository,
            BaseRepository<Person> cacheRepository,
            BaseSchedulerProvider schedulerProvider) {
        mHttpRepository = httpRepository;
        mCacheRepository = cacheRepository;
        mScheduleProvider = schedulerProvider;
    }

    @Override
    public void subscribe(PersonsListContracts.View view) {
        mView = view;
        load();
    }

    private void load() {
        mView.showLoadingScreen();
        Observable<List<Person>> observable = mViewState.getHasCache()
                ? mCacheRepository.getAll()
                : mHttpRepository.getAll();

        observable
                .subscribeOn(mScheduleProvider.io())
                .observeOn(mScheduleProvider.ui())
                .subscribe(new Consumer<List<Person>>() {
                    @Override
                    public void accept(List<Person> persons) throws Exception {
                        mViewState.setPersons(persons);
                        mViewState.setHasCache(true);
                        updateCache();
                        mView.setPersons(mViewState.getPersons());
                        mView.hideLoadingScreen();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }

    private void updateCache() {
        mCacheRepository.clear();
        for (Person person
                : mViewState.getPersons()) {
            mCacheRepository.add(person);
        }
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public void onPersonSelect(int index) {
        mRouter.showDetails(mViewState.getPersons().get(index));
    }

    @Override
    public void setRouter(PersonsListContracts.Router router) {
        mRouter = router;
    }

    @Override
    public void setViewState(PersonsListContracts.ViewState viewState) {
        mViewState = viewState;
    }

    @Override
    public PersonsListContracts.ViewState getViewState() {
        return mViewState;
    }
}
