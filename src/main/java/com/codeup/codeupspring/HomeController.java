package com.codeup.codeupspring;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String getHome () {
        return "This is the landing page";
    }
}
