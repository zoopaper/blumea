<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>

    <ul class="nav nav-list">
        <li class="">
            <a href="/">
                <i class="icon-dashboard"></i>
                <span class="menu-text"> 控制台 </span>
            </a>
        </li>

        <li>
            <a href="/adm/user/userList">
                <i class="icon-user"></i>
                <span class="menu-text"> 用户管理 </span>
            </a>
        </li>

        <li>
            <a href="/adm/channel/channelList">
                <i class="icon-columns"></i>
                <span class="menu-text"> 频道管理 </span>
            </a>
        </li>

        <li>
            <a href="/adm/subject/subjectList">
                <i class="icon-align-justify"></i>
                <span class="menu-text">栏目管理 </span>
            </a>
        </li>

        <li>
            <a href="/adm/media/mediaList">
                <i class="icon-align-justify"></i>
                <span class="menu-text">媒体管理 </span>
            </a>
        </li>

        <li>
            <a href="/adm/media/mediaList">
                <i class="icon-book"></i>
                <span class="menu-text">新闻管理</span>
            </a>
        </li>

        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-desktop"></i>
                <span class="menu-text">权限管理</span>

                <b class="arrow icon-angle-down"></b>
            </a>
            <ul class="submenu">
                <li>
                    <a href="/adm/function/functionList">
                        <i class="icon-double-angle-right"></i>
                        功能管理
                    </a>
                </li>
                <li>
                    <a href="/adm/role/roleList">
                        <i class="icon-double-angle-right"></i>
                        角色管理
                    </a>
                </li>
            </ul>

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