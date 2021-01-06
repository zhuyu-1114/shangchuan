<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<html>
<body>
<%--
    分层设计
        Dao层：数据访问层
        Service层：业务逻辑层
        Pojo：数据实体类
        Servlet层：负责前端的请求，并处理
        JSP：负责展示数据

        这种架构模式就是最经典的MVC设计模式
        模型：Model        -->    Dao  Service  Pojo
        视图：View         -->    Jsp
        控制器：Controller  -->   Servlet
--%>
<h2>Hello Spring-MVC！zzz</h2>
</body>
</html>
