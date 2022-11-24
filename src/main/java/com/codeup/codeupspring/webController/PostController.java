package com.codeup.codeupspring.webController;

import com.codeup.codeupspring.entity.Post;
import com.codeup.codeupspring.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String createForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/submitCreateForm")
    public String submitCreateForm(Post post) {
        postService.savePost(post);
        return "redirect:/posts";
    }
}
