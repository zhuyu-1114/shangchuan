<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>首页</title>
</head>
<body>
<table id="userTable" align="center" border="1">
    <%--    <tr>--%>
    <%--        <th>编号</th>--%>
    <%--        <th>账号</th>--%>
    <%--        <th>密码</th>--%>
    <%--        <th>性别</th>--%>
    <%--        <th>创建时间</th>--%>
    <%--        <th>修改时间</th>--%>
    <%--        <th>姓名</th>--%>
    <%--        <th>操作</th>--%>
    <%--    </tr>--%>
    <%--    <c:forEach items="${pageUtil.lists}" var="user">--%>
    <%--        <tr>--%>
    <%--            <td>${user.id}</td>--%>
    <%--            <td>${user.userName}</td>--%>
    <%--            <td>${user.password}</td>--%>
    <%--            <td>${user.sex}</td>--%>
    <%--            <td><fmt:formatDate value="${user.createDate}" type="both"/></td>--%>
    <%--            <td><fmt:formatDate value="${user.updateDate}" type="both"/></td>--%>
    <%--            <td>${user.name}</td>--%>
    <%--            <td><a href="del?id=${user.id}">删除</a>--%>
    <%--                <a href="update.html?id=${user.id}">修改</a></td>--%>
    <%--        </tr>--%>
    <%--    </c:forEach>--%>
    <%--    <tr>--%>
    <%--        <td align="center" colspan="8">--%>
    <%--            <c:if test="${pageUtil.pageindex>1}">--%>
    <%--                <a href="getPage.html?pageIndex=1">首页</a>--%>
    <%--                <a href="getPage.html?pageIndex=${pageUtil.pageindex-1 }">上一页</a>--%>
    <%--            </c:if>--%>
    <%--            <c:if test="${pageUtil.pageindex<pageUtil.pagecount }">--%>
    <%--                <a href="getPage.html?pageIndex=${pageUtil.pageindex+1 }">下一页</a>--%>
    <%--                <a href="getPage.html?pageIndex=${pageUtil.pagecount }">尾页</a>--%>
    <%--            </c:if>--%>
    <%--        </td>--%>
    <%--    </tr>--%>
    <%--    <tr>--%>
    <%--        <td colspan="8" align="center">--%>
    <%--            <a href="add.html">添加数据</a>--%>
    <%--        </td>--%>
    <%--    </tr>--%>
</table>
</body>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<script>
    $(function () {
        var pageIndex=1;
        initUser();
        //主页的初始化
        function initUser() {
            $("#userTable").html("");
            $("#userTable").append("<tr>\n" +
                "        <th>编号</th>\n" +
                "        <th>账号</th>\n" +
                "        <th>密码</th>\n" +
                "        <th>性别</th>\n" +
                "        <th>创建时间</th>\n" +
                "        <th>修改时间</th>\n" +
                "        <th>姓名</th>\n" +
                "        <th>操作</th>\n" +
                "    </tr>");

            $.post("getPage",
                {"pageIndex":pageIndex},
                getPage,
                "JSON"
            )
            function getPage(data) {
                $(data.lists).each(function () {
                    $("#userTable").append("<tr>\n" +
                        "            <td>"+this.id+"</td>\n" +
                        "            <td>"+this.userName+"</td>\n" +
                        "            <td>"+this.passWord+"</td>\n" +
                        "            <td>"+this.sex+"</td>\n" +
                        "            <td>"+this.createDate+"</td>\n" +
                        "            <td>"+this.updateDate+"</td>\n" +
                        "            <td>"+this.name+"</td>\n" +
                        "            <td><a class='delUser' value='"+this.id+"' href=\"javascript:void(0)\">删除</a>\n" +
                        "                <a href=\"upd.html?id="+this.id+"\">修改</a></td>\n" +
                        "        </tr>");
                })
                $("#userTable").append("<tr>\n" +
                    "        <td id='table_td' align=\"center\" colspan=\"8\">\n" +
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
                //首页
                $("#sy").click(function () {
                    pageIndex=1;
                    initUser();
                })
                //上一页
                $("#syy").click(function () {
                    pageIndex=data.pageindex-1;
                    initUser();
                })
                //下一页
                $("#xyy").click(function () {
                    pageIndex=data.pageindex+1;
                    initUser();
                })
                //尾页
                $("#wy").click(function () {
                    pageIndex=data.pagecount;
                    initUser();
                })
                $("#userTable").append("<tr>\n" +
                    "        <td colspan=\"8\" align=\"center\">\n" +
                    "            <a href=\"add.html\">添加数据</a>\n" +
                    "        </td>\n" +
                    "    </tr>")

                //REST风格：之前传递参数通过？后面携带参数传值
                //Representational State Transfer  ,表达性状态转移
                //         直接通过/传递参数
                //         /user/del?id=12 =>  /user/del/12
                //         虽然REST风格，传递及页面信息比较清晰，但是会有中文乱码的问题
                //         一般开发中，传统风格和REST风格混搭
                $(".delUser").click(function () {
                    var id = $(this).attr("value");
                    $.post("delUser/"+id,delUser,"text");
                    function delUser(data) {
                        if(data=="true"){
                            alert("删除成功")
                            initUser();
                        }else{
                            alert("删除失败")
                        }
                    }
                })
            }
        }
    })
</script>
</html>