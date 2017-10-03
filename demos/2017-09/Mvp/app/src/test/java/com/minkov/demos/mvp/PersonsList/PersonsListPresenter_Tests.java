package com.minkov.demos.mvp.PersonsList;

import com.minkov.demos.mvp.PersonsLists.PersonsListContracts;
import com.minkov.demos.mvp.PersonsLists.PersonsListPresenter;
import com.minkov.demos.mvp.models.Person;
import com.minkov.demos.mvp.repositories.base.BaseRepository;
import com.minkov.demos.mvp.utils.schedulers.ImmediateSchedulerProvider;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import io.reactivex.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PersonsListPresenter_Tests {
    Person[] mPersons;

    private ImmediateSchedulerProvider mScheduleProvider;

    @Mock
    BaseRepository<Person> mockRepository;

    @Mock
    PersonsListContracts.View mockView;

    @Mock
    PersonsListContracts.Router mockRouter;

    private PersonsListPresenter mPresenter;

    // Once, before all tests
    // @BeforeClass


    // Before each test
    @Before
    public void testSetup() {
        MockitoAnnotations.initMocks(this);

        mScheduleProvider = new ImmediateSchedulerProvider();

        mPersons = new Person[]{
                new Person("John"),
                new Person("Jane"),
                new Person("Pesho"),
        };

        when(mockRepository.getAll())
                .thenReturn(Observable.just(mPersons));

        mPresenter = new PersonsListPresenter(mockRepository, mScheduleProvider);
        mPresenter.subscribe(mockView);
        mPresenter.setRouter(mockRouter);
    }

    @Test
    public void subscrine_shouldCallSetPersons() {
        verify(mockView).setPersons(mPersons);
    }

    @Test
    public void onPersonSelect_shouldCallShowDetailsNavigate() {
        mPresenter.onPersonSelect(0);
        verify(mockRouter).showDetails(mPersons[0]);
    }
}
