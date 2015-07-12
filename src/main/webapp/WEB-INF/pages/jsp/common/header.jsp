<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="/assets/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="/assets/css/font-awesome.min.css"/>
<link href="/assets/css/kkpager_blue.css" rel="stylesheet">
<link href="/assets/css/formvalid/validationEngine.jquery.css" rel="stylesheet">
<link href="/assets/css/formvalid/template.css" rel="stylesheet">


<!--[if IE 7]>
<link rel="stylesheet" href="/assets/css/font-awesome-ie7.min.css" />
<![endif]-->

<%--<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />--%>

<link rel="stylesheet" href="/assets/css/ace.min.css"/>
<%--<link rel="stylesheet" href="/assets/css/ace-rtl.min.css"/>--%>
<link rel="stylesheet" href="/assets/css/ace-skins.min.css"/>

<!--[if lte IE 8]>
<!--<link rel="stylesheet" href="/assets/css/ace-ie.min.css" />-->
<![endif]-->

<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"/>
<!-- ace settings handler -->
<script src="/assets/js/jquery-2.0.3.min.js"></script>
<script src="/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
<script src="/assets/js/html5shiv.js"></script>
<script src="/assets/js/respond.min.js"></script>
<![endif]-->
<script src="/assets/js/formvalid/jquery.validationEngine.js"></script>
<script src="/assets/js/formvalid/jquery.validationEngine-zh_CN.js"></script>


<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    CMS
                </small>
            </a>
        </div>

        <div class="navbar-header pull-right" role="navigation">

        </div>
    </div>
</div>
