<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>登录</title>
    <link href="/ui/css/semantic.min.css" rel="stylesheet">
    <script src="/ui/js/jquery-1.6.4.min.js"></script>
    <script src="/ui/js/semantic.min.js"></script>
</head>
<body>
<div style="width: 500px;margin: 0px auto;">
    <div style="margin-top: 180px;">

        <form action="/adm/doLogin" method="post">

            <div class="ui message">
                <div class="header">
                    ${loginTip}
                </div>
            </div>
            <div class="ui one column relaxed grid">
                <div class="column">
                    <div class="ui fluid form segment">
                        <h3 class="ui header">登录</h3>

                        <div class="field">
                            <label>账号</label>
                            <input placeholder="用户名" type="text" name="account" id="account" >
                        </div>
                        <div class="field">
                            <label>密码</label>
                            <input type="password" name="password" id="password" >
                        </div>
                        <input type="submit" value="登 录" class="ui blue submit button"/>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
