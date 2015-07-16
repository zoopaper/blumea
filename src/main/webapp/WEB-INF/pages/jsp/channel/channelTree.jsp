<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>频道列表</title>
    <%@ include file="../common/header.jsp" %>
    <link href="/assets/css/ztree/zTreeStyle.css" rel="stylesheet">
    <script src="/assets/js/ztree/jquery.ztree.all-3.5.js"></script>
    <script type="text/javascript">
        <!--
        var setting = {
            async: {
                enable: true,
                url:"/adm/channel/channelTree",
                autoParam:["id", "name=n", "level=lv"],
                otherParam:{"otherParam":"zTreeAsyncTest"}
            }
        };

        function filter(treeId, parentNode, childNodes) {
            if (!childNodes) return null;
            for (var i=0, l=childNodes.length; i<l; i++) {
                childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
            }
            return childNodes;
        }

        $(document).ready(function(){
            $.fn.zTree.init($("#treeChannel"), setting);
        });
        //-->
    </script>
</head>
<body>
<div class="main-container" id="main-container">

    <div class="zTreeChannel" style="width: 250px;">
        <ul id="treeChannel" class="ztree">
        </ul>
    </div>

</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>