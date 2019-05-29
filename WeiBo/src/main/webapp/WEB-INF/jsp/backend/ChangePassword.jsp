<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="common/header.jsp" %>
<!-- page content -->
<div class="right_col" role="main" style="margin-left: 0">
    <div class="">
        <div class="row top_tiles">
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>修改密码<small>Change Password</small></h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <br />
                            <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left"
                                  action="/backend/changpass">
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="oldpass">旧密码<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input class="sr-only" id="userpass" value="${sessionScope.admin.admin_pass}">
                                        <input type="password" id="oldpass" name="oldpass" required="required" class="form-control col-md-7 col-xs-12">
                                        <span class="text-danger"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="newpass">新密码 <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="password" id="newpass" name="newpass" required="required" class="form-control col-md-7 col-xs-12">
                                        <span class="text-danger"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="confirmpass" class="control-label col-md-3 col-sm-3 col-xs-12">确认新密码<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="confirmpass"  name="confirmpass" class="form-control col-md-7 col-xs-12" type="password">
                                        <span class="text-danger"></span>
                                    </div>
                                </div>
                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <button type="button" id="tijiao" class="btn btn-success">SUBMIT</button>
                                    </div>
                                </div>
                            </form>
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
    $(function () {

        $("[data-toggle='popover']").popover("toggle");

        var oldpass=$("#oldpass")
        var newpass=$("#newpass")
        var confirmpass=$("#confirmpass")
        var button=$("#tijiao")

        // input propertychange
        oldpass.bind("blur",function () {
            $.ajax({
                type:"get",
                url:"/backend/oldpass.json",
                data:{old:oldpass.val()},
                dataType:"json",
                success:function (map) {
                    if (map.msg=="error"){
                        oldpass.next().html("您输入的旧密码有误！")
                    }else{
                        oldpass.next().html("")
                    }
                },error:function (map) {
                   alert("请求失败")
                }
            })
        })
        
        newpass.bind("blur",function () {
            var pattern = /^[\w_-]{6,16}$/;
            if (newpass.val()==""){
                newpass.next().html("")
            }else{
                if (newpass.val().match(pattern)){
                    newpass.next().html("")
                } else {
                    newpass.next().html("密码必须为6到16位！")
                }
            }
        })
        
        confirmpass.bind("blur",function () {
            if (confirmpass.val()!=newpass.val()) {
                confirmpass.next().html("两次密码不一致！")
            }else {
                confirmpass.next().html("")
            }
        })

        button.bind("click",function () {
            if ($("#userpass").val()!=oldpass.val()){
                return;
            }else if(confirmpass.val()!=newpass.val()){
                confirmpass.next().html("两次密码不一致！")
                return;
            }else if(oldpass.val()==""||confirmpass.val()==""||newpass.val()==""){
                return;
            } else{
                    $("#demo-form2").submit();
            }
        })
    })
</script>
<%@include file="common/footer.jsp" %>
