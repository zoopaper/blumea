<%--
  Created by IntelliJ IDEA.
  User: kirs
  Date: 2015/6/24
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>修改栏目</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>

<div id="container">

    <div id="sidebar"></div>

    <div id="content" style="margin-top: 60px;width: 600px;height: 700px;">
        <h4 class="ui dividing header">修改栏目</h4>

        <form class="ui form segment" action="/adm/subject/doModifySubject" method="post">
            <input type="hidden" id="id" name="id" value="${subject.id}"/>
            <div class="field">
                <label>名称</label>
                <input name="name" type="text" value="${subject.name}">
            </div>
            <div class="field">
                <label>父栏目</label>
                <input name="pid" type="text" value="${subject.pid}">
            </div>
            <div class="field">
                <label>短名称</label>
                <input name="shortName" type="text" value="${subject.shortName}">
            </div>
            <div class="field">
                <label>频道</label>
                <input name="channelId" type="text" value="${subject.channelId}">
            </div>
            <div class="field">
                <label>标签</label>
                <input name="tags" type="text" value="${subject.tags}">
            </div>
            <div class="field">
                <label>状态</label>
                <input name="status" type="text" value="${subject.status}">
            </div>
            <div class="field">
                <label>描述</label>
                <input name="description" type="text" value="${subject.description}">
            </div>
            <input class="ui blue submit button" type="submit" value="保 存">
        </form>
    </div>
</div>
</body>
</html>