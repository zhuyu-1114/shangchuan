package com.yuntu.controller;


import com.yuntu.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController{
    //创建日志
    private Logger logger = Logger.getLogger(IndexController.class);

    //Controller都会有增删改查的方法
    //@RequestMapping映射的请求信息，必须要全局唯一

    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "userName" ,required =false ) String userName){
        logger.info("Hello-SpringMvc");
        //参数的接收
        //@RequestParam接收到前台传递过来的值，默认为变量名
        //@RequestParam三个参数：
        //1.value：参数名称
        //2.required：是否必需，默认值为true，请求中是否需要参数，如果没有抛出异常
        //3.defaultValue：默认参数，不推荐使用
        //相当于request.getParameter
        logger.info("接收到的值为"+userName);

        //ModelAndView,有些请求
        //，不仅仅只返回视图，还要携带参数（模型）
        ModelAndView mView =  new ModelAndView();
        String name = "你好";
        //addObject()：添加模型数据
        mView.addObject("userName",name);
        mView.setViewName("index1");
        return mView;
    }
    //value:可以是一个String类型的数组
    //value里面可以写多个参数，访问的时候，多个URL方法都可以进入此方法2

    //method：表示的是请求方法(RequestMethod.GET,RequestMethod.POST)
    //值会从RequestMethod对象里获取静态常量
    @RequestMapping(value = {"/Model-index","/"})
    public String ModelIndex(@RequestParam("userName") String userName,Model model){
        //Model model:隐式模型
        model.addAttribute("number","小张");
        //可以不指定键，会使用对象的类型最为Key
        //如果userName的类型是String，则Key为String
        model.addAttribute(userName);

        User user = new User("账号","密码");
        model.addAttribute(user);
        return "index1";
    }
}
