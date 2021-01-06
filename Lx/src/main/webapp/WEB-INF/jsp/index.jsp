<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="center" border="1" id="totable"></table>
</body>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<script>
    $(function () {
        var pageIndex = 1;
        initstu();
        function initstu() {
            $("#totable").html("");
            $.post("getPage",
                {"pageIndex":pageIndex},
                getPage,
                "JSON"
            )
            function getPage(data) {
                $("#totable").append("       <tr>\n" +
                    "            <td>id</td>\n" +
                    "            <td>姓名</td>\n" +
                    "            <td>身份证</td>\n" +
                    "            <td>生日</td>\n" +
                    "            <td>账号</td>\n" +
                    "            <td>密码</td>\n" +
                    "            <td>性别</td>\n" +
                    "            <td>操作</td>\n" +
                    "        </tr>")
                $(data.lists).each(function () {
                    $("#totable").append(
                        "            <tr>\n" +
                        "                <td>"+this.t_id+"</td>\n" +
                        "                <td>"+this.t_name+"</td>\n" +
                        "                <td>"+this.t_idcard+"</td>\n" +
                        "                <td>"+this.t_birthday+"</td>\n" +
                        "                <td>"+this.t_loginName+"</td>\n" +
                        "                <td>"+this.t_pwd+"</td>\n" +
                        "                <td>"+this.sex.s_sex+"</td>\n" +
                        "                <td>\n" +
                        "                    <a class='delstu' value='"+this.t_id+"' href=\"javascript:void(0)\">删除</a>\n" +
                        "                    <a class='updstu' value='"+this.t_id+"' href=\"update?id="+this.t_id+"\">修改</a>\n" +
                        "                </td>\n" +
                        "            </tr>");
                })
                $("#totable").append("<tr>\n" +
                    "        <td id='table_td' align=\"center\" colspan=\"10\">\n" +
                    "        </td>\n" +
                    "    </tr>");

                if(data.pageindex>1){
                    $("#table_td").append("<a id='sy' href=\"javascript:void(0)\">首页</a>\n" +
                        "                <a id='syy' href=\"javascript:void(0)\">上一页</a>\n");
                }
                if(data.pageindex<data.pagecount){
                    $("#table_td").append("<a id='xyy' href=\"javascript:void(0)\">下一页</a>\n" +
                        "                <a id='wy' href=\"javascript:void(0)\">尾页</a>\n");
                }
                $("#sy").click(function () {
                    pageIndex = 1
                    initstu();
                })
                $("#syy").click(function () {
                    pageIndex = data.pageindex-1
                    initstu();
                })
                $("#xyy").click(function () {
                    pageIndex = data.pageindex+1
                    initstu();
                })
                $("#wy").click(function () {
                    pageIndex = data.pagecount
                    initstu();
                })
                $("#totable").append("<tr>\n" +
                    "        <td colspan=\"8\" align=\"center\">\n" +
                    "            <a href=\"add\">添加数据</a>\n" +
                    "        </td>\n" +
                    "    </tr>");
                $(".delstu").click(function () {
                    var id = $(this).attr("value");
                    $.post("del/"+id,
                        delstu,
                        "text"
                    )
                    function delstu(data) {
                        if(data){
                            alert("删除成功");
                            initstu();
                        }else{
                            alert("删除失败");
                            initstu();
                        }
                    }
                })
            }
        }
    })
</script>
</html>
