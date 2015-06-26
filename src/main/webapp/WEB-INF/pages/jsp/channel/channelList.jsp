<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>频道列表</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>


<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">

                <button onclick="addChannel();" type="button" class="btn btn-primary btn-sm">新增频道</button>

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
                                   style="color: white;" class="btn btn-primary">修改</a>
                                <a href="/adm/channel/delChannel?id=${channel.id}"
                                       class="btn btn-danger" >删除</a>
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
        if (confirm("您确定要删除选中的用户吗!")) {
            window.location.href = "/adm/channel/delChannel?id=" + id;
        } else {
            return false;
        }
    }
    function addChannel() {
        window.location.href = "/adm/channel/addChannel";
    }
</script>
</body>
</html>