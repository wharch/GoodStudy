<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/6
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台登录-X-admin1.1</title>
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

</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="./login.jsp">易学网</a></div>
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
                            <a href="member-list.html">
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
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
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
                    <a style="color: white" href="<%=application.getContextPath()%>/courseInfo?op=reviewVideo&infoState=2"><li class="">待审核</li></a>
                    <a style="color: white" href="<%=application.getContextPath()%>/courseInfo?op=reviewVideo&infoState=1"><li>已通过</li></a>
                    <a style="color: white" href="<%=application.getContextPath()%>/courseInfo?op=reviewVideo&infoState=0"><li>未通过</li></a>
                </ul>
                <div class="layui-tab-content" style="height: 100px;">
                    <div class="layui-tab-item layui-show">
                        <table class="layui-table">
                            <thead>
                            <tr>
                                <th>
                                    ID
                                </th>
                                <th>
                                    课程名
                                </th>
                                <th>
                                    章节名
                                </th>
                                <th>
                                    小节名称
                                </th>
                                <th>
                                    视频
                                </th>
                                <th>
                                    教师名
                                </th>
                                <th>
                                    操作
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                               <c:forEach var="ci" items="${courseinfo_page.data}">
                                   <tr>
                                       <td>
                                           ${ci.infoId}
                                       </td>
                                       <td>
                                           ${ci.section.course.cName}
                                       </td>
                                       <td>
                                           ${ci.section.sectionName}
                                       </td>
                                       <td>
                                           ${ci.knobbleName}
                                       </td>
                                       <td>
                                           <p style="display: none" id="video">${ci.video}</p>
                                           <div class="site-demo-button" id="layerDemo" style="margin-bottom: 0;">
                                               <button data-method="offset" data-type="auto" class="layui-btn layui-btn-normal">查看视频</button>
                                           </div>
                                       </td>
                                       <td>
                                           ${ci.section.course.teacher.tName}
                                       </td>
                                       <td class="td-manage">
                                          <c:if test="${ci.infoState==2}">
                                           <a href="<%=application.getContextPath()%>/courseInfo?op=updateState&state=1&infoId=${ci.infoId}">通过</a>
                                           <a href="<%=application.getContextPath()%>/courseInfo?op=updateState&state=0&infoId=${ci.infoId}">不通过</a>
                                       </c:if>
                                           <c:if test="${ci.infoState==1}">
                                               已通过
                                           </c:if>
                                           <c:if test="${ci.infoState==0}">
                                               未通过
                                           </c:if>
                                       </td>
                                   </tr>
                               </c:forEach>
                            </tbody>
                            <tr>
                                <td colspan="7" style="text-align: center">
                                    <a href="<%=application.getContextPath()%>/courseInfo?op=reviewVideo&infoState=${state}&pageNum=1">首页</a>
                                    <a href="<%=application.getContextPath()%>/courseInfo?op=reviewVideo&infoState=${state}&pageNum=${courseinfo_page.prev()}">上一页</a>
                                    当前${courseinfo_page.currentPage}页/总共${courseinfo_page.totalPageCount()}页
                                    <a href="<%=application.getContextPath()%>/courseInfo?op=reviewVideo&infoState=${state}&pageNum=${courseinfo_page.next()}">下一页</a>
                                    <a href="<%=application.getContextPath()%>/courseInfo?op=reviewVideo&infoState=${state}&pageNum=${courseinfo_page.totalPageCount()}">尾页</a>
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
            <div class="swiper-slide"><img class="item" src="<%=application.getContextPath()%>/back/images/a.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="<%=application.getContextPath()%>/back/images/b.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="<%=application.getContextPath()%>/back/images/c.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="<%=application.getContextPath()%>/back/images/d.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="<%=application.getContextPath()%>/back/images/e.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="<%=application.getContextPath()%>/back/images/f.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="<%=application.getContextPath()%>/back/images/g.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="<%=application.getContextPath()%>/back/images/h.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="<%=application.getContextPath()%>/back/images/i.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="<%=application.getContextPath()%>/back/images/j.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="<%=application.getContextPath()%>/back/images/k.jpg" alt=""></div>
            <div class="swiper-slide"><span class="reset">初始化</span></div>
        </div>
    </div>
    <div class="bg-out"></div>
    <div id="changer-set"><i class="iconfont">&#xe696;</i></div>
</div>
<!-- 背景切换结束 -->
<!-- 页面动态效果 -->
<script>

    layui.use(['laydate'], function(){
        laydate = layui.laydate;//日期插件

        //以上模块根据需要引入
        //



        var start = {
            min: laydate.now()
            ,max: '2099-06-16 23:59:59'
            ,istoday: false
            ,choose: function(datas){
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };

        var end = {
            min: laydate.now()
            ,max: '2099-06-16 23:59:59'
            ,istoday: false
            ,choose: function(datas){
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };

        document.getElementById('LAY_demorange_s').onclick = function(){
            start.elem = this;
            laydate(start);
        }
        document.getElementById('LAY_demorange_e').onclick = function(){
            end.elem = this
            laydate(end);
        }

    });

    //批量删除提交
    function delAll () {
        layer.confirm('确认要删除吗？',function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
        });
    }

    /*浏览-删除*/
    function view_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }
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
<script>
    var a = $("#video").text();;
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
                    , area: ['800px', '500px']
                    , title: '视频'
                    , content:'<video  style="width: 700px;height:460px" controls = "controls"> <source src="<%=application.getContextPath()%>/video'+a+'"></source></video>'
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
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });

    });
</script>
</body>
</html>
