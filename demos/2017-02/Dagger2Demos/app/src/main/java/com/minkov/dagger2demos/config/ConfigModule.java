package com.minkov.dagger2demos.config;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ConfigModule {

    @Provides
    @Named("baseApiUrl")
    String provideApiUrl() {
        return "http://192.168.192.229:3001/";
    }
}
