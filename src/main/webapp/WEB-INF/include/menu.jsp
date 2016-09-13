<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/dist/img/user_hoang.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${isLogin.username}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> <O></O>nline</a>
            </div>
        </div>
        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i
                        class="fa fa-search"></i></button>
              </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">Admin LTE</li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>Công nghệ</span> <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li  class="${page=='datatable'?'active':''}"><a href="/home/dataTable.html"><i class="fa fa-circle-o"></i> Data Table</a></li>
                    <li  class="${page=='popup_notify'?'active':''}"><a href="/home/popup.html"><i class="fa fa-circle-o"></i> Popup Notify</a></li>
                    <li  class="${page=='lazy_load'?'active':''}"><a href="/home/lazyLoad.html"><i class="fa fa-circle-o"></i> Lazy Load </a></li>
                    <li  class="${page=='uploadFile'?'active':''}"><a href="/home/uploadFile.html"><i class="fa fa-circle-o"></i> Upload file </a></li>
                    <li  class="${page=='exportPDF'?'active':''}"><a href="/home/uploadFile.html"><i class="fa fa-circle-o"></i> Export PDF </a></li>
                    <li  class="${page=='exportExcel'?'active':''}"><a href="/home/uploadFile.html"><i class="fa fa-circle-o"></i> Export Excel </a></li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-circle-o text-red"></i> <span>Quản trị</span></a>
                <ul class="treeview-menu">
                    <li ><a href="/home/dataTable.html"><i class="fa fa-circle-o"></i> Công việc</a></li>
                    <li ><a href="/home/popup.html"><i class="fa fa-circle-o"></i> Plan </a></li>
                    <li ><a href="/home/lazyLoad.html"><i class="fa fa-circle-o"></i> Quyền sử dụng </a></li>
                </ul>
            </li>
            <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Học tập</span></a></li>
            <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Giải trí</span></a></li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
