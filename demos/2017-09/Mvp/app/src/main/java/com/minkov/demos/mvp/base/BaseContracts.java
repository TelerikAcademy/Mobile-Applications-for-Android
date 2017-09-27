package com.minkov.demos.mvp.base;

/**
 * Created by minkov on 9/27/17.
 */

public abstract class BaseContracts {
  public interface View<T> {
    void setPresenter(T presenter);
  }

  public interface Presenter<T> {
    void subscribe(T view);
    void unsubscribe();
  }
}
