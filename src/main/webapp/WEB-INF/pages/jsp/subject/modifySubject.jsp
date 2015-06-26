<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>修改栏目</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <h4 class="ui dividing header">修改栏目</h4>

                <div class="col-xs-5">
                    <form class="ui form segment" action="/adm/subject/doModifySubject" method="post">
                        <input type="hidden" id="id" name="id" value="${subject.id}"/>

                        <div class="form-group">
                            <label>名称</label>
                            <input name="name" type="text" value="${subject.name}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>父栏目</label>
                            <input name="pid" type="text" value="${subject.pid}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>短名称</label>
                            <input name="shortName" type="text" value="${subject.shortName}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>频道</label>
                            <input name="channelId" type="text" value="${subject.channelId}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>标签</label>
                            <input name="tags" type="text" value="${subject.tags}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>状态</label>
                            <input name="status" type="text" value="${subject.status}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="description" type="text" value="${subject.description}" class="form-control">
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