package com.minkov.sqlitedemos;

import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.minkov.sqlitedemos.models.Power;
import com.minkov.sqlitedemos.models.Superhero;
import com.orm.SugarRecord;
import com.orm.SugarTransactionHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter.load();
    }

    void update(){
        var data = this.presenter.getData();
        //update UI
    }

    class Presenter {

        View view;

        void load(){
            //async operation
            //ready -> view.update();
        }
    }
}

