<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/10/9
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>教师列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="https://cdn.bootcdn.net/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/js/swiper.jquery.min.js"></script>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=application.getContextPath()%>/back/css/font.css">
    <link rel="stylesheet" href="<%=application.getContextPath()%>/back/lib/layui/css/layui.css">
    <link rel="stylesheet" href="<%=application.getContextPath()%>/back/css/xadmin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/css/swiper.min.css">
    <script src="<%=application.getContextPath()%>/back/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=application.getContextPath()%>/back/js/xadmin.js"></script>
    <script type="text/javascript">
        $(function(){
            if(${sessionScope.adminLogin == null}){
                alert("您还未进行登录，请登录后查看...")
                location.href="./login.jsp";
            }
        })
    </script>
</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="back/admin-index.jsp">易学网</a></div>
    <div class="open-nav"><i class="iconfont">&#xe699;</i></div>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;"  id="adminName">
                ${sessionScope.adminLogin.tName}
            </a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a href="#"></a></dd>
                <dd><a href="<%=application.getContextPath()%>/teacher?op=logout&user=admin">切换帐号</a></dd>
                <dd><a href="<%=application.getContextPath()%>/teacher?op=logout&user=admin">退出</a></dd>
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
                    <a href="./login.jsp">
                        <i class="iconfont">&#xe761;</i>
                        欢迎页面
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                </li>
                <li class="list">
                    <a href="javascript:;">
                        <i class="iconfont">&#xe70b;</i>
                        教师管理
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="<%=application.getContextPath()%>/teacher?op=findByStateByPage">
                                <i class="iconfont">&#xe6a7;</i>
                                教师列表
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="list" >
                    <a href="javascript:;">
                        <i class="iconfont">&#xe6a3;</i>
                        课程管理
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu" style="display:none">
                        <li>
                            <a href="<%=application.getContextPath()%>/courseInfo?op=reviewVideo&infoState=2">
                                <i class="iconfont">&#xe6a7;</i>
                                视频审核
                            </a>
                        </li>
                        <li>
                            <a href="<%=application.getContextPath()%>/kind?op=doFindAllByPage">
                                <i class="iconfont">&#xe6a7;</i>
                                分类列表
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!-- 左侧菜单结束 --> <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="content">
            <!-- 右侧内容框架，更改从这里开始 -->
            <form class="layui-form xbs" action="" >
            </form>
            <div class="layui-input-inline">
                <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-input-inline" style="width:80px">
                <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
            </div>
            <br>
            <div class="layui-tab layui-tab-card" style="border: 0;height: 600px">
                <ul class="layui-tab-title" style="background-color: rgba(0,0,0,0.1);color: white;border: 0">
                    <a style="color: white" href="<%=application.getContextPath()%>/teacher?op=findByStateByPage&tState=1"><li class="">已通过</li></a>
                    <a style="color: white" href="<%=application.getContextPath()%>/teacher?op=findByStateByPage&tState=2"><li>待审核</li></a>
                </ul>
                <div class="layui-tab-content" style="height: 100px;">
                    <div class="layui-tab-item layui-show">
                        <table class="layui-table" method="post">
                            <thead>
                            <tr>
                                <th>
                                    编号
                                </th>
                                <th>
                                    姓名
                                </th>
                                <th>
                                    性别
                                </th>
                                <th>
                                    入职日期
                                </th>
                                <th>
                                    电话
                                </th>
                                <th>
                                    头像
                                </th>
                                <th>
                                    证书编号
                                </th>
                                <th>
                                    手持证书照片
                                </th>
                                <th>
                                    状态
                                </th>
                                <th>
                                    审核操作
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="t" items="${teacherPage.data}">
                                <tr>
                                    <td>
                                            ${t.tId}
                                    </td>
                                    <td>
                                            ${t.tName}
                                    </td>
                                    <td>
                                            ${t.tGender}
                                    </td>
                                    <td>
                                            ${t.hiredate}
                                    </td>
                                    <td>
                                            ${t.tPhone}
                                    </td>
                                    <td>
                                        <img src="<%=application.getContextPath()%>/teacherHeadImg/${t.tHeadImg}"width="100"height="100">
                                    </td>
                                    <td>
                                            ${t.certificate}
                                    </td>
                                    <td>
                                        <img src="<%=application.getContextPath()%>/certificate/${t.certificateImg}"width="100"height="100">
                                    </td>
                                    <td>
                                        <c:if test="${t.tState == 1}">
                                            已通过
                                        </c:if>
                                        <c:if test="${t.tState == 2}">
                                            待审核
                                        </c:if>
                                    </td>
                                    <td class="td-manage">
                                        <c:if test="${t.tState == 1}">
                                            <a href="<%=application.getContextPath()%>/teacher?op=updateState&tStateNow=1&tId=${t.tId}">不通过</a>
                                        </c:if>
                                        <c:if test="${t.tState == 2}">
                                            <a href="<%=application.getContextPath()%>/teacher?op=updateState&tStateNow=2&tId=${t.tId}">通过</a>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tr>
                                <td colspan="9" style="text-align: center">
                                    <a href="<%=application.getContextPath()%>/teacher?op=findByStateByPage&pageNum=1&tState=${requestScope.state}">首页</a>
                                    <a href="<%=application.getContextPath()%>/teacher?op=findByStateByPage&pageNum=${requestScope.teacherPage.prev()}&tState=${requestScope.state}">上一页</a>
                                    当前${requestScope.teacherPage.currentPage}页/总共${requestScope.teacherPage.totalPageCount()}页
                                    <a href="<%=application.getContextPath()%>/teacher?op=findByStateByPage&pageNum=${requestScope.teacherPage.next()}&tState=${requestScope.state}">下一页</a>
                                    <a href="<%=application.getContextPath()%>/teacher?op=findByStateByPage&pageNum=${requestScope.teacherPage.totalPageCount()}&tState=${requestScope.state}">尾页</a>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <!-- 右侧内容框架，更改从这里结束 -->
        </div>
    </div>
    <!-- 右侧主体结束 -->
</div>
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <div class="copyright">Copyright ©2017 x-admin v2.3 All Rights Reserved. 本后台系统由X前端框架提供前端技术支持</div>
</div>
<!-- 底部结束 -->
<!-- 背景切换开始 -->
<div class="bg-changer">
    <div class="swiper-container changer-list">
        <div class="swiper-wrapper">
            <div class="swiper-slide"><img class="item" src="./images/a.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="./images/b.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="./images/c.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="./images/d.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="./images/e.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="./images/f.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="./images/g.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="./images/h.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="./images/i.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="./images/j.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="./images/k.jpg" alt=""></div>
            <div class="swiper-slide"><span class="reset">初始化</span></div>
        </div>
    </div>
    <div class="bg-out"></div>
    <div id="changer-set"><i class="iconfont">&#xe696;</i></div>
</div>
<!-- 背景切换结束 -->
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
