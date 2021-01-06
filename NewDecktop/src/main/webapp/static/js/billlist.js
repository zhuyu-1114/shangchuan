jQuery.noConflict();//放弃对$的使用权    让渡
jQuery(document).ready(function($){
	var pageContext = $("#pageContext").val();
	function initBillList() {
		$("#mytbody").html("");
		var pageindex = 1;
		$.post(""+pageContext+"/bill/getBillPage",{"pageindex":pageindex},getBillPage,"json")
		function getBillPage(data){
			$(data.lists).each(function (){
				var isPay = "";
				if (this.isPayment==1){
					isPay="未支付";
				}else{
					isPay="已经支付";
				}
				$("#mytbody").append("<tr>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.billCode+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.productName+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.provider.proName+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.totalPrice+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+isPay+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.creationDate+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span><a class=\"viewBill\" href=\""+pageContext+"/bill/billView?id="+this.id+"\" ><img src="+pageContext+"/static/images/read.png alt=\"查看\" title=\"查看\"/></a></span>\n" +
					"\t\t\t\t\t<span><a class=\"modifyBill\" href=\""+pageContext+"/bill/updateBill?id="+this.id+"\"><img src="+pageContext+"/static/images/xiugai.png alt=\"修改\" title=\"修改\"/></a></span>\n" +
					"\t\t\t\t\t<span><a class=\"deleteBill\" value='"+this.id+"'  href=\"javascript:;\"><img src="+pageContext+"/static/images/schu.png alt=\"删除\" title=\"删除\"/></a></span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t</tr>")
			})
			$(".deleteBill").click(function(){
				$(".remove").fadeIn();
				var id = $(this).attr("value");
				$("#yes").click(function (){
					if (id!=null){
						$.post(""+pageContext+"/bill/delBill",{"id":id},isDelSuccess,"text")
						function isDelSuccess(data) {
							if (data=="true"){
								$(".remove").fadeOut();
								initBillList();
							}else{
								$(".remove").fadeOut();
							}
						}
					}

				})
				$("#no").click(function (){
					id=null;
					$(".remove").fadeOut();
				})
			})

		}
	}
	initBillList();
	function initProviderAll(){
		$.post(pageContext+"/provider/providerAll",{},ProviderAll,"json");
		function ProviderAll(data) {
			$("#queryProviderId").html("");//通过标签选择器，得到select标签，适用于页面里只有一个select
			var options = "<option value=\"0\">请选择</option>";
			for(var i = 0; i < data.length; i++){
				//alert(data[i].id);
				//alert(data[i].proName);
				options += "<option value=\""+data[i].id+"\">"+data[i].proName+"</option>";
			}
			$("#queryProviderId").html(options);
		}
	}
	initProviderAll();
	$("#searchbutton").click(function (){
		$("#mytbody").html("");
		var pName = $("#queryProductName").attr("value");
		var Pid = $("#queryProviderId").attr("value");
		var isPay = $("#queryIsPayment").attr("value");
		$.post(pageContext+"/bill/getBillByCondition",{"productName":pName,"providerId":Pid,"isPayment":isPay},getBillByCondition,"json")
		function getBillByCondition(data) {
			$(data).each(function (){
				var isPay = "";
				if (this.isPayment==1){
					isPay="未支付";
				}else{
					isPay="已经支付";
				}
				$("#mytbody").append("<tr>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.billCode+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.productName+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.provider.proName+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.totalPrice+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+isPay+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.creationDate+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span><a class=\"viewBill\" href=\""+pageContext+"/bill/billView?id="+this.id+"\" ><img src="+pageContext+"/static/images/read.png alt=\"查看\" title=\"查看\"/></a></span>\n" +
					"\t\t\t\t\t<span><a class=\"modifyBill\" href=\""+pageContext+"/bill/updateBill?id="+this.id+"\"><img src="+pageContext+"/static/images/xiugai.png alt=\"修改\" title=\"修改\"/></a></span>\n" +
					"\t\t\t\t\t<span><a class=\"deleteBill\" value='"+this.id+"'  href=\"javascript:;\"><img src="+pageContext+"/static/images/schu.png alt=\"删除\" title=\"删除\"/></a></span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t</tr>")
			})
		}
	})
})