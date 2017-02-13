package com.minkov.mvpdemos;

/**
 * Created by minkov on 2/12/17.
 */

public class Mvp {
    public interface BaseView<T> {
        void setPresenter(T presenter);
    }
}
