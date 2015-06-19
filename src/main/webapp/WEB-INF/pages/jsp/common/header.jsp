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
<div style="margin: 0 auto;">
    <div class="ui one column relaxed grid">
        <div class="column">
            <div class="ui blue inverted menu">
                <a class="active item">
                    <i class="home icon"></i> Home
                </a>
                <a class="item" href="/adm/user/userList">
                    <i class="mail icon"></i> 用户管理
                </a>
                <a class="item">
                    <i class="mail icon"></i> 消息管理
                </a>
                <a class="item">
                    <i class="user icon"></i> 功能管理
                </a>
                <a class="item">
                    <i class="user icon"></i> 角色管理
                </a>
                <a class="item">
                    <i class="user icon"></i> 账号管理
                </a>
            </div>
        </div>
    </div>
</div>

</body>
</html>