package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Book;
import com.example.pojo.User;
import com.example.service.BookService;
import com.example.service.BookServiceImpl;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class DoController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private BookService bookService;

    @Autowired
    public void setBookService(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/select")
    public String select() {
        List<Book> books = bookService.queryAllBooks();
        return JSONObject.toJSONString(books);
    }
    
    @PostMapping("/delete")
    public String delete(@RequestParam("bookName") String bookName) {
        System.out.println("删除的书籍为：" + bookName);
        int result = bookService.deleteBookByName(bookName);
        System.out.println("删除结果为：" + result);
        return String.valueOf(result);
    }

    @PostMapping("/add")
    public String add(Book book) {
        if (bookService.isHasBookByName(book.getBookName())) {
            /*表示有该书名的书籍*/
            return "-1";
        }
        int result = bookService.addBook(book);
        System.out.println("插入书籍：" + book.toString() + "\n结果为：" + result);
        return String.valueOf(result);
    }

    @GetMapping("/Session")
    public String getSession(HttpSession session) {
        System.out.println("传递给前端的Session用户名为：" + session.getAttribute("username"));
        return (String) session.getAttribute("username");
    }

    @PostMapping("/doLogin")
    public String login(User user, HttpSession session) {
        if (userService.hasUser(user)) {
            session.setAttribute("username", user.getUsername());
            System.out.println("当前登录的用户为：" + user.toString());
            //返回1表示登录成功
            return "1";
        } else {
            //返回0表示登录失败
            return "0";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //注销操作，将session保存的用户名移除
        session.removeAttribute("username");
        return "1";
    }
}
