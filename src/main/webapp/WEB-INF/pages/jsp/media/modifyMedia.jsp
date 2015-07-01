<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <title>修改媒体</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="main-container" id="main-container">
  <div class="main-container-inner">
    <%@ include file="../common/auth_sider.jsp" %>
    <div class="main-content" style="margin-top: 10px;">
      <div class="page-content">
        <h4 class="ui dividing header">修改媒体</h4>

        <div class="col-xs-5">
          <form class="ui form segment" action="/adm/media/doModifyMedia" method="post">
            <input type="hidden" name="id" value="${media.id}"/>

            <div class="form-group">
              <label>名称</label>
              <input name="name" type="text" value="${media.name}" class="form-control">
            </div>
            <div class="form-group">
              <label>站点Url</label>
              <input name="siteUrl" type="text" value="${media.siteUrl}" class="form-control">
            </div>
            <div class="form-group">
              <label>站点Logo</label>
              <input type="text" name="description" value="${media.siteLogo}" class="form-control">
            </div>
            <div class="form-group">
              <label>描述</label>
              <input type="text" name="description" value="${media.desc}" class="form-control">
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
