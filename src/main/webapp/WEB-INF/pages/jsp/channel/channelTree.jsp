<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>频道列表</title>
    <%@ include file="../common/header.jsp" %>
    <link href="/assets/css/ztree/zTreeStyle.css" rel="stylesheet">
    <script src="/assets/js/ztree/jquery.ztree.all-3.5.js"></script>
    <script type="text/javascript">
        var districtTools;
        var districtSetting = {
            check: {
                enable: true
//                chkboxType: {"Y": "ps", "N": "ps"}
            },
            view: {
                dblClickExpand: false
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                onClick: onClick
            }
        };

        function beforeClickDistrict(treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("treeChannel");
            zTree.checkNode(treeNode, !treeNode.checked, null, true);
            return false;
        }

        function onCheckDistrict() {
            var zTree = $.fn.zTree.getZTreeObj("treeChannel"),
                    nodes = zTree.getCheckedNodes(true),
                    v = "",
                    k = "";
            for (var i = 0, l = nodes.length; i < l; i++) {
                if (nodes[i].getCheckStatus().half == false) {
                    if (k == "") {
                        k += nodes[i].id;
                    } else {
                        k += "," + nodes[i].id;
                    }
                    v += nodes[i].name + ",";
                }
            }
            if (v.length > 0) v = v.substring(0, v.length - 1);
            var districtList = $("#treeChannel");
            districtList.attr("value", k);
        }

        $.ajax({
            url: "/adm/channel/channelTree",
            type: "post",
            dataType: "json",
            data: {channel:${channel}},
            success: function (response) {
                var root = {id: '0', name: '我的频道', isParent: 'true'};
                response.push(root);
                $("#treeChannel").empty();
                districtSetting.check.enable = true;
                districtTools = $.fn.zTree.init($("#treeChannel"), districtSetting, response);
            }
        });

        //单击节点
        function onClick(event, treeId, treeNode, clickFlag) {
            var pid = treeNode.id;
            $("#pid").val(pid)
            distTreeList(pid)
        }
    </script>
</head>
<body>
<div class="main-container" id="main-container">

    <div class="zTreeChannel" style="width: 250px;">
        <ul id="treeChannel" class="ztree">
        </ul>
    </div>
    <%--<div class="main-container-inner">--%>
        <%--<%@ include file="../common/auth_sider.jsp" %>--%>
        <%--<div class="main-content" style="margin-top: 10px;">--%>
            <%--<div class="page-content">--%>
                <%--<button onclick="addChannel();" type="button" class="btn btn-primary btn-sm">新增频道</button>--%>
                <%--<table class="table table-striped table-bordered table-hover">--%>
                    <%--<thead>--%>
                    <%--<tr>--%>
                        <%--<th>频道名称</th>--%>
                        <%--<th>频道目录</th>--%>
                        <%--<th>操作</th>--%>
                    <%--</tr>--%>
                    <%--</thead>--%>
                    <%--<tbody>--%>
                    <%--<c:forEach items="${channelList}" var="channel">--%>
                        <%--<tr>--%>
                            <%--<td>${channel.name}</td>--%>
                            <%--<td>${channel.dir}</td>--%>
                            <%--<td>--%>
                                <%--<a href="/adm/channel/toModifyChannel?id=${channel.id}"--%>
                                   <%--class="btn btn-xs btn-primary"><i class="icon-pencil bigger-130"></i></a>--%>
                                <%--<a href="/adm/channel/delChannel?id=${channel.id}" class="btn btn-xs btn-danger"><i--%>
                                        <%--class="icon-trash bigger-120"></i></a>--%>
                            <%--</td>--%>
                        <%--</tr>--%>
                    <%--</c:forEach>--%>
                    <%--</tbody>--%>
                <%--</table>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
</div>

<script type="text/javascript">
    function delChannel(id) {
        if (confirm("您确定要删除选中的频道吗!")) {
            window.location.href = "/adm/channel/delChannel?id=" + id;
        } else {
            return false;
        }
    }
    function addChannel() {
        window.location.href = "/adm/channel/addChannel";
    }
</script>
<%@ include file="../common/footer.jsp" %>
</body>
</html>