package com.minkov.mvpdagger2demos.views;

import com.minkov.mvpdagger2demos.views.details.DetailsModule;
import com.minkov.mvpdagger2demos.views.main.MainModule;

import dagger.Module;

/**
 * Created by minkov on 2/15/17.
 */

@Module(includes = {MainModule.class, DetailsModule.class})
public class ViewsModule {
}
