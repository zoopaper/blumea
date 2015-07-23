<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>新增新闻</title>
    <link rel="stylesheet" href="/assets/css/kindeditor/default.css" />
    <script charset="utf-8" src="/assets/js/kindeditor/kindeditor-min.js"></script>
    <script charset="utf-8" src="/assets/js/kindeditor/zh_CN.js"></script>
    <%@ include file="../common/common.jsp" %>
</head>
<body>

<%@ include file="../common/header.jsp" %>
<script>
    function validate() {

    }
    function formSuccess() {
        alert('Success!');
    }

    function formFailure() {
        alert('Failure!');
    }
    jQuery(document).ready(function () {
        // binds form submission and fields to the validation engine
        jQuery("#form1").validationEngine({
            onFormSuccess: formSuccess,
            onFormFailure: formFailure
        });
    });

    var editor;
    KindEditor.ready(function(K) {
        editor = K.create('textarea[name="content"]', {
            resizeType : 1,
            allowPreviewEmoticons : false,
            allowImageUpload : false,
            items : [
                'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                'insertunorderedlist', '|', 'emoticons', 'image', 'link']
        });
    });
</script>

<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <h4 class="ui dividing header">新增新闻</h4>

                <div class="col-xs-5">
                    <form action="/adm/entry/doAddEntry" method="post" id="form1"
                          onsubmit="return jQuery(this).validationEngine('validate');" class="form-horizontal">
                        <div class="form-group" style="text-align: center;width: 300px;">
                            <span style="color:red;">${errTip}</span>
                        </div>

                        <div class="form-group">
                            <label>频道</label><br>

                            <select name="channelId" style="width: 400px;">
                                <c:forEach items="${channelList}" var="channel">
                                    <option value="${channel.id}">${channel.name}</option>
                                </c:forEach>
                            </select>

                        </div>

                        <div class="form-group">
                            <label>标题</label><br>
                            <input name="title" type="text" id="title" class="validate[required] text-input"  style="width: 400px;">
                        </div>


                        <div class="form-group">
                            <label>副标题</label><br>
                            <input name="subhead" type="text" class="validate[required] text-input" style="width: 400px;">
                        </div>

                        <div class="form-group">
                            <label>来源</label><br>
                            <input name="subhead" type="text" class="validate[required] text-input" style="width: 400px;">
                        </div>

                        <div class="form-group">
                            <label>作者</label><br>
                            <input name="author" type="text" class="validate[required] text-input" style="width: 400px;">
                        </div>

                        <div class="form-group">
                            <label>责任编辑</label><br>
                            <input name="dutyEditor" type="text" class="validate[required] text-input" style="width: 400px;">
                        </div>

                        <div class="form-group">
                            <label>关键字</label><br>
                            <input name="keyword" type="text" class="validate[required] text-input" style="width: 400px;">
                        </div>

                        <div class="form-group">
                            <label>标签</label><br>
                            <input name="tag" type="text" class="validate[required] text-input" style="width: 400px;">
                        </div>

                        <div class="form-group">
                            <label>摘要</label><br>
                            <textarea name="summary" class="validate[required]" style="width:900px;height:100px;"></textarea>
                        </div>

                        <div class="form-group">
                            <label>正文</label>
                            <%--<input name="subhead" type="text" class="validate[required] text-input" style="width: 400px;">--%>

                            <textarea name="content"  class="validate[required]" style="width:900px;height:400px;visibility:hidden;"></textarea>
                        </div>

                        <div class="form-group">

                        <input class="btn btn-primary" type="submit" value="保 存" id="submit1"
                               onclick="jQuery('#form1').submit();">

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>