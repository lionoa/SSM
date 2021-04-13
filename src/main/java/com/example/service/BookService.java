package com.example.service;

import com.example.pojo.Book;

import java.util.List;

public interface BookService {

    List<Book> queryAllBooks();
    int deleteBookById(int  id);
    int addBook(Book book);
    boolean isHasBookByName(String bookName);
    int updateBook(Book book);
    Book queryBookById(int id);
}
