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
            <td>项目名称</td>
            <td><input type="text" name="itemname"/></td>
        </tr>
        <tr>
            <td>项目类别</td>
            <td>
                <input type="checkbox" name="typeid" value="1"/>内科
                <input type="checkbox" name="typeid" value="2"/>外科
            </td>
        </tr>
        <tr>
            <td>是否必查</td>
            <td>
                <input type="checkbox" name="necessary" value="1"/>是
                <input type="checkbox" name="necessary" value="2"/>否
            </td>
        </tr>
        <tr>
            <td>参考值</td>
            <td><input type="text" name="ref"/></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="price"/></td>
        </tr>
        <tr>
            <td>说明</td>
            <td><input type="text" name="info"/></td>
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
