package com.example.dnt.dagger2mvp.detail_screen;

import com.example.dnt.dagger2mvp.data.Post;
import com.example.dnt.dagger2mvp.data.PostComment;

import java.util.List;

/**
 * Created by dnt on 2.2.2017 г..
 */

public interface DetailScreenContract {
    interface View {
        void showComments(List<PostComment> postComments);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadComments(int postId);
    }
}
