<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
<body>
<table id="StuTable" align="center" border="1"></table>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<script>
    $(function () {
        var pageindex = 1;
        initStu();
        function initStu() {
            $("#StuTable").html("")
            $("#StuTable").append("\n" +
                "    <tr>\n" +
                "        <th>用户编码</th>\n" +
                "        <th>用户名称</th>\n" +
                "        <th>性别</th>\n" +
                "        <th>手机</th>\n" +
                "        <th>操作</th>\n" +
                "    </tr>")
            $.post("${pageContext.request.contextPath}/user/getPage",{"pageindex":pageindex},getPage,"JSON")
            function getPage(data) {
                $(data.lists).each(function () {
                    $("#StuTable").append("<tr>\n" +
                        "            <td>"+this.userCode+"</td>\n" +
                        "            <td>"+this.userName+"</td>\n" +
                        "            <td>"+this.gender+"</td>\n" +
                        "            <td>"+this.phone+"</td>\n" +
                        "            <td>\n" +
                        "                <a class='delUser' value='"+this.id+"' href=\"javascript:void(0)\">删除</a>\n" +
                        "                <a href=\"${pageContext.request.contextPath}/student/update.html?id="+this.id+"\">修改</a>\n" +
                        "            </td>"+
                        "<tr>");
                })
                $("#StuTable").append("<tr>\n" +
                    "            <td align=\"center\" colspan=\"5\"><a href=\"${pageContext.request.contextPath}/user/add.html\">添加</a></td>" +
                    "        </tr>");
                $("#StuTable").append("<tr>\n" +
                    "        <td id='table_td' align=\"center\" colspan=\"5\">\n" +
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
                    pageindex=1
                    initStu();
                })
                $("#syy").click(function () {
                    pageindex=data.pageindex-1
                    initStu();
                })
                $("#xyy").click(function () {
                    pageindex=data.pageindex+1
                    initStu();
                })
                $("#wy").click(function () {
                    pageindex=data.pagecount
                    initStu();
                })
                $(".delUser").click(function () {
                    var id = $(this).attr("value");
                    $.post("del/"+id,delUser,"text")
                    function delUser(data) {
                        if(data=="true"){
                            alert("删除成功")
                        }else{
                            alert("删除失败")
                        }
                        initStu();
                    }
                })
            }
        }
    })
</script>
</body>
</html>
