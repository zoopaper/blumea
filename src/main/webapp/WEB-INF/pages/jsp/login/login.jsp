<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>登录</title>
    <link href="/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/assets/css/font-awesome-ie7.min.css"/>
    <link rel="stylesheet" href="/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="/assets/css/ace-skins.min.css"/>

    <script src="/assets/js/jquery-2.0.3.min.js"></script>

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"/>
    <script src="/assets/js/ace-extra.min.js"></script>
</head>

<body>
<div class="" style="height: 100%;margin-top: 200px;">
    <div class="container" style="width: 500px;">


        <div class="row">

            <div class="col-sm-10 col-sm-offset-1">
                <div class="widget-box">

                    <div class="widget-header"><h3>登 录</h3></div>
                    <div class="widget-body">
                        <div class="widget-main">
                            <form action="/adm/doLogin" method="post">

                                <div class="ui message">
                                    <div class="header">
                                        ${loginTip}
                                    </div>
                                </div>
                                <div id="login-box" class="login-box visible widget-box no-border">

                                    <div class="form-group">
                                        <label>账号</label>
                                        <input placeholder="用户名" type="text" name="account" id="account"
                                               class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>密码</label>
                                        <input type="password" name="password" id="password" class="form-control">
                                    </div>
                                    <input type="submit" value="登 录" class="btn btn-primary"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
