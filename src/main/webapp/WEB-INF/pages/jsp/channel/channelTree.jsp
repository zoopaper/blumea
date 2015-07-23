<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>频道列表</title>
    <%@ include file="../common/common.jsp" %>
    <link href="/assets/css/ztree/zTreeStyle.css" rel="stylesheet">
    <link href="/assets/css/jquery-ui-1.10.3.full.min.css" rel="stylesheet">
    <link href="/assets/css/datepicker.css" rel="stylesheet">
    <link href="/assets/css/ui.jqgrid.css" rel="stylesheet">


    <script src="/assets/js/jquery-ui-1.10.3.full.min.js"></script>
    <script src="/assets/js/date-time/bootstrap-datepicker.min.js"></script>
    <script src="/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
    <script src="/assets/js/jqGrid/i18n/grid.locale-en.js"></script>
    <script src="/assets/js/ztree/jquery.ztree.all-3.5.js"></script>
    <script src="/js/subject/subjectList.js"></script>
    <%@ include file="../common/header.jsp" %>

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

            $("#grid-table").jqGrid('setGridParam', {
                url: "/adm/subject/subjectGrid",
                postData: {'pid': pid},
                page: 1
            }).trigger("reloadGrid");
            alert(pid);
            $("#pid").val(pid);
        }
        //-->
    </script>
</head>

<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <input type="hidden" id="pid" name="pid"/>

        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <div class="col-md-1">
                    <div class="zTreeChannel">
                        <ul id="treeChannel" class="ztree">
                        </ul>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-9 col-md-offset-1">
                        <table id="grid-table"></table>

                        <div id="grid-pager"></div>

                        <script type="text/javascript">
                            var $path_base = "/";
                        </script>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>
</body>
</html>