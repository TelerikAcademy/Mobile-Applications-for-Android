package com.minkov.thetwitterapp.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.minkov.thetwitterapp.R;
import com.minkov.thetwitterapp.models.Tweet;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by dminkov on 4/22/2016.
 */
public class TweetArrayAdapter extends BaseAdapter{

    private final Context context;
    private List<Tweet> tweets;

    public TweetArrayAdapter (Context context){
        this.tweets = new ArrayList<>();
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.tweets.size();
    }

    @Override
    public Object getItem(int position) {
        return this.tweets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.tweets.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tweet tweet = this.tweets.get(position);

        String text = tweet.getText();

        LayoutInflater inflater = (LayoutInflater) this.context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.tweet_row, null);

        TextView textViewText =
                (TextView) view.findViewById(R.id.textView_tweetText);

        textViewText.setText(text);

        return view;
    }

    public void add(Tweet tweet) {
        this.tweets.add(tweet);
    }
}
