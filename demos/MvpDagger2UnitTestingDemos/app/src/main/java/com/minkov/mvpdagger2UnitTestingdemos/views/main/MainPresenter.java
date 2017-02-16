package com.minkov.mvpdagger2UnitTestingdemos.views.main;

import com.minkov.mvpdagger2UnitTestingdemos.data.LocalData;
import com.minkov.mvpdagger2UnitTestingdemos.models.Superhero;
import com.minkov.mvpdagger2UnitTestingdemos.ui.ModalFactory;
import com.minkov.mvpdagger2UnitTestingdemos.ui.Notifier;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class MainPresenter
        implements MainContracts.Presenter {
    public static final String NOTIFICATION_FORMAT = "This is %s!";


    private final MainContracts.View view;
    private final LocalData<Superhero> data;
    private List<Superhero> superheroes;

    @Inject
    public MainPresenter(MainContracts.View view,
                         LocalData<Superhero> data,
                         ModalFactory modalFactory,
                         Notifier notifier) {
        this.view = view;

        this.getView().setPresenter(this);
        this.getView().setModalFactory(modalFactory);
        this.getView().setNotifier(notifier);

        this.data = data;
    }

    public Observable<Boolean> start() {
        return this.data.getAll()
                .map(new Function<List<Superhero>, List<String>>() {
                    @Override
                    public List<String> apply(List<Superhero> superherosResult) throws Exception {
                        superheroes = new ArrayList<Superhero>(superherosResult);
                        ArrayList<String> names = new ArrayList<>();
                        for (Superhero sh : superheroes) {
                            names.add(sh.getName());
                        }
                        return names;
                    }
                })
                .map(new Function<List<String>, Boolean>() {
                    @Override
                    public Boolean apply(List<String> names) throws Exception {
                        String[] namesArray = new String[names.size()];
                        names.toArray(namesArray);
                        getView().setNames(namesArray);
                        return true;
                    }
                });
    }

    @Override
    public MainContracts.View getView() {
        return this.view;
    }

    public void selectName(int position) {
        Superhero superhero = this.superheroes.get(position);
        this.getView()
                .navigateWith(superhero.getId());
        this.getView().notifyText(
                String.format(NOTIFICATION_FORMAT, superhero.getName())
        );
    }

    @Override
    public void add() {
        this.getView()
                .showAddView();
    }
}
