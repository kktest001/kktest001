<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录|Login</title>
<link href="/kk/res/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/kk/res/jq/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#pwchange").on("click", function() {
			var a = $('#password').attr('type');
			if (a == 'password') {
					$('#password').attr('type', 'text');
				}
				else if(a != 'password') {
					$('#password').attr('type', 'password');
				}
			});
		});
	
	
</script>
</head>
<body background="/kk/res/img/bg003.jpg" style="background-size: 100%;">
	<form action="login.do" method="post">
		<div align="center">
			<div class="form-group form-group-lg" style="margin-top: 200px;">
				<div class="col-sm-12">
				
				<div class="btn-group">
				<button type="button" class="btn btn-default" style="font-size: 31px;">
							<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
						</button>
					<input class="form-control" type="text" id="username"
						name="username" style="width: 260px;" placeholder="请输入用户名">
				</div>
				</div>
			</div>
			<div class="form-group form-group-lg">
				<div class="col-sm-12" style="margin-top: 10px;">
				
				<div class="btn-group">
				<button type="button" class="btn btn-default" id="pwchange" style="font-size: 31px;">
							<span class="glyphicon glyphicon-off" aria-hidden="true"></span>
						</button>
					<input class="form-control" type="password" id="password"
						name="password" style="width: 260px;" placeholder="请输入密码">
				</div>
				</div>
			</div>
			<div class="form-group form-group-lg">
				<div class="col-sm-12" style="margin-top: 20px;">
					<input type="submit" value="Login" class="btn btn-primary btn-lg" />
					<a class="btn btn-default btn-lg" href="/kk/main/register"
						role="button">Regiser</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>