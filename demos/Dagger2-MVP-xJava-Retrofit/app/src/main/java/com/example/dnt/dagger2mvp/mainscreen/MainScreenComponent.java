package com.example.dnt.dagger2mvp.mainscreen;

import com.example.dnt.dagger2mvp.data.NetComponent;
import com.example.dnt.dagger2mvp.util.CustomScope;

import dagger.Component;

/**
 * Created by dnt on 31.1.2017 г..
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainScreenFragment fragment);
}