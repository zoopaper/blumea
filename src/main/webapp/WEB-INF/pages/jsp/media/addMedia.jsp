<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>新增媒体</title>


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
    //    function checkHELLO(field, rules, i, options) {
    //        if (field.val() != "HELLO") {
    //            // this allows to use i18 for the error msgs
    //            return options.allrules.validate2fields.alertText;
    //        }
    //    }
</script>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <h4 class="ui dividing header">新增媒体</h4>

                <div class="col-xs-5">
                    <form action="/adm/media/doAddMedia" method="post" id="form1"
                          onsubmit="return jQuery(this).validationEngine('validate');" class="formular">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="name" id="name" type="text" class="validate[required] text-input">
                        </div>
                        <div class="form-group">
                            <label>站点URL</label>
                            <input name="siteUrl" id="siteUrl" type="text"
                                   class="validate[required] text-input">
                        </div>
                        <div class="form-group">
                            <label>Logo</label>
                            <input type="text" name="logoUrl" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input type="text" name="desc" class="form-control">
                        </div>
                        <input class="btn btn-primary" id="submit1" type="submit" onclick="jQuery('#formID').submit();"
                               value="保存"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>
</body>
</html>