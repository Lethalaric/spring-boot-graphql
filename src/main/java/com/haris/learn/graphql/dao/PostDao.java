package com.haris.learn.graphql.dao;

import com.haris.learn.graphql.model.Post;
import com.haris.learn.graphql.model.PostRequest;
import com.haris.learn.graphql.repository.PostRepository;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDao {

    @Autowired
    private PostRepository postRepository;

    public Page<Post> getRecentPosts(int count, int offset) {
        return postRepository.findAll(PageRequest.of(offset, count));
    }

    public List<Post> findPost(PostRequest postRequest) {
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withMatcher("authorId", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("category", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnorePaths("id")
                .withIgnoreNullValues();
        Post post = Post
                .builder()
                .authorId(postRequest.getAuthorId())
                .category(postRequest.getCategory())
                .title(postRequest.getTitle())
                .build();
        return postRepository.findAll(Example.of(post, exampleMatcher));
    }

    public Post insertPost(PostRequest postRequest) {
        Lorem lorem = LoremIpsum.getInstance();
        Post post = Post
                .builder()
                .authorId(postRequest.getAuthorId())
                .title(postRequest.getTitle())
                .category(postRequest.getCategory())
                .description(lorem.getWords(35))
                .build();

        return postRepository.save(post);
    }
}
