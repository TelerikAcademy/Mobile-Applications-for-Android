package com.minkov.mvpdagger2demos.views.main;

import com.minkov.mvpdagger2demos.data.LocalData;
import com.minkov.mvpdagger2demos.models.Superhero;
import com.minkov.mvpdagger2demos.ui.ModalFactory;
import com.minkov.mvpdagger2demos.ui.Notifier;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 2/15/17.
 */

@Module
public class MainModule {

    @Provides
    MainContracts.View provideMainView() {
        MainContracts.View view = new MainView();
        return view;
    }

    @Provides
    MainContracts.Presenter provideMainPresenter(
            MainContracts.View view,
            LocalData<Superhero> data,
            ModalFactory modalFactory,
            Notifier notifier
    ) {
        return new MainPresenter(view, data, modalFactory, notifier);
    }
}
