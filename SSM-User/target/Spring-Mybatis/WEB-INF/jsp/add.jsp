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
            <td>姓名</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="sex" value="男"/>男
                <input type="radio" name="sex" value="女"/>女
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>
