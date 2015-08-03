<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="/assets/css/kkpager_blue.css" rel="stylesheet">
<link href="/assets/css/formvalid/validationEngine.jquery.css" rel="stylesheet">
<link href="/assets/css/formvalid/template.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/ace.min.css"/>
<link rel="stylesheet" href="/assets/css/ace-skins.min.css"/>
<!--[if IE 7]>
<link rel="stylesheet" href="/assets/css/font-awesome-ie7.min.css" />
<![endif]-->

<!--[if lte IE 8]>
<!--<link rel="stylesheet" href="/assets/css/ace-ie.min.css" />-->
<![endif]-->
<!-- ace settings handler -->

<script src="/assets/js/ace-extra.min.js"></script>


<!--[if lt IE 9]>
<!--<script src="/assets/js/html5shiv.js"></script>-->
<!--<script src="/assets/js/respond.min.js"></script>-->
<![endif]-->
<script src="/assets/js/formvalid/jquery.validationEngine.js"></script>
<script src="/assets/js/formvalid/jquery.validationEngine-zh_CN.js"></script>
<script src="/assets/js/typeahead-bs2.min.js"></script>
<div class="navbar navbar-default" id="navbar" style="height: 60px;">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="navbar-container" id="navbar-container" style="margin-top: 10px;">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-beer"></i>
                    Blumea CMS
                </small>
            </a>

        </div>


        <div class="navbar-header">
            <div style="margin-top:8px;text-align: center;width: 600px;">
                <div class="btn-group">
                    <a>
                        <button class="btn btn-info">内容文档</button>
                    </a>
                    <a>
                        <button class="btn btn-info">频道栏目管理</button>
                    </a>
                    <a>
                        <button class="btn btn-info">系统管理</button>
                    </a>
                    <a>
                        <button class="btn btn-info">其它功能</button>
                    </a>
                </div>
            </div>

        </div>

        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <i class="icon-user-md"></i>

                        <i class="icon-caret-down"></i>
                    </a>

                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="icon-cog"></i>
                                Settings
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <i class="icon-user"></i>
                                Profile
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="/adm/logout">
                                <i class="icon-off"></i>
                                Logout
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>