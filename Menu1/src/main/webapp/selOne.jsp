<%--
  Created by IntelliJ IDEA.
  User: JinYu1
  Date: 2020/11/27
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ScenServlet?type=upd&id=${scenicspot.sid}" method="post">
    <table>
        <tr>
            <td>菜品名</td>
            <td><input type="text" name="sname" value="${scenicspot.sname}"/></td>
        </tr>
        <tr>
            <td>原料</td>
            <td><input type="text" name="describe" value="${scenicspot.describe}"/></td>
        </tr>
        <tr>
            <td>工序</td>
            <td><input type="text" name="city" value="${scenicspot.city}"/></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="price" value="${scenicspot.price}"/></td>
        </tr>
        <tr>
            <td colspan="2"> <input type="submit" value="提交"/> <input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>
