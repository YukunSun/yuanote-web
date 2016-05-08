$(function() {
	$("#login_btn").click(function() {
		login();
	});

	$("#register_btn").click(function() {
		register();
	});
});
function login() {
	var options = {
		// target: '#divToUpdate',
		type :'POST',
		url : basePath + "user/login",
		success : function(result) {
			alert(result.message);// 弹出ajax请求后的回调结果
			//进入系统
			location.href="edit.html";
		}
	};
	// 将options传给ajaxForm
	$('#login_form').ajaxForm(options);
}

function register() {
	var reg_pwd_1 = $("#reg_pwd_1").val();
	var reg_pwd_2 = $("#reg_pwd_2").val();
	if (reg_pwd_1 != reg_pwd_2) {
		alert("两次密码输入不一致！");
		return false;
	}
	var options = {
		// target: '#divToUpdate',
		type :'POST',
		url : basePath + "user/register",
		success : function(result) {
			if (1 == result.status) {
				alert("注册成功！");
			} else if (0 == result.status) {
				alert("用户已存在！");
			}
		}
	};
	// 将options传给ajaxForm
	$('#register_form').ajaxForm(options);
}