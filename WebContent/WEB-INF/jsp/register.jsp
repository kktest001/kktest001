<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册|Register</title>
<link href="/kk/res/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body background="/kk/res/img/bg001.jpg" >
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					注册 <small class="text-primary"><i>请填写注册相关信息</i></small>
				</h1>
			</div>
			<form class="form-horizontal" role="form" action="register.do" method="post">
				<div class="form-group">
					 <label for="username" class="col-sm-2 control-label">用户名|USERNAME</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名" required="required"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="password" class="col-sm-2 control-label">密码|PASSWORD</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="password" name="password" placeholder="请输入密码" required="required"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="realname" class="col-sm-2 control-label">真实姓名|REALNAME</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="realname" name="realname" placeholder="请输入真实姓名" required="required"/>
					</div>
				</div><div class="form-group">
					 <label for="age" class="col-sm-2 control-label">年龄|AGE</label>
					<div class="col-sm-10">
						<input  type="number" class="form-control" id="age" name="age"  placeholder="请输入年龄" required="required" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default">Sign Up</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>