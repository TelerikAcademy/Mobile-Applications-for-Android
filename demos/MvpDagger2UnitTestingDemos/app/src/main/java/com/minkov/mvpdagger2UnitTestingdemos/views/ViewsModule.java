package com.minkov.mvpdagger2UnitTestingdemos.views;

import com.minkov.mvpdagger2UnitTestingdemos.views.details.DetailsModule;
import com.minkov.mvpdagger2UnitTestingdemos.views.main.MainModule;

import dagger.Module;

/**
 * Created by minkov on 2/15/17.
 */

@Module(includes = {MainModule.class, DetailsModule.class})
public class ViewsModule {
}
