<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台登录-X-admin1.1</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/back/css/font.css">
    <link rel="stylesheet" href="<%=application.getContextPath()%>/back/lib/layui/css/layui.css">
    <link rel="stylesheet" href="<%=application.getContextPath()%>/back/css/xadmin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/css/swiper.min.css">
    <script type="text/javascript" src="https://cdn.bootcdn.net/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/js/swiper.jquery.min.js"></script>
    <script src="<%=application.getContextPath()%>/back/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=application.getContextPath()%>/back/js/xadmin.js"></script>

</head>
<body>
<div class="login-logo"><h1>教师注册</h1></div>
<div class="login-box" style="height: auto">
    <form class="layui-form layui-form-pane" action="<%=application.getContextPath()%>/teacher?op=register" method="post" enctype="multipart/form-data">

        <h3>注册您的帐号</h3>
        <label class="login-title" for="tName">姓名</label>
        <div class="layui-form-item" id="tName">
            <label class="layui-form-label login-form" style="height: 20px"><i class="iconfont">&#xe67f;</i></label>
            <div class="layui-input-inline login-inline" >
                <input type="text"  name="tName" lay-verify="required" placeholder="请输入您的姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <label class="login-title" for="tSex">性别</label>
        <div class="layui-form-item" id="tSex">
            <div class="layui-input-inline login-inline" >
                <input type="radio"  name="tSex"  class="layui-form-radio" value="男" title="男" checked>
                <input type="radio"  name="tSex"  class="layui-input" value="女" title="女">
            </div>
        </div>
        <label class="login-title" for="hiredate">入职日期</label>
        <div class="layui-form-item" id="hiredate">
            <label class="layui-form-label login-form" style="height: 20px"><i class="iconfont">&#xe66c;</i></label>
            <div class="layui-input-inline login-inline" >
                <input type="date"  name="hiredate" lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <label class="login-title" for="tPhone">电话</label>
        <div class="layui-form-item" id="tPhone">
            <label class="layui-form-label login-form" style="height: 20px"><i class="iconfont">&#xe673;</i></label>
            <div class="layui-input-inline login-inline" >
                <input type="text"  name="tPhone" lay-verify="required" placeholder="请输入手机号"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <label class="login-title" for="password">密码</label>
        <div class="layui-form-item" id="password">
            <label class="layui-form-label login-form" style="height: 20px"><i class="iconfont">&#xe674;</i></label>
            <div class="layui-input-inline login-inline" >
                <input type="password"  name="password" lay-verify="required" placeholder="请输入你的密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <label class="login-title" for="certificate">证件号</label>
        <div class="layui-form-item" id="certificate">
            <label class="layui-form-label login-form" style="height: 20px"><i class="iconfont">&#xe67e;</i></label>
            <div class="layui-input-inline login-inline" >
                <input type="text"  name="certificate" lay-verify="required" placeholder="请输入你的证件号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <label class="login-title" for="certificate_img">上传证件照</label>
        <div class="layui-form-item" id="certificate_img">
            <label class="layui-form-label login-form" style="height: 20px"><i class="iconfont">&#xe67e;</i></label>
            <div class="layui-input-inline login-inline" >
                <input type="file"  name="certificate_img" accept="image/*" lay-verify="required" placeholder="请输入你的证件号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="form-actions">
            <button class="btn btn-warning pull-right" lay-submit lay-filter="login"  type="submit">注册</button>
            <div class="forgot"><a href="#" class="forgot">忘记帐号或者密码</a></div>
        </div>
    </form>
</div>
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
<%--<script>--%>
<%--    $(function  () {--%>
<%--        layui.use('form', function(){--%>
<%--            var form = layui.form();--%>
<%--            //监听提交--%>
<%--            form.on('submit(login)', function(data){--%>
<%--                layer.msg(JSON.stringify(data.field),function(){--%>
<%--                    location.href='index.html'--%>
<%--                });--%>
<%--                return false;--%>
<%--            });--%>
<%--        });--%>
<%--    })--%>

<%--</script>--%>
<%--<script>--%>
<%--    //百度统计可去掉--%>
<%--    var _hmt = _hmt || [];--%>
<%--    (function() {--%>
<%--        var hm = document.createElement("script");--%>
<%--        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";--%>
<%--        var s = document.getElementsByTagName("script")[0];--%>
<%--        s.parentNode.insertBefore(hm, s);--%>
<%--    })();--%>
<%--</script>--%>
</body>
</html>
