<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<%--<html>--%>
<%--<head>--%>
<%--<link href="/ui/css/semantic.min.css" rel="stylesheet">--%>
<link href="/assets/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="/assets/css/font-awesome.min.css"/>
<link href="/assets/css/customer.css" rel="stylesheet">
<link href="/assets/css/kkpager_blue.css" rel="stylesheet">


<!-- basic styles -->


<!--[if IE 7]>
<link rel="stylesheet" href="/assets/css/font-awesome-ie7.min.css" />
<![endif]-->

<!-- page specific plugin styles -->

<!-- fonts -->

<%--<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />--%>

<!-- ace styles -->

<link rel="stylesheet" href="/assets/css/ace.min.css"/>
<link rel="stylesheet" href="/assets/css/ace-rtl.min.css"/>
<link rel="stylesheet" href="/assets/css/ace-skins.min.css"/>

<!--[if lte IE 8]>
<link rel="stylesheet" href="/assets/css/ace-ie.min.css" />
<![endif]-->

<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
<!-- ace settings handler -->
<script src="/assets/js/jquery-2.0.3.min.js"></script>
<script src="/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
<script src="/assets/js/html5shiv.js"></script>
<script src="/assets/js/respond.min.js"></script>
<![endif]-->
<%--</head>--%>
<%--<body>--%>
<%--<div style="width: auto; min-width: 900px;">--%>
<%--<div class="ui blue inverted menu">--%>
<%--<a class="item" id="home" onclick="javascript:selectStyle(this);">--%>
<%--<i class="home icon"></i> Home--%>
<%--</a>--%>
<%--<a class="item" href="/adm/user/userList">--%>
<%--<i class="users icon"></i> 用户管理--%>
<%--</a>--%>
<%--<a class="item">--%>
<%--<i class="comments icon"></i> 消息管理--%>
<%--</a>--%>
<%--<a class="item" href="/adm/auth">--%>
<%--<i class="user icon"></i> 权限管理--%>
<%--</a>--%>
<%--<a class="item" href="/adm/channel/channelList">--%>
<%--<i class="block layout icon"></i> 频道管理--%>
<%--</a>--%>
<%--<a class="item" href="/adm/subject/subjectList">--%>
<%--<i class="block layout icon"></i> 栏目管理--%>
<%--</a>--%>
<%--<a class="item">--%>
<%--<i class="block layout icon"></i> 系统管理--%>
<%--</a>--%>
<%--</div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>


<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    Ace Admin
                </small>
            </a>
        </div>

        <div class="navbar-header pull-right" role="navigation">

        </div>
    </div>
</div>
