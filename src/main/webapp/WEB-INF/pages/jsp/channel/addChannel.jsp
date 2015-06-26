<%--
  Created by IntelliJ IDEA.
  User: kirs
  Date: 2015/6/23
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>新增频道</title>

</head>
<body>
<%@ include file="../common/header.jsp" %>

<div id="container">

    <div id="sidebar"></div>

    <div id="content" style="margin-top: 60px;width: 600px;height: 700px;">
        <h4 class="ui dividing header">新增频道</h4>
        <script src="/ui/js/form.js"></script>
        <script src="/ui/js/validate-form.js"></script>
        <form class="ui form segment" action="/adm/channel/doAddChannel" method="post" name="">
            <div class="field">
                <label>频道名称</label>
                <input name="name" type="text" id="name">
            </div>
            <div class="field">
                <label>频道目录</label>
                <input name="dir" type="text">
            </div>
            <input class="ui blue submit button" type="submit" value="保 存">
        </form>
    </div>
</div>
</body>
</html><script type="text/javascript">
    $('.ui.form').form({
        dir: {
            identifier: 'dir',
            rules: [
                {
                    type: 'empty',
                    prompt: 'Please enter your name'
                }
            ]
        }
    });
</script>
