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
    <title>新增栏目</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <h4 class="ui dividing header">新增栏目</h4>

                <div class="col-xs-5">
                    <form class="ui form segment" action="/adm/subject/doAddSubject" method="post">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="name" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>父栏目</label>
                            <input name="pid" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>短名称</label>
                            <input name="shortName" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>优先级</label>
                            <input name="priority" type="text" id="priority" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>频道</label>
                            <input name="channelId" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>标签</label>
                            <input name="tags" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>状态</label>
                            <input name="status" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="description" type="text" class="form-control">
                        </div>
                        <input class="btn btn-primary" type="submit" value="保 存">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>