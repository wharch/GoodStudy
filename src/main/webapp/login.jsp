<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>

    <!-- Stylesheets -->
    <link href="front/css/bootstrap.css" rel="stylesheet">
    <link href="front/css/main.css" rel="stylesheet">
    <link href="front/css/responsive.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;300;400;500;600;700;800;900&family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">

    <!-- Color Switcher Mockup -->
    <link href="front/css/color-switcher-design.css" rel="stylesheet">
    <!-- Color Themes -->
    <link id="theme-color-file" href="front/css/color-themes/theme-one.css" rel="stylesheet">

    <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
    <link rel="icon" href="images/favicon.png" type="image/x-icon">

    <!-- Responsive -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

    <!--[if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script><![endif]-->
    <!--[if lt IE 9]><script src="front/js/respond.js"></script><![endif]-->

</head>

<body>


<div class="page-wrapper">

    <!-- Preloader -->
    <div class="preloader"></div>

    <!-- Main Header-->
    <header class="main-header">

        <!-- Header Upper -->
        <div class="header-upper">
            <div class="outer-container">
                <div class="clearfix">

                    <!-- Header Left -->
                    <div class="header-left clearfix">

                        <!-- Left Sidebar Btn -->
                        <div class="left-sidebar-btn hidden-bar-opener">
                            <span class="icon flaticon-menu-2"></span>
                        </div>

                        <div class="pull-left logo-box">
                            <div class="logo"><a href="index.html"><img src="images/logo.png" alt="" title=""></a></div>
                            <div class="dark-layout-logo"><a href="index.html"><img src="images/logo-4.png" alt="" title=""></a></div>
                        </div>

                        <!-- Search -->
                        <div class="search-box">
                            <form method="post" action="contact.html">
                                <div class="form-group">
                                    <input type="search" name="search-field" value="" placeholder="Search course name" required>
                                    <button type="submit"><span class="icon fa fa-search"></span></button>
                                </div>
                            </form>
                        </div>

                    </div>

                    <!-- Header Right -->
                    <div class="header-right clearfix">

                        <div class="nav-outer clearfix">

                            <!-- Main Menu -->
                            <nav class="main-menu navbar-expand-md">
                                <div class="navbar-header">
                                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </button>
                                </div>

                                <div class="navbar-collapse collapse clearfix" id="navbarSupportedContent">
                                    <ul class="navigation clearfix">
                                        <li class="dropdown"><a href="#">Course</a>
                                            <ul>
                                                <li><a href="featured-courses.html">Featured Courses</a></li>
                                                <li><a href="latest-courses.html">Latest Courses</a></li>
                                                <li><a href="category.html">Course Categories</a></li>
                                                <li><a href="course-detail.html">Course Landing</a></li>
                                                <li><a href="course-lesson.html">Course Lesson</a></li>
                                            </ul>
                                        </li>
                                        <li class="dropdown"><a href="#">Instructor</a>
                                            <ul>
                                                <li><a href="dashboard.html">Instructor Dashboard</a></li>
                                                <li><a href="manage-course.html">Manage Courses</a></li>
                                                <li><a href="edit-course.html">Edit Course</a></li>
                                                <li><a href="earning.html">Earnings</a></li>
                                                <li><a href="instructor-profile.html">Instructor Profile</a></li>
                                                <li><a href="team.html">Popular Instructors</a></li>
                                            </ul>
                                        </li>
                                        <li class="dropdown"><a href="#">Student</a>
                                            <ul>
                                                <li><a href="enrolled-courses.html">Enrolled Courses</a></li>
                                                <li><a href="certificate.html">Certificate Center</a></li>
                                                <li><a href="test.html">Quiz</a></li>
                                                <li><a href="result.html">Quiz Result</a></li>
                                                <li><a href="student-profile.html">Student Profile</a></li>
                                            </ul>
                                        </li>
                                        <li class="dropdown"><a href="#">Pages</a>
                                            <ul>
                                                <li><a href="price.html">Subscription</a></li>
                                                <li><a href="blog.html">Blog</a></li>
                                                <li><a href="blog-detail.html">Blog Detail</a></li>
                                                <li><a href="not-found.html">Error Page</a></li>
                                                <li><a href="coming-soon.html">Coming Soon</a></li>
                                                <li><a href="checkout.html">Checkout</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>

                            </nav>

                        </div>

                        <!-- Options Box -->
                        <div class="options-box clearfix">

                            <!-- Message Box -->
                            <div class="message-box">
                                <a href="#" class="icon flaticon-envelope"></a>
                            </div>
                            <!-- End Message Box -->

                            <!-- Notification Box -->
                            <div class="notification-box">
                                <div class="dropdown">
                                    <button class="notification-box-btn dropdown-toggle" type="button" id="dropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="flaticon-notification"></span><i class="notification-alert"></i></button>
                                    <div class="dropdown-menu pull-right cart-panel" aria-labelledby="dropdownMenu">

                                        <div class="notification-block">
                                            <div class="inner">
                                                <div class="image"><img src="images/resource/author-1.jpg" alt="" /></div>
                                                <h3><a href="#">Jessica Parl</a></h3>
                                                <div class="notification-text">It is a long established fact that a most reader will be distracted by the way readable</div>
                                                <div class="post-time">15 min ago</div>
                                            </div>
                                        </div>
                                        <div class="notification-block">
                                            <div class="inner">
                                                <div class="image"><img src="images/resource/author-2.jpg" alt="" /></div>
                                                <h3><a href="#">David John</a></h3>
                                                <div class="notification-text">It is a long established fact that a like reader will</div>
                                                <div class="post-time">15 min ago</div>
                                            </div>
                                        </div>
                                        <div class="notification-block">
                                            <div class="inner">
                                                <div class="image"><img src="images/resource/author-3.jpg" alt="" /></div>
                                                <h3><a href="#">Jonathon Deo</a></h3>
                                                <div class="notification-text">It is a long established fact that a reader will</div>
                                                <div class="post-time">15 min ago</div>
                                            </div>
                                        </div>

                                        <a href="#" class="view">View All</a>

                                    </div>
                                </div>
                            </div>
                            <!-- End Notification Box -->

                            <!-- Profile Box -->
                            <div class="profile-box dropdown" id="someElementID5">
                                <div class="btn btn-default dropdown-toggle">
                                    <span class="profile-image"><img src="images/resource/author-4.jpg" alt="" /></span> <i class="arrow flaticon-down-arrow"></i>
                                </div>
                                <div class="profile-content">
                                    <div class="setting"><a href="setting.html">Settings</a></div>
                                    <!-- Dark Mode -->
                                    <div class="dark-mode">
                                        <div class="clearfix">
                                            <div class="pull-left">
                                                <div class="mode"><span class="icon"><img src="images/icons/moon.png" alt="" /></span> Dark Mode</div>
                                            </div>
                                            <div class="pull-right">
                                                <!-- Dark Btns -->
                                                <ul class="dark-buttons clearfix">
                                                    <li data-tab="#" class="off">Off</li>
                                                    <li class="boll"><span class="round"></span></li>
                                                    <li data-tab="#" class="on">On</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Pages -->
                                    <ul class="pages">
                                        <li><a href="login.html">Sign In</a></li>
                                        <li><a href="sign-up.html">Sign Up</a></li>
                                        <li><a href="feedback.html">Feedback</a></li>
                                        <li><a href="contact.html">Contact Us</a></li>
                                        <li><a href="help.html">Help</a></li>
                                    </ul>
                                </div>
                            </div>

                        </div>

                    </div>

                </div>
            </div>
        </div>
        <!--End Header Upper-->

        <!-- Mobile Menu  -->
        <div class="mobile-menu">
            <div class="menu-backdrop"></div>
            <div class="close-btn"><span class="icon fa fa-remove"></span></div>

            <nav class="menu-box">
                <div class="nav-logo"><a href="index.html"><img src="images/logo.png" alt="" title=""></a></div>
                <div class="menu-outer"><!--Here Menu Will Come Automatically Via Javascript / Same Menu as in Header--></div>
            </nav>
        </div><!-- End Mobile Menu -->

    </header>
    <!--End Main Header -->

    <!-- Sign Up Section -->
    <section class="signup-section login-section" style="background-image:url(front/images/background/pattern-4.png)">
        <div class="auto-container">
            <div class="logo">
                <a href="register.jsp"><img src="images/logo-3.png" alt="" /></a>
            </div>
            <div class="inner-container">
                <h2><span class="theme_color">学生登录</span></h2>
                <div class="text">Student login</div>

                <!-- Login Form -->
                <div class="styled-form">
                    ${message}
                    <form method="post" action="<%=application.getContextPath()%>/admin?op=login" method="post">
                        <%--创建一个隐藏域--%>
                        <input type="hidden" name="token" value="${word}">
                        <!-- Form Group -->
                        <div class="form-group">
                            <input type="text" name="username" value="" placeholder="用户名" required>
                        </div>

                        <!-- Form Group -->
                        <div class="form-group">
                            <input type="password" name="pwd" value="" placeholder="密码" required>
                        </div>

                        <div class="form-group">
                            <div class="clearfix">
                                <div class="pull-left">
                                    <div class="check-box">
                                        <input type="checkbox" name="remember-password" id="type-1">
                                        <label for="type-1">记住密码</label>
                                    </div>
                                </div>
                                <div class="pull-right">
                                    <a href="#" class="forgot">忘记密码?</a>
                                </div>
                            </div>
                        </div>

                        <div class="form-group text-center">
                            <button type="submit" class="theme-btn btn-style-one"><span class="txt">登录</span></button>
                        </div>

                        <div class="form-group">
                            <div class="users">没有账号？ <a href="sign-up.html">立即注册</a></div>
                        </div>

                    </form>
                </div>

                <!-- Social Boxed -->
                <!--<div class="social-boxed text-center">-->
                <!--<a href="#"><span class="icon fa fa-facebook"></span>Continue with Facebook</a>-->
                <!--<a class="linkedin" href="#"><span class="icon fa fa-linkedin"></span>Continue with Linkedin</a>-->
                <!--<a class="twitter" href="#"><span class="icon fa fa-twitter"></span>Continue with Twitter</a>-->
                <!--</div>-->

            </div>

            <!-- Copyright -->
            <div class="copyright">版权所有 © 2020 AuburnForest</div>

        </div>
    </section>
    <!-- End Sign Up Section -->

</div>
<!-- End pagewrapper -->

<!-- Sidebar Nav -->
<div class="sidenav-list">
    <ul class="navbar">
        <li><a href="index.html"><i class="icon flaticon-home"></i> <span><i class="flaticon-home"></i> Home</span></a></li>
        <li><a href="course-lesson.html"><i class="icon flaticon-book"></i> <span><i class="flaticon-book"></i>Course Lesson</span></a></li>
        <li><a href="category.html"><i class="icon flaticon-test"></i> <span><i class="flaticon-test"></i>Categories</span></a></li>
        <li><a href="dashboard.html"><i class="icon flaticon-report"></i> <span><i class="flaticon-report"></i>Dashboard</span></a></li>
        <li><a href="manage-course.html"><i class="icon flaticon-test"></i> <span><i class="flaticon-test"></i>Manage Course</span></a></li>
        <li><a href="earning.html"><i class="icon flaticon-pie-chart-1"></i> <span><i class="flaticon-pie-chart-1"></i>Earning</span></a></li>
        <li><a href="enrolled-courses.html"><i class="icon flaticon-file"></i> <span><i class="flaticon-file"></i>Enrolled Courses</span></a></li>
        <li><a href="certificate.html"><i class="icon flaticon-new-window"></i> <span><i class="flaticon-new-window"></i>Certificate</span></a></li>
        <li><a href="team.html"><i class="icon flaticon-file"></i> <span><i class="flaticon-file"></i>Instructors</span></a></li>
        <li><a href="contact.html"><i class="icon flaticon-contact"></i> <span><i class="flaticon-contact"></i>Contact Us</span></a></li>
        <li><a href="help.html"><i class="icon flaticon-information"></i> <span><i class="flaticon-information"></i>Help</span></a></li>
    </ul>
</div>
<!-- End Sidebar Nav -->

<!-- Hidden Navigation Bar -->
<section class="hidden-bar left-align">
    <div class="color-layer"></div>
    <div class="hidden-bar-closer">
        <span class="flaticon-multiply"></span>
    </div>
    <!-- Hidden Bar Wrapper -->
    <div class="hidden-bar-wrapper">
        <ul class="pages-list">
            <li class="active"><a href="index.html"><span class="icon flaticon-home"></span>Home</a></li>
            <li><a href="featured-courses.html"><span class="icon flaticon-book"></span>Featured Courses</a></li>
            <li><a href="course-lesson.html"><span class="icon flaticon-category"></span>Courses Lesson</a></li>
            <li><a href="category.html"><span class="icon flaticon-test"></span>Course Categories</a></li>
            <li><a href="latest-courses.html"><span class="icon flaticon-subscription"></span>Latest Courses</a></li>
            <li><a href="course-detail.html"><span class="icon flaticon-new-window"></span>Course Landing</a></li>
            <li><a href="team.html"><span class="icon flaticon-instructor"></span>Popular Instructors</a></li>
        </ul>
        <div class="heading">Instructor</div>
        <ul class="pages-list">
            <li><a href="dashboard.html"><span class="icon flaticon-home"></span>Dashboard</a></li>
            <li><a href="manage-course.html"><span class="icon flaticon-test"></span>Manage Courses</a></li>
            <li><a href="earning.html"><span class="icon flaticon-scholarship"></span>Earnings</a></li>
            <li><a href="edit-course.html"><span class="icon flaticon-report"></span>Edit Course</a></li>
            <li><a href="instructor-profile.html"><span class="icon flaticon-file"></span>Instructor Profile</a></li>
        </ul>
        <div class="heading">Student</div>
        <ul class="pages-list">
            <li><a href="price.html"><span class="icon flaticon-money-bag"></span>Pricing</a></li>
            <li><a href="enrolled-courses.html"><span class="icon flaticon-test"></span>Enrolled Courses</a></li>
            <li><a href="certificate.html"><span class="icon flaticon-skills"></span>Certificate Center</a></li>
            <li><a href="test.html"><span class="icon flaticon-quiz"></span>Quiz</a></li>
            <li><a href="result.html"><span class="icon flaticon-document"></span>Quiz Result</a></li>
            <li><a href="student-profile.html"><span class="icon flaticon-student"></span>Student Profile</a></li>
        </ul>
        <div class="heading">Pages</div>
        <ul class="pages-list">
            <li><a href="blog.html"><span class="icon flaticon-social-media"></span>Blog</a></li>
            <li><a href="blog-detail.html"><span class="icon flaticon-article"></span>Blog Detail</a></li>
            <li><a href="not-found.html"><span class="icon flaticon-garbage"></span>Not Found</a></li>
            <li><a href="login.html"><span class="icon flaticon-contract"></span>Sign In</a></li>
            <li><a href="sign-up.html"><span class="icon flaticon-clipboard"></span>Sign Up</a></li>
            <li><a href="feedback.html"><span class="icon flaticon-thumb-up"></span>Feedback</a></li>
            <li><a href="checkout.html"><span class="icon flaticon-checkout"></span>Checkout</a></li>
            <li><a href="contact.html"><span class="icon flaticon-contact"></span>Contact Us</a></li>
            <li><a href="setting.html"><span class="icon flaticon-settings-1"></span>Settings</a></li>
            <li><a href="help.html"><span class="icon flaticon-information"></span>Help</a></li>
        </ul>
    </div>
    <!--Copyright Text-->
    <div class="copyright-text">Copyright &copy; 2020.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></div>
</section>

<!-- Color Palate / Color Switcher -->
<div class="color-palate">
    <div class="color-trigger">
        <i class="fa fa-gear"></i>
    </div>
    <div class="color-palate-head">
        <h6>Choose Your Color</h6>
    </div>
    <div class="various-color clearfix">
        <div class="colors-list">
            <span class="palate color-one active" data-theme-file="css/color-themes/theme-one.css"></span>
            <span class="palate color-two" data-theme-file="css/color-themes/theme-two.css"></span>
            <span class="palate color-three" data-theme-file="css/color-themes/theme-three.css"></span>
            <span class="palate color-four" data-theme-file="css/color-themes/theme-four.css"></span>
            <span class="palate color-five" data-theme-file="css/color-themes/theme-five.css"></span>
            <span class="palate color-six" data-theme-file="css/color-themes/theme-six.css"></span>
            <span class="palate color-seven" data-theme-file="css/color-themes/theme-seven.css"></span>
            <span class="palate color-eight" data-theme-file="css/color-themes/theme-eight.css"></span>
            <span class="palate color-nine" data-theme-file="css/color-themes/theme-nine.css"></span>
            <span class="palate color-ten" data-theme-file="css/color-themes/theme-ten.css"></span>
            <span class="palate color-eleven" data-theme-file="css/color-themes/theme-eleven.css"></span>
            <span class="palate color-twelve" data-theme-file="css/color-themes/theme-twelve.css"></span>
        </div>
    </div>

</div>


<script src="front/js/jquery.js"></script>
<script src="front/js/popper.min.js"></script>
<script src="front/js/bootstrap.min.js"></script>
<script src="front/js/jquery.fancybox.js"></script>
<script src="front/js/appear.js"></script>
<script src="front/js/isotope.js"></script>
<script src="front/js/owl.js"></script>
<script src="front/js/wow.js"></script>
<script src="front/js/jquery.countdown.js"></script>
<script src="front/js/jquery-ui.js"></script>
<script src="front/js/script.js"></script>
<script src="front/js/color-settings.js"></script>

</body>
</html>