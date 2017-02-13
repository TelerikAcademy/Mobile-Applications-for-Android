package com.minkov.mvpexplore2.tests;

import com.minkov.mvpdemos.data.base.IData;
import com.minkov.mvpdemos.models.Superhero;
import com.minkov.mvpdemos.views.main.MainContracts;
import com.minkov.mvpdemos.views.main.MainPresenter;

import net.bytebuddy.implementation.bind.annotation.Super;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import io.reactivex.Observable;

import static org.junit.Assert.assertEquals;

public class MainPresenterTests {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void presenterCallsSetItems() {
        MainContracts.View view = Mockito.spy(MainContracts.View.class);

        IData<Superhero> data = Mockito.mock(IData.class);

        Superhero[] superheroes = {
                new Superhero("id-1", "Test-1"),
                new Superhero("id-2", "Test-2")};

        Mockito.when(data.getAll())
                .thenReturn(Observable.just(superheroes));

        MainContracts.Presenter presenter = new MainPresenter(view, data);
        presenter.start();

        Mockito.verify(data).getAll();
        Mockito.verify(view).setItems(Mockito.any(String[].class));
    }
//
    @Test
    public void saveSuperhero_isCalled() {
        IData<Superhero> data = Mockito.mock(IData.class);
        MainContracts.View view = Mockito.mock(MainContracts.View.class);

        final Superhero sh = new Superhero("id", "test");

        Mockito.doReturn(Observable.just(sh))
                .when(data).add(Mockito.any(Superhero.class));

        MainPresenter presenter = new MainPresenter(view, data);

        presenter.saveSuperhero(sh.getName());

        Mockito.verify(data).add(Mockito.any(Superhero.class));
    }
}