<%--
  Created by IntelliJ IDEA.
  User: JinYu1
  Date: 2020/11/26
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="5" align="center">
    <tr align="center">
        <td><a href="addComm.jsp?sid=${sid}">添加</a></td>
    </tr>
    <tr>
        <th>评论序号</th>
        <th>菜名序号</th>
        <th>评论</th>
        <th>时间</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${comment}" var="comm">
    <tr>
        <td>${comm.cid}</td>
        <td>${comm.sid}</td>
        <td>${comm.content}</td>
        <td><fmt:formatDate value="${comm.createDate}" pattern="yyyy-MM-dd     HH:mm:ss"/></td>
        <td>
            <a href="CommentServlet?type=del&id=${comm.cid}">删除</a>
            <a href="CommentServlet?type=selOneC&id=${comm.cid}">修改</a>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
