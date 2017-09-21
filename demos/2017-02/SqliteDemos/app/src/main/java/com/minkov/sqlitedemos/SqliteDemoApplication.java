package com.minkov.sqlitedemos;

import android.app.Application;

import com.orm.SugarContext;

import java.io.File;

public class SqliteDemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);

        File dbPath = getDatabasePath("superheroesDb.db");
        int b = 5;
    }
}
