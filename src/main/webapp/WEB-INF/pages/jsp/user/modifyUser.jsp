<%--
  Created by IntelliJ IDEA.
  User: kirs
  Date: 2015/6/23
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
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
    <h4 class="ui dividing header">新增用户</h4>

    <form class="ui form segment" action="/adm/user/doModifyUser" method="post">
      <input type="hidden" id="id" name="id" value="${user.id}"/>
      <div class="field">
        <label>用户名</label>
        <input name="userName" type="text" value="${user.userName}">
      </div>
      <div class="field">
        <label>账号</label>
        <input name="account" type="text" value="${user.account}">
      </div>
      <div class="field">
        <label>邮箱</label>
        <input type="email" name="email" value="${user.email}">
      </div>

      <div class="field">
        <label>手机</label>
        <input type="text" name="mobileTel" id="mobileTel" value="${user.mobileTel}">
      </div>

      <div class="field">
        <label>城市</label>
        <input type="text" name="city" id="city" value="${user.city}">
      </div>

      <input class="ui blue submit button" type="submit" value="保 存">
    </form>
  </div>
</div>


</body>
</html>
