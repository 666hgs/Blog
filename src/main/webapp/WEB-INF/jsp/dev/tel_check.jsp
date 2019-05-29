<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>手机号验证</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/font-awesome-4.7.0/css/font-awesome.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/tel_check.css"/>
		<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/statics/js/tel_check.js"></script>
	</head>
	<body>
		<ul>
			<li><a href="/Lf/login">返回登陆界面</a></li>
			<li><a href="#">帮助</a></li>
		</ul>
		<div class="t_center">
			 <div class="check">
				<div class="t_top">
					<span>找回帐号密码</span>
				</div>
				<div class="t_under">
					<form>
						<div>
							<span>账号:</span>
							<input type="text" name="user_tel" placeholder="账号/手机号" />
							<span></span>
						</div>
						<input type="button" value="立刻验证"  />
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
