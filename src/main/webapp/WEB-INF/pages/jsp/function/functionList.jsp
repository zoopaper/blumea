<%--
  Created by IntelliJ IDEA.
  User: kirs
  Date: 2015/6/25
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>功能列表</title>
</head>
<body style="margin: 0 auto;">
<%@ include file="../common/header.jsp" %>
<div id="container">

    <div id="sidebar"></div>

    <div id="content" style="margin-top: 60px;margin-right: 10px;">
        <div class="ui blue button">
            <span onclick="addFunc();" title="新增功能"> <i class="add icon"></i></span>
        </div>
        <div class="ui red button">
            <span onclick="delFunc();" title="删除功能"><i class="minus icon"></i></span>
        </div>
        <div class="ui action input">
            <input type="text" placeholder="功能名称" id="name" value="${name}" name="name">
            <button class="ui button" onclick="funcSearch()">Search</button>
        </div>

        <table class="ui celled table">
            <thead>
            <tr>
                <th><input type="checkbox" id="selectAll"></th>
                <th>功能名称</th>
                <th>功能URl</th>
                <th>功能参数</th>
                <th>是否功能组</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.items}" var="func">
                <tr>
                    <td><input type="checkbox" name="id" value="${func.id}"></td>
                    <td>${func.name}</td>
                    <td>${func.action}</td>
                    <td>${func.param}</td>
                    <td>
                        <c:if test="${func.isGroup=='0'}">
                            否
                        </c:if>
                        <c:if test="${func.isGroup=='1'}">
                            是
                        </c:if>
                    </td>
                    <td><a href="/adm/function/toModifyFunction?id=${func.id}">修改</a></td>
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
            hrefFormer: '/adm/function/functionList',
            //链接尾部
            hrefLatter: '',
            getLink: function (n) {
                return this.hrefFormer + this.hrefLatter + "?page=" + n + param;
            }
        });
    });
</script>
<script type="text/javascript">

    function delFunc() {
        var idArray = new Array();
        $("input[name='id']:checked").each(function () {
            idArray.push($(this).val());
        });

        if (idArray.length == 0) {
            alert("请选择要删除的记录!");
            return false;
        }

        if (confirm("您确定要删除选中的功能吗!")) {
            window.location.href = "/adm/function/delFunction?id=" + idArray;
        } else {
            return false;
        }
    }

    function addFunc() {
        window.location.href = "/adm/function/addFunction";
    }

    function funcSearch() {
        var name = $("#name").val();
        $("#name").val(name);
        window.location.href = "/adm/function/functionList?name=" + name;
    }

    $('#selectAll').click(function () {
        $('input[name="id"]').attr("checked", this.checked);
    });
</script>
</body>
</html>
