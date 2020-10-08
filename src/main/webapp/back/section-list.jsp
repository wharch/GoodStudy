<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/10/7
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>课程列表</title>
    <script type="text/javascript" src="https://cdn.bootcdn.net/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/js/swiper.jquery.min.js"></script>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/back/css/font.css">
    <link rel="stylesheet" href="<%=application.getContextPath()%>/back/lib/layui/css/layui.css">
    <link rel="stylesheet" href="<%=application.getContextPath()%>/back/css/xadmin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/css/swiper.min.css">
    <script src="<%=application.getContextPath()%>/back/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=application.getContextPath()%>/back/js/xadmin.js"></script>
    <script type="text/javascript">
        $(function(){
            //判断有没有进行登录
            if(${sessionScope.teacherLogin == null}){
                alert("您还未进行登录，请登录后查看...")
                location.href="./login.jsp";
            }
            //判断有没有上传成功
            if(${requestScope.addCourseMsg == 'yes'}){
                alert("上传成功！")
            }else if(${requestScope.addCourseMsg == 'no'}){
                alert("上传失败！")
            }
        })
    </script>
</head>
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
            <form class="layui-form xbs" action="" >
                <div class="layui-form-pane" style="text-align: center;">
                    <div class="layui-form-item" style="display: inline-block;">
                        <div class="layui-input-inline">
                            <input type="text" name="username"  placeholder="请输入章节名" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-input-inline" style="width:80px">
                            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </div>
                </div>
            </form>
            <xblock><button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon">&#xe640;</i>批量删除</button><button class="layui-btn" onclick="section_add('添加章节','<%=application.getContextPath()%>/course?op=findByName&cName=${requestScope.cName}','4','','510')"><i class="layui-icon">&#xe608;</i>添加</button><span class="x-right" style="line-height:40px">共有数据：88 条</span></xblock>
            <table class="layui-table text-center" id="menuTable">
                <caption></caption>
                <thead>
                <tr>
                    <th>
                        <input type="checkbox" name="" value="">
                    </th>
                    <th>
                        章节编号
                    </th>
                    <th>
                        章节名称
                    </th>
                    <th colspan="2">
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.allSectionByPage.getData()}" var="section">
                    <tr>
                        <td>
                            <input type="checkbox" value="1" name="">
                        </td>
                        <td>
                                ${section.sectionId}
                        </td>

                        <td >
                                ${section.sectionName}
                        </td>
                        <td class="td-manage">
                            <a style="text-decoration:none"  onclick="course_update('修改章节','section-update.jsp','10001','600','400')" href="javascript:;" title="修改章节">
                                <i class="layui-icon">&#xe631;</i>
                            </a>
                            <a title="删除" href="javascript:;" onclick="section_del(this,${section.sectionId})"  style="text-decoration:none">
                                <i class="layui-icon">&#xe640;</i>
                            </a>
                            <div class="site-demo-button" id="layerDemo" style="margin-bottom: 0;">
                                <button data-method="offset"  data-type="auto" class="layui-btn layui-btn-normal">上传视频与笔记</button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                <tr>
                    <td colspan="9" style="text-align: center">
                        <a href="<%=application.getContextPath()%>/section?op=findByCId&pageNum=1&cId=${requestScope.cId}">首页</a>
                        <a href="<%=application.getContextPath()%>/section?op=findByCId&pageNum=${requestScope.allSectionByPage.prev()}&cId=${requestScope.cId}">上一页</a>
                        当前${requestScope.allSectionByPage.currentPage}页/总共${requestScope.allSectionByPage.totalPageCount()}页
                        <a href="<%=application.getContextPath()%>/section?op=findByCId&pageNum=${requestScope.allSectionByPage.next()}&cId=${requestScope.cId}">下一页</a>
                        <a href="<%=application.getContextPath()%>/section?op=findByCId&pageNum=${requestScope.allSectionByPage.totalPageCount()}&cId=${requestScope.cId}">尾页</a>
                    </td>
                </tr>
            </table>
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
<!--模态框开始-->
<!-- 页面动态效果 -->
<script>

    layui.use(['laydate'], function(){
        laydate = layui.laydate;//日期插件

        //以上模块根据需要引入
        //
        //
        //
        //
        // document.getElementById('LAY_demorange_s').onclick = function(){
        //     start.elem = this;
        //     laydate(start);
        // }
        // document.getElementById('LAY_demorange_e').onclick = function(){
        //     end.elem = this
        //     laydate(end);
        // }

    });

    //批量删除提交
    function delAll () {
        layer.confirm('确认要删除吗？',function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
        });
    }
    /*用户-添加*/
    function course_add(title,url,w,h){
        x_admin_show(title,url,w,h);
    }
    /*用户-查看*/
    function member_show(title,url,id,w,h){
        x_admin_show(title,url,w,h);
    }
    // 用户-编辑
    function section_add (title,url,id,w,h) {
        x_admin_show(title,url,w,h);
    }
    /*密码-修改*/
    function course_update(title,url,id,w,h){
        x_admin_show(title,url,w,h);
    }
    /*章节-删除*/
    function section_del(obj,id){
        layer.confirm('确认要删除吗？',function(){
            $.ajax({
                async:true,
                url:"<%=application.getContextPath()%>/section",
                type:"post",
                data:{
                    op:"delete",
                    sectionId:id
                },
                success:function (data) {
                    if("yes" == data){
                        //发异步把用户状态进行更改
                        //发异步删除数据
                        $(obj).parents("tr").remove();
                        layer.msg('已删除!',{icon:1,time:1000});
                    }

                },
                error:function (xhr,status,error) {
                    alert("ajax异步刷新失败！")
                }

            });

        });
    }
    //视频和笔记的上传
    layui.use('layer', function () { //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        var active = {
            offset: function (othis) {
                var type = othis.data('type')
                    , text = othis.text();

                layer.open({
                    type: 1
                    , offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                    , id: 'layerDemo' + type //防止重复弹出
                    , area: ['600px', '650px']
                    , title: '上传视频和笔记'
                    , content: '<div style="padding: 20px 100px;">\n' +
                        '<div class="login-box" style="height: auto">\n' +
                        '    <form class="layui-form layui-form-pane" action="<%=application.getContextPath()%>/courseInfo?op=addCourseInfo" method="post" enctype="multipart/form-data">\n' +
                        '\n' +
                        '        <h3>上传视频和笔记</h3>\n' +'<p>章节名为:'+$(othis).parents("td").prev().html()+'</p><br>'+
                        '        <input type="text"  name="cId" hidden="hidden" value="${requestScope.cId}">\n'+
                        '        <input type="text"  name="sId" hidden="hidden" value="'+$(othis).parents("td").prev().prev().html()+'">\n'+
                        '        <label class="login-title" for="video">上传视频</label>\n' +
                        '        <div class="layui-form-item" id="video">\n' +
                        '            <label class="layui-form-label login-form" style="height: 20px"><i class="iconfont">&#xe675;</i></label>\n' +
                        '            <div class="layui-input-inline login-inline" >\n' +
                        '                <input type="file"  name="video" accept="video/*" lay-verify="required"  autocomplete="off" class="layui-input">\n' +
                        '            </div>\n' +
                        '        </div>\n' +
                        '        <label class="login-title" for="knobbleName">小节名称</label>\n' +
                        '        <div class="layui-form-item" id="knobbleName">\n' +
                        '            <label class="layui-form-label login-form" style="height: 20px"><i class="iconfont">&#xe673;</i></label>\n' +
                        '            <div class="layui-input-inline login-inline" >\n' +
                        '                <input type="text"  name="knobbleName" lay-verify="required" placeholder="请输入小节名称"  autocomplete="off" class="layui-input">\n' +
                        '            </div>\n' +
                        '        </div>\n' +
                        '        <label class="login-title" for="note">上传笔记</label>\n' +
                        '        <div class="layui-form-item" id="note">\n' +
                        '            <label class="layui-form-label login-form" style="height: 20px"><i class="iconfont">&#xe676;</i></label>\n' +
                        '            <div class="layui-input-inline login-inline" >\n' +
                        '                <input type="file"  name="note" accept=".doc,.pdf,.docx,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document" lay-verify="required" placeholder="请输入你的证件号" autocomplete="off" class="layui-input">\n' +
                        '            </div>\n' +
                        '        </div>\n' +
                        '        <div class="form-actions">\n' +
                        '            <button class="btn btn-warning pull-right" lay-submit lay-filter="login"  type="submit">上传</button>\n' +
                        '        </div>\n' +
                        '    </form>\n' +
                        '</div> </div>'
                    , btn: '关闭全部'
                    , btnAlign: 'c' //按钮居中
                    , shade: 0 //不显示遮罩
                    , yes: function () {
                        layer.closeAll();
                    }
                });
            }
        };
        $('#layerDemo .layui-btn').on('click', function () {
            var othis = $(this), method = othis.data('method') ;
            active[method] ? active[method].call(this, othis) : '';
        });

    });
</script>
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
