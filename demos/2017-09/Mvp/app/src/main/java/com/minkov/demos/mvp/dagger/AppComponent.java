package com.minkov.demos.mvp.dagger;

import android.app.Application;

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
 * Created by minkov on 9/27/17.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class,
        ModelsModule.class,
        HttpModule.class,
        UtilsModule.class,
        RepositoriesModule.class,
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
  void inject(PersonsApplication application);

  @Override
  void inject(DaggerApplication instance);

  @Component.Builder
  interface Builder {

    @BindsInstance
    AppComponent.Builder application(Application application);

    AppComponent build();
  }
}
