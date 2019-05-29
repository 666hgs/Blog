<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   <!-- jQuery -->
    <script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${pageContext.request.contextPath }/statics/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="${pageContext.request.contextPath }/statics/js/fastclick.js"></script>
    <!-- NProgress -->
    <script src="${pageContext.request.contextPath }/statics/js/nprogress.js"></script>
    <!-- jQuery custom content scroller -->
    <script src="${pageContext.request.contextPath }/statics/js/jquery.mCustomScrollbar.concat.min.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="${pageContext.request.contextPath }/statics/js/custom.min.js"></script>
   <script>
       $("#admin").bind("click", function () {
           var obj = $(this);
           var id = obj.attr("admin_level");
           if (id == 1) {
               window.location.href = "/backend/adminlist.html"
           } else {
               alert("你没有访问该列表的权限!")
           }
       })

   </script>