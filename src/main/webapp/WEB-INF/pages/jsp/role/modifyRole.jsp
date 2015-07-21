<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>修改角色</title>
    <%@ include file="../common/common.jsp" %>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <h4 class="ui dividing header">修改角色</h4>

                <div class="col-xs-5">
                    <form class="ui form segment" action="/adm/role/doModifyRole" method="post">
                        <input type="hidden" name="id" value="${role.id}"/>

                        <div class="form-group">
                            <label>角色名称</label>
                            <input name="name" type="text" value="${role.name}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>选择功能</label>
                            <input name="funcId" type="text" value="${role.funcId}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>角色描述</label>
                            <input type="text" name="description" value="${role.description}" class="form-control">
                        </div>
                        <input class="btn btn-primary" type="submit" value="保 存">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
