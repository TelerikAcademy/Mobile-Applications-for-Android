package com.minkov.mvpdemos.views.main;

import com.minkov.mvpdemos.ui.ModalFactory;
import com.minkov.mvpdemos.ui.Notifier;

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

        void setModalFactory(ModalFactory modalFactory);

        void setNotifier(Notifier notifier);
    }

    public interface Presenter {
        void start();

        MainContracts.View getView();

        void selectName(int index);

        void add();
    }
}
