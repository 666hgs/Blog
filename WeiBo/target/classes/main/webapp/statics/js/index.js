$(function(){
    $('#a_userPhoto').change(function(){
        var $file = $(this);
        var fileObj = $file[0];
        var windowURL = window.URL || window.webkitURL;
        var dataURL;
        var $img = $("#img1");
        if (fileObj && fileObj.files && fileObj.files[0]) {
            dataURL = windowURL.createObjectURL(fileObj.files[0]);
            $img.attr('src', dataURL);
        } else {
            dataURL = $file.val();
            var imgObj = document.getElementById("preview");
            imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
        }
        $("#img1").parent().css("display","block");
});

    $('#a_userPhoto2').change(function(){
        var $file = $(this);
        var fileObj = $file[0];
        var windowURL = window.URL || window.webkitURL;
        var dataURL;
        var $img = $("#img2");
        if (fileObj && fileObj.files && fileObj.files[0]) {
            dataURL = windowURL.createObjectURL(fileObj.files[0]);
            $img.attr('src', dataURL);
        } else {
            dataURL = $file.val();
            var imgObj = document.getElementById("preview");
            imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
        }
        $("#img2").parent().css("display","block");
    });

    $('#a_userPhoto3').change(function(){
        var $file = $(this);
        var fileObj = $file[0];
        var windowURL = window.URL || window.webkitURL;
        var dataURL;
        var $img = $("#img3");
        if (fileObj && fileObj.files && fileObj.files[0]) {
            dataURL = windowURL.createObjectURL(fileObj.files[0]);
            $img.attr('src', dataURL);
        } else {
            dataURL = $file.val();
            var imgObj = document.getElementById("preview");
            imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
        }
        $("#img3").parent().css("display","block");
        $("#filebutton").css("display","none");

    });


    $("#filebutton").click(function(){
        if($('#a_userPhoto').val()==null||$('#a_userPhoto').val()==""){
            $('#a_userPhoto').click();
        }else{
            if($('#a_userPhoto2').val()==null||$('#a_userPhoto2').val()==""){
                $('#a_userPhoto2').click();
            }else{
                if($('#a_userPhoto3').val()==null||$('#a_userPhoto3').val()==""){
                    $('#a_userPhoto3').click();
                }else{
                    return;
                }
            }
        }
    })

    $("#img1").mouseover(function(){
        $(this).prevAll(".blackbo").css("display","block")
        $(this).next().css("display","inline-block")
    })
    $("#img2").mouseover(function(){
        $(this).prevAll(".blackbo").css("display","block")
        $(this).next().css("display","inline-block")
    })
    $("#img3").mouseover(function(){
        $(this).prevAll(".blackbo").css("display","block")
        $(this).next().css("display","inline-block")
    })


    $(".blackbo").mouseout(function(){
        $(this).css("display","none")
        $("i[class='fa fa-times']").css("display","none")
    })


    $img1_p=$("#img1").next();
    $img2_p=$("#img2").next();
    $img3_p=$("#img3").next();

    $img1_p.click(function(){
        $("#a_userPhoto").val("");
        $(this).parent().css("display","none");
        $("#filebutton").css("display","inline-block");
    })

    $img2_p.click(function(){
        $("#a_userPhoto2").val("");
        $(this).parent().css("display","none");
        $("#filebutton").css("display","inline-block");

    })

    $img3_p.click(function(){
        $("#a_userPhoto3").val("");
        $(this).parent().css("display","none");
        $("#filebutton").css("display","inline-block");
    })

    $("#lphoto").click(function(){
        $("#photoshow").toggle();
    })

    $(".smallphoto").click(function(){
        $(this).prevAll(".bigphoto").attr("src",$(this).attr("src"));
    })
    $(".bigphoto").click(function(){
        $(this).attr("src","");
    })


    $(".ceshi").bind("click", function () {

        var user_tel = $("#user_tel").html();
        var dy=$(this).parent().prev().prev().children("li.dy").html();
        var dianzan=$(this).find("#dianzan");
        var count1= $(this).find(".ct");
        var count2=$(this).find("span.ct").html();



        $.ajax({
            type: "get",
            url: "/Lf/rng",
            dataType: "json",
            data:{
                dynamic_id:dy
            },
            success: function (data) {
                if (data.result == "success") {
                    dianzan.removeClass("fa fa-thumbs-o-up");
                    dianzan.addClass("fa fa-thumbs-up");
                    count2++;
                    count1.html(count2);
                    up();
                }

                else if(data.result == "delete") {

                    dianzan.removeClass("fa fa-thumbs-up");
                    dianzan.addClass("fa fa-thumbs-o-up");
                    count2--;
                    count1.html(count2);
                }
                else {
                    console.log(dynamic_id)
                    alert("点赞失败！")
                }

            },

            error: function () {

                alert("出错了")
            }
        })

    })


    $(".follow").bind("click",function () {
        var user_tel = $("#user_tel").html();
        var user_tid=$(this).parent().next().find("li.uid").html();
        var gz=$(this).children("span.guanzhu");

        /*$(document).ajaxStart(function(){
            $(".loading").show();
        }).ajaxStop(function(){
            $(".loading").hide();
        })*/

        $.ajax({
            type:"get",
            url:"/Lf/skt",
            dataType:"json",
            data:{
                user_tid:user_tid
            },
            success:function (data) {
                if(data.result == "chenggong")
                {
                    if(confirm("是否关注？")){
                        var lucky =" <i class=\"fa fa-check\" style=\"color: #428bca\" aria-hidden=\"true\">"+"</i>"
                        gz.html(lucky+"已关注");
                    }



                }
                else if(data.result == "qg")
                {
                    if(confirm("确定取消关注？")) {
                        var lucky = " <i class=\"fa fa-plus\" style=\"color: #fa7d3c\" aria-hidden=\"true\">" + "</i>"
                        gz.html(lucky + "关注");
                    }
                }
                else {
                    console.log(user_tid)
                    alert("关注操作失败！")
                }
            },
            error: function () {

                alert("出错了")
            }
        })
    })

    $fasong=$(".m_center>div:nth-child(1)>form>input")
    $textarea=$("textarea[name='dynamic_text']")
    $textarea.bind('input porpertychange',function(){
        if ($textarea.val()==""||$textarea.val()==null){
            $fasong.attr("disabled","disabled");
            $fasong.css({
                "background-color":"#ffc09f",
                "border":"1px solid #ffc09f"
            });
        }else{
            $fasong.removeAttr("disabled");
            $fasong.css({
                "background-color":"#ff6d00",
                "border":"1px solid #ff6d00"
            });
        }
    });

    function up(){
        $("body").append("<i class='fa fa-thumbs-up' id='good' aria-hidden='true'>");

        $("#good").fadeIn(100).animate({
            'font-size':'80px'
        },300).fadeTo(500,1,function(){
            $("#good").remove();
        })
    }
})