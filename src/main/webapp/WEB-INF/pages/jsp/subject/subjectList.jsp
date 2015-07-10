<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>栏目列表</title>
    <script src="/assets/js/kkpager.min.js"></script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <button onclick="addSubject();" type="button" class="btn btn-primary btn-sm">新增栏目</button>
                <button onclick="delSubject();" type="button" class="btn btn-danger btn-sm">删除栏目</button>
                <input type="text" placeholder="栏目名称" id="name" value="${name}">
                <button class="btn btn-primary btn-xs" onclick="subjectSearch()">Search</button>

                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th><input type="checkbox" id="selectAll"></th>
                        <th>名称</th>
                        <th>英文名称</th>
                        <th>频道</th>
                        <th>状态</th>
                        <th>优先级</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.items}" var="subject">
                        <tr>
                            <td><input type="checkbox" name="id" value="${subject.id}"></td>
                            <td>${subject.name}</td>
                            <td>${subject.shortName}</td>
                            <td>${subject.channelId}</td>
                            <td>${subject.status}</td>
                            <td>${subject.priority}</td>
                            <td><a href="/adm/subject/toModifySubject?id=${subject.id}">
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
            hrefFormer: '/adm/subject/subjectList',
            //链接尾部
            hrefLatter: '',
            getLink: function (n) {
                return this.hrefFormer + this.hrefLatter + "?page=" + n + param;
            }
        });
    });
</script>
<script type="text/javascript">

    function delSubject() {
        var idArray = new Array();
        $("input[name='id']:checked").each(function () {
            idArray.push($(this).val());
        });

        if (idArray.length == 0) {
            alert("请选择要删除的记录!");
            return false;
        }

        if (confirm("您确定要删除选中的栏目吗!")) {
            window.location.href = "/adm/subject/delSubject?id=" + idArray;
        } else {
            return false;
        }
    }

    function addSubject() {
        window.location.href = "/adm/subject/addSubject";
    }

    function subjectSearch() {
        var name = $("#name").val();
        $("#name").val(name);
        window.location.href = "/adm/subject/subjectList?name=" + name;
    }

    $('#selectAll').click(function () {
        $('input[name="id"]').attr("checked", this.checked);
    });
</script>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
