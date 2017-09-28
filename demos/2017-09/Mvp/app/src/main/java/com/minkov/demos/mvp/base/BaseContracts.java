package com.minkov.demos.mvp.base;

/**
 * Base contracts for MVP
 * Created by minkov on 9/27/17.
 */

public abstract class BaseContracts {
    /**
     * Base view for MVP
     *
     * @param <T> {@link BaseContracts.Presenter} class
     */
    public interface View<T extends Presenter> {
        /**
         * Sets the presenter
         *
         * @param presenter {@link Presenter} object
         */
        void setPresenter(T presenter);
    }

    /**
     * Base presenter for MVP
     *
     * @param <T> {@link BaseContracts.View} class
     */
    public interface Presenter<T extends View> {

        /**
         * Attaches the view to the presenter and the presenters starts preparing data
         * @param view the {@link View} of the presenter
         */
        void subscribe(T view);


        /**
         * Releases the presenter
         */
        void unsubscribe();
    }

    /**
     * Base router for MVP
     */
    public interface Router {

    }
}
