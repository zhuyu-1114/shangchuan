package com.yuntu.controler;

import com.yuntu.biz.TeacherBiz;
import com.yuntu.pojo.Teacher;
import com.yuntu.uitl.pageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/Teacher")
public class TeacherControler {
    @Autowired
    TeacherBiz teacherBiz;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/getPage")
    @ResponseBody
    public pageUtil getPage(String pageIndex){
//        需要优化，会使用分页工具，会使用json传输数据
        if(pageIndex==null || "".equals(pageIndex)){
            pageIndex = "1";
        }
        if(Integer.parseInt(pageIndex)<1){
            pageIndex = "1";
        }
        pageUtil pageutil = new pageUtil();
        pageutil.setPageindex(Integer.parseInt(pageIndex));
        pageutil.setPagesize(2);
        teacherBiz.getPage(pageutil);
        return pageutil;
    }
    @RequestMapping("/add")
    public String add(){
        return "add";
    }
    //    spring是支持对象传递
    @RequestMapping("/addstu")
    public String addstu(String t_name,String t_idcard,String t_loginName,String t_pwd,int t_sex){
        if(teacherBiz.add(new Teacher(t_name,t_idcard,new Date(),t_loginName,t_pwd,t_sex))){
            return "index";
        }else{
            return "add";
        }
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public Boolean del(@PathVariable String id){
        if(teacherBiz.del(Integer.parseInt(id))!=0){
            return true;
        }
        return false;
    }

    @RequestMapping("/update")
    public String selone(int id,Model model){
        model.addAttribute("id",id);
        return "update";
    }

    @RequestMapping("/getone")
    @ResponseBody
    public Teacher getone(int id){
        return teacherBiz.getById(id);
    };

    @RequestMapping("/upd")
    public String upd(int id,String t_name,String t_idcard,String t_loginName,String t_pwd,int t_sex){
        if(teacherBiz.upd(new Teacher(id,t_name,t_idcard,new Date(),t_loginName,t_pwd,t_sex))!=0){
            return "index";
        }else{
            return "update";
        }
    }
}
