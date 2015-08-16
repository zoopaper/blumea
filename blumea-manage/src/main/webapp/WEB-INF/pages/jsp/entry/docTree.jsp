<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>文档管理</title>
    <%@ include file="../common/common.jsp" %>
    <link href="/assets/css/ztree/zTreeStyle.css" rel="stylesheet">
    <link href="/assets/css/jquery-ui-1.10.3.full.min.css" rel="stylesheet">
    <link href="/assets/css/ui.jqgrid.css" rel="stylesheet">
    <script src="/assets/js/kkpager.min.js"></script>

    <script src="/assets/js/ztree/jquery.ztree.all-3.5.js"></script>
    <%--<script src="/js/subject/docTree.js"></script>--%>
    <%@ include file="../common/header.jsp" %>

    <style type="text/css">
        .zTreeChannel {
            height: 500px;
            position: absolute;
        }

        #treeChannel {
            min-height: 519px;
        }

        ul.ztree {
            margin-top: 0px;
            border: 1px solid #617775;
            background: #f9f9f9;;
            width: 190px;
            height: 360px;
            overflow-y: scroll;
            overflow-x: auto;
        }
    </style>
    <script type="text/javascript">
        <!--
        var pid;
        var setting = {
            async: {
                enable: true,
                url: "/adm/channel/channelTree",
                autoParam: ["id", "isChannel", "name"],
                otherParam: {"otherParam": "zTreeAsyncTest"}
            },
            callback: {
                onClick: onClick
            }
        };
        function filter(treeId, parentNode, childNodes) {
            if (!childNodes) return null;
            for (var i = 0, l = childNodes.length; i < l; i++) {
                s
                childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
            }
            return childNodes;
        }

        $(document).ready(function () {
            $.fn.zTree.init($("#treeChannel"), setting);
        });

        function onClick(event, treeId, treeNode, clickFlag) {
            pid = treeNode.id;
            var isChannel = treeNode.isChannel;
            var channelId = treeNode.channelId;
            alert(channelId);

            $("#pid").val(pid);
            $("#isChannel").val(isChannel);
            $("#channelId").val(isChannel);
            window.location = "/adm/entry/entryList?pid=" + pid + "&isChannel=" + isChannel + "&channelId=" + channelId;
        }
        //-->
    </script>
</head>

<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <div class="" id="sidebar">
            <div class="zTreeChannel">
                <ul id="treeChannel" class="ztree">
                </ul>
            </div>
        </div>

        <div class="main-content">
            <input type="hidden" id="pid" name="pid"/>
            <input type="hidden" id="isChannel" name="isChannel"/>

            <div class="breadcrumbs" id="breadcrumbs" style="padding-top: 8px;">
                <ul class="breadcrumb">
                    <li onclick="addEntry();">
                        <button class="btn btn-sm">新增</button>
                    </li>
                </ul>
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="table-responsive">
                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th class="center">
                                        <label>
                                            <input type="checkbox" class="ace"/>
                                            <span class="lbl"></span>
                                        </label>
                                    </th>
                                    <th>标题</th>
                                    <th>作者</th>
                                    <th>
                                        <i class="icon-time bigger-110 hidden-480"></i>创建时间
                                    </th>

                                    <th>
                                        <i class="icon-time bigger-110 hidden-480"></i>
                                        更新时间
                                    </th>
                                    <th class="hidden-480">Status</th>
                                    <th></th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach items="${page.items}" var="entry">
                                    <tr>
                                        <td class="center">
                                            <label>
                                                <input type="checkbox" class="ace"/>
                                                <span class="lbl"></span>
                                            </label>
                                        </td>

                                        <td>
                                                ${entry.title}
                                        </td>
                                        <td>${entry.author}</td>
                                        <td>${entry.ctime}</td>
                                        <td>Jan 21</td>

                                        <td class="hidden-480">
                                            <span class="label label-sm label-success">Registered</span>
                                        </td>

                                        <td>
                                            <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                                <button class="btn btn-xs btn-info">
                                                    <i class="icon-edit bigger-120"></i>
                                                </button>

                                                <button class="btn btn-xs btn-danger">
                                                    <i class="icon-trash bigger-120"></i>
                                                </button>
                                            </div>
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
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        //生成分页
        //有些参数是可选的，比如lang，若不传有默认值
        var param = "&title=" + $("#title").val();
        kkpager.generPageHtml({
            pno: '${page.pageIndex}',
            //总页码
            total: '${page.maxPage}',
            //总数据条数
            totalRecords: '${page.total}',
            //链接前部
            hrefFormer: '/adm/entry/entryList',
            //链接尾部
            hrefLatter: '',
            getLink: function (n) {
                return this.hrefFormer + this.hrefLatter + "?page=" + n + param;
            }
        });
    });


    function delEntry() {
        var idArray = new Array();
        $("input[name='id']:checked").each(function () {
            idArray.push($(this).val());
        });

        if (idArray.length == 0) {
            alert("请选择要删除的记录!");
            return false;
        }

        if (confirm("您确定要删除选中的新闻吗!")) {
            window.location.href = "/adm/entry/delEntry?id=" + idArray;
        } else {
            return false;
        }
    }

    function addEntry() {
        var pid = $("#pid").val();
        var isChannel = $("#isChannel").val();
        window.location.href = "/adm/entry/addEntry?pid=";
    }

    function entrySearch() {
        var title = $("#title").val();
        $("#title").val(title);
        window.location.href = "/adm/entry/entryList?title=" + title;
    }
</script>
<%@ include file="../common/footer.jsp" %>
</body>
</html>