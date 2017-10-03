package com.minkov.demos.mvp.repositories;

import android.content.Context;

import com.minkov.demos.mvp.http.HttpRequester;
import com.minkov.demos.mvp.http.Url;
import com.minkov.demos.mvp.models.DaoMaster;
import com.minkov.demos.mvp.models.DaoSession;
import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.base.BaseRepository;
import com.minkov.demos.mvp.utils.JsonParser;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Module for providing Repositories to Dagger
 * Created by minkov on 9/27/17.
 */

@Module
public class RepositoriesModule {

    /**
     * Provides a PersonDao instance
     * @param context the application context
     * @return a {@link AbstractDao} instance for {@link Person} entity
     */
    @Provides
    AbstractDao<Person, String> providePersonDao(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "notes-db");
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        return daoSession.getPersonDao();
    }

    /**
     * Provides a {@link BaseRepository} instance for HTTP data
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

    /**
     * Provides a {@link BaseRepository} instance for cache data
     *
     * @param dao {@link org.greenrobot.greendao.AbstractDao} instance for cache data
     * @return a concrete instance of {@link BaseRepository}
     */
    @Provides
    @Named("cache")
    BaseRepository<Person> providesCacheRepository(AbstractDao<Person, String> dao) {
        return new GenericCacheRepository<>(dao);
    }
}
