package com.codeup.codeupspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String getPostIndexPage () {
        return "index";
    }

    @GetMapping(path = "/posts/{id}")
    public String getIndividualPostByID (@PathVariable long id) {

        return "posts.{id}";
    }

//    @GetMapping("/posts/create")
//    public String CreatePostForm (Model model) {
//        model.addAttribute("post", new Post)
//        return "createPostForm";
//    }

    @PostMapping("/posts/create")
    public String submitCreatePostForm () {
        return "redirect:/index";
    }
}
