package com.minkov.thetwitterapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.minkov.thetwitterapp.R;
import com.minkov.thetwitterapp.models.Tweet;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = this.getIntent();

        Tweet tweet = (Tweet) intent.getSerializableExtra("tweetDetails");

        TextView textView = (TextView) this.findViewById(R.id.textView_text);
        textView.setText(tweet.getText());

        ((TextView) this.findViewById(R.id.textView_id)).setText(tweet.getId() + "");

    }

}
