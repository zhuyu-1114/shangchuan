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
            <td>项目名称</td>
            <td><input type="text"  id="itemname" value="" name="itemname"/></td>
            <span style="display: none">${id}</span>
        </tr>
        <tr>
            <td>项目类别</td>
            <td><input id="typeid" value=""  type="text" name="typeid"/></td>
        </tr>
        <tr>
            <td>是否必查(1.是 2.否)</td>
            <td><input id="necessary" value=""  type="text" name="necessary"/></td>
        </tr>
        <tr>
            <td>参考值</td>
            <td><input id="ref" value=""  type="text" name="ref"/></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input id="price" value=""  type="text" name="price"/></td>
        </tr>
        <tr>
            <td>说明</td>
            <td><input id="info" value=""  type="text" name="info"/></td>
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
            $("#itemname").val(data.itemname);
            $("#typeid").val(data.typeid);
            $("#necessary").val(data.necessary);
            $("#ref").val(data.ref);
            $("#price").val(data.price);
            $("#info").val(data.info);
        }
    })
</script>
</html>
