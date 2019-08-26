import com.wb.entity.User;
import com.wb.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {
    @Test
    public void userDaoTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans05.xml");
        UserService userService = (UserService) context.getBean("userService");
        //System.out.println(userService.getJdbcurl());
        for (User user:userService.findAll()){
            System.out.println(user);
        }
    }
}
