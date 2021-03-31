package com.example.dao;

import com.example.pojo.Book;

import java.util.List;

public interface BookDao {

    List<Book> queryAllBooks();
    int deleteBookById(int id);
    int addBook(Book book);
    Book queryBookByName(String bookName);
}
