<%--
  Created by IntelliJ IDEA.
  User: Lsz
  Date: 2020/12/21
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/pro/addfile" method="post" enctype="multipart/form-data">
            姓名<input type="text" name="name"/>
            价格<input type="text" name="price"/>
            请选择文件<input type="file" multiple="multiple" name="files"/>
            <input type="submit" value="提交"/>
        </form>
    </body>
</html>