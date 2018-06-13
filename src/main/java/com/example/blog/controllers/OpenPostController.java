package com.example.blog.controllers;

import com.example.blog.objects.Post;
import com.example.blog.objects.Tag;
import com.example.blog.repositories.ParagraphRepository;
import com.example.blog.repositories.PostRepository;
import com.example.blog.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api2")
public class OpenPostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private ParagraphRepository paragraphRepository;

    @RequestMapping(value = "/getposts", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> getAllPosts() {
        List<Post> list = postRepository.findAll();
        return list;
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Post> getPost(@PathVariable("id") Long id) {
        Optional<Post> post = postRepository.findById(id);
        // post.get().setParagraphs(paragraphRepository.findAll());
        // paragraphRepository.findById(id);
        return post;
    }

    @RequestMapping(value = "/getTags", method = RequestMethod.GET)
    @ResponseBody
    public List<Tag> getTags() {
        List<Tag> tags = tagRepository.findAll();
        return tags;
    }

    @RequestMapping(value = "/getpost", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> getPost(@RequestParam("tagName") String tagName) {
        //Tag tag = tagRepository.findByTagName(tagName);
        List<Post> posts = postRepository.findByTags_Name(tagName);
        return posts;
    }
}
