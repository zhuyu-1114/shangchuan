<%--
  Created by IntelliJ IDEA.
  User: Lsz
  Date: 2020/11/25
  Time: 22:14
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
<c:if test="${empty menu}">
    <jsp:forward page="MenuServlet?type=selMenu&id=upd&mid=${param.mid}"></jsp:forward>
</c:if>
<body>
<form method="post" action="MenuServlet?type=updMenu&mid=${menu.mid}">
    <table border="1" align="center">
        <tr>
            <td colspan="2" align="center">修改菜品</td>
        </tr>
        <tr>
            <td>菜名</td>
            <td><input type="text" name="mname" value="${menu.mname}"/></td>
        </tr>
        <tr>
            <td>原料</td>
            <td><input type="text" name="material" value="${menu.material}"/></td>
        </tr>
        <tr>
            <td>工序</td>
            <td><input type="text" name="process" value="${menu.process}"/></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="price" value="${menu.price}"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="修改"/></td>
        </tr>
    </table>
</form>
</body>
</html>
