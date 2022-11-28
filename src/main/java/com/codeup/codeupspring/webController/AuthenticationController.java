package com.codeup.codeupspring.webController;

import com.codeup.codeupspring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthenticationController {

    private UserRepository userRepository;

//    public AuthenticationController()

    @GetMapping("/login")
    public String loginForm() {
        return "users/login";
    }

    @PostMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }

} // AuthenticationController
