package com.minkov.mvpdemos.views.main;

/**
 * Created by minkov on 2/15/17.
 */

public class MainContracts {
    public interface View {
        void setNames(String[] items);

        void notifyText(String text);

        void setPresenter(MainContracts.Presenter presenter);

        void navigateWith(String name);

        void showAddView();
    }

    public interface Presenter {
        void start();

        MainContracts.View getView();

        void selectName(int index);

        void add();
    }
}
