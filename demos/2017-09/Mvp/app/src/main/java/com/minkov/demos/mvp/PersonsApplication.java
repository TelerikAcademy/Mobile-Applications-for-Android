package com.minkov.demos.mvp;

import android.app.Activity;

import com.minkov.demos.mvp.base.BaseActivity;
import com.minkov.demos.mvp.base.CurrentActivityProvider;
import com.minkov.demos.mvp.dagger.AppComponent;
import com.minkov.demos.mvp.dagger.DaggerAppComponent;
import com.minkov.demos.mvp.models.DaoMaster;
import com.minkov.demos.mvp.models.DaoSession;

import org.greenrobot.greendao.database.Database;
//import org.greenrobot.greendao.database.Da

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by minkov on 9/27/17.
 */

public class PersonsApplication extends DaggerApplication
        implements CurrentActivityProvider {
    /**
     * A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher.
     */
    public static final boolean ENCRYPTED = true;

    private DaoSession mDaoSession;
    private BaseActivity mCurrentActivity;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db");
        Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }

    public void setCurrentActivity(BaseActivity activity) {
        mCurrentActivity = activity;
    }

    public BaseActivity getCurrentActivity() {
        return mCurrentActivity;
    }
}
