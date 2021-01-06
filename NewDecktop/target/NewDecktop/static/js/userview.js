var backBtn = null;
var id = $("#selId").text();
var pageContext = $("#pageContext").val();
initUser();
function initUser(){
	$.post(pageContext+"/user/getUserById",{"id":id},callBack,"json");
	function callBack(data){
		var sex= "";
		if (data.gender==1){
			sex="女"
		}else{
			sex="男"
		}
		$(".providerView").append("\n" +
			"            <p><strong>用户编号：</strong><span>"+data.userCode+"</span></p>\n" +
			"            <p><strong>用户名称：</strong><span>"+data.userName+"</span></p>\n" +
			"            <p><strong>用户性别：</strong>"+sex+"<span>\n" +
			"\t\t\t\t</span>\n" +
			"\t\t\t</p>\n" +
			"            <p><strong>出生日期：</strong><span>"+data.birthday+"</span></p>\n" +
			"            <p><strong>用户电话：</strong><span>"+data.phone+"</span></p>\n" +
			"            <p><strong>用户地址：</strong><span>"+data.address+"</span></p>\n" +
			"            <p><strong>用户角色：</strong><span>"+data.role.roleName+"</span></p>\n" +
			"\t\t\t<div class=\"providerAddBtn\">\n" +
			"            \t<input type=\"button\" id=\"back\" name=\"back\" value=\"返回\" >\n" +
			"            </div>");

		$(function(){
			backBtn = $("#back");
			backBtn.on("click",function(){
				//alert("view : "+referer);
				if(referer != undefined
					&& null != referer
					&& "" != referer
					&& "null" != referer
					&& referer.length > 4){
					window.location.href = referer;
				}else{
					history.back(-1);
				}
			});
		});
	}
}
