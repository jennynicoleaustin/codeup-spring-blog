package com.codeup.codeupspring.service;

import com.codeup.codeupspring.entity.Post;
import com.codeup.codeupspring.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostServiceImp implements PostService {
    PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post editPost(Post post, Long id) {

        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> getPosts() {
        return (List<Post>) postRepository.findAll();
    }


}
