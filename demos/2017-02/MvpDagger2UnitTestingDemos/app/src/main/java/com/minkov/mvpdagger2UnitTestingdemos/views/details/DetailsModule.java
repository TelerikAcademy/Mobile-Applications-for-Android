package com.minkov.mvpdagger2UnitTestingdemos.views.details;

import com.minkov.mvpdagger2UnitTestingdemos.data.LocalData;
import com.minkov.mvpdagger2UnitTestingdemos.models.Superhero;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailsModule {
    @Provides
    DetailsContracts.View provideDetailsView() {
        return new DetailsView();
    }

    @Provides
    DetailsContracts.Presenter provideDetailsPresenter(DetailsContracts.View view, LocalData<Superhero> data) {
        return new DetailsPresenter(view, data);
    }
}
