<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>新增栏目</title>
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
</script>

<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <h4 class="ui dividing header">新增栏目</h4>

                <div class="col-xs-5">
                    <form class="form-horizontal" action="/adm/subject/doAddSubject" method="post" id="form1" onsubmit="return jQuery(this).validationEngine('validate');">
                        <div class="form-group">
                            <label>名称&nbsp;&nbsp;&nbsp;&nbsp;</label>
                            <input name="name" type="text" class="validate[required] text-input" style="width: 400px;">
                        </div>
                        <div class="form-group">
                            <label>短名称</label>
                            <input name="shortName" type="text" class="validate[required] text-input" style="width: 400px;">
                        </div>
                        <div class="form-group">
                            <label>父栏目</label>
                            <input name="pid" type="text" style="width: 400px;">
                        </div>
                        <div class="form-group">
                            <label>优先级</label>
                            <input name="priority" type="text" id="priority" style="width: 400px;">
                        </div>
                        <div class="form-group">
                            <label>频道&nbsp;&nbsp;&nbsp;&nbsp;</label>
                            <select id="channelId" name="channelId" style="width: 400px;">
                                <c:forEach items="${channelList}" var="channel">
                                    <option value="${channel.id}">${channel.name}</option>
                                </c:forEach>
                            </select>
                        </div>


                        <div class="form-group">
                            <label>状态&nbsp;&nbsp;&nbsp;&nbsp;</label>
                            <select name="status" style="width: 400px;">
                                <option value="1">有效</option>
                                <option value="0">无效</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>标签&nbsp;&nbsp;&nbsp;&nbsp;</label>
                            <input name="tags" type="text" class="validate[required] text-input" style="width: 400px;">
                        </div>
                        <div class="form-group">
                            <label>描述&nbsp;&nbsp;&nbsp;&nbsp;</label>
                            <input name="description" type="text" style="width: 400px;">
                        </div>
                        <input class="btn btn-primary" type="submit" value="保 存" id="submit1" onclick="jQuery('#form1').submit();">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>