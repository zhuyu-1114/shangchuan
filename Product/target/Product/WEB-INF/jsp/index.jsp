<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<htmla>
<body>
<table id="tables" border="1" align="center">
</table>
<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script>
    $(function () {
        getAll();
        function getAll() {
            $("#tables").append("<tr><td><a href=\"${pageContext.request.contextPath}/pro/add\">添加</a></td></tr>")
            $("#tables").append("<tr>\n" +
                "        <th>姓名</th>\n" +
                "        <th>价格</th>\n" +
                "        <th>图片</th>\n" +
                "    </tr>")
            $.post("${pageContext.request.contextPath}/pro/getAll",null,getall,"JSON")
            function getall(data) {
                $(data).each(function () {
                    $("#tables").append("<tr>\n" +
                        "        <td>"+this.name+"</td>\n" +
                        "        <td>"+this.price+"</td>\n" +
                        "        <td>"+this.filename+"</td>\n" +
                        "    </tr>")
                })
            }
        }
    })
</script>
</body>
</htmla>