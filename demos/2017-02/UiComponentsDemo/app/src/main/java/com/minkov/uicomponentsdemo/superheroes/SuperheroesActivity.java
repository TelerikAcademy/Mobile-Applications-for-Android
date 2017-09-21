package com.minkov.uicomponentsdemo.superheroes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.minkov.uicomponentsdemo.R;
import com.minkov.uicomponentsdemo.adapters.GenericArrayAdapter;
import com.minkov.uicomponentsdemo.bgTasks.DownloadImageTask;
import com.minkov.uicomponentsdemo.data.Data;
import com.minkov.uicomponentsdemo.models.Superhero;
import com.minkov.uicomponentsdemo.superheroDetails.SuperheroDetailsActivity;

import java.util.List;

public class SuperheroesActivity extends AppCompatActivity {
    private Data data;

    public SuperheroesActivity() {
        this.data = new Data();

        this.data.addSuperhero("Batman", "Bruce Wayne", "http://cartoonbros.com/wp-content/uploads/2016/05/Batman-4.jpg");
        this.data.addSuperhero("Superman", "Klark Kent", "http://cartoonbros.com/wp-content/uploads/2016/05/Batman-4.jpg");
        this.data.addSuperhero("Black Widow", "Natasha Romanoff", "http://cartoonbros.com/wp-content/uploads/2016/05/Batman-4.jpg");
        this.data.addSuperhero("Ironman", "Tony Stark", "http://cartoonbros.com/wp-content/uploads/2016/05/Batman-4.jpg");
        this.data.addSuperhero("Wolverine", "Logan", "http://cartoonbros.com/wp-content/uploads/2016/05/Batman-4.jpg");
        this.data.addSuperhero("Captain America", "Steven Rogers", "http://cartoonbros.com/wp-content/uploads/2016/05/Batman-4.jpg");
        this.data.addSuperhero("The Hulk", "Bruce Baner", "http://cartoonbros.com/wp-content/uploads/2016/05/Batman-4.jpg");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superheroes);

        List<Superhero> superheroes = data.getAllSuperheroes();

        ArrayAdapter<Superhero> adapter = new GenericArrayAdapter<>(this, R.layout.item_superhero, superheroes, (superhero, view) -> {
            TextView tvName = (TextView) view.findViewById(R.id.tv_name);
            tvName.setText(superhero.getName());

            TextView tvSecretIdentity = (TextView) view.findViewById(R.id.tv_secretIdentity);
            tvSecretIdentity.setText(String.format("(%s)", superhero.getSecretIdentity()));

            ImageView ivSuperhero = (ImageView) view.findViewById(R.id.iv_superhero);

            new DownloadImageTask(ivSuperhero)
                    .execute(superhero.getImgUrl());

            return view;
        });

        ListView lvSuperheroes = (ListView) this.findViewById(R.id.lv_superheroes);

        lvSuperheroes.setAdapter(adapter);
        lvSuperheroes.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, SuperheroDetailsActivity.class);

            intent.putExtra("superhero_id", superheroes.get(position).getId());

            this.startActivity(intent);
        });
    }
}
