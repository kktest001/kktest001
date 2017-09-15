<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/kk/res/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/kk/res/jq/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/kk/res/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
function Values(kid){
	var id=kid;
	$.getJSON("/kk/main/update?id="+id,function(data){
		    $("#upkid").val(data.kid);
		    $("#upusername").val(data.username);
		    $("#uppassword").val(data.password);
		    $("#uprealname").val(data.realname);
		    $("#upage").val(data.age);
	});
}

function doDel(){
	var id = $('#hiddenid').val();
	var urls=window.location.href;
	var uindex=urls.indexOf("/kk");
	var ust=urls.substring(0,uindex);
	var sessionID='${session.id}';
	$.get("/kk/main/delOne?id="+id,id,function(data){
		location.href=ust+"/kk/main/getAllUser";	
	});
	$('#myModaldelete').modal('hide');
	
}
function delvalue(kid){
	$('#hiddenid').val(kid);
	$('#myModaldelete').modal('show');
}
function showinfo(id){
	
	$.getJSON("/kk/main/update?id="+id,function(data){
		$("#showid").val(data.kid);
		$("#showusername").val(data.username);
		$("#showpassword").val(data.password);
		$("#showrealname").val(data.realname);
		$("#showage").val(data.age);
	});
	
}

</script>
<title>用户列表|userlist</title>
</head>
<body background="/kk/res/img/bg001.jpg" >


<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					用户列表|UserList <small class="text-success">以下为已注册用户列表</small>
				</h1>
			</div>

				<div align="right">
					<div class="btn-group">
						<button type="button" class="btn btn-default" onclick="showinfo(${sessionScope.id})" data-toggle="modal" data-target="#myModalshow" style="font-size: 21px;">
							<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
						</button>
						<div class="btn-group" role="group">

							<button type="button" class="btn btn-primary dropdown-toggle" 
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								${sessionScope.username} <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="/kk/main/getAllUser">刷新</a></li>
								<li><a href="javascript:void(0);" data-toggle="modal"
									data-target="#myModaladd">增加用户</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="javascript:void(0);" data-toggle="modal"
									data-target="#myModallogout">退出登录</a></li>
							</ul>
						</div>
					</div>
				</div>
				<table class="table table-hover">
				<thead>
					<tr>
						<th>
							操作
						</th>
						<th>
							用户ID
						</th>
						<th>
							用户名
						</th>
						<th>
							登录密码
						</th>
						<th>
							年龄
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user" varStatus="vs">
							<tr>
								<td width="100" height="30"><input type="button"
									class="btn btn-default btn-danger" data-toggle="modal"
									onclick="delvalue(${user.kid})" value="删除" /> <input
									type="button" class="btn btn-warning" data-toggle="modal"
									data-target="#myModalupdate" onclick="Values(${user.kid})"
									value="修改" /></td>


								<td width="100" height="30">${user.kid}</td>
								<td width="100" height="30">${user.username}</td>
								<td width="100" height="30">${user.password}</td>
								<td width="100" height="30">${user.age}</td>
							</tr>
						</c:forEach>
				</tbody>
			</table> 
			
		</div>
	</div>
</div>
<!-- 显示当前登录用户信息模态框myModalshow -->
<div class="modal fade" id="myModalshow" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title text-primary">以下为登录用户详细信息：</h4>
      </div>
      <div class="modal-body">
        <p>个人信息</p>
					<table class="table table-condensed">
						<tr>
							<td>ID</td>
							<td><input id="showid"/></td>
						</tr>
						<tr>
							<td>UserName</td>
							<td><input id="showusername"/></td>
						</tr>
						<tr>
							<td>PassWord</td>
							<td><input id="showpassword"/></td>
						</tr>
						<tr>
							<td>RealName</td>
							<td><input id="showrealname"/></td>
						</tr>
						<tr>
							<td>Age</td>
							<td><input id="showage"/></td>
						</tr>
					</table>
				</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!-- 新增用户信息弹出模态框myModaladd -->
<div class="modal fade" id="myModaladd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增用户信息</h4>
      </div>
      <div class="modal-body">
       	<form class="form-horizontal" role="form" action="save.do" method="post">
				<div class="form-group">
					 <label for="username" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名" required="required"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="password" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="password" name="password" placeholder="请输入密码" required="required"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="realname" class="col-sm-2 control-label">真实姓名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="realname" name="realname" placeholder="请输入真实姓名" required="required"/>
					</div>
				</div><div class="form-group">
					 <label for="age" class="col-sm-2 control-label">年龄</label>
					<div class="col-sm-10">
						<input  type="number" class="form-control" id="age" name="age"  placeholder="请输入年龄" required="required" />
					</div>
				</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">保存|Save</button>
      </div>
    </div>
  </div>
</div>
</form>

<!-- 更新用户信息弹出模态框 myModalupdate -->
<div class="modal fade" id="myModalupdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">更新用户信息</h4>
      </div>
      <div class="modal-body">
       		<form class="form-horizontal" role="form" action="update.do" method="post">
				<div class="form-group">
					 <label for="username" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="upusername" name="username" />
					</div>
				</div>
				<div class="form-group">
					 <label for="password" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="uppassword" name="password" />
					</div>
				</div>
				<div class="form-group">
					 <label for="realname" class="col-sm-2 control-label">真实姓名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="uprealname" name="realname" />
					</div>
				</div>
				<div class="form-group">
					 <label for="age" class="col-sm-2 control-label">年龄</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="upage" name="age" />
					</div>
				</div>
				
				<div class="form-group" style="display:none">
					 <label for="kid" class="col-sm-2 control-label">用户ID</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="upkid" name="kid" />
					</div>
				</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">更新|Update</button>
      </div>
    </div>
  </div>
</div>
</form>
<!-- 删除用户信息弹出模态框  myModaldelete-->
<div class="modal fade" id="myModaldelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-content"> 
<input id="hiddenid" type="hidden" value="0">
         <div class="modal-header">  
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>  
        <h4 class="modal-title">提示信息</h4>  
      </div>  
            <div class="modal-body">
                    <div align="center"> <h3>你确认要删除么？</h3></div> 
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="deleteid" onclick="doDel()">确认</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>	
    </div>
</div>

<!-- 退出用户登录session信息弹出模态框  myModallogout-->
<div class="modal fade" id="myModallogout" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-content"> 
<input id="hiddenid" type="hidden" value="0">
         <div class="modal-header">  
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>  
        <h4 class="modal-title">提示信息</h4>  
      </div>  
            <div class="modal-body">
                    <div align="center"> <h3>你确认要退出登录么？</h3></div> 
            </div>
            <div class="modal-footer">
                <a type="button" class="btn btn-primary" id="logoutid" href="/kk/main/logout.do">确认</a>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>