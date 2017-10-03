package com.minkov.demos.myapplication;

import android.app.Application;

import com.orm.Database;
import com.orm.SugarApp;

/**
 * Created by minkov on 10/2/17.
 */

public class MyApp extends Application {

    private Database database;
    private static MyApp sugarContext;

    public void onCreate(){
        super.onCreate();
        SugarApp.sugarContext = this;
        this.database = new Database(this);
    }

    public void onTerminate(){
        if (this.database != null) {
            this.database.getDB().close();
        }
        super.onTerminate();
    }

    public static MyApp getSugarContext(){
        return sugarContext;
    }

    protected Database getDatabase() {
        return database;
    }
}
