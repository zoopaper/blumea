<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>新增频道</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>

<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <h4 class="ui dividing header">新增频道</h4>

                <div class="col-xs-5">
                    <form class="ui form segment" action="/adm/channel/doAddChannel" method="post" name="">
                        <div class="form-group">
                            <label>频道名称</label>
                            <input name="name" type="text" id="name" class="form-control input-lg">
                        </div>
                        <div class="form-group">
                            <label>频道目录</label>
                            <input name="dir" type="text" class="form-control input-lg">
                        </div>
                        <input class="btn btn-primary btn-lg" type="submit" value="保 存">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

