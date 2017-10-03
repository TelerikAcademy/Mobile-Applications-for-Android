package com.minkov.demos.mvp.repositories;

import android.content.Context;

import com.minkov.demos.mvp.http.HttpRequester;
import com.minkov.demos.mvp.http.Url;
import com.minkov.demos.mvp.models.DaoMaster;
import com.minkov.demos.mvp.models.DaoSession;
import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.models.PersonDao;
import com.minkov.demos.mvp.repositories.base.BaseRepository;
import com.minkov.demos.mvp.utils.JsonParser;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by minkov on 9/27/17.
 */

@Module
public class RepositoriesModule {
    @Provides
    PersonDao providePersonDao(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "notes-db");
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        return daoSession.getPersonDao();
    }

    /**
     * Provides a {@link BaseRepository} instance
     *
     * @param httpRequester create HTTP requests
     * @param jsonParser    parses strings to <T> objects
     * @param url           the url wrapper
     * @return a concrete instance of {@link BaseRepository}
     */
    @Provides
    @Named("remote")
    BaseRepository<Person> providesRemoteRepository(HttpRequester httpRequester,
                                                    JsonParser<Person> jsonParser,
                                                    Url<Person> url) {
        return new GenericHttpRepository<>(httpRequester, jsonParser, url);
    }

    @Provides
    @Named("cache")
    BaseRepository<Person> providesCacheRepository(PersonDao dao) {
        return new GenericCacheRepository<>(dao);
    }
}
