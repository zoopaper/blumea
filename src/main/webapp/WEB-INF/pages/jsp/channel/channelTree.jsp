<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>频道列表</title>
    <%@ include file="../common/header.jsp" %>
    <link href="/assets/css/ztree/zTreeStyle.css" rel="stylesheet">

    <style type="text/css">

        .zTreeChannel {
            width: 300px;
            height: 500px;
            position: absolute;

        }

        #treeChannel {
            min-height: 600px;
        }

        ul.ztree {
            margin-top: 10px;
            border: 1px solid #617775;
            background: #f9f9f9;;
            width: 220px;
            height: 360px;
            overflow-y: scroll;
            overflow-x: auto;
        }
    </style>

    <script src="/assets/js/ztree/jquery.ztree.all-3.5.js"></script>
    <script type="text/javascript">
        <!--
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
                childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
            }
            return childNodes;
        }

        $(document).ready(function () {
            $.fn.zTree.init($("#treeChannel"), setting);
        });

        //单击节点
        function onClick(event, treeId, treeNode, clickFlag) {
            var pid = treeNode.id;

            $("#pid").val(pid);
            window.location="/adm/subject/subjectTreeList?pid="+pid;
        }
        //-->
    </script>
</head>
<body>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="col-md-1">
            <div class="zTreeChannel">
                <ul id="treeChannel" class="ztree">
                </ul>
            </div>
        </div>

        <div class="col-md-7 col-md-offset-1">

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
                        <td>${subject.channelName}</td>
                        <td>
                            <c:choose>
                                <c:when test="${subject.status=='1'}">
                                    有效
                                </c:when>
                                <c:when test="${subject.status=='0'}">
                                    无效
                                </c:when>
                                <c:otherwise>无效</c:otherwise>
                            </c:choose>
                        </td>
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
<%@ include file="../common/footer.jsp" %>
</body>
</html>