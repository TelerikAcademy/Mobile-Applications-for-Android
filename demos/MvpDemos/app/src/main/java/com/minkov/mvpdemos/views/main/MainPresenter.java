package com.minkov.mvpdemos.views.main;

import com.minkov.mvpdemos.data.base.IData;
import com.minkov.mvpdemos.models.Superhero;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by minkov on 2/12/17.
 */

public class MainPresenter implements MainContracts.Presenter {
    private final IData<Superhero> data;
    private MainContracts.View view;
    private ArrayList<Superhero> superheroes;

    @Inject
    public MainPresenter(MainContracts.View view, IData<Superhero> data) {
        this.view = view;
        this.view.setPresenter(this);
        this.data = data;
        this.superheroes = new ArrayList<>();
    }

    @Override
    public void start() {
        update();
    }

    public void update() {
        this.data.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Superhero[]>() {
                    @Override
                    public void accept(Superhero[] resultSuperheroes) throws Exception {
                        superheroes.clear();
                        String[] names = new String[resultSuperheroes.length];
                        for (int i = 0; i < names.length; i++) {
                            superheroes.add(resultSuperheroes[i]);
                            names[i] = resultSuperheroes[i].getName();
                        }

                        view.setItems(names);
                    }
                });
    }

    public MainContracts.View getView() {
        return this.view;
    }

    @Override
    public void saveSuperhero(final String name) {
        Superhero superhero = new Superhero(null, name);
        this.data
                .add(superhero)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Superhero>() {
                    @Override
                    public void accept(Superhero superhero) throws Exception {
                        getView().notify(String.format("%s created!", name));
                        update();
                    }
                });
    }

    @Override
    public void selectItem(int position) {
        this.getView().navigateWith(superheroes.get(position));
    }
}
