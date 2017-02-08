package com.example.dnt.dagger2mvp.detail_screen;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dnt.dagger2mvp.App;
import com.example.dnt.dagger2mvp.R;
import com.example.dnt.dagger2mvp.data.Post;
import com.example.dnt.dagger2mvp.data.PostComment;
import com.example.dnt.dagger2mvp.data.PostCommentsAdapter;
import com.example.dnt.dagger2mvp.data.PostsAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.R.id.message;

/**
 * Created by dnt on 2.2.2017 г..
 */

public class DetailScreenFragment extends android.support.v4.app.Fragment implements DetailScreenContract.View{

    ArrayList<PostComment> commentsList;
    RecyclerView recyclerView;
    PostCommentsAdapter adapter;

    @Inject
    DetailScreenPresenter presenter;

    public DetailScreenFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail,container,false);

        DaggerDetailScreenComponent.builder()
                .netComponent(((App) getActivity().getApplicationContext()).getNetComponent())
                .detailScreenModule(new DetailScreenModule(this))
                .build().inject(this);
        Integer postId = getArguments().getInt(getString(R.string.GetPostId));
        this.commentsList = new ArrayList<>();

        presenter.loadComments(postId);

        recyclerView = (RecyclerView) view.findViewById(R.id.my_comments_list);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        return view;
    }


    @Override
    public void showComments(List<PostComment> postComments) {
        for (int i = 0; i<postComments.size();i++){
            this.commentsList.add(postComments.get(i));
        }

        adapter = new PostCommentsAdapter(getActivity(), this.commentsList);
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
