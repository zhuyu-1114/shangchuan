package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pojo.User;
import service.UserService;
import util.PageUtil;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/doLogin.html")
    private String doLogin(String userName, String passWord, Model model, HttpSession session, HttpServletResponse response){
       /* ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("UserService");
        */User user = userService.login(userName, passWord);
        //如何将参数存到session里
        //1.无法直接访问login页面
        //2.拦截器：没有登录也能访问其他页面
        if(user!=null){
            /*return "index";*/
            session.setAttribute("user", user);
            return "index";
        }else {
            throw new RuntimeException("用户名或密码不正确");
        }
        /*//注意：重定向,不会通过视图解析器,解析View
        return "redirect:login.html";*/
    }

    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }

    @RequestMapping("/getPage")
    @ResponseBody
    public PageUtil getPage(String pageIndex){
        //需要优化，会使用分页工具，会使用JSON数据传输
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("UserService");
        if(pageIndex==null || "".equals(pageIndex)){
            pageIndex = "1";
        }
        if (Integer.parseInt(pageIndex)<1){
            pageIndex="1";
        }
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageindex(Integer.parseInt(pageIndex));
        pageUtil.setPagesize(2);
        userService.getPage(pageUtil);
        return pageUtil;
    }


    @RequestMapping("/add.html")
    public String add(){
        return "add";
    }

    @RequestMapping("/add")
    //Spring是支持对象传递的
    public String addUser(String userName,String passWord,String sex,String name){
        User user = new User(userName,passWord,sex,new Date(),new Date(),name);
        if(userService.addUser(user)){
            return "index";
        }
        return "add";
    }
    @RequestMapping("/delUser/{id}")
    @ResponseBody
    public Boolean delUser(@PathVariable String id){
        return userService.delUser(Integer.parseInt(id));
    }

    @RequestMapping("/upd.html")
    public String update(int id,Model model){
        model.addAttribute("id",id);
        return "upd";
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public User getOne(int id){
        return userService.getUserById(id);
    }
    @RequestMapping("/upd")
    public String updaUser(String id,String userName,String passWord,String sex,String name){
        User user = new User(Integer.parseInt(id),userName,passWord,sex,null,new Date(),name);
        if(userService.updUser(user)){
            return "index";
        }else {
            return "redirect:upd.html?id=" + id;
        }
    }
    /*@RequestMapping("/userJSON")
    @ResponseBody
    public User getUserJSON(){
        User user = new User();
        user.setId(1);
        user.setUserName("qwe");
        user.setSex("男");
        user.setPassWord("123456");
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        return user;
    }*/

    //局部异常的处理
    /*@ExceptionHandler(value = {RuntimeException.class})
    public String handlerException(RuntimeException e, HttpServletRequest request){
        request.setAttribute("e", e);
        return "error";
    }*/
}
