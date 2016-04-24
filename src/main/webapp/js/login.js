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
	$.ajax({
		type : "POST",
		url : basePath + "user/login",
		data : {
			userName : userName,
			password : pwd
		},
		success : function(result) {
			//
		}
	});

	alert(pwd);
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
		dataType:"JSON",
		data : user,
		success : function(result) {
			//
		}
	});

}