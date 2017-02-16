package com.minkov.mvpdagger2UnitTestingdemos.views.details;

import com.minkov.mvpdagger2UnitTestingdemos.models.Superhero;

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

        void start();

        void setId(String name);
    }
}
