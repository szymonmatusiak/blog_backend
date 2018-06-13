package com.example.blog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class UserController {

    @RequestMapping(value = "/tester", method = RequestMethod.GET)
    @ResponseBody
    public String showUserCredential(Principal principal) {
        return principal.getName();
    }
}
