<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>用户列表</title>
    <script src="/assets/js/kkpager.min.js"></script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <div class="ui-jqgrid-view">
                    <div class="ui-jqgrid-titlebar ui-widget-header ui-corner-top ui-helper-clearfix">

                        <div class="col-xs-2">
                            <button onclick="addUser();" type="button" class="btn btn-primary btn-sm">新增用户</button>
                            <button onclick="delUser();" type="button" class="btn btn-danger btn-sm">删除用户</button>
                            <%--<input type="text" class="form-control input-lg" placeholder="用户名" id="userName" value="${userName}">--%>
                        </div>
                        <div class="col-xs-2">
                            <input type="text" class="form-control" placeholder="" id="userName" value="${userName}">
                        </div>
                        <div class="col-xs-1">
                            <button class="btn btn-default btn-sm" onclick="userSearch()">Search</button>
                        </div>
                    </div>

                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>
                                <%--<input type="checkbox" id="selectAll">--%>
                                <label>
                                    <input type="checkbox" name="selectAll" value="${user.id}" class="ace">
                                    <span class="lbl"></span>
                                </label>
                            </th>
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
                                <td>
                                    <label>
                                        <input type="checkbox" name="id" value="${user.id}" class="ace">
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td>${user.userName}</td>
                                <td>${user.account}</td>
                                <td>${user.email}</td>
                                <td>${user.mobileTel}</td>
                                <td>${user.city}</td>
                                <td><a href="/adm/user/toModifyUser?id=${user.id}">
                                    <button class="btn btn-xs btn-info">
                                        <i class="icon-edit bigger-120"></i>
                                    </button>
                                </a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div id="kkpager" class="page_s" style="width: 490px;"></div>
                </div>
            </div>
        </div>
    </div>
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
