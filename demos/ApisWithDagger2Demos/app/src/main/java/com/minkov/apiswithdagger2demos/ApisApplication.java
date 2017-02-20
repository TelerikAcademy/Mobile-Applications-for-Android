package com.minkov.apiswithdagger2demos;

import android.app.Application;

import dagger.Component;

public class ApisApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        this.component = DaggerApisApplication_ApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }

    @Component(modules = {ApplicationModule.class})
    public interface ApplicationComponent {
        void inject(MainActivity mainActivity);
    }
}
