<%--
  Created by IntelliJ IDEA.
  User: Lsz
  Date: 2020/11/25
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="MenuServlet?type=addMenu" method="post">
        <table border="1" align="center">
            <tr>
                <td colspan="2">添加菜品</td>
            </tr>
            <tr>
                <td>菜名</td>
                <td><input type="text" name="mname"/></td>
            </tr>
            <tr>
                <td>原料</td>
                <td><input type="text" name="material"/></td>
            </tr>
            <tr>
                <td>工序</td>
                <td><input type="text" name="process"/></td>
            </tr>
            <tr>
                <td>价格</td>
                <td><input type="text" name="price"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
