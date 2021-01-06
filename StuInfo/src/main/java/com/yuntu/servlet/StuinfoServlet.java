package com.yuntu.servlet;

import com.yuntu.biz.StuinfoBiz;
import com.yuntu.biz.StuinfoBizImpl;
import com.yuntu.pojo.Stuinfo;
import com.yuntu.util.PageUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "StuinfoServlet",value = "/StuinfoServlet")
public class StuinfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StuinfoBiz stuinfoBiz = (StuinfoBiz) applicationContext.getBean("stuinfoBiz");
        if("getPage".equals(type)){
            String strindex = request.getParameter("index");
            if(strindex==null) {
                strindex = "1";
            }
            int index = Integer.parseInt(strindex);
            if(index<1) {
                index=1;
            }
            PageUtil<Stuinfo> pageutil = new PageUtil<Stuinfo>();
            pageutil.setPageindex(index);
            pageutil.setPagesize(2);
            stuinfoBiz.getALl(pageutil);
            request.setAttribute("pageutil", pageutil);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if("delStu".equals(type)){
            int stu_id = Integer.parseInt(request.getParameter("stu_id"));
            if(stuinfoBiz.delStu(stu_id)){
                out.print("<script type='text/javascript'>alert('删除成功!');open('index.jsp','_self');</script>");
            }else{
                out.print("<script type='text/javascript'>alert('删除失败!');open('index.jsp','_self');</script>");
            }
        }else if("addStu".equals(type)){
            String stu_name = request.getParameter("stu_name");
            String stu_pwd = request.getParameter("stu_pwd");
            int stu_sex = Integer.parseInt(request.getParameter("stu_sex"));
            String stu_age = request.getParameter("stu_age");
            String stu_address = request.getParameter("stu_address");
            String stu_major = request.getParameter("stu_major");
            Stuinfo stuinfo = new Stuinfo(stu_name,stu_pwd,stu_sex,stu_age,stu_address,stu_major);
            if(stuinfoBiz.addStu(stuinfo)){
                out.print("<script type='text/javascript'>alert('添加成功!');open('index.jsp','_self');</script>");
            }else {
                out.print("<script type='text/javascript'>alert('添加失败!');open('index.jsp','_self');</script>");
            }
        }else if("selStu".equals(type)){
            int stu_id = Integer.parseInt(request.getParameter("stu_id"));
            Stuinfo stuinfo = stuinfoBiz.selStu(stu_id);
            request.setAttribute("stuinfo",stuinfo);
            request.getRequestDispatcher("updStu.jsp").forward(request,response);
        }else if("updStu".equals(type)){
            int stu_id = Integer.parseInt(request.getParameter("stu_id"));
            String stu_name = request.getParameter("stu_name");
            String stu_pwd = request.getParameter("stu_pwd");
            int stu_sex = Integer.parseInt(request.getParameter("stu_sex"));
            String stu_age = request.getParameter("stu_age");
            String stu_address = request.getParameter("stu_address");
            String stu_major = request.getParameter("stu_major");
            Stuinfo stuinfo = new Stuinfo(stu_id,stu_name,stu_pwd,stu_sex,stu_age,stu_address,stu_major);
            if(stuinfoBiz.updStu(stuinfo)){
                out.print("<script type='text/javascript'>alert('修改成功!');open('index.jsp','_self');</script>");
            }else {
                out.print("<script type='text/javascript'>alert('修改失败!');open('index.jsp','_self');</script>");
            }
        }else{
            out.print("<script type='text/javascript'>alert('异常!');open('index.jsp','_self');</script>");
        }
        out.flush();
        out.close();

    }
}
