package com.example.blog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api2")
public class OpenControler {
    @RequestMapping(value = "/tester", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<String> returnLust() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        return list;
    }
}
