package com.minkov.apiswithdagger2demos;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 2/17/17.
 */

@Module
public class ApplicationModule {
    private final Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideApplicationContext() {
        return this.context;
    }

//    @Provides
//    LocationManager provideLocationManager() {
//        return (LocationManager) this.context.getSystemService(Context.LOCATION_SERVICE);
//    }
}
