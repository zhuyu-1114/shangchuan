<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lsz
  Date: 2020/12/4
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="updForm" action="${pageContext.request.contextPath}/student/upd?id=${id}" method="post">
    <table border="1" align="center">
        <tr>
            <td colspan="2">修改</td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" class="userName" name="userName"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" class="sexnan" name="sex" value="男"/>男
                <input type="radio" class="sexnv" name="sex" value="女"/>女
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<script>
    $(function () {
        var id = $("#updForm").attr("action").substring($("#updForm").attr("action").indexOf("id=")+3);
        $.post("${pageContext.request.contextPath}/student/getOne",{"id":id},getOne,"JSON")
        function getOne(data) {
            $(".userName").attr("value",data.name);
            if(data.sex=="男"){
                $(".sexnan").attr("checked","checked");
            }else if(data.sex=="女"){
                $(".sexnv").attr("checked","checked");
            }
        }
    })

</script>
</html>
