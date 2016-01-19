<div class="row" style="margin-top: 30px;">
    <div class="col-md-2">
        <div class="widget box">
            <div class="widget-header">
                <h4><i class="icon-reorder"></i> 分类</h4>
            </div>
            <div class="widget-content align-center">
                <div class="btn-toolbar btn-toolbar-demo">
                    <input class="form-control" type="text" placeholder="请输入分类" style="display: block; margin-top: 6px;">
                    <button class="btn btn-sm btn-primary">&nbsp; 添加 &nbsp; </button>

                    <br>
                    <br>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-10">
        <div class="widget box">
            <div class="widget-header">
                <h4><i class="icon-reorder"></i>写文章</h4>

                <div class="toolbar no-padding">
                    <div class="btn-group">
                        <span><button class="btn btn-sm btn-primary" onclick="addArticle()">发布文章</button></span>
                    </div>
                </div>
            </div>
            <div class="widget-content">
                <form class="form-horizontal row-border article_form" action="/adm/article/save" method="post" name="article_form" id="article_form">
                    <div class="form-group">
                        <label class="col-md-1 control-label">标题</label>

                        <div class="col-md-11">
                            <input type="text" name="title" id="title" class="form-control" autofocus="autofocus" data-rule-required="true" data-msg-required="请输入您的用户名.">

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-1 control-label">分类</label>

                        <div class="col-md-11">
                            <div class="row next-row">
                                <div class="col-md-12">
                                    <select class="form-control" name="categoryId" id="categoryId">
                                        <option value="1">ddddd</option>
                                        <option value="2">aaaa</option>
                                        <option value="3">bbbb</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-1 control-label">正文</label>

                        <div class="col-md-11">
                            <textarea id='textarea1' name="content" style='height:400px; width:100%;'></textarea>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    function addArticle() {
        var title = $("#title").val();
        var categoryId = $("#categoryId").val();
        var content = $("#textarea1").val();
        if (title == "") {
            alert("文章标题不能为空!");
            $("#title").focus();
            return false;
        }
        if (categoryId == "") {
            alert("文章分类不能为空");
            $("#categoryId").focus();
            return false;
        }
        alert(content);
        if (content == "") {
            alert("正文不能为空");
            $("#textarea1").focus();
            return false;
        }
        $("#article_form").submit();


    }
</script>








