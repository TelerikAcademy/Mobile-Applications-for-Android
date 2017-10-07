package com.example.dnt.dagger2mvp.detail_screen;

import com.example.dnt.dagger2mvp.mainscreen.MainScreenContract;
import com.example.dnt.dagger2mvp.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dnt on 2.2.2017 г..
 */
@Module
public class DetailScreenModule {
    private final DetailScreenContract.View mView;

    public DetailScreenModule(DetailScreenContract.View mView) {
        this.mView = mView;
    }


    @Provides
    @CustomScope
    DetailScreenContract.View providesDetailScreenContractView() {
        return mView;
    }
}
