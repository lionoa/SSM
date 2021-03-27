package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String hello() {
        return "index";
    }

    @RequestMapping("/books")
    public String books() {
        return "books";
    }

    @RequestMapping("/addBook")
    public String addBook() {
        return "addBook";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
