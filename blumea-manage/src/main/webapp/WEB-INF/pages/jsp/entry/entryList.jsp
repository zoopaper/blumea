<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <title>新闻列表</title>
  <%@ include file="../common/common.jsp" %>
  <script src="/assets/js/kkpager.min.js"></script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="main-container" id="main-container">
  <div class="main-container-inner">
    <%@ include file="../common/other_sider.jsp" %>
    <div class="main-content" style="margin-top: 10px;">
      <div class="page-content">
        <div class="ui-jqgrid-view">
          <p  class="bg-info">
          <form class="form-inline">
            <div class="form-group">
              <button onclick="addEntry();" type="button" class="btn btn-primary btn-sm">新 增</button>
            </div>
            <div class="form-group">
              <button onclick="delEntry();" type="button" class="btn btn-danger btn-sm">删 除</button>
            </div>
            <div class="checkbox">
              <input type="text" id="title" name="title" value="${title}" class="form-control"  placeholder="新闻标题">
            </div>
            <button class="btn btn-default btn-sm" onclick="entrySearch()">Search</button>
          </form>
          </p>

          <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
              <th>
                <label>
                  <input type="checkbox" name="selectAll" value="${entry.id}" class="ace">
                  <span class="lbl"></span>
                </label>
              </th>
              <th>标题</th>
              <th>作者</th>
              <th>频道</th>
              <th>栏目</th>
              <th>创建时间</th>
              <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.items}" var="entry">
              <tr>
                <td>
                  <label>
                    <input type="checkbox" name="id" value="${entry.id}" class="ace">
                    <span class="lbl"></span>
                  </label>
                </td>
                <td>${entry.title}</td>
                <td>${entry.author}</td>
                <td>${entry.channelName}</td>
                <td>${entry.subjectName}</td>
                <td>${entry.ctime}</td>
                <td><a href="/adm/entry/toModifyEntry?id=${entry.id}">
                  <button class="btn btn-xs btn-info">
                    <i class="icon-edit bigger-120"></i>
                  </button>
                </a></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
          <div id="kkpager" class="page_s" style="width: 490px;"></div>
        </div>
      </div>
    </div>
  </div>
</div>
</div>


<script type="text/javascript">
  $(function () {
    //生成分页
    //有些参数是可选的，比如lang，若不传有默认值
    var param = "&title=" + $("#title").val();
    kkpager.generPageHtml({
      pno: '${page.pageIndex}',
      //总页码
      total: '${page.maxPage}',
      //总数据条数
      totalRecords: '${page.total}',
      //链接前部
      hrefFormer: '/adm/article/list',
      //链接尾部
      hrefLatter: '',
      getLink: function (n) {
        return this.hrefFormer + this.hrefLatter + "?page=" + n + param;
      }
    });
  });
</script>
<script type="text/javascript">

  function delEntry() {
    var idArray = new Array();
    $("input[name='id']:checked").each(function () {
      idArray.push($(this).val());
    });

    if (idArray.length == 0) {
      alert("请选择要删除的记录!");
      return false;
    }

    if (confirm("您确定要删除选中的新闻吗!")) {
      window.location.href = "/adm/entry/delEntry?id=" + idArray;
    } else {
      return false;
    }
  }

  function addEntry() {
    window.location.href = "/adm/entry/addEntry";
  }

  function entrySearch() {
    var title = $("#title").val();
    $("#title").val(title);
    window.location.href = "/adm/entry/entryList?title=" + title;
  }

  $('#selectAll').click(function () {
    $('input[name="id"]').attr("checked", this.checked);
  });
</script>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
