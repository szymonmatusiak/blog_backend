package com.example.blog.controllers;

import com.example.blog.objects.ApplicationUser;
import com.example.blog.objects.Post;
import com.example.blog.objects.PostComment;
import com.example.blog.objects.Tag;
import com.example.blog.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ApplicationUserRepository userRepo;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private CommentsRepository commentsRepository;

    @RequestMapping(value = "/createPost", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(Principal principal, @RequestBody Post post) {
        ApplicationUser user = userRepo.findByEmail(principal.getName());
        if (true) {
            postRepository.save(post);
            return "success";
        } else return "not allowed";
    }

    @RequestMapping(value = "/addComment/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(Principal principal, @RequestBody PostComment comment, @PathVariable("id") Long id) {
        //ApplicationUser user = userRepo.findByEmail(principal.getName());
        Optional<Post> post = postRepository.findById(id);
        post.get().getComments().add(comment);
        postRepository.save(post.get());
        //commentsRepository.save(comment);
        return "";
    }

    @RequestMapping(value = "/createTag", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(Principal principal, @RequestBody Tag tag) {
        tagRepository.save(tag);
        return "";
    }
}
