<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>新增用户</title>

    <script type="text/javascript">


        $('.ui.form').form({
                    username: {
                        identifier: 'username',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a username'
                            }
                        ]
                    },
                    password: {
                        identifier: 'password',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a password'
                            },
                            {
                                type: 'length[6]',
                                prompt: 'Your password must be at least 6 characters'
                            }
                        ]
                    }
                })
        ;
    </script>
</head>
<body>
<%@ include file="../common/header.jsp" %>

<div id="container">

    <div id="sidebar"></div>

    <div id="content" style="margin-top: 60px;width: 600px;height: 700px;">
        <%--<form action="/adm/user/doAddUser" method="post">--%>

        <%--<input type="text" name="userName">--%>
        <%--<input type="text" name="account">--%>
        <%--<input type="password" name="password">--%>

        <%--<input type="submit" value="保 存">--%>

        <%--</form>--%>
        <h4 class="ui dividing header">新增用户</h4>

        <form class="ui form segment" action="/adm/user/doAddUser" method="post">
            <div class="field">
                <label>用户名</label>
                <input  name="userName" type="text">
            </div>
            <div class="field">
                <label>账号</label>
                <input  name="account" type="text">
            </div>
            <div class="field">
                <label>密码</label>
                <input type="password" name="password">
            </div>

            <input class="ui blue submit button" type="submit" value="保 存">
        </form>
    </div>
</div>


</body>
</html>
