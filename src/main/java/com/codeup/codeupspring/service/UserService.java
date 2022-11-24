package com.codeup.codeupspring.service;

import com.codeup.codeupspring.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUser(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    List<User> getUsers();
}
