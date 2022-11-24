package com.codeup.codeupspring.service;

import com.codeup.codeupspring.entity.User;
import com.codeup.codeupspring.exception.UserNotFoundException;
import com.codeup.codeupspring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService{

    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return unwrapUser(user, id);
    }



    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    static User unwrapUser(Optional<User> entity, Long id) {
        if(entity.isPresent()) return entity.get();
        else throw new UserNotFoundException(id);
    }
}
