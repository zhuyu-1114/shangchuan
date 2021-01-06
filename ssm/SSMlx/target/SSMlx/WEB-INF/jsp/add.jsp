<%--
  Created by IntelliJ IDEA.
  User: He
  Date: 2020/12/4
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="add" method="post">
    <table align="center" border="1">
        <tr>
            <th colspan="2">添加</th>
        </tr>
        <tr>
            <td>账号</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                男：<input type="radio" value="男" name="sex"/>
                女：<input type="radio" value="女" name="sex"/>
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
