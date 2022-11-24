package com.codeup.codeupspring.service;

import com.codeup.codeupspring.entity.Post;
import com.codeup.codeupspring.entity.User;
import com.codeup.codeupspring.repository.PostRepository;
import com.codeup.codeupspring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostServiceImp implements PostService {
    PostRepository postRepository;
    UserRepository userRepository;

    @Override
    public Post savePost(Post post, Long user_id) {
        User user = UserServiceImp.unwrapUser((userRepository.findById(user_id)), user_id);
        post.setUser(user);
        return postRepository.save(post);
    }

    @Override
    public Post getPost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return unwrapPost(post, id);
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

    static Post unwrapPost(Optional<Post> entity, Long id) {
        return entity.orElseGet(Post::new);
    }

}
