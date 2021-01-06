<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="addstu" method="post">
    <table align="center" border="1">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="t_name"/></td>
        </tr>
        <tr>
            <td>身份证</td>
            <td><input type="text" name="t_idcard"/></td>
        </tr>
        <tr>
            <td>账号</td>
            <td><input type="text" name="t_loginName"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="t_pwd"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" name="t_sex"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"value="提交"/>
                <input type="reset"value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
