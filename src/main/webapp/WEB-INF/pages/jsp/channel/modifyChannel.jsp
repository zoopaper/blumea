<%--
  Created by IntelliJ IDEA.
  User: kirs
  Date: 2015/6/23
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>修改频道</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>

<div id="container">

    <div id="sidebar"></div>

    <div id="content" style="margin-top: 60px;width: 600px;height: 700px;">
        <h4 class="ui dividing header">修改频道</h4>

        <form class="ui form segment" action="/adm/channel/doModifyChannel" method="post">
            <input type="hidden" name="id" value="${channel.id}"/>

            <div class="field">
                <label>频道名称</label>
                <input name="name" type="text" value="${channel.name}">
            </div>
            <div class="field">
                <label>频道目录</label>
                <input name="dir" type="text" value="${channel.dir}">
            </div>
            <input class="ui blue submit button" type="submit" value="保 存">
        </form>
    </div>
</div>
</body>
</html>
