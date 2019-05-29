$(function () {
    var $guan = $("#link1");
    var $gz = $(".gz");
    var $fen = $("#link2");
    var $fs = $(".fs");
    var $dong = $("#link3");
    var $dt = $(".right");
    var $na = $(".na");
    var $qb = $("#link4");
    var $dt = $(".dt");
    var $wdz = $("#link5");
    var $dt_2 = $(".dt_2");
    var $wdpl = $("#link6");
    var $dt_3 = $(".dt_3");
    var $but_1 = $(".left>div:nth-child(2)>form:nth-child(1)>input[type='button']");
    var $but_2 = $(".left>div:nth-child(2)>form:nth-child(2)>input[type='button']");
    var $boom=$(".boom");




    $(".smallphoto").click(function(){
        $(this).prevAll(".bigphoto").attr("src",$(this).attr("src"));
        $(this).prevAll(".bigphoto").css("display","block");
    })
    $(".bigphoto").click(function(){
        $(this).css("display","none");
    })

    $("#link1").bind("click", function () {
        $.ajax({
            type: "get",
            url: "/Lf/getfollow",
            dataType: "json",
            success: function (data) {

                $gz.css("display", "block");
                $fs.css("display", "none");
                $dt.css("display", "none");
                $dt_3.css("display", "none");
                $boom.css("display", "none");
                $na.css("display", "none");
                $(".gz").empty(".users");


                var arr = data.result;

                $.each(arr, function (index, n) {

                    var t = document.createElement("div");
                    t.className = "users";
                    var nike = "<img src=\"" + arr[index].user_photo + "\" width='70' height='60' />" +
                        "<div>" +
                        "  <span>" + arr[index].user_name + "</span>" +
                        "<span  class=\"ur_tel\">" + arr[index].user_tel + "</span>" +
                        " <input type='button' value='取消关注' class='qg' />" +
                        " </div>";

                    t.innerHTML = nike;
                    $gz.append(t);


                })


            },
            error: function () {

                alert("出错了")
            }


        })
    })

    $(document).on("click",".qg",function () {

        var user_tid = $(this).prev().html();

        $.ajax({
            type: "get",
            url: "/Lf/qg",
            dataType: "json",
            data: {
                user_tid: user_tid
            },

            success: function (data) {
                if (data.result == "success") {
                    window.location.reload();
                }


            },
            error: function () {
                alert("出错了")
            }


        })


    })


    $("#link2").bind("click", function () {

        $.ajax({
            type: "get",
            url: "/Lf/getfs",
            dataType: "json",
            success: function (data) {

                $gz.css("display", "none");
                $fs.css("display", "block");
                $dt.css("display", "none");
                $na.css("display", "none");
                $dt_3.css("display", "none");
                $boom.css("display", "none");



                $(".fs").empty(".users");


                var arr = data.result;
                /*var leng =data.listLeng;*/

                $.each(arr, function (index) {
                    var users= document.createElement("div");
                    users.className = "users";
                    var anta = "<img src=\"" + arr[index].user_photo + "\" width='70' height='60' />" +
                        "<div class='nb'>" +
                        "  <span>" + arr[index].user_name + "</span>" +
                        "<span  class=\"ur_tel\" >" + arr[index].user_tel + "</span>" +
                        " <input type='button' class=\"ggzz\"/>" +
                        " </div>";

                    users.innerHTML = anta;
                    $fs.append(users);

                    if(arr[index].leng==1){
                        $(".ggzz").eq(index).val("已关注");
                        $(".ggzz").eq(index).attr("disabled","disabled");
                    }
                    else if(arr[index].leng==0) {
                        $(".ggzz").eq(index).val("+关注");
                    }




                })
                /* $.each(leng,function (index) {
                     if(leng[index]==1){
                         $(".ggzz").eq(index).val("已关注");
                         $(".ggzz").eq(index).attr("disabled","disabled");
                     }
                     else if(leng[index]==0) {
                         $(".ggzz").eq(index).val("+关注");
                     }
                 })*/
            },
            error: function () {
                alert("出错了")
            }

        })

    })


    $(document).on("click",".ggzz", function () {
        var fb = $(this).prev().html();
        $.ajax({
            type: "get",
            url: "/Lf/py",
            dataType: "json",
            data: {
                fans_tel: fb
            },
            success: function (data) {
                if (data.result == "success") {

                    window.location.reload();
                }


            },
            error: function () {
                alert("关注失败！")
            }


        })

    })


    $(".left>div:nth-child(2)>form:nth-child(1)>input[type='button']").bind("click", function () {

        $guan = $("#link1");
        $gz = $(".gz");
        $fen = $("#link2");
        $fs = $(".fs");
        $dong = $("#link3");
        $dt = $(".right");
        $na = $(".na");
        $qb = $("#link4");
        $dt = $(".dt");
        $wdz = $("#link5");
        $dt_2 = $(".dt_2");
        $wdpl = $("#link6");
        $dt_3 = $(".dt_3");
        $but_1 = $(".left>div:nth-child(2)>form:nth-child(1)>input[type='button']");
        $but_2 = $(".left>div:nth-child(2)>form:nth-child(2)>input[type='button']");

        $(this).css("display", "none");
        $(this).next().css("display", "block");
        $(".left>div:nth-child(2)>form:nth-child(1) table tr td:nth-child(3)").css("display", "block");
        $(".left>div:nth-child(2)>form:nth-child(1) table tr td:nth-child(2)").css("display", "none");

    })


    $(".left>div:nth-child(2)>form:nth-child(2)>input[type='button']").bind("click", function () {

        $(this).css("display", "none");
        $(this).next().css("display", "block");
        $(".left>div:nth-child(2)>form:nth-child(2) table tr td:nth-child(3)").css("display", "block");
        $(".left>div:nth-child(2)>form:nth-child(2) table tr td:nth-child(2)").css("display", "none");

    })


    $("#link4").bind("click", function () {

        $dt.css("display", "block");
        $boom.css("display", "none");
        $dt_3.css("display", "none");

    })


    $("#link5").bind("click", function () {



        $.ajax({
            type:"get",
            contentType:"application/json",
            url:"/Lf/wdz",
            dataType:"json",
            success:function (data) {

                $dt.css("display", "none");
                $boom.css("display", "block");
                $dt_3.css("display", "none");

                $(".dt_2").empty();
                /*$(".boom").empty(".dt_2");*/


                var brr = data.result;

                $.each(brr, function (index) {
                    var date=new Date(brr[index].dynamic_time);
                    var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
                    var rdate=date.getFullYear()+'-'+month+'-'+date.getDate();


                    var dt_2 = document.createElement("div");
                    dt_2.className = "dt_2";
                    var lucky =
                        "<div class='dt_message'>"+
                        "<img src=\"" + brr[index].user_photo + "\" width='70' height='60' />" +
                        "<span>" + brr[index].user_name + "</span>" +
                        "<span>" + rdate + "</span>" +
                        "</div>"+
                        "<div class='dt_text'> " + brr[index].dynamic_text +
                        "</div>"+
                        "<div class='dt_photo'>"+
                        "</div>"+
                        "<div class='dt_zc'> " +
                        "<a>"+ "<i class='fa fa-comment-o' aria-hidden=\"true\">" + "</i>" + "<span>" +"</span>"+
                        "</a>"+
                        "<a>"+ "<i aria-hidden=\"true\">" + "</i>" + "<span>" + brr[index].like_count +  "</span>"+
                        "</a>"+
                        "</div>";


                    dt_2.innerHTML = lucky;
                    $boom.append(dt_2);

                    if(brr[index].size == 0) {
                        $(".dt_2>div:nth-child(4)>a:nth-child(2)>i:nth-child(1)").attr("class", "fa fa-thumbs-o-up")
                    }
                    else if(brr[index].size == 1)
                    {
                        $(".dt_2>div:nth-child(4)>a:nth-child(2)>i:nth-child(1)").attr("class", "fa fa-thumbs-up")
                    }



                })


            },
            error: function () {

                alert("出错了")
            }


        })







    })

    $("#filebutton").click(function () {
       $("#a_userPhoto").click()
    })
    $('#a_userPhoto').change(function(){
        var $file = $(this);
        var fileObj = $file[0];
        var windowURL = window.URL || window.webkitURL;
        var dataURL;
        var $img = $("#ylimg1");
        var $img2 = $("#ylimg2");
        var $img3 = $("#ylimg3");
        if (fileObj && fileObj.files && fileObj.files[0]) {
            dataURL = windowURL.createObjectURL(fileObj.files[0]);
            $img.attr('src', dataURL);
            $img2.attr('src', dataURL);
            $img3.attr('src', dataURL);
        } else {
            dataURL = $file.val();
            var imgObj = document.getElementById("preview");
            imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
        }

    });

    $(".deletedt").click(function () {
        if(confirm("确定删除？")){
            window.location.href=""
        }
    })

})

