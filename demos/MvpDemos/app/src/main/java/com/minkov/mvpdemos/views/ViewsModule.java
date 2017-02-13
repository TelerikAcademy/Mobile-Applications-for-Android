package com.minkov.mvpdemos.views;

import com.minkov.mvpdemos.views.details.DetailsModule;
import com.minkov.mvpdemos.views.main.MainModule;

import dagger.Module;

/**
 * Created by minkov on 2/13/17.
 */

@Module(includes = {MainModule.class, DetailsModule.class})
public class ViewsModule {
}
