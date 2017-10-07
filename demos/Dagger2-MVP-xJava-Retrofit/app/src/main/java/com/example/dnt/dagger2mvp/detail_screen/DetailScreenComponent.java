package com.example.dnt.dagger2mvp.detail_screen;

import com.example.dnt.dagger2mvp.data.NetComponent;
import com.example.dnt.dagger2mvp.util.CustomScope;

import dagger.Component;

/**
 * Created by dnt on 2.2.2017 г..
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = DetailScreenModule.class)
public interface DetailScreenComponent {
    void inject(DetailScreenFragment fragment);
}