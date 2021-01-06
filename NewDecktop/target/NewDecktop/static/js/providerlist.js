jQuery.noConflict();//放弃对$的使用权    让渡
jQuery(document).ready(function($){
	var pageContext = $("#pageContext").val();
	function initProviderList() {
		$("#mytbody").html("");
		$.post(""+pageContext+"/provider/providerAll",{},getProviderPage,"json")
		function getProviderPage(data){
			$(data).each(function (){
				$("#mytbody").append("<tr>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.proCode+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.proName+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.proContact+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.proPhone+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.proFax+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.creationDate+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span><a class=\"viewProvider\" href=\""+pageContext+"/provider/providerView?id="+this.id+"\" ><img src="+pageContext+"/static/images/read.png alt=\"查看\" title=\"查看\"/></a></span>\n" +
					"\t\t\t\t\t<span><a class=\"modifyProvider\" href=\""+pageContext+"/provider/updateProvider?id="+this.id+"\"><img src="+pageContext+"/static/images/xiugai.png alt=\"修改\" title=\"修改\"/></a></span>\n" +
					"\t\t\t\t\t<span><a class=\"deleteBill\" value='"+this.id+"'  href=\"javascript:;\"><img src="+pageContext+"/static/images/schu.png alt=\"删除\" title=\"删除\"/></a></span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t</tr>")
			})
			$(".deleteBill").click(function(){
				$(".remove").fadeIn();
				var id = $(this).attr("value");
				$("#yes").click(function (){
					if (id!=null){
						$.post(""+pageContext+"/provider/delProvider",{"id":id},isDelSuccess,"text")
						function isDelSuccess(data) {
							if (data=="true"){
								$(".remove").fadeOut();
								initProviderList();
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
	initProviderList();
	$("#searchbutton").click(function (){
		$("#mytbody").html("");
		var proCode = $("#proCode").attr("value");
		var proName = $("#proName").attr("value");
		$.post(pageContext+"/provider/getProviderByCondition",{"proCode":proCode,"proName":proName},getProviderByCondition,"json")
		function getProviderByCondition(data) {
			$(data).each(function (){
				$("#mytbody").append("<tr>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.proCode+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.proName+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.proContact+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.proPhone+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.proFax+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.creationDate+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span><a class=\"viewProvider\" href=\""+pageContext+"/provider/providerView?id="+this.id+"\" ><img src="+pageContext+"/static/images/read.png alt=\"查看\" title=\"查看\"/></a></span>\n" +
					"\t\t\t\t\t<span><a class=\"modifyProvider\" href=\""+pageContext+"/provider/updateProvider?id="+this.id+"\"><img src="+pageContext+"/static/images/xiugai.png alt=\"修改\" title=\"修改\"/></a></span>\n" +
					"\t\t\t\t\t<span><a class=\"deleteBill\" value='"+this.id+"'  href=\"javascript:;\"><img src="+pageContext+"/static/images/schu.png alt=\"删除\" title=\"删除\"/></a></span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t</tr>")
			})
		}
	})
})