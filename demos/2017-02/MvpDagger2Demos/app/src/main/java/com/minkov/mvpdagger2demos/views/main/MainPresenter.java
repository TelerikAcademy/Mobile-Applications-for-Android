package com.minkov.mvpdagger2demos.views.main;

import com.minkov.mvpdagger2demos.data.LocalData;
import com.minkov.mvpdagger2demos.models.Superhero;
import com.minkov.mvpdagger2demos.ui.ModalFactory;
import com.minkov.mvpdagger2demos.ui.Notifier;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter
        implements MainContracts.Presenter {
    private final MainContracts.View view;
    private final LocalData<Superhero> data;
    private List<Superhero> superheroes;

    @Inject
    public MainPresenter(MainContracts.View view, LocalData<Superhero> data, ModalFactory modalFactory, Notifier notifier) {
        this.view = view;

        this.getView().setPresenter(this);
        this.getView().setModalFactory(modalFactory);
        this.getView().setNotifier(notifier);

        this.data = data;
    }

    public void start() {
        this.data.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> names) throws Exception {
                        String[] namesArray = new String[names.size()];
                        names.toArray(namesArray);
                        getView().setNames(namesArray);
                    }
                });
    }

    @Override
    public MainContracts.View getView() {
        return this.view;
    }

    public void selectName(int position) {
        this.getView()
                .navigateWith(this.superheroes.get(position).getId());
        this.getView().notifyText(
                "Selected \"" + this.superheroes.get(position).getName() + "\""
        );
    }

    @Override
    public void add() {
        this.getView()
                .showAddView();
    }
}
