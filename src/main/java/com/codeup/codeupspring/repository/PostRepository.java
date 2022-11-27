package com.codeup.codeupspring.repository;

import com.codeup.codeupspring.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findByTitle(String title);
}
