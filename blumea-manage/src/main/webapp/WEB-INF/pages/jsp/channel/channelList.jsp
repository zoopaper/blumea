<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>频道列表</title>
    <%@ include file="../common/common.jsp" %>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/channel_sider.jsp" %>
        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs" style="padding-top: 8px;">
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        频道管理
                    </li>
                </ul>
            </div>
            <div class="page-content">
                <p>
                    <button onclick="addChannel();" type="button" class="btn btn-primary btn-sm">新 增</button>
                </p>
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>频道名称</th>
                        <th>频道目录</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${channelList}" var="channel">
                        <tr>
                            <td>${channel.name}</td>
                            <td>${channel.dir}</td>
                            <td>
                                <a href="/adm/channel/toModifyChannel?id=${channel.id}"
                                   class="btn btn-xs btn-primary"><i class="icon-pencil bigger-130"></i></a>
                                <a href="/adm/channel/delChannel?id=${channel.id}" class="btn btn-xs btn-danger"><i
                                        class="icon-trash bigger-120"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function delChannel(id) {
        if (confirm("您确定要删除选中的频道吗!")) {
            window.location.href = "/adm/channel/delChannel?id=" + id;
        } else {
            return false;
        }
    }
    function addChannel() {
        window.location.href = "/adm/channel/addChannel";
    }
</script>
<%@ include file="../common/footer.jsp" %>
</body>
</html>