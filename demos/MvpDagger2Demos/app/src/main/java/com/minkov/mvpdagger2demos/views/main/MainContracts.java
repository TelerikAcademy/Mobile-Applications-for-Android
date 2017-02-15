package com.minkov.mvpdagger2demos.views.main;

import com.minkov.mvpdagger2demos.models.Superhero;
import com.minkov.mvpdagger2demos.ui.ModalFactory;
import com.minkov.mvpdagger2demos.ui.Notifier;

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
        void start();

        MainContracts.View getView();

        void selectName(int index);

        void add();
    }
}
