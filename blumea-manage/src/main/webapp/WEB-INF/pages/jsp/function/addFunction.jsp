<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>新增功能</title>
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
                        功能管理
                    </li>
                    <li>
                        新增功能
                    </li>
                </ul>
            </div>
            <div class="page-content">
                <h4 class="ui dividing header">新增功能</h4>

                <div class="col-xs-5">
                    <form  action="/adm/function/doAddFunction" method="post">
                        <div class="form-group">
                            <label>功能名称</label>
                            <input name="name" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>功能URL</label>
                            <input name="action" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>功能参数</label>
                            <input type="text" name="param" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>是否功能组</label>
                            <select id="isGroup" name="isGroup" class="form-control">
                                <option value="1">是</option>
                                <option value="0" selected>否</option>
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