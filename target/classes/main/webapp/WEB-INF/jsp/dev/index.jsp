<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/font-awesome-4.7.0/css/font-awesome.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/index.css"/>
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/index.js"></script>
<body>
<%@include file="common/navbar.jsp" %>
<div class="main">
    <div class="center">
        <!-- 主页左 -->
        <div class="m_left">
            <div>
                <!-- 背景图片和头像框 -->
                <div>
                    <div class="photo">
                        <a href="/Lf/touser">
                            <img src="${sessionScope.users.user_photo}">
                        </a>
                    </div>
                </div>
                <!-- 关注/粉丝/微博数 -->
                <div class="message">
                    <h3>
                        <a href="/Lf/touser">${sessionScope.users.user_name}</a><br>
                        <a href="/Lf/touser">${sessionScope.users.user_tel}</a>
                    </h3>
                    <span><a href="/Lf/getfollow">关注<br>${users.follow_count}</a></span>|
                    <span><a href="#">粉丝<br>${users.fans_count}</a></span>|
                    <span><a href="#">动态<br>${users.dynamic_count}</a></span>
                </div>
            </div>

            <div>
                <ul>
                    <li><a href="#">首页</a></li>
                    <li><a href="#">好友圈</a></li>
                    <li><a href="#">特别关注</a></li>
                    <li><a href="#">我的赞</a></li>
                    <li><a href="#">热门微博</a></li>
                </ul>
            </div>
        </div>

        <!-- 主页中 -->
        <div class="m_center">
            <!-- 发表动态 -->
            <div>
                <span>今天你想说点什么呢！？</span>
                <br/>
                <form action="/up/sendBolg" method="post" enctype="multipart/form-data">
                    <textarea rows="3" style="width: 100%;" name="dynamic_text"></textarea>
                    <div class="nei">
                        <i class="fa fa-picture-o" aria-hidden="true" id="lphoto"></i><span>图片</span>
                        <i class="fa fa-smile-o" aria-hidden="true"></i><span>表情</span>
                        <i class="fa fa-video-camera" aria-hidden="true" ></i><span>视频</span>
                        <i class="fa fa-bolt" aria-hidden="true"></i><span>文章</span>
                        <i class="fa fa-hashtag" aria-hidden="true"></i><span>话题</span>
                        <div id="photoshow">
                            <i class="fa fa-sort-asc" aria-hidden="true"></i>
                            <h4>本地上传</h4>
                            <span>一共只能上传3张照片哦</span>
                            <div>
                                <div>
                                    <span class="blackbo"></span>
                                    <img id="img1" src=''/>
                                    <i class="fa fa-times" aria-hidden="true"></i>
                                </div>
                                <div>
                                    <span class="blackbo"></span>
                                    <img id="img2" src=''/>
                                    <i class="fa fa-times" aria-hidden="true"></i>
                                </div>
                                <div>
                                    <span class="blackbo"></span>
                                    <img id="img3" src=''/>
                                    <i class="fa fa-times" aria-hidden="true"></i>
                                </div>
                                <input type="file" style="display: none;" id="a_userPhoto" name="a_userPhoto">
                                <input type="file" style="display: none;" id="a_userPhoto2" name="a_userPhoto2">
                                <input type="file" style="display: none;" id="a_userPhoto3" name="a_userPhoto3">
                                <input type="button" id="filebutton" value="+">
                            </div>
                        </div>
                    </div>
                    <input type="submit" disabled="disabled" value="发送"/>
                </form>
            </div>
            <!-- 动态内容 -->
            <div>

                <c:forEach var="dynamic" items="${dtlist}" varStatus="status">
                    <div class="dt">
                        <!-- 个人信息 -->
                        <div class="dt_message">
                            <img src="${dynamic.user_photo}"
                                 onclick="window.location.href='/Lf/userindex?user_tid=${dynamic.user_tid}'"/>
                            <span>${dynamic.user_name}</span>
                            <span><fmt:formatDate value="${dynamic.dynamic_time}"
                                                  pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></span>
                            <a class="follow">
                            <span class="guanzhu">
                                <c:if test="${dynamic.big==0}">
                                    <i style="color: #fa7d3c" class="fa fa-plus" aria-hidden="true"></i>关注
                                </c:if>
                                <c:if test="${dynamic.big>0}">
                                    <i style="color: #428bca" class="fa fa-check"
                                       aria-hidden="true"></i>已关注</c:if></span>
                            </a>
                            <img src="/statics/images/03.gif" class="loading" width="16" height="16"
                                 style="margin-left: 520px; margin-top: 12px; display: none;">
                        </div>
                        <!-- 内容 -->
                        <div class="dt_text">
                            <li name="dynamic_id" class="dy" style="display: none">${dynamic.dynamic_id}</li>
                            <li name="user_tid" class="uid" style="display: none">${dynamic.user_tid}</li>
                                ${dynamic.dynamic_text}

                        </div>
                        <!-- 图片 -->
                        <div class="dt_photo">
                            <img class="bigphoto" src="">
                            <c:if test="${!empty dynamic.dynamic_photo}">
                                <img class="smallphoto" src="${dynamic.dynamic_photo}">
                            </c:if>
                            <c:if test="${!empty dynamic.dynamic_photo1}">
                                <img class="smallphoto" src="${dynamic.dynamic_photo1}">
                            </c:if>
                            <c:if test="${!empty dynamic.dynamic_photo2}">
                                <img class="smallphoto" src="${dynamic.dynamic_photo2}">
                            </c:if>
                        </div>
                        <!-- 点赞/评论 -->
                        <div class="dt_zc">
                            <a href="/Comment/comment?dynamic_id=${dynamic.dynamic_id}"><i class="fa fa-comment-o"
                                                                                           aria-hidden="true"></i><span>${dynamic.comsun}</span></a>
                            <a class="ceshi">
                                <i
                                        <c:if test="${dynamic.size==0}">class="fa fa-thumbs-o-up"</c:if>
                                        <c:if test="${dynamic.size>0}">class="fa fa-thumbs-up"</c:if> aria-hidden="true"
                                        id="dianzan"></i><span class="ct">${dynamic.like_count}</span></a>

                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>

        <div class="m_right">
            <div class="ggl">
                <div>
                    <span>公告栏</span>
                </div>
                <span><a href="#">《全国辟谣平台》</a></span><br/>
                <span><a href="#">《首都互联网协会发布七条底线倡议书》</a></span>
            </div>
            <div class="hot">
                <div>
                    <span>热门话题</span>
                </div>
                <ul>
                    <li><a href="#">#我们的师傅#<span>222</span></a></li>
                    <li><a href="#">#愚人节#<span>342</span></a></li>
                    <li><a href="#">#3月再见#<span>223352</span></a></li>
                    <li><a href="#">#这就是街舞#<span>2245462</span></a></li>
                    <li><a href="#">#歌手#<span>226762</span></a></li>
                </ul>
                <div>查看更多</div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<%@include file="common/footer.jsp" %>
</body>
</html>
