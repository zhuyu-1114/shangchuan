<%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2020/12/4
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%><%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="update?id=${student.id}" method="post">
    <table align="center" border="1">
        <tr>
            <th colspan="2">添加数据</th>
        </tr>
        <tr>
            <td>账号</td>
            <td><input type="text" name="userName" value="${student.name}"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <c:choose>
                    <c:when test="${student.sex=='男'}">
                        男：<input type="radio" value="男" name="sex"  checked="checked"/>
                        女：<input type="radio" value="女" name="sex"/>
                    </c:when>
                    <c:otherwise>
                        男：<input type="radio" value="男" name="sex"/>
                        女：<input type="radio" value="女" name="sex" checked="checked"/>
                    </c:otherwise>
                </c:choose>

            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
