$(function () {
    $button=$("input[type='button']")
    $user_pass=$("input[name='user_pass']")
    $user_rpass=$("input[name='user_rpass']")
    $from=$("#changpass")

    /*判断输入是否为合法的密码格式*/
    $user_pass.bind("blur",function () {
        var pass=$user_pass.val();
        var partte=/^[\d\w]{6,12}$/;

        if (partte.test(pass)){
            $(this).next().html("")
        } else {
            $(this).next().html("请输入6~12以内数字、字母或组合密码!")
        }
    })

    /*判断两次输入的密码是否一致*/
    $user_rpass.bind("blur",function () {
        if ($user_rpass.val()==$user_pass.val()){
            $(this).next().html("")
        } else {
            $(this).next().html("两次密码不一致")
        }
    })


    $button.bind("click",function () {
        if ($user_pass.val()==""||$user_rpass.val()==""){
            return;
        }
        if($user_pass.next().val()!=""||$user_rpass.next().val()!=""){
            return;
        }else{
            $from.submit();
        }
    })
})