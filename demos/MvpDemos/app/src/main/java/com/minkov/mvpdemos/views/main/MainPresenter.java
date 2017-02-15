package com.minkov.mvpdemos.views.main;

public class MainPresenter
        implements MainContracts.Presenter {
    private final MainContracts.View view;
    String[] names;

    public MainPresenter(MainContracts.View view) {
        this.view = view;
        this.getView().setPresenter(this);
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
