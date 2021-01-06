package com.yuntu.controller;


import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.Student;
import com.yuntu.pojo.User;
import com.yuntu.service.StudentService;
import com.yuntu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/getPage")
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
        studentService.getPage(pageUtil);
        return pageUtil;
    }
    @RequestMapping("/add.html")
    public String add(){
        return "add";
    }
    @RequestMapping("/add")
    public String addUser(String userName,String sex){

        Student student = new Student(userName,sex,new Date());
        if (studentService.addStu(student)){
            return "index";
        }
        return "add.html";
    }
    @RequestMapping("/del/{id}")
    @ResponseBody
    public Boolean delUser(@PathVariable String id){
        return studentService.delStu(Integer.parseInt(id));
    }

    @RequestMapping("/upd")
    public String updUser(String id,String userName,String sex){
        Student student = new Student(Integer.parseInt(id),userName,sex,new Date());
        if (studentService.updStu(student)){
            return "index";
        }
        return "update.html";
    }
    @RequestMapping("/getOne")
    @ResponseBody
    public Student getOne(int id){
        return studentService.selStu(id);
    }
    @RequestMapping("/update.html")
    public String getUser(String id,Model model){
        model.addAttribute("id",id);
        return "update";
    }
}
