package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;
import service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/dologin.html")
    public String login(String userName, String password, Model model, HttpSession session, HttpServletResponse response){
        User user = userService.login(userName,password);
        if(user!=null){
            session.setAttribute("user", user);
            return "index";
        }
        return "redirect:login.html";
    }

    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }
}
