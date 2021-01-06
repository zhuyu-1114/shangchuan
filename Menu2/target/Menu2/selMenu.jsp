<%--
  Created by IntelliJ IDEA.
  User: Lsz
  Date: 2020/11/25
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<c:if test="${empty menu}">
    <jsp:forward page="MenuServlet?type=selMenu&id=sel&mid=${param.mid}"></jsp:forward>
</c:if>
<body>
<table border="1" align="center">
    <tr >
        <td colspan="2" align="center">菜品详情</td>
    </tr>
    <tr>
        <td>菜名</td>
        <td><input type="text" name="mname" value="${menu.mname}" disabled="disabled"/></td>
    </tr>
    <tr>
        <td>原料</td>
        <td><input type="text" name="material" value="${menu.material}" disabled="disabled"/></td>
    </tr>
    <tr>
        <td>工序</td>
        <td><input type="text" name="process" value="${menu.process}" disabled="disabled"/></td>
    </tr>
    <tr>
        <td>价格</td>
        <td><input type="text" name="price" value="${menu.price}" disabled="disabled"/></td>
    </tr>

</table>
<table id="comm" align="center">
    <tr>
        <td colspan="2" align="center">添加评论</td>
    </tr>
    <tr>
        <td align="center"><textarea id="textarea" name="content" cols="30" rows="5"></textarea></td>
        <td align="center"><input type="submit" value="添加" id="add"/></td>
    </tr>
    <tr>
        <td colspan="2" align="center">菜品评价</td>
    </tr>
    <tr>
        <td align="left">评价内容</td>
        <td align="center">评价时间</td>
        <td align="right">操作</td>
    </tr>
</table>
</body>
<script src="js/jquery-1.12.4.min.js"></script>
<script>
    var mid = GetQueryString("mid");
    $(function () {
        a()
    })
    function a(){
        $.getJSON("CommentServlet",{"type":"getAll","mid":mid},comm)
        function comm(data) {
            $(data).each(function (i) {
                var $sexRadio = $("<tr><td align=\"left\">"+data[i].content+"</td><td align=\"right\">"+data[i].createDate+"</td><td align=\"right\"><a href='CommentServlet?type=del&cid="+data[i].cid+"&mid="+mid+"'>删除</a></td></tr>")
                $("#comm").append($sexRadio)
            })
        }
    }
    $("#add").click(function () {
        $.getJSON("CommentServlet",{"type":"addComm","mid":mid,"content":$("#textarea").val()},addComm)
        function addComm(data) {
            if (data==true){
                alert("添加成功");
                open('selMenu.jsp?mid='+mid+'','_self');
            }else{
                alert("添加失败");
                open('selMenu.jsp?mid='+mid+'','_self');
            }
            a()
        }
    })
    $("#del").click(function () {
        var cid = this;
        $.getJSON("CommentServlet",{"type":"delComm","cid": $("#del").attr("value")},delComm)
        function delComm(data) {
            if (data==true){
                alert("删除成功");
                open('selMenu.jsp?mid='+mid+'','_self');
            }else{
                alert("删除失败");
                open('selMenu.jsp?mid='+mid+'','_self');
            }
            a()
        }
    })
    function GetQueryString(name){
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null){
            return unescape(r[2]);
        }
        return null;
    }
</script>
</html>
