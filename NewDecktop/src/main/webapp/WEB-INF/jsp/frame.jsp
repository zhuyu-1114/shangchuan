﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@include file="common/head.jsp"%>
    <div class="right">
        <img class="wColck" src="${pageContext.request.contextPath }/static/images/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>${user.userName}</h2>
            <p>欢迎来到超市订单管理系统!</p>
        </div>
    </div>
</section>
<%@include file="common/foot.jsp" %>
