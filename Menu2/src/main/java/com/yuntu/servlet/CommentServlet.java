package com.yuntu.servlet;

import com.alibaba.fastjson.JSON;
import com.yuntu.biz.CommentBiz;
import com.yuntu.biz.MenuBiz;
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

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CommentBiz commentBiz = (CommentBiz) applicationContext.getBean("commentBiz");
        if("getAll".equals(type)){
            int mid = Integer.parseInt(request.getParameter("mid"));
            List<Comment> list = commentBiz.getAll(mid);
            String comm = JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd hh-mm-ss");
            out.print(comm);
        }else if("addComm".equals(type)){
            int mid = Integer.parseInt(request.getParameter("mid"));
            String content = request.getParameter("content");
            Comment comment = new Comment(mid,content,new Date());
            boolean flag = false;
            if(commentBiz.addComm(comment)!=0){
                flag = true;
            }
            String json = JSON.toJSONString(flag);
            out.print(flag);
        }else if("del".equals(type)){
            int cid = Integer.parseInt(request.getParameter("cid"));
            int mid = Integer.parseInt(request.getParameter("mid"));
            if(commentBiz.delComm(cid)!=0){
                out.print("<script type='text/javascript'>alert('删除成功!');open('selMenu.jsp?mid="+mid+"','_self');</script>");
            }else{
                out.print("<script type='text/javascript'>alert('删除失败!');open('selMenu.jsp?mid="+mid+"','_self');</script>");
            }
        }else{
            out.print("<script type='text/javascript'>alert('异常!');open('index.jsp','_self');</script>");
        }
    }
}
