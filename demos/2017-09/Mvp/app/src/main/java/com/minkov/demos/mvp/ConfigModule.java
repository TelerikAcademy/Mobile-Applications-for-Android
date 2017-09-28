package com.minkov.demos.mvp;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public class ConfigModule {
  private static final String BASE_URL = "http://192.168.160.7:3001/";

  public ConfigModule() {
  }

  @Provides
  @Named("base-url")
  String providesBaseUrl() {
    return BASE_URL;
  }
}
