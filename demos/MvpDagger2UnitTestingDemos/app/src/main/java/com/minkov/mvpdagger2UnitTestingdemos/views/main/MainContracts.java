package com.minkov.mvpdagger2UnitTestingdemos.views.main;

import com.minkov.mvpdagger2UnitTestingdemos.ui.ModalFactory;
import com.minkov.mvpdagger2UnitTestingdemos.ui.Notifier;

import io.reactivex.Observable;

/**
 * Created by minkov on 2/15/17.
 */

public class MainContracts {
    public interface View {
        void notifyText(String text);

        void setPresenter(MainContracts.Presenter presenter);

        void navigateWith(String name);

        void showAddView();

        void setModalFactory(ModalFactory modalFactory);

        void setNotifier(Notifier notifier);

        void setNames(String[] names);
    }

    public interface Presenter {
        Observable<Boolean> start();

        MainContracts.View getView();

        void selectName(int index);

        void add();
    }
}
