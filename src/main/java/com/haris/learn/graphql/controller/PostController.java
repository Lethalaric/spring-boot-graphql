package com.haris.learn.graphql.controller;

import com.haris.learn.graphql.dao.PostDao;
import com.haris.learn.graphql.model.Post;
import com.haris.learn.graphql.model.PostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostDao postDao;

    @QueryMapping
    public Page<Post> recentPosts(@Argument int count, @Argument int offset) {
        return postDao.getRecentPosts(count, offset);
    }

    @QueryMapping
    public List<Post> findPost(@Argument PostRequest postRequest) {
        return postDao.findPost(postRequest);
    }

    @MutationMapping
    public Post insertPost(@Argument PostRequest postRequest) {
        return postDao.insertPost(postRequest);
    }

}
