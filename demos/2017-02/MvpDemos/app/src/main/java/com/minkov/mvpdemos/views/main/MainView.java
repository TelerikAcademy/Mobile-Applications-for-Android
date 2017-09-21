package com.minkov.mvpdemos.views.main;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.minkov.mvpdemos.R;
import com.minkov.mvpdemos.ui.ModalFactory;
import com.minkov.mvpdemos.ui.Notifier;
import com.minkov.mvpdemos.views.details.DetailsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainView
        extends Fragment
        implements
        MainContracts.View,
        AdapterView.OnItemClickListener,
        View.OnClickListener,
        ModalFactory.ModalFactoryPositiveHandler {
    private MainContracts.Presenter presenter;

    private ListView lvNames;
    private ArrayAdapter<String> adapter;
    private FloatingActionButton btnAdd;

    private ModalFactory modalFactory;
    private Notifier notifier;

    public MainView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_view, container, false);

        //Prepare views

        this.adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1);
        this.lvNames = (ListView) root.findViewById(R.id.lvNames);
        this.lvNames.setAdapter(this.adapter);
        this.lvNames.setOnItemClickListener(this);


        this.btnAdd = (FloatingActionButton) root.findViewById(R.id.btnAdd);
        this.btnAdd.setOnClickListener(this);

        //  Start the presenter
        this.presenter.start();

        return root;
    }

    @Override
    public void setPresenter(MainContracts.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void navigateWith(String name) {
        Intent intent = new Intent(this.getContext(), DetailsActivity.class);
        intent.putExtra("details", name);
        startActivity(intent);
    }

    @Override
    public void showAddView() {
        Dialog addModal =
                this.modalFactory.
                        getAddNameModal(this.getContext(), this);
        addModal.show();
    }

    public static MainView create() {
        return new MainView();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.presenter.selectName(position);
    }

    public void setNames(String[] names) {
        this.adapter.clear();
        this.adapter.addAll(names);
    }

    public void notifyText(String text) {
        this.notifier.notifySuccess(this.getContext(), text);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAdd:
                this.presenter.add();
                break;
        }
    }

    public void setModalFactory(ModalFactory modalFactory) {
        this.modalFactory = modalFactory;
    }

    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void onPositive() {
        this.notifier.notifySuccess(this.getContext(), "Agreed!");
    }

}
