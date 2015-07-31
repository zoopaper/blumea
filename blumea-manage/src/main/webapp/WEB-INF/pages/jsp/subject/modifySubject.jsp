<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>修改栏目</title>
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
</script>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <h4 class="ui dividing header">修改栏目</h4>

                <div class="col-xs-5">
                    <form class="ui form segment" action="/adm/subject/doModifySubject" method="post" id="form1" onsubmit="return jQuery(this).validationEngine('validate');">
                        <input type="hidden" id="id" name="id" value="${subject.id}"/>

                        <div class="form-group">
                            <label>名称</label>
                            <input name="name" type="text" value="${subject.name}" class="validate[required] text-input" style="width: 400px;">
                        </div>
                        <div class="form-group">
                            <label>短名称</label>
                            <input name="shortName" type="text" value="${subject.shortName}" class="validate[required] text-input" style="width: 400px;">
                        </div>
                        <div class="form-group">
                            <label>父栏目</label>
                            <input name="pid" type="text" value="${subject.pid}" style="width: 400px;">
                        </div>
                        <div class="form-group">
                            <label>频道</label>
                            <select name="channelId">
                                <c:forEach items="${channelList}" var="channel">
                                    <c:if test="${channel.id == subject.channelId}">
                                        <option selected value="${channel.id}">${channel.name}</option>
                                    </c:if>
                                    <c:if test="${channel.id != subject.channelId}">
                                        <option value="${channel.id}">${channel.name}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>状态</label>
                            <select name="status" style="width: 400px;">
                             <c:choose>
                                <c:when test="${subject.status=='1'}">
                                    <option value="1" selected>有效</option>
                                    <option value="0">无效</option>
                                </c:when>
                                <c:when test="${subject.status=='0'}">
                                    <option value="1">有效</option>
                                    <option value="0" selected>无效</option>
                                </c:when>
                                 <c:otherwise>
                                     <option value="1">有效</option>
                                     <option value="0" selected>无效</option>
                                 </c:otherwise>
                             </c:choose>
                            </select>

                        </div>
                        <div class="form-group">
                            <label>标签</label>
                            <input name="tags" type="text" value="${subject.tags}" class="validate[required] text-input" style="width: 400px;">
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="description" type="text" value="${subject.description}" style="width: 400px;">
                        </div>
                        <input class="btn btn-primary" type="submit" value="保 存" class="form-control" id="submit1" onclick="jQuery('#form1').submit();">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>