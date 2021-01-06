<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>
<%@page isELIgnored="false"%>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/user/updUser.do">
			<input type="hidden" name="method" value="modifyexe">
			<input type="hidden" name="uid" id="id" value="${id}"/>
            <input type="hidden" value="${pageContext.request.contextPath }" id="pageContext">
			 <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value="">
					<font color="red"></font>
             </div>
			 <div>
                    <label >用户性别：</label>
                    <select name="gender" id="gender">
                        <option value="2">男</option>
                        <option value="1">女</option>
					 </select>
             </div>
			 <div>
                    <label for="birthday">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" value="" readonly="readonly" onclick="WdatePicker();">
                    <font color="red"></font>
              </div>
			
		       <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="phone" id="userphone" value="">
                    <font color="red"></font>
               </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="address" id="userAddress" value="">
                </div>
				<div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
					<input type="hidden" value="" id="rid" />
					<select name="userRole" id="userRole"></select>
        			<font color="red"></font>
                </div>
			 <div class="providerAddBtn">
                    <input type="submit" name="save" id="save" value="保存" />
                    <input type="button" id="back" name="back" value="返回"/>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/usermodify.js"></script>
