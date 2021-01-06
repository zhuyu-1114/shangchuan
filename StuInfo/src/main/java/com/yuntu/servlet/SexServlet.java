package com.yuntu.servlet;

import com.alibaba.fastjson.JSON;
import com.yuntu.biz.SexBiz;
import com.yuntu.pojo.Sex;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SexServlet",value = "/SexServlet")
public class SexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SexBiz sexBiz = (SexBiz) applicationContext.getBean("sexBiz");
        if ("getAll".equals(type)){
            List<Sex> sexList = sexBiz.getAll();
            String sexStr = JSON.toJSONString(sexBiz);
            out.print(sexStr);
        }
        out.flush();
        out.close();
    }
}
