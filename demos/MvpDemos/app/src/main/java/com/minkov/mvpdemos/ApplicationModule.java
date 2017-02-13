package com.minkov.mvpdemos;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 2/12/17.
 */

@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @Provides

    MvpApplication provideApplication(){
        return (MvpApplication) this.context;
    }

}
