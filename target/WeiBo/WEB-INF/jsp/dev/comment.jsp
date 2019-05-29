<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/font-awesome-4.7.0/css/font-awesome.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/comment.css" />
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script>
	$(function () {
		$(".smallphoto").click(function(){
			$(this).prevAll(".bigphoto").attr("src",$(this).attr("src"));
			$(this).prevAll(".bigphoto").css("display","block");
		})
		$(".bigphoto").click(function(){
			$(this).css("display","none");
		})
    })
</script>

<body>
<%@include file="common/navbar.jsp" %>
<div class="main">
	<div class="center">
		<div class="dt">
			<!-- 个人信息 -->
			<div class="dt_message">
				<img src="${dynamic.user_photo}" />
				<span>${dynamic.user_name}</span>
				<span><fmt:formatDate value="${dynamic.dynamic_time}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></span>
			</div>
			<!-- 内容 -->
			<div class="dt_text">
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
				<a href="#"><i class="fa fa-comment-o" aria-hidden="true"></i><span id="CommentNum">${requestScope.num}</span></a>
				<a href="#"><i <c:if test="${dynamic.size==0}"> class="fa fa-thumbs-o-up"</c:if> <c:if
						test="${dynamic.size>0}"> class="fa fa-thumbs-up"</c:if>
						aria-hidden="true"></i><span>${requestScope.good}</span></a>
			</div>
		</div>
		<!-- 评论区 -->
		<div class="comment" id="command_big">
			<div class="mypl">
				<img src="${sessionScope.users.user_photo}">
				<textarea name="comment" id="textarea" placeholder="请留下您的评论"></textarea>
                <input type="hidden" id="dynamic_Id" name="dynamic_Id" value="${dynamic_Id}">
				<input type="submit" value="评论" onclick="addComment()"/>
			</div>
           <%-- 父列表区--%>
			<c:forEach items="${requestScope.commentList}" var="list" varStatus="status">
			<div class="pl">
				<img src="${list.photo}">
				<div class="fistpl">
					<a href="#"><span>${list.name}</span></a>：
					<span>${list.comment}</span>
					<span class="time">${list.timeChange}</span>
					<input class="returnf" type="button" value="回复" />  <%--点击按钮跳出弹框--%>
                    <form style="display: none" onclick="return false" id="SonComment1${status.index}">
                        <textarea  name='sonComment' class='huif' rows='1' id=${status.index} placeholder='请留下您的回复'></textarea>
                        <input  type="hidden" name="commentId"  value="${list.commentId}">
						<input  type="hidden" name="othername" value="${list.name}">
                        <input  type="hidden" name="dynamic_Id" value="${dynamic_Id}">
                        <input type='submit' value='回复' onclick="addSonComment1(${status.index})" />
                    </form>
				</div>



                <div class="zjpl" id="son${status.index}">
                    <c:forEach items="${list.soncommentList}" var="list2" varStatus="status2">
						<c:if test="${empty list.soncommentList}">
							<div></div>
						</c:if>
                    <div style="padding-top: 3px">
                        <a href="#"><span>${list2.myname}</span></a><span>回复</span><a href="#"><span>${list2.othername}</span></a>：
                        <span>${list2.reply}</span>
                        <span class="time" style="font-size: 11px">${list2.timeChange}</span>
                        <input type="button" value="回复" class="returnf" />
						<form style="display: none" onclick="return false" id="SonComment2${status.index}${status2.index}">
							<textarea  name='sonComment2' class='huif' rows='1' id="SonCom${status.index}${status2.index}" placeholder='请留下您的回复'></textarea>
							<input  type="hidden" name="name2"  value="${list2.commentId}">
							<input  type="hidden" name="othername2" value="${list2.myname}">
                            <input  type="hidden" name="dynamic_Id" value="${dynamic_Id}">
							<input type='submit' value='回复' onclick="addSonComment2(${status.index},${status2.index})" />
						</form>
                    </div>

                    </c:forEach>
					<c:if test="${empty list.soncommentList}">
						<div></div>
					</c:if>
                </div>




			</div>
			</c:forEach>

        </div>
	</div>
