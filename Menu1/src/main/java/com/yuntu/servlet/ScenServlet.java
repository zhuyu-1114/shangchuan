package com.yuntu.servlet;

import com.yuntu.biz.ScenicspotBiz;
import com.yuntu.pojo.Scenicspot;
import com.yuntu.util.PageUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "ScenServlet",value = "/ScenServlet")
public class ScenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ScenicspotBiz biz = (ScenicspotBiz) context.getBean("ScenicspotBiz");

        String type = request.getParameter("type");
        if("pageUtil".equals(type)){
            String strindex = request.getParameter("pageindex");
            if(strindex==null){
                strindex="1";
            }
            int pageindex = Integer.parseInt(strindex);
            if (pageindex<1){
                pageindex=1;
            }
            PageUtil<Scenicspot> pageUtil = new PageUtil<>();
            pageUtil.setPageindex(pageindex);
            pageUtil.setPagesize(2);
            biz.getPageAll(pageUtil);
            request.setAttribute("pageUtil",pageUtil);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if("add".equals(type)){
            String sname  = request.getParameter("sname");
            String describe = request.getParameter("describe");
            String city  = request.getParameter("city");
            Double price = Double.parseDouble(request.getParameter("price"));
            Date createDate = new Date();
            Scenicspot scenicspot = new Scenicspot(sname,describe,city,price,createDate);
            int num = biz.addSce(scenicspot);
            if(num!=0){
                out.print("<script type='text/javascript'>alert('添加成功！');open('index.jsp','_self');</script>");
            }else{
                out.print("<script type='text/javascript'>alert('添加失败！');open('index.jsp','_self');</script>");
            }
        }else if("del".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            int num = biz.delSce(id);
            if(num!=0){
                out.print("<script type='text/javascript'>alert('删除成功，返回首页！');open('index.jsp','_self');</script>");
            }else {
                out.print("<script type='text/javascript'>alert('删除失败，返回首页！');open('index.jsp','_self');</script>");
            }
        }else if("selOne".equals(type)){
            int id =Integer.parseInt(request.getParameter("id"));
            Scenicspot scenicspot = biz.selOneS(id);
            request.setAttribute("scenicspot", scenicspot);
            request.getRequestDispatcher("selOne.jsp").forward(request, response);
        }else if("upd".equals(type)){
            int sid =Integer.parseInt(request.getParameter("id"));
            String sname  = request.getParameter("sname");
            String describe = request.getParameter("describe");
            String city  = request.getParameter("city");
            Double price = Double.parseDouble(request.getParameter("price"));
            Date createDate = new Date();
            Scenicspot scenicspot = new Scenicspot(sid,sname,describe,city,price,createDate);
            int num = biz.updSce(scenicspot);
            if(num!=0){
                out.print("<script type='text/javascript'>alert('修改成功！');open('index.jsp','_self');</script>");
            }else{
                out.print("<script type='text/javascript'>alert('修改失败！');open('index.jsp','_self');</script>");
            }
        }else{
            out.print("<script type='text/javascript'>alert('加载失败，返回首页！');open('index.jsp','_self');</script>");
        }
    }
}
