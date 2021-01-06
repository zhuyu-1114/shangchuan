jQuery.noConflict();//放弃对$的使用权    让渡
jQuery(document).ready(function($){
	var pageContext = $("#pageContext").val();
	var pageindex = 1;
	function initUserList() {
		$("#mytbody").html("");
		$.post(""+pageContext+"/user/getUserPage",{"pageindex":pageindex},getUserPage,"json")
		function getUserPage(data){
			$(data.lists).each(function (){
				var sex= "";
				if (this.gender==1){
					sex="女"
				}else{
					sex="男"
				}
				$("#mytbody").append("<tr>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.userCode+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.userName+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+sex+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.birthday+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.phone+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.role.roleName+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span><a class=\"viewUser\" href=\""+pageContext+"/user/userView?id="+this.id+"\" ><img src="+pageContext+"/static/images/read.png alt=\"查看\" title=\"查看\"/></a></span>\n" +
					"\t\t\t\t\t<span><a class=\"modifyUser\" href=\""+pageContext+"/user/updateUser?id="+this.id+"\"><img src="+pageContext+"/static/images/xiugai.png alt=\"修改\" title=\"修改\"/></a></span>\n" +
					"\t\t\t\t\t<span><a class=\"deleteUser\" value='"+this.id+"'  href=\"javascript:;\"><img src="+pageContext+"/static/images/schu.png alt=\"删除\" title=\"删除\"/></a></span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t</tr>")
			})
			$("#mytbody").append("<tr>\n" +
				"            <td id='tb_td' colspan=\"8\">\n" +
				"            </td>\n" +
				"        </tr>"
			)
			if(data.pageindex>1){
				$("#tb_td").append("<a id='pageIndex' href=\"javascript:void(0)\">首页</a>\n" +
					"<a id='lastPage' href=\"javascript:void(0)\">上一页</a>\n" )
			}
			if(data.pageindex<data.pagecount){
				$("#tb_td").append("<a id='nextPage' href=\"javascript:void(0)\">下一页</a>\n" +
					"<a id='finalPage' href=\"javascript:void(0)\">尾页</a>\n" )
			}
			$("#pageIndex").click(function () {
				pageindex = 1;
				initUserList();
			})
			$("#lastPage").click(function () {
				pageindex = data.pageindex-1;
				initUserList();
			})
			$("#nextPage").click(function () {
				pageindex = data.pageindex+1;
				initUserList();
			})
			$("#finalPage").click(function () {
				pageindex = data.pagecount;
				initUserList();
			})
			$(".deleteUser").click(function(){
				$(".remove").fadeIn();
				var id = $(this).attr("value");
				$("#yes").click(function (){
					if (id!=null){
						$.post(""+pageContext+"/user/delUser",{"id":id},isDelSuccess,"text")
						function isDelSuccess(data) {
							if (data=="true"){
								$(".remove").fadeOut();
								initUserList();
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
	initUserList();
	function initRoleAll(){
		$.post(pageContext+"/role/getRoleAll",{},getRoleAll,"json");
		function getRoleAll(data) {
			$("#queryUserRole").html("");//通过标签选择器，得到select标签，适用于页面里只有一个select
			var options = "<option value=\"0\">请选择</option>";
			for(var i = 0; i < data.length; i++){
				//alert(data[i].id);
				//alert(data[i].proName);
				options += "<option value=\""+data[i].id+"\">"+data[i].roleName+"</option>";
			}
			$("#queryUserRole").html(options);
		}
	}
	initRoleAll();
	$("#searchbutton").click(function (){
		$("#mytbody").html("");
		var name = $("#queryname").attr("value");
		var roleid = $("#queryUserRole").attr("value");
		$.post(pageContext+"/user/getUserByCondition",{"username":name,"userrole":roleid},getUserByCondition,"json")
		function getUserByCondition(data){
			$(data).each(function (){
				var sex= "";
				if (this.gender==1){
					sex="女"
				}else{
					sex="男"
				}
				$("#mytbody").append("<tr>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.userCode+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.userName+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+sex+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.birthday+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.phone+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span>"+this.role.roleName+"</span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t<span><a class=\"viewUser\" href=\""+pageContext+"/user/userView?id="+this.id+"\" ><img src="+pageContext+"/static/images/read.png alt=\"查看\" title=\"查看\"/></a></span>\n" +
					"\t\t\t\t\t<span><a class=\"modifyUser\" href=\""+pageContext+"/user/updateUser?id="+this.id+"\"><img src="+pageContext+"/static/images/xiugai.png alt=\"修改\" title=\"修改\"/></a></span>\n" +
					"\t\t\t\t\t<span><a class=\"deleteUser\" value='"+this.id+"'  href=\"javascript:;\"><img src="+pageContext+"/static/images/schu.png alt=\"删除\" title=\"删除\"/></a></span>\n" +
					"\t\t\t\t\t</td>\n" +
					"\t\t\t\t</tr>")
			})
			$(".deleteUser").click(function(){
				$(".remove").fadeIn();
				var id = $(this).attr("value");
				$("#yes").click(function (){
					if (id!=null){
						$.post(""+pageContext+"/user/delUser",{"id":id},isDelSuccess,"text")
						function isDelSuccess(data) {
							if (data=="true"){
								$(".remove").fadeOut();
								initUserList();
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
	})
})