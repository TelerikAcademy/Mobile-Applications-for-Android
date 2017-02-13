package com.minkov.mvpdemos.views.details;

import com.minkov.mvpdemos.data.base.IData;
import com.minkov.mvpdemos.models.Superhero;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by minkov on 2/13/17.
 */

public class DetailsPresenter implements DetailsContracts.Presenter {
    private final DetailsContracts.View view;
    private final IData<Superhero> localData;

    public DetailsPresenter(DetailsContracts.View view, IData<Superhero> localData) {
        this.view = view;
        this.view.setPresenter(this);
        this.localData = localData;
    }

    @Override
    public void start(Object id) {
        this.localData.getById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Superhero>() {
                    @Override
                    public void accept(Superhero superhero) throws Exception {
                        getView().setItemDetails(superhero);
                    }
                });
    }

    @Override
    public DetailsContracts.View getView() {
        return view;
    }
}
