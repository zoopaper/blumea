<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>用户列表</title>

    <script src="/assets/js/kkpager.min.js"></script>

</head>
<body style="margin: 0 auto;">
<%@ include file="../common/header.jsp" %>


<div id="container">

    <div id="sidebar"></div>

    <div id="content" style="margin-top: 60px;margin-right: 10px;">
        <div class="ui blue button">
            <span onclick="addUser();" title="新增用户"> <i class="add icon"></i></span>
        </div>
        <div class="ui red button">
            <span onclick="delUser();" title="删除用户"><i class="minus icon"></i></span>
        </div>
        <div class="ui action input">
            <input type="text" placeholder="用户名" id="userName" value="${userName}">
            <button class="ui button" onclick="userSearch()">Search</button>
        </div>

        <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th><input type="checkbox" id="selectAll"></th>
                <th>用户名</th>
                <th>账号</th>
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
                    <td>${user.userName}</td>
                    <td>${user.account}</td>
                    <td>${user.email}</td>
                    <td>${user.mobileTel}</td>
                    <td>${user.city}</td>
                    <td><a href="/adm/user/toModifyUser?id=${user.id}">修改</a></td>
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
        var param = "&userName=" + $("#userName").val();
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
                return this.hrefFormer + this.hrefLatter + "?page=" + n + param;
            }
        });
    });
</script>
<script type="text/javascript">

    function delUser() {
        var idArray = new Array();
        $("input[name='id']:checked").each(function () {
            idArray.push($(this).val());
        });

        if (idArray.length == 0) {
            alert("请选择要删除的记录!");
            return false;
        }

        if (confirm("您确定要删除选中的用户吗!")) {
            window.location.href = "/adm/user/delUser?id=" + idArray;
        } else {
            return false;
        }
    }

    function addUser() {
        window.location.href = "/adm/user/addUser";
    }

    function userSearch() {
        var userName = $("#userName").val();
        $("#userName").val(userName);
        window.location.href = "/adm/user/userList?userName=" + userName;
    }

    $('#selectAll').click(function () {
        $('input[name="id"]').attr("checked", this.checked);
    });
</script>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
