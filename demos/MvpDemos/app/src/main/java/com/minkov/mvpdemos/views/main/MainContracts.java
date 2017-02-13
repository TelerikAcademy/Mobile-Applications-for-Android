package com.minkov.mvpdemos.views.main;

import com.minkov.mvpdemos.Mvp;
import com.minkov.mvpdemos.models.Superhero;

/**
 * Created by minkov on 2/12/17.
 */

public class MainContracts {

    public interface View extends Mvp.BaseView<MainContracts.Presenter> {
        void setPresenter(MainContracts.Presenter presenter);

        void notify(String text);

        void setItems(String[] items);

        void navigateWith(Superhero superhero);
    }

    public interface Presenter {

        void start();

        MainContracts.View getView();

        void saveSuperhero(String name);

        void selectItem(int position);
    }
}
