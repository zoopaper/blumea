<%--
  Created by IntelliJ IDEA.
  User: kirs
  Date: 2015/6/24
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>栏目列表</title>
</head>
<body style="margin: 0 auto;">
<%@ include file="../common/header.jsp" %>


<div id="container">

    <div id="sidebar"></div>

    <div id="content" style="margin-top: 60px;margin-right: 10px;">
        <div class="ui blue button">
            <span onclick="addUser();" title="新增栏目"> <i class="add icon"></i></span>
        </div>
        <div class="ui red button">
            <span onclick="delUser();" title="删除栏目"><i class="minus icon"></i></span>
        </div>
        <div class="ui action input">
            <input type="text" placeholder="栏目名称" id="name" value="${name}">
            <button class="ui button" onclick="subjectSearch()">Search</button>
        </div>

        <table class="ui celled table">
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
                    <td>${subject.shrotName}</td>
                    <td>${subject.channelId}</td>
                    <td>${subject.status}</td>
                    <td>${subject.priority}</td>
                    <td><a href="/adm/subject/toModifySubject?id=${subject.id}">修改</a></td>
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
        window.location.href = "/adm/subject/addSubject";
    }

    function userSearch() {
        var name = $("#name").val();
        $("#name").val(name);
        window.location.href = "/adm/subject/subjectList?name=" + name;
    }

    $('#selectAll').click(function () {
        $('input[name="id"]').attr("checked", this.checked);
    });
</script>
</body>
</html>
