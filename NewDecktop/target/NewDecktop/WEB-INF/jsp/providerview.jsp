<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>
<%@page isELIgnored="false"%>
 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 信息查看</span>
            <span style="display: none" id="selId">${id}</span>
            <input type="hidden" value="${pageContext.request.contextPath }" id="pageContext">
        </div>
        <div class="providerView">

        </div>
    </div>
</section>
<%@include file="common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/providerview.js"></script>
