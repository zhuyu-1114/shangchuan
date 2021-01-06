<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<body>
<c:if test="${empty pageUtil}">
    <jsp:forward page="ScenServlet?type=pageUtil"/>
</c:if>
<table border="1" align="center">
    <tr align="center">
        <td><a href="add.jsp">添加</a></td>
    </tr>
    <tr>
        <th>景区序号</th>
        <th>景区名称</th>
        <th>景区描述</th>
        <th>所在城市</th>
        <th>门票价格</th>
        <th>建立时间</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${pageUtil.lists}" var="sce">
        <tr>
            <td>${sce.sid}</td>
            <td>${sce.sname}</td>
            <td>${sce.describe}</td>
            <td>${sce.city}</td>
            <td>${sce.price}</td>
            <td><fmt:formatDate value="${sce.createDate}" pattern="yyyy-MM-dd     HH:mm:ss"/></td>
            <td>
                <a href="ScenServlet?type=del&id=${sce.sid}">删除</a>
                <a href="ScenServlet?type=selOne&id=${sce.sid}">修改</a>
                <a href="CommentServlet?type=selOne&sid=${sce.sid}">评论</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td align="center" colspan="8">
            <span>[${pageUtil.pageindex}/${pageUtil.pagecount}]</span>
            <c:if test="${pageUtil.pageindex>1}">
                <a href="ScenServlet?type=pageUtil&pageindex=1">首页</a>
                <a href="ScenServlet?type=pageUtil&pageindex=${pageUtil.pageindex-1}">上一页</a>
            </c:if>
            <c:if test="${pageUtil.pageindex<pageUtil.pagecount}">
                <a href="ScenServlet?type=pageUtil&pageindex=${pageUtil.pageindex+1}">下一页</a>
                <a href="ScenServlet?type=pageUtil&pageindex=${pageUtil.pagecount}">尾页</a>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>