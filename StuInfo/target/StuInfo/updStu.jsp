<%--
  Created by IntelliJ IDEA.
  User: Lsz
  Date: 2020/11/24
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="StuinfoServlet?type=updStu&stu_id=${stuinfo.stu_id}">
    <table border="1" align="center">
        <tr>
            <td colspan="2">修改</td>
        </tr>
        <tr>
            <td>学生姓名</td>
            <td>
                <input type="text" name="stu_name" value="${stuinfo.stu_name}"/>
            </td>
        </tr>
        <tr>
            <td>学生密码</td>
            <td>
                <input type="text" name="stu_pwd" value="${stuinfo.stu_pwd}"/>
            </td>
        </tr>
        <tr>
            <td>学生性别</td>
            <td>
                <input type="radio" name="stu_sex" value="1" <c:if test="${stuinfo.stu_sex==1}">checked</c:if>/>男
                <input type="radio" name="stu_sex" value="2" <c:if test="${stuinfo.stu_sex==2}">checked</c:if>/>女
            </td>
        </tr>
        <tr>
            <td>学生年龄</td>
            <td>
                <input type="text" name="stu_age" value="${stuinfo.stu_age}"/>
            </td>
        </tr>
        <tr>
            <td>学生家庭地址</td>
            <td>
                <input type="text" name="stu_address" value="${stuinfo.stu_address}"/>
            </td>
        </tr>
        <tr>
            <td>学生所学课程</td>
            <td>
                <input type="text" name="stu_major" value="${stuinfo.stu_major}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
