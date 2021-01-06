<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<body>
<h2>Hello World!</h2>
<form action="upload/fileUpload" method="post" enctype="multipart/form-data">
    请选择文件：
        <input type="file" name="file"/>
        <input type="file" name="file"/>
        <input type="submit" value="提交"/>
</form>
</body>
</html>
