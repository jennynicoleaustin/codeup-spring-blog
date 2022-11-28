package com.codeup.codeupspring.service;

import com.codeup.codeupspring.entity.User;

import java.util.List;
public interface UserService {
    User getUser(Long id);

    User saveUser(User user);

    void deleteUser(Long id);

    List<User> getUsers();
}
