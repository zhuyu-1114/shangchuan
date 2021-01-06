package com.yuntu.demo.controller;

import com.yuntu.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Value("Hello World!!!")
    public String a;


    @RequestMapping("/hello")
    @ResponseBody
    public String Hello(){

        return a;
    }
}
