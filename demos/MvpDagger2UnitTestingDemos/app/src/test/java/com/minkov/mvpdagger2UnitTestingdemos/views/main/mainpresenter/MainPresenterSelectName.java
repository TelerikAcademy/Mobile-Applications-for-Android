package com.minkov.mvpdagger2UnitTestingdemos.views.main.mainpresenter;

import com.minkov.mvpdagger2UnitTestingdemos.BuildConfig;
import com.minkov.mvpdagger2UnitTestingdemos.data.LocalData;
import com.minkov.mvpdagger2UnitTestingdemos.models.Superhero;
import com.minkov.mvpdagger2UnitTestingdemos.ui.ModalFactory;
import com.minkov.mvpdagger2UnitTestingdemos.ui.Notifier;
import com.minkov.mvpdagger2UnitTestingdemos.views.main.MainContracts;
import com.minkov.mvpdagger2UnitTestingdemos.views.main.MainPresenter;
import com.minkov.mvpdagger2UnitTestingdemos.views.main.MainView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivestreams.Subscriber;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by minkov on 2/15/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
//@Config(sdk = 18, manifest = "app/src/main/AndroidManifest.xml")
public class MainPresenterSelectName {

    List<Superhero> SUPERHEROES;

    @Mock
    MainContracts.View view;

    @Mock
    LocalData<Superhero> data;

    @Mock
    ModalFactory modalFactory;

    @Mock
    Notifier notifier;

    MainPresenter presenter;
    private CountDownLatch latch;

    @Before
    public void testInit() {
        latch = new CountDownLatch(1);
        MockitoAnnotations.initMocks(this);

        SUPERHEROES = new ArrayList<>();
        SUPERHEROES.add(new Superhero("1", "Pesho"));
        SUPERHEROES.add(new Superhero("2", "Pesho"));
        SUPERHEROES.add(new Superhero("3", "Gosho"));
        SUPERHEROES.add(new Superhero("4", "Pesho"));
        SUPERHEROES.add(new Superhero("5", "Pesho"));
        SUPERHEROES.add(new Superhero("6", "Pesho"));
        SUPERHEROES.add(new Superhero("7", "Pesho"));
        SUPERHEROES.add(new Superhero("8", "Pesho"));
        SUPERHEROES.add(new Superhero("9", "Pesho"));

        when(data.getAll())
                .thenReturn(Observable.just(SUPERHEROES));
        presenter = new MainPresenter(view, data, modalFactory, notifier);
    }

    @Test()
    public void whenNames_shouldCallNotifyText() {
        presenter.start()
                .blockingFirst();

        presenter.selectName(2);
        verify(view)
                .notifyText(
                        String.format(MainPresenter.NOTIFICATION_FORMAT, SUPERHEROES.get(2).getName())
                );
    }

    @Test
    public void whenNames_shouldCallNavigateTo() {
        presenter.start()
                .blockingFirst();

        presenter.selectName(2);

        verify(view)
                .navigateWith(SUPERHEROES.get(2).getId());
    }
}
