import com.yuntu.pojo.User;
import com.yuntu.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void login(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService u = (UserService) applicationContext.getBean("userService");
        User user = u.login("admin","1234567");
        if(user!=null){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}
