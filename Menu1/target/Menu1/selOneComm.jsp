<%--
  Created by IntelliJ IDEA.
  User: JinYu1
  Date: 2020/11/27
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="CommentServlet?type=upd&id=${comment.cid}&sid=${comment.sid}" method="post">
    <table>
        <tr>
            <td>评论</td>
            <td><input type="text" name="content" value="${comment.content}"/></td>
        </tr>
        <tr>
            <td colspan="2"> <input type="submit" value="提交"/> <input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>
