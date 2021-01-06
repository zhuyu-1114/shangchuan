<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>
<%@page isELIgnored="false"%>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>订单管理页面 >> 订单添加页面</span>
        </div>
        <div class="providerAdd">
          <form id="billForm" name="billForm" method="post" action="${pageContext.request.contextPath }/bill/updBill.do">
				<input type="hidden" name="method" value="modifysave">
				<input type="hidden" id="id" name="id" value="${id}">
              <input type="hidden" value="${pageContext.request.contextPath }" id="pageContext">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="billCode">订单编码：</label>
                    <input type="text" name="billCode" id="billCode" value="" readonly="readonly">
                </div>
                <div>
                    <label for="productName">商品名称：</label>
                    <input type="text" name="productName" id="productName" value="">
					<font color="red"></font>
                </div>
                <div>
                    <label for="productUnit">商品单位：</label>
                    <input type="text" name="productUnit" id="productUnit" value="">
					<font color="red"></font>
                </div>
                <div>
                    <label for="productCount">商品数量：</label>
                    <input type="text" name="productCount" id="productCount" value="">
					<font color="red"></font>
                </div>
                <div>
                    <label for="totalPrice">总金额：</label>
                    <input type="text" name="totalPrice" id="totalPrice" value="">
					<font color="red"></font>
                </div>
                <div>
                    <label for="providerId">供应商：</label>
                    <input type="hidden" value="" id="pid" />
					<select name="providerId" id="providerId">
		        	</select>
					<font color="red"></font>
                </div>
                <div>
                    <label >是否付款：</label>
						<input type="radio" name="isPayment" value="1">未付款
						<input type="radio" name="isPayment" value="2">已付款
                </div>
                <div class="providerAddBtn">
                  <input type="button" name="save" id="save" value="保存">
				  <input type="button" id="back" name="back" value="返回" >
              	</div>
            </form>
        </div>

    </div>
</section>

<%@include file="common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/billmodify.js"></script>