<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>用户列表</title>
</head>
<body style="margin: 0 auto;">
<%@ include file="../common/header.jsp" %>


<div id="container">

    <div id="sidebar"></div>

    <div id="content" style="margin-top: 60px;">
        <div class="mini ui basic button">
            <i class="plus icon"></i>
            <a href="/adm/user/addUser">添加</a>
        </div>

        <div class="mini ui basic button">
            <i class="minus icon"></i>
            删除
        </div>
        <table class="ui celled table">
            <thead>
            <tr>
                <th>账号</th>
                <th>用户名</th>
                <th>Eamil</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>No Name Specified</td>
                <td>Unknown</td>
                <td>None</td>
            </tr>
            <tr class="warning">
                <td>Jimmy</td>
                <td><i class="attention icon"></i> Requires Action</td>
                <td>None</td>
            </tr>
            <tr>
                <td>Jamie</td>
                <td>Unknown</td>
                <td class="warning"><i class="attention icon"></i> Hostile</td>
            </tr>
            <tr>
                <td>Jill</td>
                <td>Unknown</td>
                <td>None</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
