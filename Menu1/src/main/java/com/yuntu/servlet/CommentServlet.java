package com.yuntu.servlet;

import com.yuntu.biz.CommentBiz;
import com.yuntu.pojo.Comment;
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
import java.util.List;

@WebServlet(name = "CommentServlet",value = "/CommentServlet")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CommentBiz biz = (CommentBiz) context.getBean("CommentBiz");

        String type = request.getParameter("type");
        if("selOne".equals(type)){
            int sid = Integer.parseInt(request.getParameter("sid"));
            List<Comment> comment = biz.selOne(sid);
            request.setAttribute("comment",comment);
            request.getSession().setAttribute("sid",sid);
            request.getRequestDispatcher("comm.jsp").forward(request,response);
        }else if("add".equals(type)){
            String sid  = request.getParameter("sid");
            String content = request.getParameter("content");
            Date createDate  = new Date();
            Comment comment = new Comment(Integer.parseInt(sid),content,createDate);
            int num = biz.addComm(comment);
            if(num!=0){
                out.print("<script type='text/javascript'>alert('添加成功！');open('index.jsp','_self');</script>");
            }else{
                out.print("<script type='text/javascript'>alert('添加失败！');open('index.jsp','_self');</script>");
            }
        }else if("del".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            int num = biz.delComm(id);
            if(num!=0){
                out.print("<script type='text/javascript'>alert('删除成功，返回首页！');open('index.jsp','_self');</script>");
            }else {
                out.print("<script type='text/javascript'>alert('删除失败，返回首页！');open('index.jsp','_self');</script>");
            }
        }else if("selOneC".equals(type)){
            int id =Integer.parseInt(request.getParameter("id"));
            Comment comment = biz.selOneC(id);
            request.setAttribute("comment", comment);
            request.getRequestDispatcher("selOneComm.jsp").forward(request, response);
        }else if("upd".equals(type)){
            int id =Integer.parseInt(request.getParameter("id"));
            String sid  = request.getParameter("sid");
            String content = request.getParameter("content");
            Date createDate  = new Date();
            Comment comment = new Comment(id,Integer.parseInt(sid),content,createDate);
            int num = biz.updComm(comment);
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
