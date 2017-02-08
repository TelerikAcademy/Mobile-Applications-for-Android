package com.example.dnt.dagger2mvp.data;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import retrofit2.Retrofit;

/**
 * Created by dnt on 31.1.2017 г..
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
