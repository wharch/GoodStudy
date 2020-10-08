<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/10/8
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>教师-个人中心</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="https://cdn.bootcdn.net/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/js/swiper.jquery.min.js"></script>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/back/css/font.css">
    <link rel="stylesheet" href="<%=application.getContextPath()%>/back/lib/layui/css/layui.css">
    <link rel="stylesheet" href="<%=application.getContextPath()%>/back/css/xadmin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/css/swiper.min.css">
    <script src="<%=application.getContextPath()%>/back/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=application.getContextPath()%>/back/js/xadmin.js"></script>
    <%--<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />--%>
    <%--<link rel="stylesheet" href="<%=application.getContextPath()%>/back/css/font.css">--%>
    <%--<link rel="stylesheet" href="<%=application.getContextPath()%>/back/css/xadmin.css">--%>
    <%--<link rel="stylesheet" href="https://cdn.bootcss.com/Swiper/3.4.2/css/swiper.min.css">--%>
    <%--<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>--%>
    <%--<script type="text/javascript" src="https://cdn.bootcss.com/Swiper/3.4.2/js/swiper.jquery.min.js"></script>--%>
    <%--<script src="<%=application.getContextPath()%>/back/lib/layui/layui.js" charset="utf-8"></script>--%>
    <%--<script type="text/javascript" src="<%=application.getContextPath()%>/back/js/xadmin.js"></script>--%>
    <script type="text/javascript">
        $(function(){
            if(${sessionScope.teacherLogin == null}){
                alert("您还未进行登录，请登录后查看...")
                location.href="./login.jsp";
            }
            if(${requestScope.editMsg == "yes"}){
                alert("修改成功！")
            }else if(${requestScope.editMsg == "no"}){
                alert("修改失败！")
            }
        })
    </script>
</head>
<body>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="back/teacher-index.jsp">易学网</a></div>
    <div class="open-nav"><i class="iconfont">&#xe699;</i></div>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;"  id="adminName">
                ${sessionScope.teacherLogin.tName}
            </a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a href="#"></a></dd>
                <dd><a href="<%=application.getContextPath()%>/teacher?op=findByTId">个人中心</a></dd>
                <dd><a href="<%=application.getContextPath()%>/teacher?op=logout&user=teacher">切换帐号</a></dd>
                <dd><a href="<%=application.getContextPath()%>/teacher?op=logout&user=teacher">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="/">前台首页</a></li>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<div class="wrapper">
    <!-- 左侧菜单开始 -->
    <div class="left-nav">
        <div id="side-nav">
            <ul id="nav">
                <li class="list" current>
                    <a href="back/teacher-index.jsp">
                        <i class="iconfont">&#xe761;</i>
                        欢迎页面
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                </li>
                <li class="list">
                    <a href="javascript:;">
                        <i class="iconfont">&#xe70b;</i>
                        课程管理
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="<%=application.getContextPath()%>/course?op=findAllByPage&pageNum=1">
                                <i class="iconfont">&#xe6a7;</i>
                                课程列表
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="content">
            <!-- 右侧内容框架，更改从这里开始 -->
            <form class="layui-form" action="<%=application.getContextPath()%>/teacher?op=editPersonal" method="post" enctype="multipart/form-data">
                <input hidden="hidden" value="${requestScope.teacherOld.tId}" name="tId" type="text">
                <input hidden="hidden" value="${requestScope.teacherOld.tPwd}" name="tPwd" type="text">
                <input hidden="hidden" value="${requestScope.teacherOld.tHeadImg}" name="tHeadImgName" type="text">
                <div class="layui-form-item">
                    <label for="tHeadImg" class="layui-form-label">
                        头像
                    </label>
                    <div class="layui-input-inline layui-btn-radius">
                      <img src="<%=application.getContextPath()%>/teacherHeadImg${requestScope.teacherOld.tHeadImg}" height="50px" width="50px"/>
                      <div class="layui-input-inline">
                          <input type="file" name="tHeadImg" id="tHeadImg" multiple><br/>
                      </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="tUsername" class="layui-form-label">
                        账号（用户名）
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="tUsername" name="tUsername" required value="${requestScope.teacherOld.tUsername}" readonly="readonly" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="tName" class="layui-form-label">
                        真实姓名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="tName" name="tName" required value="${requestScope.teacherOld.tName}" readonly="readonly" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        真实姓名一旦注册无法修改
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="tPhone" class="layui-form-label">
                       手机号码
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="tPhone" name="tPhone" required value="${requestScope.teacherOld.tPhone}" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        性别
                    </label>
                        <div class="layui-input-inline">
                            <c:if test="${requestScope.teacherOld.tGender == '男'}">
                                <input type="radio" name="tGender" value="男" checked title="男">
                                <input type="radio" name="tGender" value="女" title="女">
                            </c:if>
                            <c:if test="${requestScope.teacherOld.tGender == '女'}">
                                <input type="radio" name="tGender" value="男" title="男">
                                <input type="radio" name="tGender" value="女" checked title="女">
                            </c:if>
                        </div>
                </div>

                <div class="layui-form-item">
                    <label for="hiredate" class="layui-form-label">
                        入职日期
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="hiredate" name="hiredate" autocomplete="off" value="${requestScope.teacherOld.hiredate}"  class="layui-input" readonly="readonly">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label for="tInfo" class="layui-form-label">
                        简介
                    </label>
                    <div class="layui-input-block">
                        <textarea placeholder="随便写些什么刷下存在感" id="tInfo" name="tInfo" autocomplete="off" class="layui-textarea" style="height: 80px;">
                            ${requestScope.teacherOld.tInfo}
                        </textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn" key="set-mine" lay-filter="save" lay-submit type="submit">
                        保存
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
</body>
</html>
