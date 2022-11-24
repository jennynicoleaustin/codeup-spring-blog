package com.codeup.codeupspring.webController;

import com.codeup.codeupspring.entity.Post;
import com.codeup.codeupspring.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class PostController {
    PostService postService;

    @GetMapping("/posts")
    public String getPosts(Model model) {
        List<Post> allPosts = postService.getPosts();
        model.addAttribute("posts", allPosts);
        return "/posts/index";
    }

    @GetMapping(path = "/show")
    public String getPost(Model model, @PathVariable(required = false) Long id) {
        Optional<Post> post = postService.getPost(id);
        model.addAttribute("post");
        return "posts/show";
    }

    @GetMapping(path = "/create")
    public String postForm(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("post", postService.getPost(id));
        return "posts/postForm";
    }

    public String editForm() {

        return "postForm";
    }

    @PostMapping("/submitPostForm")
    public String submitCreateForm(@ModelAttribute Post post) {
        postService.savePost(post);
        return "redirect:/posts";
    }
}
