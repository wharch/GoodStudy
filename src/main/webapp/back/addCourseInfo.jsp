<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/6
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/back/css/font.css">
    <link rel="stylesheet" href="<%=application.getContextPath()%>/back/lib/layui/css/layui.css">
    <link rel="stylesheet" href="<%=application.getContextPath()%>/back/css/xadmin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/css/swiper.min.css">
    <script type="text/javascript" src="https://cdn.bootcdn.net/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/js/swiper.jquery.min.js"></script>
    <script src="<%=application.getContextPath()%>/back/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=application.getContextPath()%>/back/js/xadmin.js"></script>
</head>
<body>
<div class="site-demo-button" id="layerDemo" style="margin-bottom: 0;">
    <button data-method="offset" data-type="auto" class="layui-btn layui-btn-normal">添加课程</button>
</div>
<script>
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
                        '        <h3>上传视频和笔记</h3>\n' +'<p>章节名为:</p><br>'+
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
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });

    });
</script>
</body>
</html>
