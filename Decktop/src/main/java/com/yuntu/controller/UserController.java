package com.yuntu.controller;

import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.User;
import com.yuntu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController{
    @Autowired
    UserService userService;
    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }
    @RequestMapping("/yhgl")
    public String yhgl(){
        return "userlist";
    }
    @RequestMapping("/ddgl")
    public String ddgl(){
        return "billlist";
    }
    @RequestMapping("/gysgl")
    public String gysgl(){
        return "providerlist";
    }
    @RequestMapping("/tcxt")
    public String tcxt(){
        return "login";
    }
    @RequestMapping("/mmxg")
        public String mmxg(){
            return "pwdmodify";
        }

        @RequestMapping("doLogin.html")
        public String dologin(String userCode, String userPassword, Model model, HttpSession session){
            User u = userService.login(userCode, userPassword);
        if(u!=null){
            session.setAttribute("user",u);
            return "frame";
        }
        return "login";
    }
    @RequestMapping("/getPage.html")
    @ResponseBody
    public PageUtil getPage(String pageindex){
        if(pageindex==null || "".equals(pageindex)){
            pageindex = "1";
        }
        if(Integer.parseInt(pageindex)<1){
            pageindex = "1";
        }
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageindex(Integer.parseInt(pageindex));
        pageUtil.setPagesize(2);
        userService.getPage(pageUtil);
        return pageUtil;
    }
    @RequestMapping("/add.html")
    public String add(){
        return "add";
    }
    @RequestMapping("/add")
    public String addUser(User user){

        User student = new User(user.getId(),user.getUserCode(),user.getUserName(),user.getUserPassword(),user.getGender(),user.getBirthday(),user.getPhone(),user.getAddress(),user.getUserRole(),user.getCreatedBy(),new Date(),user.getModifyBy(),new Date());
        if (userService.addStu(student)){
            return "frame";
        }
        return "add.html";
    }
}
