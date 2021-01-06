package com.yuntu.annotation;

import com.yuntu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request,response);
    }
    /*
     * 注解︰
     * 可以标注在类、属性、方法.方法的参数等位置，可以为当前标注的内容去提供一些额外的数据汶些是可以在编码期间,编译期间、运行期间，程序可以动态的进行使用
     * 不经常改变的数据使用注解，进行携带
     * 经常发生更改的数据，使用xml进行携带
     * */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用户提交的数据事通过伪造的表单提交，并且数据是脏数据
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String validCode = request.getParameter("validCode");
        //对当前用户提交的数据进行验证（最后一道保险）
        User u= new User();
        u.setUserName(userName);
        u.setPwd(pwd);
        u.setValidCode(validCode);
        //调用业务逻辑层==》数据访问层==》当前用户信息添加到数据表里


        /*
        *  1.需要验证数据
        *  2.如果提交的字段非常时，我们希望数据能够自动映射到user对象中
        * */


    }
}
