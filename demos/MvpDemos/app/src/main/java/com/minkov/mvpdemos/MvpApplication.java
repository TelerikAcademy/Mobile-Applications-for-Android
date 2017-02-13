package com.minkov.mvpdemos;

import android.app.Application;

import com.minkov.mvpdemos.data.DataModule;
import com.minkov.mvpdemos.http.HttpModule;
import com.minkov.mvpdemos.utils.UtilsModule;
import com.minkov.mvpdemos.views.ViewsModule;
import com.minkov.mvpdemos.views.base.BaseViewFragment;
import com.minkov.mvpdemos.views.details.DetailsActivity;
import com.minkov.mvpdemos.views.main.MainActivity;

import dagger.Component;

public class MvpApplication extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        this.component = DaggerMvpApplication_ApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    public ApplicationComponent getComponent() {
        return component;
    }

    @Component(modules = {ApplicationModule.class, ViewsModule.class, DataModule.class, HttpModule.class, UtilsModule.class})
    public interface ApplicationComponent {
        void inject(MainActivity mainActivity);

        void inject(DetailsActivity detailsActivity);

        void inject(BaseViewFragment baseViewFragment);
    }
}
