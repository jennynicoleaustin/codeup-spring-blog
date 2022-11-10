package com.codeup.codeupspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String getPostIndexPage () {

        return "/posts/index";
    }

    @GetMapping(path = "/show")
    public String getIndividualPostByID (@PathVariable(required = false) Long id) {
        Post firstPost = new Post("Welcome Day", "I so excited you are visiting my blog! I hope you stick around");
        return "posts/show";
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