</div>
<script>
        function addComment() {
            $.ajax({
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/Comment/addComment.json",//url
                data: {"comment": $("#textarea").val(),"dynamic_Id": $("#dynamic_Id").val()},
                success: function (data) {
                    var name = data.comment2.name
                    var comment = data.comment2.comment
                    var timeChange = data.comment2.timeChange
                    var num=data.num
                    $("#command_big>div:last").after("<div class=\"pl\" >\n" +
                        "                <img src=\"${sessionScope.users.user_photo}\">\n" +
                        "                <div class=\"fistpl\">\n" +
                        "                    <a href=\"#\"><span></span></a>：\n" +
                        "                    <span></span>\n" +
                        "                    <span class=\"time\"></span>\n" +
                        "                    <input class=\"returnf\" type=\"button\" value=\"回复\" />\n" +
                        "                </div>\n" +
                        "\n" +
                        "            </div>")
                    $("#command_big>div:last").children().children("a").children("span").html(name)
                    $("#command_big>div:last").children().children("span:first").html(comment)
                    $("#command_big>div:last").children().children("span:last").html(timeChange)
                    $("#textarea").val("")
                    $("#CommentNum").html(num)

                },
                error: function () {
                    alert("异常！");
                }
            });
        }

        function addSonComment1(id) {
            $.ajax({
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/Comment/addSonComment.json",//url
                data: {
                    "sonComment": $("#" + id).val(),
                    "commentId": $("#"+id).next().val(),
                    "othername": $("#"+id).next().next().val(),
                    "dynamic_Id":$("#"+id).next().next().next().val()
                },
                success: function (data) {
                    var myname = data.soncomment1.myname
                    var othername = data.soncomment1.othername
                    var timeChange = data.soncomment1.timeChange
                    var reply=data.soncomment1.reply
                    var num=data.num

                    $("#son"+id).children("div:last").after("  <div style=\"padding-top: 3px\">\n" +
                       "                        <a href=\"#\"><span></span></a><span>回复</span><a href=\"#\"><span></span></a>：\n" +
                       "                        <span></span>\n" +
                       "                        <span class=\"time\" style=\"font-size: 11px\"></span>\n" +
                       "                        <input type=\"button\" value=\"回复\" />\n" +
                       "                    </div>")

                    $("#son"+id).children("div:last").children("a:first").children("span").html(myname)
                    $("#son"+id).children("div:last").children("a:last").children("span").html(othername)
					$("#son"+id).children("div:last").children("span:last").html(timeChange)
                    $("#son"+id).children("div:last").children("span:last").prev().html(reply)
                    $("#" + id).val("")
                    $("#SonComment1"+id).css("display","none")
                    $("#CommentNum").html(num)

                },
                error: function () {
                    alert("异常！");
                }
            });
        }

        function addSonComment2(id,id2) {
            $.ajax({
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/Comment/addSonComment.json",//url
                data: {
                    "sonComment": $("#SonCom" + id+id2).val(),
                    "commentId": $("#SonCom"+id+id2).next().val(),
                    "othername": $("#SonCom"+id+id2).next().next().val(),
                    "dynamic_Id":$("#SonCom"+id+id2).next().next().next().val()
                },
                success: function (data) {
                    var myname = data.soncomment1.myname
                    var othername = data.soncomment1.othername
                    var timeChange = data.soncomment1.timeChange
                    var reply=data.soncomment1.reply
                    var num=data.num

                    $("#son"+id).children("div:last").after("  <div style=\"padding-top: 3px\">\n" +
                        "                        <a href=\"#\"><span></span></a><span>回复</span><a href=\"#\"><span></span></a>：\n" +
                        "                        <span></span>\n" +
                        "                        <span class=\"time\" style=\"font-size: 11px\"></span>\n" +
                        "                        <input type=\"button\" value=\"回复\" />\n" +
                        "                    </div>")

                    $("#son"+id).children("div:last").children("a:first").children("span").html(myname)
                    $("#son"+id).children("div:last").children("a:last").children("span").html(othername)
                    $("#son"+id).children("div:last").children("span:last").html(timeChange)
                    $("#son"+id).children("div:last").children("span:last").prev().html(reply)
                    $("#SonCom" + id+id2).val("")
                    $("#SonComment2"+id+id2).css("display","none")
                    $("#CommentNum").html(num)


                },
                error: function () {
                    alert("异常！");
                }
            });
        }

        $(".returnf").click(function () {
            if ($(this).next().css("display") == "none") {
                $(this).next().css("display", "block")
            }
            else {
                $(this).next().css("display", "none")

            }
        })

</script>
<%@include file="common/footer.jsp" %>
</body>
</html>
