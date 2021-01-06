<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="updform" action="upd?id=${id}" method="post">
    <table align="center" border="1">
        <tr>
            <td>姓名</td>
            <td><input type="text"  id="t_name" value="" name="t_name"/></td>
            <span style="display: none">${id}</span>
        </tr>
        <tr>
            <td>身份证</td>
            <td><input id="t_idcard" value=""  type="text" name="t_idcard"/></td>
        </tr>
        <tr>
            <td>账号</td>
            <td><input id="t_loginName" value=""  type="text" name="t_loginName"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input id="t_pwd" value=""  type="text" name="t_pwd"/></td>
        </tr>
        <tr>
            <td>性别(1男/2女)</td>
            <td><input id="t_sex" value=""  type="text" name="t_sex"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit"value="提交"/>
                <input type="reset"value="重置"/>
            </td>
        </tr>
    </table></form>
</body>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<script>
    $(function () {
        var id = $("#updform").attr("action").substring($("#updform").attr("action").indexOf("id=")+3);
        alert(id);
        $.post("getone",{"id":id},getone,"JSON")
        function getone(data) {
            $("#t_name").val(data.t_name);
            $("#t_idcard").val(data.t_idcard);
            $("#t_loginName").val(data.t_loginName);
            $("#t_pwd").val(data.t_pwd);
            $("#t_sex").val(data.t_sex);
        }
    })
</script>
</html>
