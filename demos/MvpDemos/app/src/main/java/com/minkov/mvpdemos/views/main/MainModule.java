package com.minkov.mvpdemos.views.main;

import com.minkov.mvpdemos.data.base.IData;
import com.minkov.mvpdemos.utils.Waiter;
import com.minkov.mvpdemos.models.Superhero;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 2/12/17.
 */

@Module
public class MainModule {
    @Provides
    MainContracts.View provideMainView() {
        return new MainView();
    }

    @Provides
    MainContracts.Presenter provideMainPresenter(MainContracts.View view, IData<Superhero> data, Waiter waiter) {
        return new MainPresenter(view, data);
    }
}
