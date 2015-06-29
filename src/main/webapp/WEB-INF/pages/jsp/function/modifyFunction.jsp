<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>修改功能</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <h4 class="ui dividing header">修改功能</h4>

                <div class="col-xs-5">
                    <form class="ui form segment" action="/adm/function/doModifyFunction" method="post">
                        <input type="hidden" name="id" value="${function.id}"/>

                        <div class="form-group">
                            <label>功能名称</label>
                            <input name="name" type="text" value="${function.name}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>功能URL</label>
                            <input name="action" type="text" value="${function.action}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>功能参数</label>
                            <input type="text" name="param" value="${function.param}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>是否功能组</label>
                            <select id="isGroup" name="isGroup" class="form-control">
                                <option value="1" <c:if test="${function.isGroup=='1'}"> selected</c:if>>是</option>
                                <option value="0" <c:if test="${function.isGroup=='0'}"> selected</c:if>>否</option>
                            </select>
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
