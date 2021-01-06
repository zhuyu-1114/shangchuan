<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
           		<form method="get" action="${pageContext.request.contextPath }/jsp/user.do">
					<input name="method" value="query" class="input-text" type="hidden">
					 <span>用户名：</span>
					 <input name="queryname" class="input-text"	type="text" value="${queryUserName }">

					 <span>用户角色：</span>
					 <select name="queryUserRole">
						<c:if test="${roleList != null }">
						   <option value="0">--请选择--</option>
						   <c:forEach var="role" items="${roleList}">
						   		<option <c:if test="${role.id == queryUserRole }">selected="selected"</c:if>
						   		value="${role.id}">${role.roleName}</option>
						   </c:forEach>
						</c:if>
	        		</select>
					 
					 <input type="hidden" name="pageIndex" value="1"/>
					 <input	value="查 询" type="submit" id="searchbutton">
					 <a href="${pageContext.request.contextPath}/WEB-INF/jsp/useradd.jsp" >添加用户</a>
				</form>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户角色</th>
                    <th width="30%">操作</th>
                </tr>
				<table id="user-tr"></table>
                   <c:forEach var="user" items="${userList }" varStatus="status">
					<tr>
						<td>
						<span>${user.userCode }</span>
						</td>
						<td>
						<span>${user.userName }</span>
						</td>
						<td>
							<span>
								<c:if test="${user.gender==1}">男</c:if>
								<c:if test="${user.gender==2}">女</c:if>
							</span>
						</td>
						<td>
						<span>${user.age}</span>
						</td>
						<td>
						<span>${user.phone}</span>
						</td>
						<td>
							<span>${user.userRoleName}</span>
						</td>
						<td>
						<span><a class="viewUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
						<span><a class="modifyUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
						<span><a class="deleteUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
						</td>
					</tr>
				</c:forEach>
			</table>
			<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
		  	<c:import url="rollpage.jsp">
	          	<c:param name="totalCount" value="${totalCount}"/>
	          	<c:param name="currentPageNo" value="${currentPageNo}"/>
	          	<c:param name="totalPageCount" value="${totalPageCount}"/>
          	</c:import>
        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/userlist.js"></script><table align="center" border="1" id="user-tabel"></table>
<script src="${pageContext.request.contextPath }/static/jquery/jquery-1.12.4.min.js"></script>
<script>
	$(function () {
		getPage();
		function getPage() {
			var pageindex = 1;
			$.post("${pageContext.request.contextPath }/user/getPage.html", {"pageindex":pageindex},getPage,"JSON")
			function getPage(data){
				$(data).each(function () {
					var userCode = this.userCode;
					var userName = this.userName;
					var gender = this.gender;
					var phone = this.phone;
					$("#providerTable").append("<tr>\n" +
							"<td>\n" +
							"<span>"+userCode+"</span>\n" +
							"</td>\n" +
							"<td>\n" +
							"<span>"+userName+"</span>\n" +
							"</td>\n" +
							"<td>\n" +
							"<span>"+gender+"</span>\n" +
							"</td>\n" +
							"<td>\n" +
							"<span>"+phone+"</span>\n" +
							"</td>\n" +
							"<td>\n" +
							"<span><a class=\"viewBill\" href=\"javascript:;\" billid="+id+" billcc="+billCode+"><img src=\""+lj+"/static/images/read.png\" alt=\"查看\" title=\"查看\"/></a></span>\n" +
							"<span><a class=\"modifyBill\" href=\""+lj+"/Bill/upd?id="+id+"\" billid="+id+" billcc="+billCode+"><img src=\""+lj+"/static/images/xiugai.png\" alt=\"修改\" title=\"修改\"/></a></span>\n" +
							"<span><a class=\"deleteBill\" href=\"javascript:;\" billid="+id+" billcc="+billCode+"><img src=\""+lj+"/static/images/schu.png\" alt=\"删除\" title=\"删除\"/></a></span>\n" +
							"</td>\n" +
							"</tr>")
				})
				$("#providerTable").append("<tr>\n" +
						"            <td align=\"center\" colspan=\"5\"><a href=\"${pageContext.request.contextPath}/student/add.html\">添加</a></td>" +
						"        </tr>");
				$("#providerTable").append("<tr>\n" +
						"        <td id='table_td' align=\"center\" colspan=\"5\">\n" +
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
				$("#sy").click(function () {
					pageindex=1
					initStu();
				})
				$("#syy").click(function () {
					pageindex=data.pageindex-1
					initStu();
				})
				$("#xyy").click(function () {
					pageindex=data.pageindex+1
					initStu();
				})
				$("#wy").click(function () {
					pageindex=data.pagecount
					initStu();
				})
				$(".deleteUser").click(function () {
					var id = $(this).attr("billid");
					$.post(""+lj+"/Bill/del",{"id":id},delBill,"JSON")
					function delBill(data) {
						if(data){
							alert("删除成功")
							getAllBill();
						}else{
							alert("删除失败")
							getAllBill();
						}
					}
				})
			}
		}
	})
</script>