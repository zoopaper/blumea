<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>新增频道</title>
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
                <h4 class="ui dividing header">新增频道</h4>
                <div class="col-xs-5">

                    <form action="/adm/channel/doAddChannel" method="post" id="form1" onsubmit="return jQuery(this).validationEngine('validate');" class="form-horizontal">
                        <div class="form-group" style="text-align: center;width: 300px;">
                            <span style="color:red;">${errTip}</span>
                        </div>

                        <div class="form-group">
                            <label>频道名称</label>
                            <input name="name" type="text" id="name"  class="validate[required] text-input" style="width: 400px;">
                        </div>
                        <div class="form-group">
                            <label>频道目录</label>
                            <input name="dir" type="text"  class="validate[required] text-input" style="width: 400px;">
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

