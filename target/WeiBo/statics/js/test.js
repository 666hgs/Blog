var time=60;
var t;
var flag=true;

function timedCount(){
    time=time-1;
    $getcode.attr("value",time+"后可重新发送")
    t=setTimeout("timedCount()",1000)
    while(time<=0){
        time=60;
        clearTimeout(t);
        $getcode.attr("value","重新获取验证码")
    }
}
$(function () {

    $getcode=$("#getcode")
    $next=$("#next")
    $mycode=$("input[name='mycode']")
    $code=$("input[name='code']")

    $getcode.click(function () {
        if(flag){
            flag=false;
            timedCount();
            $.ajax({
                type: "get",//方法类型
                url: "/Lf/code.json" ,//
                dataType: "json",//预期服务器返回的数据类型
                success:function (code) {
                    $("input[name='code']").val(code);
                },
                error:function (code) {
                    alert("请求错误")
                }
            })
        }else{
            alert(time+"秒后才可重新发送")
        }
        setTimeout(function(){
            flag=true;
        },60000)
    })

    $next.click(function () {
        if ($mycode.val()==$code.val()){
            window.location.href="/Lf/tel_changepass.html"
        } else {
            alert("验证码不对！")
        }
    })
})