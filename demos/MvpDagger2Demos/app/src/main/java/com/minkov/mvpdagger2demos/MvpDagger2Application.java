package com.minkov.mvpdagger2demos;

import android.app.Application;

import com.minkov.mvpdagger2demos.data.DataModule;
import com.minkov.mvpdagger2demos.views.ViewsModule;
import com.minkov.mvpdagger2demos.views.details.DetailsActivity;
import com.minkov.mvpdagger2demos.views.main.MainActivity;

import dagger.Component;

public class MvpDagger2Application extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        this.component = DaggerMvpDagger2Application_ApplicationComponent
                .builder().
                        build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }

    @Component(modules = {ViewsModule.class, DataModule.class})
    public interface ApplicationComponent {
        void inject(MainActivity mainActivity);

        void inject(DetailsActivity detailsActivity);
    }
}
