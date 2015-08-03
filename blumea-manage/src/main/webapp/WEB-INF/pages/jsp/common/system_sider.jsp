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
            <a href="/adm/user/userList">
                <i class="icon-user"></i>
                <span class="menu-text"> 用户管理 </span>
            </a>
        </li>
        <li>
            <a href="/adm/function/functionList">
                <i class="icon-certificate"></i>
                功能管理
            </a>
        </li>
        <li>
            <a href="/adm/role/roleList">
                <i class="icon-group"></i>
                角色管理
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