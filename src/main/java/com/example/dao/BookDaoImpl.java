package com.example.dao;

import com.example.pojo.Book;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Book> queryAllBooks() {
        BookDao bookDao = sqlSessionTemplate.getMapper(BookDao.class);
        return bookDao.queryAllBooks();
    }

    @Override
    public int deleteBookById(int id) {
        BookDao bookDao = sqlSessionTemplate.getMapper(BookDao.class);
        return bookDao.deleteBookById(id);
    }

    @Override
    public int addBook(Book book) {
        BookDao bookDao = sqlSessionTemplate.getMapper(BookDao.class);
        return bookDao.addBook(book);
    }

    @Override
    public Book queryBookByName(String bookName) {
        BookDao bookDao = sqlSessionTemplate.getMapper(BookDao.class);
        return bookDao.queryBookByName(bookName);
    }

    @Override
    public int updateBook(Book book) {
        BookDao bookDao = sqlSessionTemplate.getMapper(BookDao.class);
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) {
        BookDao bookDao = sqlSessionTemplate.getMapper(BookDao.class);
        return bookDao.queryBookById(id);
    }
}
