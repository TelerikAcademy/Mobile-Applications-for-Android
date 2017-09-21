package com.minkov.mvpdagger2UnitTestingdemos.views.details.detailspresenter;

import com.minkov.mvpdagger2UnitTestingdemos.data.LocalData;
import com.minkov.mvpdagger2UnitTestingdemos.models.Superhero;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class someMethod {
    private List<Superhero> ITEMS;

    @Mock
    LocalData<Superhero> data;

    public someMethod() {
        ITEMS = new ArrayList<>();
    }

    @Before
    public void initTest(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSomething(){
        when(data.getAll())
                .thenReturn(Observable.just(ITEMS));

        data.getAll();

        verify(data).getAll();
    }

}
