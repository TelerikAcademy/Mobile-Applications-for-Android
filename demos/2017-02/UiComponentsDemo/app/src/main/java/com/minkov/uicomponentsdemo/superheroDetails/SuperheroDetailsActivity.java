package com.minkov.uicomponentsdemo.superheroDetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.minkov.uicomponentsdemo.R;
import com.minkov.uicomponentsdemo.bgTasks.DownloadImageTask;
import com.minkov.uicomponentsdemo.data.Data;
import com.minkov.uicomponentsdemo.models.Superhero;

public class SuperheroDetailsActivity extends AppCompatActivity {
    private Data data;

    public SuperheroDetailsActivity() {
        this.data = new Data();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superhero_details);

        Intent intent = this.getIntent();
        String superheroId = intent.getStringExtra("superhero_id");
        Superhero superhero = this.data.getSuperheroById(superheroId);

        TextView tvName = (TextView) this.findViewById(R.id.tv_name);
        tvName.setText(superhero.getName());

        ImageView ivSuperhero = (ImageView) this.findViewById(R.id.iv_superhero);

        new DownloadImageTask(ivSuperhero)
                .execute(superhero.getImgUrl());
    }
}
