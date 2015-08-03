<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>

    <ul class="nav nav-list">

        <li>
            <a href="/adm/media/mediaList">
                <i class="icon-align-justify"></i>
                <span class="menu-text">媒体管理 </span>
            </a>
        </li>

        <li>
            <a href="/adm/entry/entryList">
                <i class="icon-book"></i>
                <span class="menu-text">新闻管理</span>
            </a>
        </li>

    </ul>

    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
           data-icon2="icon-double-angle-right"></i>
    </div>

    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>
</div>