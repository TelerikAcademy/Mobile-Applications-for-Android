package com.minkov.demos.mvp.dagger;

import android.app.Application;

import com.minkov.demos.mvp.ConfigModule;
import com.minkov.demos.mvp.PersonsApplication;
import com.minkov.demos.mvp.http.HttpModule;
import com.minkov.demos.mvp.models.ModelsModule;
import com.minkov.demos.mvp.repositories.RepositoriesModule;
import com.minkov.demos.mvp.utils.UtilsModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * AppComponent module for Dagger
 * Created by minkov on 9/27/17.
 */

@Singleton
@Component(modules = {
        ConfigModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class,
        UtilsModule.class,
        ModelsModule.class,
        HttpModule.class,
        RepositoriesModule.class,
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    /**
     * Dagger2 inject method
     *
     * @param application injected by Dagger2
     */
    void inject(PersonsApplication application);

    @Override
    void inject(DaggerApplication instance);

    /**
     * Used for syntax sugar before build
     */
    @Component.Builder
    interface Builder {

        /**
         * @param application Used for syntax sugar before build
         * @return the builder
         */
        @BindsInstance
        AppComponent.Builder application(Application application);

        /**
         * Used for syntax sugar before build
         *
         * @return Used for syntax sugar before build
         */
        AppComponent build();
    }
}
