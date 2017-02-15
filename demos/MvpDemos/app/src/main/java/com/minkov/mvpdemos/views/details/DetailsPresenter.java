package com.minkov.mvpdemos.views.details;

public class DetailsPresenter implements DetailsContracts.Presenter {
    private final DetailsContracts.View view;
    private String name;

    public DetailsPresenter(DetailsContracts.View view) {
        this.view = view;
        this.getView().setPresenter(this);
    }

    @Override
    public DetailsContracts.View getView() {
        return view;
    }

    @Override
    public void start() {

        this.getView().setDetails(name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
