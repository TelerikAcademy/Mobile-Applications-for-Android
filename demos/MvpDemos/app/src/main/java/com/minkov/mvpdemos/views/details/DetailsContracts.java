package com.minkov.mvpdemos.views.details;

import com.minkov.mvpdemos.Mvp;
import com.minkov.mvpdemos.models.Superhero;

/**
 * Created by minkov on 2/13/17.
 */

public class DetailsContracts {

    public interface View extends Mvp.BaseView<Presenter> {
        void setPresenter(DetailsContracts.Presenter presenter);

        void notify(String text);

        void setItemDetails(Superhero details);
    }

    public interface Presenter {

        void start(Object id);

        DetailsContracts.View getView();
    }
}
