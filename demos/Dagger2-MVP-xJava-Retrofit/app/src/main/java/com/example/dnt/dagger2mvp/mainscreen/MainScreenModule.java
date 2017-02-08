package com.example.dnt.dagger2mvp.mainscreen;

import com.example.dnt.dagger2mvp.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dnt on 31.1.2017 г..
 */

@Module
public class MainScreenModule {
    private final MainScreenContract.View mView;


    public MainScreenModule(MainScreenContract.View mView) {
        this.mView = mView;
    }


    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView() {
        return mView;
    }
}
