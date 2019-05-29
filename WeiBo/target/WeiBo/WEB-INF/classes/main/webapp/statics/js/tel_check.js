$(function () {
    $user_tel=$("input[name='user_tel']")
    $button=$("input[type=\"button\"]")

    $user_tel.blur(function () {
        $.ajax({
            type: "get",//方法类型
            url: "/Lf/exit.json" ,//
            data:"user_tel="+$user_tel.val(),
            dataType: "json",//预期服务器返回的数据类型
            success:function (map) {
                if (map.msg=="exit")
                    $user_tel.next().html("")
                else {
                    $user_tel.next().html("该账号不存在")
                }
            },
            error:function (map) {
                alert("请求错误")
            }
        })
    })

    $button.click(function () {
        if($user_tel.next().html()==""){
            window.location.href="/Lf/tel_way?user_tel="+$user_tel.val();
        }else {
            return;
        }
    })
})