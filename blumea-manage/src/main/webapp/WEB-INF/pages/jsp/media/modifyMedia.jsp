<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>修改媒体</title>
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
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <h4 class="ui dividing header">修改媒体</h4>

                <div class="col-xs-5">
                    <form class="ui form segment" id="form1" action="/adm/media/doModifyMedia" method="post"
                          style="width: 400px;">
                        <input type="hidden" name="id" value="${media.id}"/>

                        <div class="form-group">
                            <label>名称</label>
                            <input name="name" type="text" value="${media.name}" class="validate[required] text-input"
                                   style="border-radius: 0;-webkit-box-shadow: none!important;box-shadow: none!important;color: #858585;background-color: #fff;border: 1px solid #d5d5d5;width: 400px;height: 35px;">
                        </div>
                        <div class="form-group">
                            <label>站点Url</label>
                            <input name="siteUrl" type="text" value="${media.siteUrl}"
                                   class="validate[required] text-input"
                                   style="border-radius: 0;box-shadow: none!important;color: #858585;background-color: #fff;border: 1px solid #d5d5d5;width: 400px;height: 35px;">
                        </div>
                        <div class="form-group">
                            <label>站点Logo</label>
                            <input type="text" name="description" value="${media.logoUrl}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input type="text" name="description" value="${media.descs}" class="form-control">
                        </div>
                        <input class="btn btn-primary" id="submit1" type="submit" value="保 存">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
