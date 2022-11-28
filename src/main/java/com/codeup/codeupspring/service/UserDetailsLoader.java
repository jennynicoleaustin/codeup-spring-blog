package com.codeup.codeupspring.service;

import com.codeup.codeupspring.entity.User;
import com.codeup.codeupspring.entity.UserWithRoles;
import com.codeup.codeupspring.exception.EntityNotFoundException;
import com.codeup.codeupspring.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository users;
    public UserDetailsLoader(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new EntityNotFoundException(username, User.class);
        }
        return new UserWithRoles(user);
    }
}
