<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>修改用户</title>
    <%@ include file="../common/common.jsp" %>
</head>
<body>
<%@ include file="../common/header.jsp" %>

<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/system_sider.jsp" %>
        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs" style="padding-top: 8px;">
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        系统管理
                    </li>
                    <li>
                        用户管理
                    </li>
                    <li>
                        修改用户
                    </li>
                </ul>
            </div>
            <div class="page-content">
                <div class="col-xs-5">
                    <h4 class="ui dividing header">修改用户</h4>

                    <form action="/adm/user/doModifyUser" method="post">
                        <input type="hidden" id="id" name="id" value="${user.id}"/>

                        <div class="form-group">
                            <label>用户名</label>
                            <input name="userName" type="text" value="${user.userName}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>账号</label>
                            <input name="account" type="text" value="${user.account}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>邮箱</label>
                            <input type="email" name="email" value="${user.email}" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>手机</label>
                            <input type="text" name="mobileTel" id="mobileTel" value="${user.mobileTel}"
                                   class="form-control">
                        </div>

                        <div class="form-group">
                            <label>城市</label>
                            <input type="text" name="city" id="city" value="${user.city}" class="form-control">
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
