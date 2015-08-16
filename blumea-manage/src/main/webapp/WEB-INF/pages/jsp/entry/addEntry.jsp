<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>文档管理-新增文档</title>
    <link rel="stylesheet" href="/assets/css/kindeditor/default.css"/>
    <script charset="utf-8" src="/assets/js/kindeditor/kindeditor-min.js"></script>
    <script charset="utf-8" src="/assets/js/kindeditor/zh_CN.js"></script>
    <%@ include file="../common/common.jsp" %>
    <link href="/assets/css/ztree/zTreeStyle.css" rel="stylesheet">
    <link href="/assets/css/jquery-ui-1.10.3.full.min.css" rel="stylesheet">
    <link href="/assets/css/ui.jqgrid.css" rel="stylesheet">
    <script src="/assets/js/kkpager.min.js"></script>

    <script src="/assets/js/ztree/jquery.ztree.all-3.5.js"></script>
    <script src="/js/subject/docTree.js"></script>
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
            $("#pid").val(pid);
            $("#isChannel").val(isChannel);
            window.location = "/adm/entry/entryList?pid=" + pid + "&isChannel=" + isChannel;
        }
        //-->

        function validate() {

        }
        function formSuccess() {
            alert('Success!');
        }

        function formFailure() {
            alert('Failure!');
        }
        jQuery(document).ready(function () {
            // binds form submission and fields to the validation engine
            jQuery("#form1").validationEngine({
                onFormSuccess: formSuccess,
                onFormFailure: formFailure
            });
        });

        var editor;
        KindEditor.ready(function (K) {
            editor = K.create('textarea[name="content"]', {
                resizeType: 1,
                allowPreviewEmoticons: false,
                allowImageUpload: true,
                afterBlur: function () {
                    this.sync();
                },
                items: ['source', 'code', 'justifyleft', 'justifycenter',
                    'justifyright', 'insertorderedlist', 'insertunorderedlist',
                    'clearhtml', 'quickformat', 'formatblock', 'fontname',
                    'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                    'italic', 'underline', 'lineheight', 'removeformat', '|',
                    'image', 'multiimage', 'insertfile', 'table', 'hr',
                    'emoticons', 'baidumap', 'link', 'unlink', 'fullscreen']
            });
        });
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
                    <li>
                        <h4>新增新闻</h4>
                    </li>
                </ul>
            </div>
            <div class="page-content">
                <%--<h4 class="ui dividing header">新增新闻</h4>--%>
                <div class="col-xs-5">
                    <form action="/adm/entry/doAddEntry" method="post" id="form1"
                          onsubmit="return jQuery(this).validationEngine('validate');" class="form-horizontal">
                        <div class="form-group" style="text-align: center;width: 300px;">
                            <span style="color:red;">${errTip}</span>
                        </div>
                        <div class="form-group">
                            <label>频道</label><br>
                            <select name="channelId" style="width: 400px;">
                                <c:forEach items="${channelList}" var="channel">
                                    <option value="${channel.id}">${channel.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>标题</label><br>
                            <input name="title" type="text" id="title" class="validate[required] text-input"
                                   style="width: 400px;">
                        </div>
                        <div class="form-group">
                            <label>副标题</label><br>
                            <input name="subhead" type="text" style="width: 400px;">
                        </div>
                        <div class="form-group">
                            <label>来源</label><br>
                            <div class="">
                                <select id="media" name="media" style="width: 210px;">
                                    <c:forEach items="${mediaList}" var="media">
                                        <option value="${media.id}">${media.name}</option>
                                    </c:forEach>
                                </select>
                                链接:<input name="url" type="text"
                                          style="width: 151px;">
                            </div>
                        </div>

                        <div class="form-group">
                            <label>作者</label><br>
                            <input name="author" type="text" style="width: 400px;">
                        </div>

                        <div class="form-group">
                            <label>责任编辑</label><br>
                            <input name="dutyEditor" type="text" style="width: 400px;">
                        </div>

                        <div class="form-group">
                            <label>关键字</label><br>
                            <input name="keyword" type="text" class="validate[required] text-input"
                                   style="width: 400px;">
                        </div>

                        <div class="form-group">
                            <label>标签</label><br>
                            <input name="tag" type="text" style="width: 400px;">
                        </div>

                        <div class="form-group">
                            <label>摘要</label><br>
                            <textarea name="summary"
                                      style="width:900px;height:100px;"></textarea>
                        </div>

                        <div class="form-group">
                            <label>正文</label>
                            <textarea name="content" id="content"
                                      style="width:900px;height:400px;visibility:hidden;"></textarea>
                        </div>

                        <div class="form-group">
                            <input class="btn btn-primary btn-sm" type="submit" value="保 存" id="submit1"
                                   onclick="jQuery('#form1').submit();">

                        </div>
                    </form>
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