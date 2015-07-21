<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>角色列表</title>
    <%@ include file="../common/common.jsp" %>
    <script src="/assets/js/kkpager.min.js"></script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <button onclick="addRole();" type="button" class="btn btn-primary btn-sm">新增角色</button>
                <button onclick="delRole();" type="button" class="btn btn-danger btn-sm">删除角色</button>
                <input type="text" placeholder="角色名称" id="name" value="${name}" name="name">
                <button class="btn btn-primary btn-xs" onclick="roleSearch()">搜索</button>

                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th><input type="checkbox" id="selectAll"></th>
                        <th>角色名称</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.items}" var="role">
                        <tr>
                            <td><input type="checkbox" name="id" value="${role.id}"></td>
                            <td>${role.name}</td>
                            <td>
                                <a href="/adm/role/toModifyRole?id=${role.id}">
                                    <button class="btn btn-xs btn-info">
                                        <i class="icon-edit bigger-120"></i>
                                    </button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div id="kkpager" class="page_s" style="width: 490px;"></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        //生成分页
        //有些参数是可选的，比如lang，若不传有默认值
        var param = "&name=" + $("#name").val();
        kkpager.generPageHtml({
            pno: '${page.pageIndex}',
            //总页码
            total: '${page.maxPage}',
            //总数据条数
            totalRecords: '${page.total}',
            //链接前部
            hrefFormer: '/adm/role/roleList',
            //链接尾部
            hrefLatter: '',
            getLink: function (n) {
                return this.hrefFormer + this.hrefLatter + "?page=" + n + param;
            }
        });
    });
</script>
<script type="text/javascript">

    function delRole() {
        var idArray = new Array();
        $("input[name='id']:checked").each(function () {
            idArray.push($(this).val());
        });

        if (idArray.length == 0) {
            alert("请选择要删除的记录!");
            return false;
        }

        if (confirm("您确定要删除选中的角色吗!")) {
            window.location.href = "/adm/role/delRole?id=" + idArray;
        } else {
            return false;
        }
    }

    function addRole() {
        window.location.href = "/adm/role/addRole";
    }

    function roleSearch() {
        var name = $("#name").val();
        $("#name").val(name);
        window.location.href = "/adm/role/roleList?name=" + name;
    }

    $('#selectAll').click(function () {
        $('input[name="id"]').attr("checked", this.checked);
    });
</script>
</body>
<%@ include file="../common/footer.jsp" %>
</html>
