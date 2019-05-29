<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/user.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/font-awesome-4.7.0/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/bootstrap.3.3.7.min.css"/>
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/user.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/bootstrap.3.7.7.min.js"></script>
<body>
<%@include file="common/navbar.jsp" %>
<div class="main">
    <div class="center">
        <div class="top">
            <img src="${user.user_photo}" data-toggle="modal" data-target="#myModal">
            <span>${user.user_name}</span>
            <span>${user.user_intro}</span>
        </div>

        <div class="left">
            <div>
                <a id="link1"><span>${user.follow_count}</span><br>关注</a>
                <a id="link2"><span>${user.fans_count}</span><br>粉丝</a>
                <a id="link3" href="/Lf/userindex?user_tid=${user.user_tel}"><span>${user.dynamic_count}</span><br>动态</a>
            </div>
            <!-- 个人信息 -->

            <div>
                <form action="/Lf/update" method="post">
                    <hr/>
                    <span>基本信息</span>
                    <c:if test="${user.user_tel==sessionScope.users.user_tel}">
                        <input type="button" value="编辑"/>
                        <input type="submit" value="保存"/>
                    </c:if>
                    <table>
                        <tr>
                            <td>登录名</td>
                            <td class="usert">${user.user_tel}</td>
                            <td><input name="user_tel" type="text" value="${user.user_tel}"/></td>
                        </tr>
                        <tr>
                            <td>昵称</td>
                            <td>${user.user_name}</td>
                            <td><input type="text" name="user_name" value="${user.user_name}"/></td>
                        </tr>
                        <tr>
                            <td>性别</td>
                            <td>
                                <c:if test="${user.user_sex==1}">男</c:if>
                                <c:if test="${user.user_sex==2}">女</c:if>
                            </td>
                            <td>
                                <select name="user_sex" class="select">
                                    <c:if test="${user.user_sex==1 }">
                                        <option value="1" selected="selected">男</option>
                                        <option value="2">女</option>
                                    </c:if>
                                    <c:if test="${user.user_sex==2 }">
                                        <option value="1">男</option>
                                        <option value="2" selected="selected">女</option>
                                    </c:if>
                                    <c:if test="${user.user_sex==null}">
                                        <option value="1">男</option>
                                        <option value="2">女</option>
                                    </c:if>
                                </select>

                            </td>

                        </tr>
                        <tr>
                            <td>生日</td>
                            <td><fmt:formatDate value="${user.user_birth}" type="date"></fmt:formatDate></td>
                            <td><input name="user_birth" type="date"
                                       value="<fmt:formatDate value="${user.user_birth}"	type="date"></fmt:formatDate>"/>
                            </td>
                        </tr>
                        <tr>
                            <td>简介</td>
                            <td>${user.user_intro}</td>
                            <td><input name="user_intro" type="text" value="${user.user_intro}"/></td>
                        </tr>
                        <tr>
                            <td>注册时间</td>
                            <td><fmt:formatDate value="${user.user_rtime}" type="date"></fmt:formatDate></td>
                            <td><input  type="text" value="<fmt:formatDate value="${user.user_rtime}" type="date"></fmt:formatDate>" readonly="readonly" style="border: none"/></td>
                        </tr>
                    </table>
                </form>
                <form action="/Lf/pudate" method="post">
                    <hr/>
                    <span>联系方式</span>
                    <c:if test="${user.user_tel==sessionScope.users.user_tel}">
                        <input type="button" value="编辑"/>
                        <input type="submit" value="保存"/>
                    </c:if>
                    <table>
                        <tr>
                            <td>邮箱</td>
                            <td>${user.user_email}</td>
                            <td><input name="user_email" type="text" value="${user.user_email}"/></td>
                        </tr>
                        <tr>
                            <td>QQ</td>
                            <td>${user.user_qq}</td>
                            <td><input name="user_qq" type="text" value="${user.user_qq}"/></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="gz">
            <div>
                <span>全部关注</span>
            </div>
            <%--遍历关注--%>
        </div>
        <div class="fs">
            <div>
                <span>全部粉丝</span>
            </div>
            <%--遍历粉丝--%>
        </div>

        <div class="right">
            <div class="na">
                <span id="link4">我的动态</span>
                <c:if test="${user.user_tel==sessionScope.users.user_tel}">
                    <span id="link5">我的点赞</span>
                    <span id="link6">我的评论</span>
                </c:if>
            </div>
            <!-- 全部 -->
            <c:forEach var="my" items="${mylist}" varStatus="status">
                <div class="dt">
                    <c:if test="${user.user_tel==sessionScope.users.user_tel}">
                        <a href="/up/delete?dynamic_id=${my.dynamic_id}" class="deletedt">
                            <i class="fa fa-times"  aria-hidden="true"></i>
                        </a>
                    </c:if>
                    <div class="dt_message">
                        <img src="${my.user_photo}"/>
                        <span>${my.user_name}</span>
                        <span><fmt:formatDate value="${my.dynamic_time}" type="date"></fmt:formatDate></span>
                    </div>
                    <div class="dt_text">
                            ${my.dynamic_text}
                    </div>
                    <div class="dt_photo">
                        <img class="bigphoto" src="">
                        <c:if test="${!empty my.dynamic_photo}">
                            <img class="smallphoto" src="${my.dynamic_photo}">
                        </c:if>
                        <c:if test="${!empty my.dynamic_photo1}">
                            <img class="smallphoto" src="${my.dynamic_photo1}">
                        </c:if>
                        <c:if test="${!empty my.dynamic_photo2}">
                            <img class="smallphoto" src="${my.dynamic_photo2}">
                        </c:if>
                    </div>
                    <div class="dt_zc">
                        <a href="/Comment/comment?dynamic_id=${my.dynamic_id}"><i class="fa fa-comment-o" aria-hidden="true"></i><span>${my.comsun}</span></a>
                        <a href="#"><i <c:if test="${my.size==0}"> class="fa fa-thumbs-o-up"</c:if> <c:if
                                test="${my.size>0}"> class="fa fa-thumbs-up"</c:if>
                                aria-hidden="true"></i><span>${my.like_count}</span></a>
                        </div>
                </div>
            </c:forEach>
            <!-- 我的点赞 -->

            <div class="boom">
                <%--遍历我的点赞--%>
            </div>

            <!-- 我的评论 -->
            <div class="dt_3">
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    头像设置
                </h4>
            </div>
            <form action="/Lf/photo?user_tel=${user.user_tel}" method="post" enctype="multipart/form-data">
                <div class="modal-body">
                    <div class="left_bo">
                        <input type="button" id="filebutton" value="+选择照片">
                        <span>只支持JPG、PNG、GIF，大小不超过5M</span>
                    </div>
                    <div class="right_bo">
                        <p>预览</p>
                        <img id="ylimg1" src="${user.user_photo}" >
                        <p>100px x 100px</p>
                        <img id="ylimg2" src="${user.user_photo}">
                        <p>50px x 50px</p>
                        <img id="ylimg3" src="${user.user_photo}">
                        <p>30px x 30px</p>
                    </div>
                    <div style="clear: left;"></div>
                    <input type="file" style="display: none;" id="a_userPhoto"  name="a_userPhoto"   multiple="multiple" accept="image/jpeg,image/jpg">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="submit" class="btn btn-primary">
                        确定
                    </button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%@include file="common/footer.jsp" %>

</body>
</html>



