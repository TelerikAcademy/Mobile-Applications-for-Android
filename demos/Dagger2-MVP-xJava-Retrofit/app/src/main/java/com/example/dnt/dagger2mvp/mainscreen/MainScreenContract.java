package com.example.dnt.dagger2mvp.mainscreen;

import com.example.dnt.dagger2mvp.data.Post;

import java.util.List;

/**
 * Created by dnt on 31.1.2017 г..
 */

public interface MainScreenContract {
    interface View {
        void showPosts(List<Post> posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}