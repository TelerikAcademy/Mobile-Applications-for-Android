package com.example.dnt.dagger2mvp.data;

import java.util.ArrayList;

import static android.R.attr.id;

/**
 * Created by dnt on 2.2.2017 г..
 */

public class PostComment {

    public String authorName;
    public Integer id;
    public Integer postId;
    public String body;

    public PostComment(Integer postId, Integer id, String authorName, String body) {
        this.postId = postId;
        this.id= id;
        this.authorName= authorName;
        this.body = body;

    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }



    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
