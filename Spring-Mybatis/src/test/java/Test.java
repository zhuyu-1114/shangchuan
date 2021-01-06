import com.yuntu.biz.UserBiz;
import com.yuntu.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    @org.junit.Test
    public void Test(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserBiz userBiz = (UserBiz) applicationContext.getBean("userService");
        List<User> userList  = userBiz.getAll();
        for(User u:userList){
            System.out.println(u.toString());
        }
    }
}
