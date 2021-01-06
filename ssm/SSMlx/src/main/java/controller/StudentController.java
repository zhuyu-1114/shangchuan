package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.PageUtil;
import pojo.Student;
import service.StudentService;

import java.util.Date;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping("/getPage")
    @ResponseBody
    public String getPage(String pageindex, Model model){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = (StudentService) applicationContext.getBean("studentService");
        if(pageindex == null || "".equals(pageindex)){
            pageindex ="1";
        }
        int index = Integer.parseInt(pageindex);
        if(index < 1){
            index=1;
        }
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageindex(index);
        pageUtil.setPagesize(3);
        studentService.getPage(pageUtil);
        model.addAttribute(pageUtil);
        return "index";
    }

    @RequestMapping("/del")
    public String del(String id){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.delStu(Integer.parseInt(id));
        return "redirect:getPage.html";
    }


    @RequestMapping("/add.html")
    public String add(){
        return "add";
    }

    @RequestMapping("add")
    public String addUser(String userName,String sex){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = (StudentService) applicationContext.getBean("studentService");
        Student student = new Student(userName,new Date(),sex);
        int num = studentService.addStu(student);
        if(num != 0){
            return "index";
        }
        return "add";
    }

    @RequestMapping("/update.html")
    public String getOne(String id,Model model){
        Student student = studentService.getStuById(Integer.parseInt(id));
        model.addAttribute(student);
        return "update";
    }

    @RequestMapping("/update")
    public String updUser(String id,String userName,String birthday,String sex){
        Student student = new Student(Integer.parseInt(id),userName, new Date(),sex);
        int num = studentService.updStu(student);

        if(num > 0){
            return "redirect:getPage.html";
        }else{
            return "update";
        }
    }



}
