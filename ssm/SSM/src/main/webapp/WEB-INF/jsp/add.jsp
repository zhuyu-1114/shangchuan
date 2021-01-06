<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="add">
        <table align="center" border="1">
            <tr>
                <th colspan="2">添加数据</th>
            </tr>
            <tr>
                <td>账号</td>
                <td><input type="text" name="userName"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="passWord"/></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    男：<input type="radio" value="男" name="sex"/>
                    女：<input type="radio" value="女" name="sex"/>
                </td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
