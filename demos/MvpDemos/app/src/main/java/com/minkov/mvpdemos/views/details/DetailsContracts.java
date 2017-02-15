package com.minkov.mvpdemos.views.details;

/**
 * Created by minkov on 2/15/17.
 */

public class DetailsContracts {
    public interface View {
        void setDetails(String detail);

        void setPresenter(DetailsContracts.Presenter presenter);
    }

    public interface Presenter {
        DetailsContracts.View getView();

        void start();

        void setName(String name);
    }
}
