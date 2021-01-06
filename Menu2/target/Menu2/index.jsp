<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty pageutil}">
    <jsp:forward page="MenuServlet?type=getPage"></jsp:forward>
</c:if>
<table border="1" align="center">
    <tr>
        <td colspan="6" align="center"><a href="addMenu.jsp">添加</a></td>
    </tr>
    <tr>
        <th>序号</th>
        <th>菜名</th>
        <th>原料</th>
        <th>工序</th>
        <th>价格</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${pageutil.lists}" var="menu" varStatus="statu">
        <tr>
            <td>${menu.mid}</td>
            <td><a href="selMenu.jsp?mid=${menu.mid}">${menu.mname}</a></td>
            <td>${menu.material}</td>
            <td>${menu.process}</td>
            <td>${menu.price}</td>
            <td>
                <a href="MenuServlet?type=delMenu&mid=${menu.mid}">删除</a>
                <a href="updMenu.jsp?mid=${menu.mid}">修改</a></td>
            </td>
        </tr>
    </c:forEach>
    <tr align="center">
        <td align="center" colspan="6">当前页[${pageutil.pageindex }/${pageutil.pagecount }]</td>
    </tr>
    <tr>
        <td align="center" colspan="6">
            <c:if test="${pageutil.pageindex>1}">
                <a href="MenuServlet?type=getPage">首页</a>
                <a href="MenuServlet?type=getPage&index=${pageutil.pageindex-1 }">上一页</a>
            </c:if>
            <c:if test="${pageutil.pageindex<pageutil.pagecount }">
                <a href="MenuServlet?type=getPage&index=${pageutil.pageindex+1 }">下一页</a>
                <a href="MenuServlet?type=getPage&index=${pageutil.pagecount }">尾页</a>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>
