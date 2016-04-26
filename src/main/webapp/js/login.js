$(function() {
	$("#login_btn").click(function() {
		login();
	});

	$("#register_btn").click(function() {
		register();
	});
});
function login() {
	var userName = $("#username").val();
	var pwd = $("#pwd").val();
	if (userName == "" || pwd == "") {
		return false;
	}
	$.ajax({
		type : "POST",
		url : basePath + "user/login",
		data : {
			userName : userName,
			password : pwd
		},
		success : function(result) {
			if (result.status == 0) {
				alert(result.message);
			}
		},
		error : function(xhr, status, error) {
			alert("请求失败！");
		}
	});
}

function register() {
	var userName = $("#username").val();
	var pwd = $("#pwd").val();
	var user = {
		userName : userName,
		password : pwd
	};
	$.ajax({
		type : "POST",
		url : basePath + "user/register",
		dataType : "JSON",
		data : user,
		success : function(result) {
//			if (result.status == 0) {
//				alert(result.message);
//			}
		},
		error : function(xhr, status, error) {
			alert("请求失败！");
		}
	});

}