<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>登录</title>
</head>
<body style="text-align:center;">
<%@ include file="../common/header.jsp" %>


<div style="width: 500px;margin: 0px auto;">
    <div style="margin-top: 180px;">

        <form action="/adm/doLogin" method="post">
            <div class="ui one column relaxed grid">
                <div class="column">
                    <div class="ui fluid form segment">
                        <h3 class="ui header">登录</h3>

                        <div class="field">
                            <label>用户名</label>
                            <input placeholder="用户名" type="text">
                        </div>
                        <div class="field">
                            <label>密码</label>
                            <input type="password">
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
