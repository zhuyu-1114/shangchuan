<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="updForm" method="post" action="upd?id=${id}">
    <table align="center" border="1">
        <tr>
            <th colspan="2">修改数据<span id="span" style="display: none">${id}</span></th>
        </tr>
        <tr>
            <td>账号</td>
            <td><input id="userName" type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input id="passWord" type="password" name="passWord"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                男：<input type="radio" value="男" name="sex"/>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               " name="sex" checked/>
                女：<input type="radio" value="女" name="sex"/>
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input id="name" type="text" name="name"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<script>
    $(function () {
        //通过jQuery获取地址栏参数
        var id = $("#updForm").attr("action").substring($("#updForm").attr("action").indexOf("id=")+3)
        $.post("getOne",{"id":id},getOne,"JSON");
        function getOne(data) {
            $("#userName").val(data.userName);
            $("#passWord").val(data.passWord);
            if(data.sex=="男"){
                $("#updForm :radio").eq(0).attr("checked","checked")
            }else if(data.sex=="女"){
                $("#updForm :radio").eq(1).attr("checked","checked")
            }
            $("#name").val(data.name);
        }
    })
</script>
</html>
