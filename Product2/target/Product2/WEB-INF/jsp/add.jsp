<%--
  Created by IntelliJ IDEA.
  User: Lsz
  Date: 2020/12/4
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="add" method="post">
    <table border="1" align="center">
        <tr>
            <td colspan="2">添加</td>
        </tr>
        <tr>
            <td>名字</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="price"/></td>
        </tr>
        <tr>
            <td>库存</td>
            <td><input type="text" name="stock"/></td>
        </tr>
        <tr>
            <td>文件名</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>类型</td>
            <td><input type="text" name="typeId"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>
