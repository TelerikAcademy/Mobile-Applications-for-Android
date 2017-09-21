package com.minkov.mvpdagger2UnitTestingdemos;

import android.support.test.runner.AndroidJUnit4;

import com.minkov.mvpdagger2UnitTestingdemos.data.LocalData;
import com.minkov.mvpdagger2UnitTestingdemos.models.Superhero;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
//    @Mock
//    public MainContracts.View view;
//
//    @Mock
//    public Notifier notifier;
//
//    @Mock
//    public ModalFactory modalFactory;
//
//    @Mock
//    public LocalData<Superhero> data;
//
//    private List<Superhero> list;

    @Before
    public void initTest() {

//        MockitoAnnotations.initMocks(this);
//
//        data = new LocalData<>();
//
//        list = new ArrayList<>();
//        list.add(new Superhero("a", "b"));
//
////        when(data.getAll())
////                .thenReturn(Observable.just(list));
    }

    @Test
    public void useAppContext() {
//
//        LocalData<Superhero> data = spy(LocalData.class);
//
//        data.getAll();
//
//        verify(data).getAll();

//        MainPresenter presenter = new MainPresenter(view, data, modalFactory, notifier);
//
//        presenter.start();
//
//        verify(data)
//                .getAll();

    }
}
