import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;
import service.UserService;
import util.PageUtil;

import java.util.Date;
import java.util.List;

public class Test {
    @org.junit.Test
    public void getPage(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("UserService");
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageindex(1);
        pageUtil.setPagesize(2);
        userService.getPage(pageUtil);
        System.out.println(pageUtil);
    }
    @org.junit.Test
    public void login(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("UserService");
        User user = userService.login("li", "123456");
        if(user!=null){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }

    }
    @org.junit.Test
    public void addUser(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("UserService");
        User user = new User("yy","123456","男",new Date(),new Date(),"花花");
        if(userService.addUser(user)){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }
    @org.junit.Test
    public void updUser(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("UserService");
        User user = new User(1,"zyy","123456","女",new Date(),new Date(),"花花");
        if(userService.addUser(user)){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }
    @org.junit.Test
    public void delUser(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("UserService");
        if(userService.delUser(2)){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }
    @org.junit.Test
    public void getUserById(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("UserService");
        User user = userService.getUserById(3);
        System.out.println(user);
    }
    @org.junit.Test
    public void getUserBySexAndName(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("UserService");
        List<User> users = userService.getUserBySexAndName("男", "BOSS");
        System.out.println(users);

    }
}
