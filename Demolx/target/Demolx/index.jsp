<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<html>
    <body>
        <h2>Hello World!</h2>
    </body>
    <c:if test="${empty pageUtil}">
        <jsp:forward page="UserInfoServlet?type=getPage"></jsp:forward>
    </c:if>
    <table border="1" align="center">
        <tr>
            <td colspan="8" align="center"></td>
        </tr>
        <tr>
            <th>学生编号</th>
            <th>学生姓名</th>
            <th>学生密码</th>
            <th>学生性别</th>
            <th>学生年龄</th>
            <th>学生家庭地址</th>
            <th>学生所学课程</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageUtil.lists}" var="stu" varStatus="statu">
            <tr>
                <td>${stu.stu_id}</td>
                <td>${stu.stu_name}</td>
                <td>${stu.stu_pwd}</td>
                <td>${stu.sex.s_sex}</td>
                <td>${stu.stu_age}</td>
                <td>${stu.stu_address}</td>
                <td>${stu.stu_major}</td>
                <td>
                    <a href="UserInfoServlet?type=delStu&id=${stu.stu_id}">删除</a>
                    <a href="UserInfoServlet?type=selStu&id=${stu.stu_id}">修改</a>
                </td>
            </tr>
        </c:forEach>
        <tr align="center">
            <td align="center" colspan="8">当前页[${pageUtil.pageindex }/${pageUtil.pagecount }]</td>
        </tr>
        <tr>
            <td align="center" colspan="8">
                <c:if test="${pageUtil.pageindex>1}">
                    <a href="UserInfoServlet?type=getPage">首页</a>
                    <a href="UserInfoServlet?type=getPage&index=${pageUtil.pageindex-1 }">上一页</a>
                </c:if>
                <c:if test="${pageUtil.pageindex<pageUtil.pagecount }">
                    <a href="UserInfoServlet?type=getPage&index=${pageUtil.pageindex+1 }">下一页</a>
                    <a href="UserInfoServlet?type=getPage&index=${pageUtil.pagecount }">尾页</a>
                </c:if>
            </td>
        </tr>
    </table>
    </html>