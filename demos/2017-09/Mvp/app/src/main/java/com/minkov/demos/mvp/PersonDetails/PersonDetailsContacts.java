package com.minkov.demos.mvp.PersonDetails;

import com.minkov.demos.mvp.base.BaseContracts;
import com.minkov.demos.mvp.models.Person;

/**
 * Contracts for PersonDetails {@link com.minkov.demos.mvp.base.BaseContracts.View},
 * {@link com.minkov.demos.mvp.base.BaseContracts.Presenter} and
 * {@link com.minkov.demos.mvp.base.BaseContracts.Router}
 * Created by minkov on 9/27/17.
 */
public interface PersonDetailsContacts {
    /**
     * Base view for PersonDetails
     */
    interface View extends BaseContracts.View<Presenter> {
        /**
         * Sets the presenter
         *
         * @param person object to visualize
         */
        void setPerson(Person person);
    }

    /**
     * Base presenter for PersonDetails
     */
    interface Presenter extends BaseContracts.Presenter<View> {

        /**
         * Prepate the person to load
         * @param id a {@link String}
         */
        void setPersonId(String id);
    }
}
