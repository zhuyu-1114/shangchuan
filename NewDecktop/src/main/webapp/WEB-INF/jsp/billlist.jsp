<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>
<%@page isELIgnored="false"%>
<div class="right">
       <div class="location">
           <strong>你现在所在的位置是:</strong>
           <span>订单管理页面</span>
       </div>
       <div class="search">
       <form method="get" action="">
			<input name="method" value="query" class="input-text" type="hidden">
			<span>商品名称：</span>
			<input name="queryProductName" type="text" value="" id="queryProductName">
			 
			<span>供应商：</span>
			<select name="queryProviderId" id="queryProviderId">

       		</select>
			 
			<span>是否付款：</span>
			<select name="queryIsPayment" id="queryIsPayment">
				<option value="0">--请选择--</option>
				<option value="1">未付款</option>
				<option value="2">已付款</option>
       		</select>
			
			 <input	value="查 询" type="button" id="searchbutton">
			 <a href="${pageContext.request.contextPath }/bill/addBill">添加订单</a>
		</form>
       </div>
    <input type="hidden" value="${pageContext.request.contextPath }" id="pageContext">
       <!--账单表格 样式和供应商公用-->
      <table class="providerTable" cellpadding="0" cellspacing="0">
          <tr class="firstTr">
              <th width="10%">订单编码</th>
              <th width="20%">商品名称</th>
              <th width="10%">供应商</th>
              <th width="10%">订单金额</th>
              <th width="10%">是否付款</th>
              <th width="10%">创建时间</th>
              <th width="30%">操作</th>
          </tr>
		  <tbody id="mytbody">

		  </tbody>
      </table>
  </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes" value="">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/billlist.js"></script>