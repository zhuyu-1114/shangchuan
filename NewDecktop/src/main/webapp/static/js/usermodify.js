var userName = null;
var birthday = null;
var phone = null;
var userRole = null;
var saveBtn = null;
var backBtn = null;

$(function(){
	userName = $("#userName");
	birthday = $("#birthday");
	phone = $("#phone");
	userRole = $("#userRole");
	saveBtn = $("#save");
	backBtn = $("#back");
	
	userName.next().html("*");
	birthday.next().html("*");
	phone.next().html("*");
	userRole.next().html("*");

	var pageContext = $("#pageContext").val();
	function initRoleAll(){
		$.post(pageContext+"/role/getRoleAll",{},getRoleAll,"json");
		function getRoleAll(data) {
			$("#userRole").html("");//通过标签选择器，得到select标签，适用于页面里只有一个select
			var options = "<option value=\"0\">请选择</option>";
			for(var i = 0; i < data.length; i++){
				//alert(data[i].id);
				//alert(data[i].proName);
				options += "<option value=\""+data[i].id+"\">"+data[i].roleName+"</option>";
			}
			$("#userRole").html(options);
		}
	}
	initRoleAll();

	initUser();
	function initUser(){
		var id = $("#id").val();
		/*alert(id)*/
		$.post(pageContext+"/user/getUserById",{"id":id},callBack,"json");
		function callBack(data){
			$("#userName").attr("value",data.userName);
			if (data.gender=="1"){
				$("#gender option:last").attr("selected","selected");
			}else{
				$("#gender option:first").attr("selected","selected");
			}
			$("#gender")
			$("#birthday").attr("value",data.birthday);
			$("#userphone").attr("value",data.phone);
			$("#userAddress").attr("value",data.address);
			$("#userRole").find('option').each(function(){
				if ($(this).val()==data.userRole){
					$(this).attr("selected","selected");
				}
			})
		}
	}
	
	
	userName.on("focus",function(){
		validateTip(userName.next(),{"color":"#666666"},"* 用户名长度必须是大于1小于10的字符",false);
	}).on("blur",function(){
		if(userName.val() != null && userName.val().length > 1 
				&& userName.val().length < 10){
			validateTip(userName.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(userName.next(),{"color":"red"},imgNo+" 用户名输入的不符合规范，请重新输入",false);
		}
		
	});
	
	birthday.on("focus",function(){
		validateTip(birthday.next(),{"color":"#666666"},"* 点击输入框，选择日期",false);
	}).on("blur",function(){
		if(birthday.val() != null && birthday.val() != ""){
			validateTip(birthday.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(birthday.next(),{"color":"red"},imgNo + " 选择的日期不正确,请重新输入",false);
		}
	});
	
	phone.on("focus",function(){
		validateTip(phone.next(),{"color":"#666666"},"* 请输入手机号",false);
	}).on("blur",function(){
		var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if(phone.val().match(patrn)){
			validateTip(phone.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(phone.next(),{"color":"red"},imgNo + " 您输入的手机号格式不正确",false);
		}
	});
	
	userRole.on("focus",function(){
		validateTip(userRole.next(),{"color":"#666666"},"* 请选择用户角色",false);
	}).on("blur",function(){
		if(userRole.val() != null && userRole.val() > 0){
			validateTip(userRole.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(userRole.next(),{"color":"red"},imgNo+" 请重新选择用户角色",false);
		}
		
	});
	
	saveBtn.on("click",function(){
		userName.blur();
		phone.blur();
		birthday.blur();
		userRole.blur();
		if(userName.attr("validateStatus") == "true" 
			&& phone.attr("validateStatus") == "true"
			&& birthday.attr("validateStatus") == "true"
			&& userRole.attr("validateStatus") == "true"){
			if(confirm("是否确认要提交数据？")){
				$("#userForm").submit();
			}
		}
	});
	
	backBtn.on("click",function(){
		//alert("modify: "+referer);
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