package com.yuntu.controller;

import com.yuntu.pojo.User;
import com.yuntu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }

    @RequestMapping("/doLogin.html")
    public String doLogin(String userName, String password, Model model,HttpSession session){
        User u = userService.login(userName,password);
        //如何将参数存到session里面
        //1.无法直接访问login页面
        //2.拦截器，没有登录也能访问其他页面
        if(u!=null){
            //model存值都是request作用域的
            //model.addAttribute("user",user);
            session.setAttribute("user",u);
            return "index";
        }
        //重定向不会通过视图解析器解析view
        return "redirect:login.html";
    }
}
