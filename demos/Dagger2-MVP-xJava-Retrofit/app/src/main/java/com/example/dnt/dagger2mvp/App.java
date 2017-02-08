package com.example.dnt.dagger2mvp;

import android.app.Application;

import com.example.dnt.dagger2mvp.data.AppModule;
import com.example.dnt.dagger2mvp.data.DaggerNetComponent;
import com.example.dnt.dagger2mvp.data.NetComponent;
import com.example.dnt.dagger2mvp.data.NetModule;

/**
 * Created by dnt on 31.1.2017 г..
 */

public class App extends Application {
    NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();

    }

    public NetComponent getNetComponent(){
        return mNetComponent;
    }
}
