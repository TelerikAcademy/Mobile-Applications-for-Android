package com.example.dnt.dagger2mvp.detail_screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dnt.dagger2mvp.R;

import static com.example.dnt.dagger2mvp.util.ActivityUtils.addFragmentToActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Integer postId = getIntent().getIntExtra(getString(R.string.GetPostId),0);
        Bundle bundle = new Bundle();
        bundle.putInt(getString(R.string.GetPostId),postId);
        DetailScreenFragment detailScreenFragment =  new DetailScreenFragment();
        detailScreenFragment.setArguments(bundle);


        addFragmentToActivity(getSupportFragmentManager(),detailScreenFragment, R.id.my_detail_fragment);
    }
}
