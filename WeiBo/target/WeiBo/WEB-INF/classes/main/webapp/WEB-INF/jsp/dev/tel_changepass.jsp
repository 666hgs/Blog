<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>手机号验证</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/font-awesome-4.7.0/css/font-awesome.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/tel_changepass.css" />
		<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath }/statics/js/tel_changepass.js"></script>
	</head>
	<body>
		<ul>
			<li><a href="/Lf/login">返回登陆界面</a></li>
			<li><a href="#">帮助</a></li>
		</ul>
		<div class="t_center">
			 <div class="check">
				<div class="t_top">
					<span>找回密码</span>
				</div>
				<div class="t_under">
					<form action="/Lf/changepass" method="post" id="changpass">
						<div>
							<span>手机号${sessionScope.map.show_tel}</span>
							<span>新密码:</span>
							<input type="password" name="user_pass" />
							<span style="font-size: 13px"></span>
						</div>
						<div>
							<span>确认密码:</span>
							<input type="password" name="user_rpass"/>
							<span style="font-size: 13px"></span>
						</div>
						<input type="button"  value="重置密码" />
					</form>
				</div>
			</div>
		
		</div>
	</body>
</html>
