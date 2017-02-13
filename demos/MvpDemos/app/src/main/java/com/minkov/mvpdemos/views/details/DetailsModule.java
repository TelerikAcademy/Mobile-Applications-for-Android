package com.minkov.mvpdemos.views.details;

import com.minkov.mvpdemos.data.base.IData;
import com.minkov.mvpdemos.models.Superhero;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 2/13/17.
 */

@Module
public class DetailsModule {

    @Provides
    DetailsContracts.View provideMainView() {
        return new DetailsView();
    }

    @Provides
    DetailsContracts.Presenter provideDetailsPresenter(DetailsContracts.View view, IData<Superhero> data) {
        return new DetailsPresenter(view, data);
    }
}
