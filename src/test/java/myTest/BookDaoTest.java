package myTest;

import com.example.pojo.Book;
import com.example.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BookDaoTest {
    @Test
    void bookDaoTest() {
        Book book = new Book(1,"小奇乐教程",128,18,"教程");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookService.class);
        int i = bookService.updateBook(book);
        System.out.println(i);
    }
}
