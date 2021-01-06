<%--
  Created by IntelliJ IDEA.
  User: JinYu1
  Date: 2020/11/26
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ScenServlet?type=add" method="post">
    <table>
        <tr>
            <td>菜品名</td>
            <td><input type="text" name="sname"/></td>
        </tr>
        <tr>
            <td>原料</td>
            <td><input type="text" name="describe"/></td>
        </tr>
        <tr>
            <td>工序</td>
            <td><input type="text" name="city"/></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="price"/></td>
        </tr>
        <tr>
            <td colspan="2"> <input type="submit" value="提交"/> <input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>
