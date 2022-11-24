package com.codeup.codeupspring.service;

import com.codeup.codeupspring.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post savePost(Post post);
    Optional<Post> getPost(Long id);
    void deletePost(Long id);
    List<Post> getPosts();
}
