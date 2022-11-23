package com.codeup.codeupspring.service;

import com.codeup.codeupspring.entity.Post;
import com.codeup.codeupspring.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PostServiceImp implements PostService {
    PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

}
