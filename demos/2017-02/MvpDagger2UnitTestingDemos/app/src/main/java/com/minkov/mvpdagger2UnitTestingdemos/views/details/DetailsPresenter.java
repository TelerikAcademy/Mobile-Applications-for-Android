package com.minkov.mvpdagger2UnitTestingdemos.views.details;

import com.minkov.mvpdagger2UnitTestingdemos.data.LocalData;
import com.minkov.mvpdagger2UnitTestingdemos.models.Superhero;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class DetailsPresenter implements DetailsContracts.Presenter {
    private final DetailsContracts.View view;
    private final LocalData<Superhero> data;
    private String superheroId;

    public DetailsPresenter(DetailsContracts.View view, LocalData<Superhero> data) {
        this.view = view;
        this.getView().setPresenter(this);

        this.data = data;
    }

    @Override
    public DetailsContracts.View getView() {
        return view;
    }

    @Override
    public Observable<Boolean> start() {
        return this.data.getById(this.superheroId)
                .map(new Function<Superhero, Boolean>() {
                    @Override
                    public Boolean apply(Superhero superhero) throws Exception {
                        getView()
                                .setDetails(superhero);
                        return true;
                    }
                });
    }

    @Override
    public void setId(String id) {
        this.superheroId = id;
    }
}
