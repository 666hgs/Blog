<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="common/header.jsp" %>
<!-- page content -->
<div class="right_col" role="main" style="margin-left: 0">
    <div class="">
        <div class="row top_tiles">
            <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="tile-stats">
                    <div class="icon"><i class="fa fa-user"></i></div>
                    <div class="count">${admincount}</div>
                    <h3>管理员</h3>
                    <p>Administrators.</p>
                </div>
            </div>
            <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="tile-stats">
                    <div class="icon"><i class="fa fa-spinner"></i></div>
                    <div class="count">${usercount}</div>
                    <h3>用户数</h3>
                    <p>User.</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /page content -->
<div class="clearfix"></div>
<%@include file="common/footer.jsp" %>
