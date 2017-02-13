package com.minkov.mvpdemos.views.main;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.minkov.mvpdemos.models.Superhero;
import com.minkov.mvpdemos.ui.ModalFactory;
import com.minkov.mvpdemos.views.details.DetailsActivity;
import com.minkov.mvpexplore2.R;
import com.minkov.mvpdemos.views.base.BaseViewFragment;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class MainView extends BaseViewFragment
        implements MainContracts.View,
        View.OnClickListener,
        AdapterView.OnItemClickListener,
        ModalFactory.OnClickCallback<Superhero> {

    private MainContracts.Presenter presenter;
    private ListView lvItems;
    private ArrayAdapter<String> adapter;
    private FloatingActionButton btnAdd;
    private Dialog modalAdd;

    @Inject
    public MainView() {
        //empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_view, container, false);

        this.btnAdd = (FloatingActionButton) root.findViewById(R.id.btnAdd);
        this.btnAdd.setOnClickListener(this);

        this.modalAdd = this.getModalFactory()
                .getAddSuperheroModal(this.getContext(), this);

        this.adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1);
        this.lvItems = (ListView) root.findViewById(R.id.lvSuperheroes);
        this.lvItems.setAdapter(this.adapter);
        this.lvItems.setOnItemClickListener(this);

        this.presenter.start();

        return root;
    }

    @Override
    public void setPresenter(MainContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setItems(final String[] names) {
        this.getUIOperationsHandler()
                .perform()
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        adapter.clear();
                        adapter.addAll(names);
                    }
                });
    }

    @Override
    public void navigateWith(Superhero superhero) {
        Intent intent = new Intent(this.getContext(), DetailsActivity.class);
        intent.putExtra("sh", superhero);
        this.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd) {
            this.showAddView();
        }
    }

    private void showAddView() {
        this.modalAdd.show();
    }

    @Override
    public void onClick(Superhero superhero) {
        this.presenter.saveSuperhero(superhero.getName());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.presenter.selectItem(position);
    }
}
