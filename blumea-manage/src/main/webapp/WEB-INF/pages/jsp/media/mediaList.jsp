<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>媒体列表</title>
    <%@ include file="../common/common.jsp" %>
    <script src="/assets/js/kkpager.min.js"></script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/other_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <p class="bg-info">

                <form class="form-inline">
                    <div class="form-group">
                        <button onclick="addMedia();" type="button" class="btn btn-primary btn-sm">新 增</button>
                    </div>
                    <div class="form-group">
                        <button onclick="delMedia();" type="button" class="btn btn-danger btn-sm">删 除</button>
                    </div>
                    <div class="checkbox">
                        <input type="text" placeholder="媒体名称" id="name" value="${name}" name="name"
                               class="form-control">
                    </div>
                    <button class="btn btn-default btn-sm" onclick="mediaSearch()">Search</button>
                </form>
                </p>

                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th><input type="checkbox" id="selectAll"></th>
                        <th>名称</th>
                        <th>站点URL</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.items}" var="media">
                        <tr>
                            <td><input type="checkbox" name="id" value="${media.id}"></td>
                            <td>${media.name}</td>
                            <td><a target="_blank" href="${media.siteUrl}">${media.siteUrl}</a></td>
                            <td>
                                <a href="/adm/media/toModifyMedia?id=${media.id}">
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
            hrefFormer: '/adm/media/mediaList',
            //链接尾部
            hrefLatter: '',
            getLink: function (n) {
                return this.hrefFormer + this.hrefLatter + "?page=" + n + param;
            }
        });
    });
</script>
<script type="text/javascript">

    function delMedia() {
        var idArray = new Array();
        $("input[name='id']:checked").each(function () {
            idArray.push($(this).val());
        });

        if (idArray.length == 0) {
            alert("请选择要删除的记录!");
            return false;
        }

        if (confirm("您确定要删除选中的媒体吗!")) {
            window.location.href = "/adm/media/delMedia?id=" + idArray;
        } else {
            return false;
        }
    }

    function addMedia() {
        window.location.href = "/adm/media/addMedia";
    }

    function mediaSearch() {
        var name = $("#name").val();
        $("#name").val(name);
        window.location.href = "/adm/media/mediaList?name=" + name;
    }

    $('#selectAll').click(function () {
        $('input[name="id"]').attr("checked", this.checked);
    });
</script>
</body>
<%@ include file="../common/footer.jsp" %>
</html>
