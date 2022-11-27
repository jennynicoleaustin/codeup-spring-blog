package com.codeup.codeupspring.webController;

import com.codeup.codeupspring.entity.User;
import com.codeup.codeupspring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @GetMapping("/sign-up")
    public String SignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }

} // UserController
