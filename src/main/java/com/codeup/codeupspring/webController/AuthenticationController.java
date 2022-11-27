package com.codeup.codeupspring.webController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String loginForm() {
        return "users/login";
    }

    @PostMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }

} // AuthenticationController
