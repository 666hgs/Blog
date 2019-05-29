$(function(){
	$dl=$(".dl")
	$zc=$(".zc")
	$dd=$(".dd")
	$input=$(".login>form>div>input")
    $user_tel=$(".zc input[name='user_tel']");
    $user_pass=$(".zc input[name='user_pass']");
    $user_rpass=$(".zc input[name='user_rpass']");
    $user_name=$(".zc input[name='user_name']");
    $zcsubmit=$("#zcsubmit");
    $question=$(".zc input[name='question']")
	
	$return=$("#return")
	
	$dd.click(function(){
		$dl.css("display","none");
		$zc.fadeIn();
	})
	
	$return.click(function(){
		$zc.css("display","none");
		$dl.fadeIn();
	})

	
	$input.focus(function(){
		$(this).css({
			"border":"1px solid #a1a4af "
		})
		$(this).prev().css({
			color:"#a1a4af"
		})
	})
	$input.blur(function(){
		$(this).css({
            "border":"1px solid black "
		})
		$(this).prev().css({
			color:"#242734"
		})
	})


    $zcsubmit.bind("click",function () {
        if($user_tel.val()==""){
            $user_tel.css({"border":"1px solid red"})
        }
        if($user_pass.val()==""){
            $user_pass.css({"border":"1px solid red"})
        }
        if($user_rpass.val()==""){
            $user_rpass.css({"border":"1px solid red"})
        }
        if($user_name.val()==""){
            $user_name.css({"border":"1px solid red"})
        }
        if($question.val()==""){
            $question.css({"border":"1px solid red"})
        }
        if($user_tel.val()==""||$user_pass.val()==""||$user_rpass.val()==""||$user_name.val()==""||$question.val()==""){
            return;
        }
        if($user_tel.next().val()!=""||$user_pass.next().val()!=""||$user_rpass.next().val()!=""||$user_name.next().val()!=""){
            return;
        }else{
            $(".zc").submit();
        }

    })

    /*判断输入是否为合法的手机号码*/
    $user_tel.bind("blur",function () {
        var tel=$user_tel.val();
        var partte=/^1[3,5,8]\d{9}$/;

        $.ajax({
            type: "get",//方法类型
            url: "/Lf/exit.json" ,//
            data:"user_tel="+$user_tel.val(),
            dataType: "json",//预期服务器返回的数据类型
            success: function (map) {
                if (tel.indexOf(" ")!=-1){
                    $user_tel.next().html("存在空格")
                    $user_tel.css({"border":"1px solid red"})
                } else if(map.msg=="exit"){
                    $user_tel.next().html("改开发者用户已存在")
                    $user_tel.css({"border":"1px solid red"})
                }else if(partte.test(tel)){
                    $user_tel.next().html("")
                    $user_tel.css({"border":"1px solid green"})
                }else {
                    $user_tel.next().html("您输入的账号/手机号格式错误!")
                    $user_tel.css({"border":"1px solid red"})
                }
            },error:function (map) {
                alert("请求错误")
            }
        });

    })

    /*判断输入是否为合法的密码格式*/
    $user_pass.bind("blur",function () {
        var pass=$user_pass.val();
        var partte=/^[\d\w]{6,12}$/;

        if (partte.test(pass)){
            $(this).css({"border":"1px solid green"})
            $(this).next().html("")
        } else {
            $(this).css({"border":"1px solid red"})
            $(this).next().html("请输入6~12以内数字、字母或组合密码!")
        }

    })

    /*判断两次输入的密码是否一致*/
    $user_rpass.bind("blur",function () {
        var rpass=$user_rpass.val();
        var pass=$user_pass.val();

        if (rpass==pass){
            $user_pass.css({"border":"1px solid green"})
            $(this).css({"border":"1px solid green"})
            $(this).next().html("")
        } else {
            $(this).css({"border":"1px solid red"})
            $(this).next().html("两次密码不一致")
        }
    })

    /*用户名格式验证*/
    $user_name.bind("blur",function () {
        var name=$user_name.val();
        var partte=/^[\u4e00-\u9fa5]{2,6}$/;

        if (partte.test(name)){
            $(this).css({"border":"1px solid green"})
            $(this).next().html("")
        } else {
            $(this).css({"border":"1px solid red"})
            $(this).next().html("请输入2~6个汉字")
        }
    })
})