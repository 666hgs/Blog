<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/header.jsp" %>
<!-- page content -->
<div class="right_col" role="main" style="margin-left: 0">
    <div class="">
        <div class="row top_tiles">
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>分配新管理员账号<small>Allocation of new administrator accounts</small></h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <br />
                            <form id="demo" data-parsley-validate class="form-horizontal form-label-left"
                                  action="/backend/adminadd" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">照片<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="file" id="a_userPhoto" name="a_userPhoto">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="admin_count">账号<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" name="admin_count" id="admin_count" required="required" class="form-control col-md-7 col-xs-12" placeholder="4到16位（字母，数字，下划线，减号）">
                                        <span class="text-danger"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">地址<span class="required">*</span></label>
                                    <div class="col-sm-2">
                                        <select id="categoryLevel1" name="categoryLevel1" class="form-control">
                                            <c:if test="${placelist != null }">
                                                <option value="">--省--</option>
                                                <c:forEach var="list" items="${placelist}">
                                                    <option value="${list.id}">${list.name}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                    </div>
                                    <div class="col-sm-2">
                                        <input type="hidden" name="categorylevel2list" id="categorylevel2list"/>
                                        <select name="categoryLevel2" id="categoryLevel2" class="form-control">
                                            <option value="">--市--</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="admin_name">姓名<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" name="admin_name" id="admin_name" required="required" class="form-control col-md-7 col-xs-12">
                                        <span class="text-danger"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="admin_card">身份证<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" name="admin_card" id="admin_card" required="required" class="form-control col-md-7 col-xs-12">
                                        <span class="text-danger"></span>
                                    </div>
                                </div>
                                <%--<div class="ln_solid"></div>--%>
                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <button type="button" id="messageadd"  class="btn btn-success">SUBMIT</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>

            <div class="row">
                <div class="col-md-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>管理员列表<small>Allocation of new administrator accounts</small></h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <div class="row">
                                <c:forEach var="list" items="${adminlist}" varStatus="status">
                                    <div class="card col-sm-3" style="margin-bottom: 10px">
                                        <img class="card-img-top" src="${list.admin_photo}" alt="Card image" style="width:100%;height: 350px">
                                        <div class="card-body">
                                            <h4 class="card-title">${list.admin_name}</h4>
                                            <p class="card-text">
                                                账号：${list.admin_count}<br>
                                                密码：${list.admin_pass}<br>
                                                <c:if test="${list.admin_level==1}">超级管理员</c:if>
                                                <c:if test="${list.admin_level==2}">普通管理员</c:if><br>
                                                身份证：${list.admin_card}<br>
                                                地址：${list.categoryLevel1Name}-${list.categoryLevel2Name}<br>
                                            </p>
                                            <a class="btn btn-danger" admin_count="${list.admin_count}" admin_level="${list.admin_level}">删除</a>
                                            <a class="btn btn-success" href="/backend/adminmessage.html?admin_id=${list.admin_id}">修改</a>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /page content -->
<div class="clearfix"></div>
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script>
    $button=$(".btn-danger")
    $button.click(function () {
         var admin_count=$(this).attr("admin_count");
         var admin_level=$(this).attr("admin_level");
         if (admin_level==1){
             alert("该管理员无法删除！")
             return;
         }else {
             if(confirm("确定删除？")){
                 window.location.href="/backend/deleteadmin?admin_count="+admin_count;
             }
         }
    })

    $("#categoryLevel1").change(function(){
        var categoryLevel1 = $("#categoryLevel1").val();
        if(categoryLevel1 != '' && categoryLevel1 != null){
            $.ajax({
                type:"GET",//请求类型
                url:"/backend/categoryLevelList.json",//请求的url
                data:{id:categoryLevel1},//请求参数
                dataType:"json",//ajax接口（请求url）返回的数据类型
                success:function(data){//data：返回数据（json对象）
                    $("#categoryLevel2").html("");
                    var options = "<option value=\"\">--市--</option>";
                    for(var i = 0; i < data.length; i++){
                        options += "<option value=\""+data[i].id+"\">"+data[i].name+"</option>";
                    }
                    $("#categoryLevel2").html(options);
                },
                error:function(data){//当访问时候，404，500 等非200的错误状态码
                    alert("加载二级分类失败！");
                }
            });
        }else{
            $("#categoryLevel2").html("");
            var options = "<option value=\"\">--市--</option>";
            $("#categoryLevel2").html(options);
        }
    });


    $("#admin_count").bind("blur",function () {
        $.ajax({
            type:"GET",//请求类型
            url:"/backend/aexit.json",//请求的url
            data:{admin_count: $("#admin_count").val()},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(map){
                var uPattern = /^[a-zA-Z0-9_-]{4,16}$/;
                var count= $("#admin_count").val();
                if(uPattern.test(count)){
                    if(map.msg=="exit"){
                        $("#admin_count").next().html("该账号已存在！");
                    }else {
                        $("#admin_count").next().html("");
                    }
                }else{
                    $("#admin_count").next().html("账号格式有误！");
                }
            },
            error:function(data){
                alert("异步失败");
            }
        })
    })

    $("#admin_name").bind("blur",function () {
        var reg =  /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/;;
        var name=  $("#admin_name").val();
        if (reg.test(name)){
            $(this).next().html("");
        }else{
            $(this).next().html("姓名有误！");
        }
    })

    
    $("#admin_card").bind("blur",function () {
        var cP = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
        var card=  $("#admin_card").val();
        if (cP.test(card)){
            $(this).next().html("");
        }else{
            $(this).next().html("身份证格式有误！");
        }
    })
    
    $("#messageadd").click(function () {
        if ($("#admin_count").val() == "" || $("#admin_card").val() == "" ||$("#a_userPhoto").val() == ""||
            $("#admin_name").val() == "" || $("#categoryLevel1").val() == ""||$("#categoryLevel2").val() == "") {
            return;
        }else if($("#admin_count").next().val()!="" || $("#admin_card").next().val()!= "" ||$("#admin_name").next().val()!=""){
            return;
        }else {
            if(confirm("确定提交？")){
                $("#demo").submit();
            }
        }

    })
</script>
<%@include file="common/js.jsp" %>
