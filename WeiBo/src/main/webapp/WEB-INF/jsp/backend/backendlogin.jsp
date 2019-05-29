<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>后台登陆</title>
    <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/nprogress.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/custom.min.css" rel="stylesheet">
</head>
<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form method="post" action="/backend/dologin" id="loginFrm">
                    <h1>后台登陆</h1>
                    <div>
                        <input type="text" name="admin_count" id="admin_count" class="form-control" placeholder="请输入登陆名" required />
                        <span class="text-danger"></span>
                    </div>
                    <div>
                        <input type="password" name="admin_pass" id="admin_pass" class="form-control" placeholder="请输入密码" required />
                        <span class="text-danger"></span>
                    </div>
                    <div>
                        <p>${msg}</p>
                    </div>
                    <div>
                        <a class="btn btn-default submit" href="javascript:void(0);" id="loginSmt">登陆</a>
                        <a class="btn btn-default" href="javascript:void(0);" onclick="history.back();">返回</a>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <div class="clearfix"></div>
                        <br/>

                        <div>
                            <h1>微博管理平台</h1>
                            <p>©2018 All Rights Reserved.</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
<script src="/statics/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">

    $(function () {
        // input propertychange  实时监听事件
        $("#loginSmt").bind("click",function () {
            //用户名
            var $userCode=$("input[name=userCode]");
            if ($userCode.val()==""){
                $userCode.next().html("登陆名不能为空");
                return;
            }
            $userCode.next().html("");
            //密码
            var userPassword=$("input[name=userPassword]");
            if (userPassword.val()==""){
                userPassword.next().html("密码不能为空");
                return;
            }
            userPassword.next().html("");
            $("#loginFrm").submit();

        })
    })

</script>
</body>
</html>