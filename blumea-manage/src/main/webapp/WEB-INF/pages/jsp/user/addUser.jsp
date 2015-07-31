<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>新增用户</title>
    <%@ include file="../common/common.jsp" %>
</head>
<body>
<%@ include file="../common/header.jsp" %>

<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <h4 class="ui dividing header">新增用户</h4>
                <div class="col-xs-5">
                <form action="/adm/user/doAddUser" method="post" class="">
                    <div class="form-group">
                        <label>用户名</label>
                        <input name="userName" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>账号</label>
                        <input name="account" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>密码</label>
                        <input type="password" name="password" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>邮箱</label>
                        <input type="email" name="email" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>手机</label>
                        <input type="text" name="mobileTel" id="mobileTel" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>城市</label>
                        <input type="text" name="city" id="city" class="form-control">
                    </div>

                    <input class="btn btn-primary btn-lg" type="submit" value="保 存">
                </form>

                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
