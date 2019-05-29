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
                            <h2>${admin.admin_name}基本信息</h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <br />
                            <form id="update" data-parsley-validate class="form-horizontal form-label-left"
                                  action="/backend/upmessage?admin_id=${admin.admin_id}" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">照片<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="file" value="${admin.admin_photo}" id="a_userPhoto" name="a_userPhoto">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="admin_count">账号<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" value="${admin.admin_count}" readonly="value" id="admin_count" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="admin_pass">密码<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="password" value="${admin.admin_pass}" readonly="value"  id="admin_pass" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="admin_name">姓名<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" value="${admin.admin_name}" name="admin_name" id="admin_name" required="required" class="form-control col-md-7 col-xs-12">
                                        <span class="text-danger"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">地址<span class="required">*</span></label>
                                    <div class="col-sm-2">
                                        <select id="categoryLevel1" name="categoryLevel1" class="form-control">
                                            <c:if test="${categoryLevel1list != null }">
                                                <option value="">--省--</option>
                                                <c:forEach var="list" items="${categoryLevel1list}">
                                                    <option <c:if test="${list.id == admin.categoryLevel1 }">selected="selected"</c:if>
                                                            value="${list.id}">${list.name}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                    </div>
                                    <div class="col-sm-2">
                                        <input type="hidden" name="categorylevel2list" id="categorylevel2list"/>
                                        <select name="categoryLevel2" id="categoryLevel2" class="form-control">
                                            <c:if test="${categoryLevel2list != null }">
                                                <option value="">--市--</option>
                                                <c:forEach var="list" items="${categoryLevel2list}">
                                                    <option <c:if test="${list.id == admin.categoryLevel2 }">selected="selected"</c:if>
                                                            value="${list.id}">${list.name}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="admin_card">身份证<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" value="${admin.admin_card}" name="admin_card" id="admin_card" required="required" class="form-control col-md-7 col-xs-12">
                                        <span class="text-danger"></span>
                                    </div>
                                </div>
                                <%--<div class="ln_solid"></div>--%>
                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <button type="button" id="updatemessage"  class="btn btn-success">确认</button>
                                        <a href="JavaScript:history.back(-1)">
                                            <button type="button"  class="btn btn-primary">返回</button>
                                        </a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>

        </div>
    </div>
</div>
<!-- /page content -->
<div class="clearfix"></div>
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script>
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

    $("#updatemessage").click(function () {
        if ($("#admin_card").val() == "" ||$("#a_userPhoto").val() == ""||
            $("#admin_name").val() == "" || $("#categoryLevel1").val() == ""||$("#categoryLevel2").val() == "") {
            return;
        }else if($("#admin_card").next().val()!= "" ||$("#admin_name").next().val()!=""){
            return;
        }else {
            if(confirm("确定修改？")){
                $("#update").submit();
            }
        }

    })
</script>
<%@include file="common/js.jsp" %>
