<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>手机号验证</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/font-awesome-4.7.0/css/font-awesome.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/tel_ways.css" />
	</head>

	<body>
		<ul>
			<li><a href="/Lf/login">返回登陆界面</a></li>
			<li><a href="#">帮助</a></li>
		</ul>
		<div class="t_center">
			<div class="ways">
				<div>
					<a href="/Lf/tel_secret.html">
						<i  style="font-size: 150px;" class="fa fa-lock" aria-hidden="true"></i>
						<br />
						<span>密保找回密码</span>
					</a>
				</div>
				<div>
					<a href="/Lf/tel_code.html">
						<i style="font-size: 150px;"  class="fa fa-mobile" aria-hidden="true"></i>
						<br />
						<span>手机短信找回密码</span>
					</a>
				</div>
			</div>
		</div>
	</body>
</html>
