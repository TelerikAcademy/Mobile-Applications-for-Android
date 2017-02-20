package com.minkov.mvpdagger2UnitTestingdemos.views.details;

import com.minkov.mvpdagger2UnitTestingdemos.models.Superhero;

import io.reactivex.Observable;

/**
 * Created by minkov on 2/15/17.
 */

public class DetailsContracts {
    public interface View {
        void setDetails(Superhero detail);

        void setPresenter(DetailsContracts.Presenter presenter);
    }

    public interface Presenter {
        DetailsContracts.View getView();

        Observable<Boolean> start();

        void setId(String name);
    }
}
