<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>短信验证</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/tel_code.css" />
		<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/statics/js/test.js"></script>
	</head>
	<body>
		<ul>
			<li><a href="/Lf/login">返回登陆界面</a></li>
			<li><a href="#">帮助</a></li>
		</ul>
		<div class="t_center">
			<div class="t_top">
				<span>通过短信验证码找回</span>
				</div>
			<div class="t_under">
				<form>
					<span>请通过${sessionScope.map.show_tel}手机号获取6位数字验证码</span>
					<span>手机号：${sessionScope.map.show_tel}</span>
					<div>
						<span>验证码：</span>
						<input type="text" name="mycode" placeholder="验证码" />
						<input type="text" name="code" style="display: none"/>
						<input id="getcode" type="button" value="获取验证码"/>
					</div>
					<input type="button" id="next" value="下一步" />
				</form>
				<div class="other">
					<span>收不到验证码，<a href="/Lf/tel_way.html">其它找回方式</a></span>
				</div>
			</div>
		</div>
	</body>
</html>
