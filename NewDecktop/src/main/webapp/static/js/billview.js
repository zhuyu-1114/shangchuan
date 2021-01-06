jQuery.noConflict();//放弃对$的使用权    让渡
jQuery(document).ready(function($){
	var backBtn = null;
	var id = $("#selId").text();
	var pageContext = $("#pageContext").val();
	initBill();
	function initBill(){
		$.post(pageContext+"/bill/getBill",{"id":id},callBack,"json");
		function callBack(data){
			var isPay = "";
			if (data.isPayment==1){
				isPay="未支付";
			}else{
				isPay="已经支付";
			}
			$(".providerView").append(" <p><strong>订单编号：</strong><span>"+data.id+"</span></p>\n" +
				"         <p><strong>商品名称：</strong><span>"+data.productName+"</span></p>\n" +
				"         <p><strong>商品单位：</strong><span>"+data.productUnit+"</span></p>\n" +
				"         <p><strong>商品数量：</strong><span>"+data.productCount+"</span></p>\n" +
				"         <p><strong>总金额：</strong><span>"+data.totalPrice+"</span></p>\n" +
				"         <p><strong>供应商：</strong><span>"+data.provider.proName+"</span></p>\n" +
				"         <p><strong>是否付款：</strong>\n" +
				"         \t<span>"+isPay+"</span>\n" +
				"\t\t</p>\n" +
				"\t\t<div class=\"providerAddBtn\">\n" +
				"         \t<input type=\"button\" id=\"back\" name=\"back\" value=\"返回\" >\n" +
				"        </div>");

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