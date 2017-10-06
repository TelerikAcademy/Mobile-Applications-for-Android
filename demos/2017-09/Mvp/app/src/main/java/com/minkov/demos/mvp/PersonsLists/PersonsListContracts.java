package com.minkov.demos.mvp.PersonsLists;

import com.minkov.demos.mvp.base.BaseContracts;
import com.minkov.demos.mvp.models.Person;

import java.util.List;

/**
 * Contracts for PersonsList {@link com.minkov.demos.mvp.base.BaseContracts.View},
 * {@link com.minkov.demos.mvp.base.BaseContracts.Presenter} and
 * {@link com.minkov.demos.mvp.base.BaseContracts.Router}
 * Created by minkov on 9/27/17.
 */
public interface PersonsListContracts {
    /**
     * Base view for PersonsList
     */
    interface View extends BaseContracts.View<Presenter> {
        /**
         * Sets the presenter
         *
         * @param persons array of objects to visualize
         */
        void setPersons(List<Person> persons);

        /**
         * Show loading screen
         */
        void showLoadingScreen();

        /**
         * Hide loading screen
         */
        void hideLoadingScreen();
    }

    /**
     * Base presenter for PersonsList
     */
    interface Presenter extends BaseContracts.ViewStatePresenter<View, ViewState> {
        /**
         * React on selection of a person object
         *
         * @param index the index of the person
         */
        void onPersonSelect(int index);

        /**
         * Sets the a {@link Router} instance
         *
         * @param router the router
         */
        void setRouter(Router router);
    }

    /**
     * Contract for PersonsList navigation
     */
    interface Router extends BaseContracts.Router {
        /**
         * Handle the navigation
         *
         * @param obj the object to navigate with
         */
        void showDetails(Person obj);
    }

    interface ViewState extends BaseContracts.ViewState {
        void setPersons(List<Person> persons);

        List<Person> getPersons();

        void setHasCache(boolean hasCache);

        boolean getHasCache();
    }
}
