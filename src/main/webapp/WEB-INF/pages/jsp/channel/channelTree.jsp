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
            $("#pid").val(pid)


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

    </div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>