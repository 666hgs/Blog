<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>登录界面</title>
	</head>

	<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/font-awesome-4.7.0/css/font-awesome.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/login.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/login.js"></script>

	<body>
		<div class="main">
			<div class="bg">
				<div class="login">
					<!-- 登录 -->
					<form class="dl" action="/Lf/dologin" method="post">
						<br />
						<span>SIGN IN</span>
						<div>
							<i class="fa fa-user-o" aria-hidden="true"></i>
							<input type="text" name="user_tel" placeholder="手机号/账号"  />
						</div>
						<div>
							<i class="fa fa-unlock-alt" aria-hidden="true"></i>
							<input type="password" name="user_pass" placeholder="密码" />
						</div>
						<input type="submit" value="登录" />
						<a href="/Lf/checktel.html" class="forget"><span>忘记密码？</span></a>
						<br />
						<a href="#" class="dd"><span>没有账号？点我注册！</span></a>
					</form>
					<!-- 注册 -->
					<form class="zc" action="/Lf/doregister">
						<br />
						<span>REGISTER</span>
						<div>
							<input type="text" name="user_tel" placeholder="手机号/账号" />
							<span class="message"></span>
						</div>
						<div>
							<input type="password" name="user_pass" placeholder="密码(只能输入6-20个字母、数字、下划线)" />
							<span class="message"></span>
						</div>
						<div>
							<input type="password"name="user_rpass" placeholder="确认密码" />
							<span class="message"></span>
						</div>
						<div>
							<input type="text" name="user_name" placeholder="用户名" />
							<span class="message"></span>
						</div>
						<div>
							<c:if test="${questionList != null }">
								<select name="questionid">
									<c:forEach var="list" items="${questionList}" varStatus="status">
										<option value="${list.id}">${list.question}</option>
									</c:forEach>
								</select>
							</c:if>
							<input type="text" name="question" placeholder="密保答案" >
						</div>
						<input type="button" id="zcsubmit" href="javascript:void(0);" value="注册" />
						<input type="button" id="return" value="返回" />
						<br />
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
