package com.minkov.mvpdagger2demos.views.details;

import com.minkov.mvpdagger2demos.data.LocalData;
import com.minkov.mvpdagger2demos.models.Superhero;

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
