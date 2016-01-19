<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <title>mas</title>
<#include "../common/assets.ftl">
    <link rel="stylesheet" type="text/css" href="/backend/ms/plugins/highlightJS/styles/github.css">
</head>

<body>
<#include "../common/header.ftl">

<div id="container">
<#include "../common/sidebar.ftl">
    <div id="content">
        <div class="container">
            <div class="crumbs">
                <ul id="breadcrumbs" class="breadcrumb">
                    <li>
                        <i class="icon-home"></i>
                        <a href="index.html">主页</a>
                    </li>
                    <li class="current">
                    </li>
                </ul>

                <ul class="crumb-buttons">
                    <li><a href="charts.html" title=""><i class="icon-signal"></i><span>Statistics</span></a></li>
                    <li class="dropdown"><a href="#" title="" data-toggle="dropdown"><i class="icon-tasks"></i><span>Users <strong>(+3)</strong></span><i class="icon-angle-down left-padding"></i></a>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="form_components.html" title=""><i class="icon-plus"></i>Add new User</a></li>
                            <li><a href="tables_dynamic.html" title=""><i class="icon-reorder"></i>Overview</a></li>
                        </ul>
                    </li>
                    <li class="range">
                        <a href="#">
                            <i class="icon-calendar"></i>
                            <span></span>
                            <i class="icon-angle-down"></i>
                        </a>
                    </li>
                </ul>
            </div>
        <#include "../article/add_article_content.ftl">
        </div>
    </div>
</div>
<script type="text/javascript" src="/backend/ms/assets/js/libs/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/backend/ms/plugins/wangeditor/js/wangEditor.min.js"></script>
<script type="text/javascript" src="/backend/ms/plugins/highlightJS/highlight.pack.js"></script>

<!--注意：javascript必须放在body最后，否则可能会出现问题-->
<script type="text/javascript">
    $(function () {
        var editor = $('#textarea1').wangEditor(
                {
                    'menuConfig': [
                        ['bold', 'underline', 'italic', 'foreColor', 'backgroundColor'],
                        ['blockquote', 'fontFamily', 'fontSize', 'setHead', 'list', 'justify'],
                        ['createLink', 'unLink', 'insertTable'],
                        ['insertImage', 'insertVideo', 'insertLocation', 'insertCode']
                    ]
                }
        );
    });
    $(function () {
        $('pre code').each(function (i, block) {
            hljs.highlightBlock(block);
        });
    });

    $(document).ready(function () {
        ArticleValidate.init();
    });
</script>
</body>
</html>
