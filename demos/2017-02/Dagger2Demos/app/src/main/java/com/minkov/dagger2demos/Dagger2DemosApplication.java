package com.minkov.dagger2demos;

import android.app.Application;

import com.minkov.dagger2demos.config.ConfigModule;
import com.minkov.dagger2demos.data.DataModule;
import com.minkov.dagger2demos.data.LocalData;
import com.minkov.dagger2demos.data.base.BaseData;
import com.minkov.dagger2demos.models.Superhero;

import javax.inject.Singleton;

import dagger.Component;

public class Dagger2DemosApplication extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        this.component = DaggerDagger2DemosApplication_ApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }

    @Singleton
    @Component(modules = {DataModule.class, ApplicationModule.class, ConfigModule.class})
    public interface ApplicationComponent {
        void inject(MainActivity mainActivity);
    }
}
