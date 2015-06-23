<%--
  Created by IntelliJ IDEA.
  User: kirs
  Date: 2015/6/23
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>频道列表</title>
</head>
<body style="margin: 0 auto;">
<%@ include file="../common/header.jsp" %>


<div id="container">

    <div id="sidebar"></div>

    <div id="content" style="margin-top: 60px;margin-right: 10px;">
        <div class="ui blue button">
            <span onclick="addChannel();" title="新增频道"> <i class="add icon"></i></span>
        </div>
        <table class="ui celled table">
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

                        <div class="ui green button"><a href="/adm/channel/toModifyChannel?id=${channel.id}" style="color: white;">修改</a>
                        </div>
                        <div class="ui red button"><a href="/adm/channel/delChannel?id=${channel.id}" style="color: white;">删除</a></div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
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