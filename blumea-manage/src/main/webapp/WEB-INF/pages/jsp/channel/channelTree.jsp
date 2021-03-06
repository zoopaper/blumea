<%@ taglib prefix="t" uri="http://www.eleword.net/blumea" %>
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

    <t:css src="http://www.adsran.com/css/jqueryUI_Overcast/jquery-ui-1.8.20.custom.css"/>
    <t:js src="http://www.adsran.com/js/jquery-ui-1.8.20.custom.min.js"/>
    <script src="/assets/js/jquery-ui-1.10.3.full.min.js"></script>
    <script src="/assets/js/date-time/bootstrap-datepicker.min.js"></script>
    <script src="/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
    <script src="/assets/js/jqGrid/i18n/grid.locale-en.js"></script>
    <script src="/assets/js/ztree/jquery.ztree.all-3.5.js"></script>
    <script src="/js/subject/subjectList.js"></script>
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
            width: 170px;
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
                childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
            }
            return childNodes;
        }

        $(document).ready(function () {
            $.fn.zTree.init($("#treeChannel"), setting);
        });

        //单击节点
        function onClick(event, treeId, treeNode, clickFlag) {
            pid = treeNode.id;
            var name = treeNode.name;

            $("#pid").val(pid);
            $("#pname").val(name);

            $("#grid-table").jqGrid('setGridParam', {
                url: "/adm/subject/subjectGrid",
                postData: {'pid': pid},
                page: 1
            }).trigger("reloadGrid");
            $("#pid").val(pid);
        }
        //-->
    </script>
</head>

<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <input type="hidden" id="pid" name="pid"/>
        <input type="hidden" id="pname" name="pname"/>
        <%@ include file="../common/channel_sider.jsp" %>
        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs" style="padding-top: 8px;">
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        频道管理
                    </li>
                    <li>
                        栏目管理
                    </li>
                </ul>
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-md-2">
                        <div class="zTreeChannel">
                            <ul id="treeChannel" class="ztree">
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-10">
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