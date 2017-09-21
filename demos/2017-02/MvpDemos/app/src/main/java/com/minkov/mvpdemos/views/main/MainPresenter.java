package com.minkov.mvpdemos.views.main;

import com.minkov.mvpdemos.ui.ModalFactory;
import com.minkov.mvpdemos.ui.Notifier;

public class MainPresenter
        implements MainContracts.Presenter {
    private final MainContracts.View view;
    String[] names;

    public MainPresenter(MainContracts.View view, ModalFactory modalFactory, Notifier notifier) {
        this.view = view;

        this.getView().setPresenter(this);
        this.getView().setModalFactory(modalFactory);
        this.getView().setNotifier(notifier);

        this.names = new String[]{"John", "Jane"};
    }

    public void start() {
        this.getView().setNames(names);
    }

    @Override
    public MainContracts.View getView() {
        return this.view;
    }

    public void selectName(int position) {
        this.getView().navigateWith(this.names[position]);
        this.getView().notifyText(
                "Selected \"" + this.names[position] + "\""
        );
    }

    @Override
    public void add() {
        this.getView()
                .showAddView();
    }
}
