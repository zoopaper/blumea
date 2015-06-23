<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <link href="/ui/css/semantic.min.css" rel="stylesheet">
    <link href="/ui/css/customer.css" rel="stylesheet">
    <link href="/ui/css/kkpager_blue.css" rel="stylesheet">
    <script src="/ui/js/jquery-1.6.4.min.js"></script>
    <script src="/ui/js/semantic.min.js"></script>
    <script src="/ui/js/kkpager.min.js"></script>
</head>
<body>
<div style="width: auto; min-width: 900px;">
    <div class="ui blue inverted menu">
        <a class="item" id="home" onclick="javascript:selectStyle(this);">
            <i class="home icon"></i> Home
        </a>
        <a class="item" href="/adm/user/userList">
            <i class="users icon"></i> 用户管理
        </a>
        <a class="item">
            <i class="comments icon"></i> 消息管理
        </a>
        <a class="item">
            <i class="user icon"></i> 功能管理
        </a>
        <a class="item">
            <i class="user icon"></i> 角色管理
        </a>
        <a class="item" href="/adm/channel/channelList">
            <i class="block layout icon"></i> 频道管理
        </a>
        <a class="item">
            <i class="block layout icon"></i> 栏目管理
        </a>
        <a class="item">
            <i class="block layout icon"></i> 系统管理
        </a>
    </div>
</div>
<script type="text/javascript">

    function selectStyle(obj) {

//        alert(obj.id);
//        alert(obj.getAttribute('class'));
        var items = $("a.item");

    }
</script>
</body>
</html>