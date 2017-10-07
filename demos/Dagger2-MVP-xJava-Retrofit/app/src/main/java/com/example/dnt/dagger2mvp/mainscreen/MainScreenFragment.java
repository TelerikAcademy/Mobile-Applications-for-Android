package com.example.dnt.dagger2mvp.mainscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dnt.dagger2mvp.App;
import com.example.dnt.dagger2mvp.R;
import com.example.dnt.dagger2mvp.data.Post;
import com.example.dnt.dagger2mvp.data.PostsAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainScreenFragment extends Fragment implements MainScreenContract.View  {

    ArrayList<Post> list;
    RecyclerView recyclerView;
    PostsAdapter adapter;

    @Inject
    MainScreenPresenter mainScreenPresenter;

    public MainScreenFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment_main_screen,container,false);
        DaggerMainScreenComponent.builder()
                .netComponent(((App) getActivity().getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);
        this.list = new ArrayList<>();

        mainScreenPresenter.loadPost();

        recyclerView = (RecyclerView) view.findViewById(R.id.my_list);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        return view;
    }


    @Override
    public void showPosts(List<Post> posts) {
        for (int i = 0; i < posts.size(); i++) {
            this.list.add(posts.get(i));
        }

        adapter = new PostsAdapter(getActivity(), this.list);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), "Error" + message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showComplete() {
            Toast.makeText(getContext(), "Complete", Toast.LENGTH_SHORT).show();

    }
}
