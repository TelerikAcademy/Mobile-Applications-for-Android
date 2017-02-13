package com.minkov.dagger2demos.models;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by minkov on 2/10/17.
 */

public class Faction {
    public Context context;

    @Inject
    public Faction(Context context){
        this.context = context;
    }
}
