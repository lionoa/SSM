package myTest;

import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BookDaoTest {
    @Test
    void bookDaoTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        UserService userService = context.getBean("userServiceImpl", UserService.class);
        System.out.println(userService);
    }
}
