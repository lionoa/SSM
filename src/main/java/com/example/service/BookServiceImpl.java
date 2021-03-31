package com.example.service;

import com.example.dao.BookDaoImpl;
import com.example.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private BookDaoImpl bookDao;

    @Autowired
    public void setBookDao(BookDaoImpl bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> queryAllBooks() {
        return bookDao.queryAllBooks();
    }

    @Override
    public int deleteBookById(int  id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public boolean isHasBookByName(String bookName) {
        Book book = bookDao.queryBookByName(bookName);
        return book != null;
    }
}
