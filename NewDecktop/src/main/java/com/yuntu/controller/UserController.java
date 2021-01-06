package com.yuntu.controller;

import com.yuntu.pojo.User;
import com.yuntu.service.user.UserService;
import com.yuntu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/doLogin")
    public String Login(String userCode, String userPassword, HttpSession session){
        User user = userService.Login(userCode,userPassword);
        if (user!=null){
            session.setAttribute("user",user);
            return "redirect:frame";
        }
        return "redirect:login";
    }

    @RequestMapping("/frame")
    public String Frame(){
        return "frame";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginout")
    public String loginOut(HttpSession session){
        session.removeAttribute("user");
        return "redirect:login";
    }

    @RequestMapping("/updPwd")
    public String updPwd(){
        return "pwdmodify";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(HttpSession session){
        User user  = (User) session.getAttribute("user");
        return user;
    }

    @RequestMapping("/doUpdPwd")
    @ResponseBody
    public boolean doUpdPwd(String newpwd,HttpSession session){
        User user  = (User) session.getAttribute("user");
        boolean flag = userService.updPwd(newpwd,user.getId());
        return flag;
    }

    @RequestMapping("/userList")
    public String userList(){
        return "userlist";
    }

    @RequestMapping("/getUserPage")
    @ResponseBody
    public PageUtil<User> getUserPage(String pageindex){
        if (pageindex.equals("") || pageindex==null){
            pageindex="1";
        }
        int index = Integer.parseInt(pageindex);
        if (index<1){
            index=1;
        }
        PageUtil<User> pageUtil = new PageUtil<User>();
        pageUtil.setPageindex(index);
        pageUtil.setPagesize(5);
        userService.getUserPage(pageUtil);
        return pageUtil;
    }

    @RequestMapping("/userView")
    public String userView(String id, Model model){
        model.addAttribute("id",id);
        return "userview";
    }

    @RequestMapping("/updateUser")
    public String updateUser(String id, Model model){
        model.addAttribute("id",id);
        return "usermodify";
    }
    @RequestMapping("/delUser")
    @ResponseBody
    public boolean delUserById(String id){
        return userService.delUser(Integer.parseInt(id));
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUser(String id){
        return userService.getUserById(Integer.parseInt(id));
    }

    @RequestMapping("/addUser")
    public String localAddUser(){
        return "useradd";
    }

    @RequestMapping("/addUser.do")
    public String addBill(String userCode,String userName,String userPassword, String gender ,String birthday ,String phone,String address,String userRole,HttpSession session) {
        int role = Integer.parseInt(userRole);
        int sex = Integer.parseInt(gender);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date =null;
        try {
            date = ft.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = (User) session.getAttribute("user");
        User addUser = new User(userCode,userName,userPassword,sex,date,phone,address,role,user.getId(),new Date());
        boolean addflag = userService.addUser(addUser);
        if (addflag){
            return "redirect:userList";
        }
        return "redirect:error";
    }

    @RequestMapping("/updUser")
    public String localUpdUser(String id, Model model){
            model.addAttribute("id",id);
            return "usermodify";
    }

    @RequestMapping("/updUser.do")
    public String updUser(String uid,String userCode,String userName,String userPassword, String gender ,String birthday ,String phone,String address,String userRole,HttpSession session){
        int role = Integer.parseInt(userRole);
        int sex = Integer.parseInt(gender);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date =null;
        try {
            date = ft.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = (User) session.getAttribute("user");
        User upduser = new User(Integer.parseInt(uid),userCode,userName,userPassword,sex,date,phone,address,role,user.getId(),new Date());
        boolean addflag = userService.updUser(upduser);
        if (addflag){
            return "redirect:userList";
        }
        return "redirect:error";
    }

    @RequestMapping("/getUserByCondition")
    @ResponseBody
    public List<User> getUserByCondition(String username, String userrole){
        return userService.getUserByCondition(username,Integer.parseInt(userrole));
    }
}
