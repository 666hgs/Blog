<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/font-awesome-4.7.0/css/font-awesome.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/navbar.css" />
	<script src="${pageContext.request.contextPath }/statics/js/jquery.3.3.1.js"></script>

	<body>
		<div class="nav_nav">
			<div class="nav_main">
				<div class="nav_main_left">
					<ul>
						<li><a href="/Lf/dologin?user_tel=${sessionScope.users.user_tel}&&user_pass=${sessionScope.users.user_pass}" id="active"><i class="fa fa-home" aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-viadeo" aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-file-sound-o" aria-hidden="true"></i></a></li>
						<li><a href="/Lf/touser"><i class="fa fa-user" aria-hidden="true"></i></a></li>
						<li><a href="/Lf/login"><i class="fa fa-power-off" aria-hidden="true"></i></a></li>

					</ul>
				</div>
				<div class="nav_logo">
					<span>Logo</span>
				</div>
				<div class="nav_main_right">
					<div>
						<form>
							<i class="fa fa-search" aria-hidden="true"></i>
							<input />
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
