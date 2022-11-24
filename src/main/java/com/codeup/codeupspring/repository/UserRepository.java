package com.codeup.codeupspring.repository;

import com.codeup.codeupspring.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User addUser
}