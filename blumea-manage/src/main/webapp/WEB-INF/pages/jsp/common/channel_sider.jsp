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
            <a href="/adm/channel/channelList">
                <i class="icon-columns"></i>
                <span class="menu-text"> 频道管理 </span>
            </a>
        </li>

        <li>
            <a href="/adm/channel/toChannelTree">
                <i class="icon-columns"></i>
                <span class="menu-text"> 栏目管理 </span>
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