jQuery.noConflict();//放弃对$的使用权    让渡
jQuery(document).ready(function($){
	var backBtn = null;
	var id = $("#selId").text();
	var pageContext = $("#pageContext").val();
	initProvider();
	function initProvider(){
		$.post(pageContext+"/provider/getProvider",{"id":id},callBack,"json");
		function callBack(data){
			$(".providerView").append("<p><strong>供应商编码：</strong><span>"+data.proCode+"</span></p>\n" +
				"            <p><strong>供应商名称：</strong><span>"+data.proName+" </span></p>\n" +
				"            <p><strong>联系人：</strong><span>"+data.proContact+" </span></p>\n" +
				"            <p><strong>联系电话：</strong><span>"+data.proPhone+" </span></p>\n" +
				"            <p><strong>传真：</strong><span>"+data.proFax+" </span></p>\n" +
				"            <p><strong>描述：</strong><span>"+data.proDesc+"</span></p>\n" +
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
})