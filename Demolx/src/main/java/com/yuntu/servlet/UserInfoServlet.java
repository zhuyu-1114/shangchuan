package com.yuntu.servlet;

import com.yuntu.biz.UserInfoBiz;
import com.yuntu.pojo.UserInfo;
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

@WebServlet(name = "UserInfoServlet",value = "/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserInfoBiz userInfoBiz =(UserInfoBiz) applicationContext.getBean("UserInfoBiz");
        if ("getPage".equals(type)) {
            String index = request.getParameter("index");
            if (index == null) {
                index = "1";
            }
            int pageindex = Integer.parseInt(index);
            if (pageindex < 1) {
                pageindex = 1;
            }
            PageUtil<UserInfo> pageUtil = new PageUtil<UserInfo>();
            pageUtil.setPageindex(pageindex);
            pageUtil.setPagesize(2);
            userInfoBiz.getPageAll(pageUtil);
            request.setAttribute("pageUtil", pageUtil);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        out.flush();
        out.close();
    }
}
