package com.yuntu.servlet;

import com.yuntu.biz.MenuBiz;
import com.yuntu.pojo.Menu;
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

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuBiz menuBiz = (MenuBiz) applicationContext.getBean("menuBiz");
        if("getPage".equals(type)){
            String strindex = request.getParameter("index");
            if(strindex==null) {
                strindex = "1";
            }
            int index = Integer.parseInt(strindex);
            if(index<1) {
                index=1;
            }
            PageUtil<Menu> pageutil = new PageUtil<Menu>();
            pageutil.setPageindex(index);
            pageutil.setPagesize(2);
            menuBiz.getPage(pageutil);
            request.setAttribute("pageutil", pageutil);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if("delMenu".equals(type)){
            int mid = Integer.parseInt(request.getParameter("mid"));
            if(menuBiz.delMenu(mid)!=0){
                out.print("<script type='text/javascript'>alert('删除成功!');open('index.jsp','_self');</script>");
            }else{
                out.print("<script type='text/javascript'>alert('删除失败!');open('index.jsp','_self');</script>");
            }
        }else if("addMenu".equals(type)){
            String mname = request.getParameter("mname");
            String material = request.getParameter("material");
            String process = request.getParameter("process");
            double price = Double.parseDouble(request.getParameter("price"));
            Menu menu = new Menu(mname,material,process,price);
            if(menuBiz.addMenu(menu)!=0){
                out.print("<script type='text/javascript'>alert('添加成功!');open('index.jsp','_self');</script>");
            }else{
                out.print("<script type='text/javascript'>alert('添加失败!');open('index.jsp','_self');</script>");
            }
        }else if("selMenu".equals(type)){
            int mid = Integer.parseInt(request.getParameter("mid"));
            String id = request.getParameter("id");
            Menu menu = menuBiz.selMenu(mid);
            request.setAttribute("menu",menu);
            if(id.equals("sel")){
                request.getRequestDispatcher("selMenu.jsp").forward(request,response);
            }else if(id.equals("upd")){
                request.getRequestDispatcher("updMenu.jsp").forward(request,response);
            }
        }else if("updMenu".equals(type)){
            int mid = Integer.parseInt(request.getParameter("mid"));
            String mname = request.getParameter("mname");
            String material = request.getParameter("material");
            String process = request.getParameter("process");
            double price = Double.parseDouble(request.getParameter("price"));
            Menu menu = new Menu(mid,mname,material,process,price);
            if(menuBiz.updMenu(menu)!=0){
                out.print("<script type='text/javascript'>alert('修改成功!');open('index.jsp','_self');</script>");
            }else{
                out.print("<script type='text/javascript'>alert('修改失败!');open('index.jsp','_self');</script>");
            }
        }else{
            out.print("<script type='text/javascript'>alert('异常!');open('index.jsp','_self');</script>");
        }
    }
}
