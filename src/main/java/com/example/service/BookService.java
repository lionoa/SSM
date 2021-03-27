package com.example.service;

import com.example.pojo.Book;

import java.util.List;

public interface BookService {

    List<Book> queryAllBooks();
    int deleteBookByName(String  username);
    int addBook(Book book);
    boolean isHasBookByName(String bookName);
}
