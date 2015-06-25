<%--
  Created by IntelliJ IDEA.
  User: kirs
  Date: 2015/6/25
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>修改功能</title>

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
        <h4 class="ui dividing header">修改功能</h4>

        <form class="ui form segment" action="/adm/function/doModifyFunction" method="post">
            <input type="hidden" name="id" value="${function.id}"/>
            <div class="field">
                <label>功能名称</label>
                <input name="name" type="text" value="${function.name}">
            </div>
            <div class="field">
                <label>功能URL</label>
                <input name="action" type="text" value="${function.action}">
            </div>
            <div class="field">
                <label>功能参数</label>
                <input type="text" name="param" value="${function.param}">
            </div>
            <div class="field">
                <label>是否功能组</label>
                <select id="isGroup" name="isGroup">
                    <option value="1" <c:if test="${function.isGroup=='1'}"> selected</c:if>>是</option>
                    <option value="0" <c:if test="${function.isGroup=='0'}"> selected</c:if>>否</option>
                </select>
            </div>

            <input class="ui blue submit button" type="submit" value="保 存">
        </form>
    </div>
</div>


</body>
</html>
