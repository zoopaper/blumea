<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>新增媒体</title>
    <script src="/assets/js/bootstrap3-validation.js"></script>
    <script type="text/javascript">
        $(function(){

            //1. 简单写法：
            $("#form1").validation({icon:true});

            // 要从后台数据确定填的邮箱是不是已注册过了，采用回调方法
            // $("form").validation(function(obj,params){
            //   if (obj.id=='mail'){
            //     $.post("/verifymail",{mail :$(obj).val()},function(data){
            //       params.err = !data.success;
            //       params.msg = data.msg;
            //     });
            //   }}
            //   ,{reqmark:true} //这个参数是设必填不要显示有星号，默认是有星号的
            // );


            //.注册
            $("#submit1").on('click',function(event){
                // 2.最后要调用 valid()方法。
                //  valide(object,msg),提示信息显示，object位置后面增加提示信息。如不填object 则自动找最后一个button submit.
                //  valide(msg)

                //第一种提示写法
                if ($("#form1").valid(this,'内容出错')==false){
                    return false;
                }

                //第二种提示写法，回调方法你自己提示就随意你了。
                //if ($("#form1").valid(this,function(err){alert(err)})==false){
                //  return false;
                //}



            })

            $("#form2").validation();
            //.注册
            $("#submit2").on('click',function(event){
                // 2.最后要调用 valid()方法。
                if ($("#form2").valid()==false){
                    alert('填写信息不完整。');
                    return false;
                }
            });


            $("#form3").validation(function(obj,params){
                //扩展校验方法
            },{reqmark:false,icon:true});
            //.注册
            $("#submit3").on('click',function(event){
                // 2.最后要调用 valid()方法。
                if ($("#form3").valid('填写信息不完整。')==false){
                    //alert('填写信息不完整。');
                    return false;
                }
            });

        })
    </script>

</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <%@ include file="../common/auth_sider.jsp" %>
        <div class="main-content" style="margin-top: 10px;">
            <div class="page-content">
                <h4 class="ui dividing header">新增媒体</h4>

                <div class="col-xs-5">
                    <form action="/adm/media/doAddMedia" method="post" id="form1">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="name" id="name" type="text" class="form-control" check-type="required">
                        </div>
                        <div class="form-group">
                            <label>站点URL</label>
                            <input name="siteUrl" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Logo</label>
                            <input type="text" name="logoUrl" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input type="text" name="desc" class="form-control">
                        </div>
                        <input class="btn btn-primary" type="submit" value="保 存">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>