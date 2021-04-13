package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Book;
import com.example.service.BookService;
import com.example.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

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

    @GetMapping("/updatedId/{id}")
    public String updatedId(@PathVariable String id) {
        return "updateBook";
    }

}
