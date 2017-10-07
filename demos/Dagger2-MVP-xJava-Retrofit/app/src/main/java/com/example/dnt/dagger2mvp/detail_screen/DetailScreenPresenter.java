package com.example.dnt.dagger2mvp.detail_screen;

import com.example.dnt.dagger2mvp.data.Post;
import com.example.dnt.dagger2mvp.data.PostComment;
import com.example.dnt.dagger2mvp.mainscreen.MainScreenContract;
import com.example.dnt.dagger2mvp.mainscreen.MainScreenPresenter;

import org.w3c.dom.Comment;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dnt on 2.2.2017 г..
 */

public class DetailScreenPresenter implements DetailScreenContract.Presenter {
    Retrofit retrofit;
    DetailScreenContract.View mView;

    @Inject
    DetailScreenPresenter(Retrofit retrofit, DetailScreenContract.View mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loadComments(int postId) {
        //TODO

        retrofit.create(CommentService.class).getCommentsListByPostId(postId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<PostComment>>() {
                    @Override
                    public void onCompleted()  {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e)  {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<PostComment> posts)  {
                        mView.showComments(posts);
                    }
                });
    }

    private interface CommentService {
        @GET("/posts/{id}/comments")
        Observable<List<PostComment>> getCommentsListByPostId(@Path("id") int id);
    }
}
