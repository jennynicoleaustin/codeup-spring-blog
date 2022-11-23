package com.codeup.codeupspring.web;

import com.codeup.codeupspring.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String getPostIndexPage(Model model) {
        List<Post> allPosts = new ArrayList<>();
        Post post = new Post("Day One", "Day One on the blog! Check out what I did! ");
        Post post2 = new Post("Day two", "Day teo on the blog! Check out what I did! ");
        allPosts.add(post);
        allPosts.add(post2);
        model.addAttribute("posts", allPosts);
        return "/posts/index";
    }

    @GetMapping(path = "/show")
    public String getIndividualPostByID(Model model, @PathVariable(required = false) Long id) {
        Post firstPost = new Post("Welcome Day", "I so excited you are visiting my blog! I hope you stick around");
        model.addAttribute("post", firstPost);
        return "posts/show";
    }

    //    @GetMapping("/posts/create")
    //    public String CreatePostForm (Model model) {
    //        model.addAttribute("post", new Post)
    //        return "createPostForm";
    //    }

    @PostMapping("/posts/create")
    public String submitCreatePostForm() {
        return "redirect:/index";
    }
}
