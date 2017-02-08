package com.example.dnt.dagger2mvp.data;

import java.util.ArrayList;

/**
 * Created by dnt on 31.1.2017 г..
 */

public class Post {
    private final Integer userId;
    private final Integer id;
    private final String title;
    private final String body;

    private ArrayList<PostComment> comments;

    public Post(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
        this.comments = new ArrayList<>();
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public ArrayList<PostComment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<PostComment> comments) {
        this.comments = comments;
    }
}
