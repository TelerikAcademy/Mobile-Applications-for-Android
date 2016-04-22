package com.minkov.thetwitterapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.minkov.thetwitterapp.R;
import com.minkov.thetwitterapp.activities.DetailsActivity;
import com.minkov.thetwitterapp.models.Tweet;
import com.minkov.thetwitterapp.utils.TweetArrayAdapter;

public class MainActivity extends AppCompatActivity {

    private int lastId = 0;

    private int getNextId(){
        return ++lastId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) this.findViewById(R.id.listView_messages);

       TweetArrayAdapter adapter =
                new TweetArrayAdapter(this);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Tweet tweet = (Tweet) adapter.getItem(position);

            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("tweetDetails", tweet);
            this.startActivity(intent);
        });

        Button btn = (Button) this.findViewById(R.id.btn_add);

        btn.setOnClickListener((view) -> {
            EditText editText = (EditText) this.findViewById(R.id.editBox_msg);
            String text = editText
                    .getText().toString();

            editText.setText("");
            Tweet tweet = new Tweet(getNextId(), text);
            adapter.add(tweet);

            adapter.notifyDataSetChanged();
        });
    }
}
