<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>用户列表</title>
</head>
<body style="margin: 0 auto;">
<%@ include file="../common/header.jsp" %>


<div id="container">

    <div id="sidebar"></div>

    <div id="content" style="margin-top: 60px;">
        <div class="mini ui basic button">
            <i class="plus icon"></i>
            <a href="/adm/user/addUser">添加</a>
        </div>

        <div class="mini ui basic button">
            <i class="minus icon"></i>
            删除
        </div>
        <table class="ui celled table">
            <thead>
            <tr>
                <th><input type="checkbox" name="fun"></th>
                <th>账号</th>
                <th>用户名</th>
                <th>Eamil</th>
                <th>手机</th>
                <th>所在城市</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.items}" var="user">
                <tr>
                    <td><input type="checkbox" name="id" value="${user.id}"></td>
                    <td>${user.account}</td>
                    <td>${user.userName}</td>
                    <td>${user.email}</td>
                    <td>${user.mobileTel}</td>
                    <td>${user.city}</td>
                    <td><a href="">修改</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div id="kkpager" class="page_s" style="width: 490px;"></div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        //生成分页
        //有些参数是可选的，比如lang，若不传有默认值
        kkpager.generPageHtml({
            pno: '${page.pageIndex}',
            //总页码
            total: '${page.maxPage}',
            //总数据条数
            totalRecords: '${page.total}',
            //链接前部
            hrefFormer: '/adm/user/userList',
            //链接尾部
            hrefLatter: '',
            getLink: function (n) {
                return this.hrefFormer + this.hrefLatter + "?page=" + n;
            }
        });
    });
</script>
</body>
</html>
