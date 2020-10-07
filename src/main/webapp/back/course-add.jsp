<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/10/6
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加课程</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%--<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />--%>
    <%--<link rel="stylesheet" href="<%=application.getContextPath()%>/back/css/font.css">--%>
    <%--<link rel="stylesheet" href="<%=application.getContextPath()%>/back/css/xadmin.css">--%>
    <%--<link rel="stylesheet" href="https://cdn.bootcss.com/Swiper/3.4.2/css/swiper.min.css">--%>
    <%--<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>--%>
    <%--<script type="text/javascript" src="https://cdn.bootcss.com/Swiper/3.4.2/js/swiper.jquery.min.js"></script>--%>
    <%--<script src="<%=application.getContextPath()%>/back/lib/layui/layui.js" charset="utf-8"></script>--%>
    <%--<script type="text/javascript" src="<%=application.getContextPath()%>/back/js/xadmin.js"></script>--%>
    <script type="text/javascript" src="https://cdn.bootcdn.net/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/js/swiper.jquery.min.js"></script>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/back/css/font.css">
    <link rel="stylesheet" href="<%=application.getContextPath()%>/back/lib/layui/css/layui.css">
    <link rel="stylesheet" href="<%=application.getContextPath()%>/back/css/xadmin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/css/swiper.min.css">
    <script type="text/javascript"  src="<%=application.getContextPath()%>/back/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=application.getContextPath()%>/back/js/xadmin.js"></script>
    <script type="text/javascript">
        $(function(){
            //在session中判断若没有登录过需要进行登录
            if(${sessionScope.teacherLogin == null}){
                alert("您还未进行登录，请登录后查看...")
                location.href="./login.jsp";
            }
        })
    </script>
</head>
<body>
<!-- 中部开始 -->
<div class="wrapper">
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="content">
            <!-- 右侧内容框架，更改从这里开始 -->
            <form class="layui-form" action="<%=application.getContextPath()%>/course?op=add" method="post" enctype="multipart/form-data">
                <div class="layui-form-item">
                    <label for="cName" class="layui-form-label">
                        <span class="x-red">*</span>课程名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="cName" name="cName" required=""  autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="kindId" class="layui-form-label">
                        <span class="x-red">*</span>课程类别
                    </label>
                    <div class="layui-input-inline" id="kind">
                        <select name="kindId" id="kindId">
                            <option>请选择课程</option>
                            <c:forEach items="${requestScope.allKind}" var="kind">
                                <option value="${kind.kindId}">${kind.kindName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="cMaster" class="layui-form-label">
                        <span class="x-red">*</span>展示缩略图
                    </label>
                    <div class="layui-input-inline">
                        <input type="file" name="cMaster" id="cMaster" multiple><br/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="cInfo" class="layui-form-label">
                        <span class="x-red">*</span>课程简介
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="cInfo" name="cInfo" required=""  autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="cPrice" class="layui-form-label">
                        <span class="x-red">*</span>课程价格
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="cPrice" name="cPrice" required=""  autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <button  class="layui-btn" lay-submit="">
                        增加
                    </button>
                </div>
            </form>
            <!-- 右侧内容框架，更改从这里结束 -->
        </div>
    </div>
    <!-- 右侧主体结束 -->
</div>
<!-- 中部结束 -->
<script>
    //百度统计可去掉
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>
</html>
