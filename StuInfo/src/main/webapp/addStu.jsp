<%--
  Created by IntelliJ IDEA.
  User: Lsz
  Date: 2020/11/24
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="StuinfoServlet?type=addStu">
    <table border="1" align="center">
        <tr>
            <td colspan="2">添加</td>
        </tr>
        <tr>
            <td>学生姓名</td>
            <td>
                <input type="text" name="stu_name"/>
            </td>
        </tr>
        <tr>
            <td>学生密码</td>
            <td>
                <input type="text" name="stu_pwd"/>
            </td>
        </tr>
        <tr>
            <td>学生性别</td>
            <td id="sex"></td>
        </tr>
        <tr>
            <td>学生年龄</td>
            <td>
                <input type="text" name="stu_age"/>
            </td>
        </tr>
        <tr>
            <td>学生家庭地址</td>
            <td>
                <input type="text" name="stu_address"/>
            </td>
        </tr>
        <tr>
            <td>学生所学课程</td>
            <td>
                <input type="text" name="stu_major"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
<script src="js/jquery-1.12.4.min.js"></script>
<script>
    $(function () {
        $.get("SexServlet",{"type":"getAll"},callBack,"json")
        function callBack(data) {
            $(data).each(function (i) {
                var $sexRadio = $("<input type='radio' name='stu_sex' value='"+data[i].s_id+"'/>+<span>"+data[i].s_sex+"</span>")
                $("#sex").append($sexRadio)
            })
        }
    })
</script>
</html>
