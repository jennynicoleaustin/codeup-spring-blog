package com.codeup.codeupspring;

import com.codeup.codeupspring.entity.Post;
import com.codeup.codeupspring.entity.User;
import com.codeup.codeupspring.repository.PostRepository;
import com.codeup.codeupspring.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CodeupSpringApplicationTests.class)
@AutoConfigureMockMvc
public class PostsIntegrationTests {

    @Autowired
    private MockMvc mvc;

    private HttpSession httpSession;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setup() throws Exception {

        User user = userRepository.findByUsername("user");
        if (user == null) {
            user = new User("user", "user@codeup.com", passwordEncoder.encode("password"));
            userRepository.save(user);
        }

        httpSession = this.mvc.perform(post("/login").with(csrf())
                        .param("username", "testUser")
                        .param("password", "getmein"))
                .andExpect(status().is(HttpStatus.FOUND.value()))
                .andExpect(redirectedUrl("/posts"))
                .andReturn()
                .getRequest()
                .getSession();
    }


    // sanity test
    @Test
    public void testIfContextLoads() {
        assertNotNull(mvc);
    }


    // sanity test
    @Test
    public void testIfSessionCreated() {
        assertNotNull(httpSession);
    }


    @Test
    public void testCreatePost() throws Exception {
        // Makes a Post request to /posts/create and expect a redirection to the Post
        this.mvc.perform(
                        post("/posts/create").with(csrf())
                                .session((MockHttpSession) httpSession)
                                // Add all the required parameters to your request like this
                                .param("title", "My Integration Test Post")
                                .param("body", "This is the body of the integration test post"))
                .andExpect(status().is3xxRedirection()); // expect on successful post creation, app will redirect user to new page
    }

    @Test
    public void testShowPost() throws Exception {

        Post existingPost = postRepository.findAll().get();

        this.mvc.perform(get("/posts/" + existingPost.getId()))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(existingPost.getBody())));
    }

    @Test
    public void testPostsIndex() throws Exception {
        Post existingPost = postRepository.findAll().get();

        this.mvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Posts")))
                .andExpect(content().string(containsString(existingPost.getTitle())));
    }

    @Test
    public void testEditPost() throws Exception {
        Post existingPost = postRepository.findAll().get(0);

        this.mvc.perform(
                        post("/posts/" + existingPost.getId() + "/edit").with(csrf())
                                .session((MockHttpSession) httpSession)
                                .param("title", "edited title")
                                .param("body", "edited body"))
                .andExpect(status().is3xxRedirection());

        this.mvc.perform(get("/posts/" + existingPost.getId()))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("edited title")))
                .andExpect(content().string(containsString("edited body")));
    }

    @Test
    public void testDeletePost() throws Exception {
        this.mvc.perform(
                        post("/posts/create").with(csrf())
                                .session((MockHttpSession) httpSession)
                                .param("title", "Post to be deleted")
                                .param("body", "Won't last long!"))
                .andExpect(status().is3xxRedirection());

        // Get the recent Post that matches the title
        Post existingPost = postRepository.findByTitle("Post to be deleted");

        this.mvc.perform(
                        post("/posts/" + existingPost.getId() + "/delete").with(csrf())
                                .session((MockHttpSession) httpSession)
                                .param("id", String.valueOf(existingPost.getId())))
                .andExpect(status().is3xxRedirection());
    }

}