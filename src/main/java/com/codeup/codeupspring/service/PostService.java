package com.codeup.codeupspring.service;

import com.codeup.codeupspring.entity.Post;

import java.util.List;

public interface PostService {
    Post savePost(Post post, Long id);
    Post getPost(Long id);
    Post editPost(Post post, Long id);
    void deletePost(Long id);
    List<Post> getPosts();
}
