<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="center" border="1" id="totable">
    <h1 align="center">体验项目查询</h1>
</table>
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
                    "            <td>项目id</td>\n" +
                    "            <td>项目名称</td>\n" +
                    "            <td>项目类别</td>\n" +
                    "            <td>是否必查</td>\n" +
                    "            <td>参考值</td>\n" +
                    "            <td>价格</td>\n" +
                    "            <td>说明</td>\n" +
                    "            <td>操作</td>\n" +
                    "        </tr>")
                $(data.lists).each(function () {
                    $("#totable").append(
                        "            <tr>\n" +
                        "                <td>"+this.itemid+"</td>\n" +
                        "                <td>"+this.itemname+"</td>\n" +
                        "                <td>"+this.itemtype.typename+"</td>\n" +
                        "                <td>"+this.necessary+"</td>\n" +
                        "                <td>"+this.ref+"</td>\n" +
                        "                <td>"+this.price+"</td>\n" +
                        "                <td>"+this.info+"</td>\n" +
                        "                <td>\n" +
                        "                    <a class='delstu' value='"+this.itemid+"' href=\"javascript:void(0)\">删除</a>\n" +
                        "                    <a class='updstu' value='"+this.itemid+"' href=\"update?id="+this.itemid+"\">修改</a>\n" +
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
