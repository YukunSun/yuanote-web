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
	var tmp = $('#login_form').formSerialize();
	//使用的是ajaxForm插件
	$('#login_form').ajaxForm(function(result) {
		alert(result.message);// 弹出ajax请求后的回调结果
	});

	// $.ajax({
	// type : "post",
	// url : basePath + "user/login",
	// dataType:"json",
	// data : {
	// userName : userName,
	// password : pwd
	// },
	// success : function(result) {
	// alert(result.message);
	// if (result.status == 0) {
	// }
	// },
	// error : function(xhr, status, error) {
	// alert("请求失败！");
	// }
	// });
}

function register() {
	var userName = $("#username").val();
	var pwd = $("#pwd").val();
	var user = {
		userName : userName,
		password : pwd
	};
	$.ajax({
		type : "post",
		url : basePath + "user/register",
		dataType : "json",
		data : user,
		success : function(result) {
			// if (result.status == 0) {
			// alert(result.message);
			// }
		},
		error : function(xhr, status, error) {
			alert("请求失败！");
		}
	});

}