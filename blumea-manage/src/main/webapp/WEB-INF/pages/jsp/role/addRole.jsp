<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>新增角色</title>
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

    /**
     *
     * @param {jqObject} the field where the validation applies
     * @param {Array[String]} validation rules for this field
     * @param {int} rule index
     * @param {Map} form options
     * @return an error string if validation failed
     */
    function checkHELLO(field, rules, i, options) {
        if (field.val() != "HELLO") {
            // this allows to use i18 for the error msgs
            return options.allrules.validate2fields.alertText;
        }
    }
</script>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/system_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <h4 class="ui dividing header">新增角色</h4>

                <div class="col-xs-6">
                    <form action="/adm/role/doAddRole" id="form1" method="post"
                          onsubmit="return jQuery(this).validationEngine('validate');">
                        <div class="form-group">
                            <label>角色名称</label>
                            <input name="name" type="text" class="validate[required] text-input" style="width: 300px;">
                        </div>
                        <div class="form-group">
                            <label>选择功能</label>
                            <input name="funcId" type="text" class="validate[required] text-input"
                                   style="width: 300px;">
                        </div>
                        <div class="form-group">
                            <label>角色描述</label>
                            <input type="text" name="description" style="width: 300px;">
                        </div>
                        <input class="btn btn-primary" type="submit" id="submit1" onclick="jQuery('#form1').submit();"
                               value="保 存">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>