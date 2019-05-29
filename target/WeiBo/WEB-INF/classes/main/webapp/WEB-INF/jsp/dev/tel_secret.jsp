<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>通过密保找回</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/tel_secret.css">
		<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
		<script>
			$(function () {

                $answer1=$("input[name='answer1']")
                $question1=$("input[name='question1']")
                $answer2=$("input[name='answer2']")
                $question2=$("input[name='question2']")
                $submit=$("input[type='button']")


                $submit.click(function () {
                    if ($answer1.val()==$question1.val()&&$answer2.val()==$question2.val()){
                        window.location.href="/Lf/tel_changepass.html"
                    }else {
                        alert("错误！")
                    }
                })

            })
		</script>
	</head>

	<body>
		<ul>
			<li><a href="#">返回登陆界面</a></li>
			<li><a href="#">帮助</a></li>
		</ul>
		<div class="t_center">
			<div class="t_top">
				<span>通过密保找回</span>
			</div>
			<div class="t_under">
				<form>
					<div>
						<input name="question1" value="${secret.answer}" style="display: none;">
						<span>密保一：${secret.question}</span>
						<input type="text" name="answer1" />
					</div>
					<input type="button" value="下一步" />
				</form>
				<div class="other">
					<span>忘记密保？<a href="/Lf/tel_way.html">其它找回方式</a></span>
				</div>
			</div>
		</div>
	</body>
</html>
