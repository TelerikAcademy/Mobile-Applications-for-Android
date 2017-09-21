package com.minkov.dagger2demos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.minkov.dagger2demos.data.HttpData;
import com.minkov.dagger2demos.data.LocalData;
import com.minkov.dagger2demos.data.base.BaseData;
import com.minkov.dagger2demos.models.Faction;
import com.minkov.dagger2demos.models.Superhero;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {
    @Inject
    public BaseData<Superhero> data;

    @Inject
    public BaseData<Faction> factionData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.injectDependencies();

        data.getAll()
                .subscribe(new Consumer<Superhero[]>() {
                    @Override
                    public void accept(Superhero[] superheros) throws Exception {
                        int b = 5;
                    }
                });


        BaseData<Faction> bd = factionData;
        int b= 5;
    }

    private void injectDependencies() {
        ((Dagger2DemosApplication) getApplication())
                .getComponent()
                .inject(this);
    }
}
