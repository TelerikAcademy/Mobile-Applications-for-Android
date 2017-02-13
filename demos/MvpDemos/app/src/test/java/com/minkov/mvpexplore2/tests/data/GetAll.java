package com.minkov.mvpexplore2.tests.data;

import com.minkov.mvpdemos.data.HttpData;
import com.minkov.mvpdemos.data.base.IData;
import com.minkov.mvpdemos.http.ApiUrl;
import com.minkov.mvpdemos.http.base.IHttpRequester;
import com.minkov.mvpdemos.models.Superhero;
import com.minkov.mvpdemos.utils.base.IParser;

import net.bytebuddy.implementation.bind.annotation.Super;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by minkov on 2/13/17.
 */

public class GetAll {
    @Test
    public void emptyArrayString_returnEmpty() {
        Superhero[] superheroes = {};
        final String url = "this is the url";
        final String jsonResult = "{\"name\":\"result\"}";

        final ApiUrl<Superhero> apiUrl = Mockito.mock(ApiUrl.class);

        Mockito.when(apiUrl.getUrl())
                .thenReturn(url);

        final IHttpRequester httpRequester = Mockito.mock(IHttpRequester.class);

        Mockito.when(httpRequester.get(url))
                .thenReturn(Observable.just(jsonResult));

        final IParser<Superhero> parser = Mockito.mock(IParser.class);

        Mockito.when(parser.parseMany(jsonResult))
                .thenReturn(superheroes);

        IData<Superhero> data = new HttpData<>(httpRequester, parser, apiUrl);

        data.getAll()
                .subscribe(new Consumer<Superhero[]>() {
                    @Override
                    public void accept(Superhero[] superheros) throws Exception {
                        Mockito.verify(httpRequester).get(url);
                        Mockito.verify(apiUrl).getUrl();
                        Mockito.verify(parser).parseMany(jsonResult);
                    }
                });
    }
}
