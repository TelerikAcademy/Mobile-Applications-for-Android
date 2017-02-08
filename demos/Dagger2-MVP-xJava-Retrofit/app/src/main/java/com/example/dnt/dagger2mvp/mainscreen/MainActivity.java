package com.example.dnt.dagger2mvp.mainscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dnt.dagger2mvp.R;
import com.example.dnt.dagger2mvp.detail_screen.DetailActivity;
import com.example.dnt.dagger2mvp.detail_screen.DetailScreenFragment;
import com.example.dnt.dagger2mvp.util.MyCommunicator;

import static android.R.attr.description;
import static com.example.dnt.dagger2mvp.util.ActivityUtils.addFragmentToActivity;

public class MainActivity extends AppCompatActivity implements MyCommunicator {

    private boolean isTwoPane = false;
    DetailScreenFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragmentToActivity(getSupportFragmentManager(), new MainScreenFragment(), R.id.my_list_fragment);
        //TODO fix
        detailFragment = (DetailScreenFragment) getSupportFragmentManager().findFragmentById(R.id.my_detail_fragment);
        View fragmentDetailScreen = findViewById(R.id.my_detail_fragment);

        isTwoPane = fragmentDetailScreen != null && fragmentDetailScreen.getVisibility() == View.VISIBLE;
    }


    @Override
    public void displayDetails(Integer postId) {
        if (isTwoPane) {
            //TODO fix
            Bundle bundle = new Bundle();
            bundle.putInt(getString(R.string.GetPostId), postId);
            detailFragment.setArguments(bundle);

            addFragmentToActivity(getSupportFragmentManager(), detailFragment, R.id.my_detail_fragment);
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(getString(R.string.GetPostId), postId);
            startActivity(intent);
        }
    }
}
