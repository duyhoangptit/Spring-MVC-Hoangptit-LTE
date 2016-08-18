<%@ page contentType="text/html;charset=UTF-8" language="java" %><!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            User Profile
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Examples</a></li>
            <li class="active">User profile</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">

        <div class="row">

            <div class="col-md-12">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Quản lý tài khoản người dùng</h3>
                    </div><!-- /.box-header -->
                    <!-- form start -->
                    <form role="form" enctype="multipart/form-data" method="post">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="inputUser">Tên tài khoản:</label>
                                <input type="email" class="form-control" id="inputUser" placeholder="Enter email" value="${isLogin.username}">
                            </div>
                            <div class="form-group">
                                <label for="inputPassword">Mật khẩu:</label>
                                <input type="password" class="form-control" id="inputPassword" placeholder="Password" value="${isLogin.password}">
                            </div>
                            <div class="form-group">
                                <label for="inputName">Họ tên:</label>
                                <input type="text" class="form-control" id="inputName" placeholder="Họ tên" value="${isLogin.fullName}">
                            </div>
                            <div class="form-group">
                                <label for="inputEmail">Email:</label>
                                <input type="email" class="form-control" id="inputEmail" placeholder="Email" value="${isLogin.email}">
                            </div>
                            <div class="form-group">
                                <label for="inputImage">Ảnh đại diện:</label>
                                <img class="profile-user-img img-responsive img-circle" src="/dist/img/${isLogin.image}" alt="User profile picture" id = "inputImage">
                            </div>
                            <div class="form-group">
                                <label for="inputFile">File input</label>
                                <input type="file" id="inputFile">
                                <p class="help-block progressBar">Example block-level help text here.</p>
                                <progress id = "progressBar" class = "progressBar" value="0" max="100" style="width: 200px;"></progress>
                            </div>
                            <div class="checkbox">
                            <label>
                                <input type="checkbox" name="enabled"> Check me out
                            </label>
                        </div>
                        </div><!-- /.box-body -->

                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Cập nhật</button>
                        </div>
                    </form>
                </div><!-- /.box -->

            </div>
        </div><!-- /.row -->

    </section><!-- /.content -->
</div><!-- /.content-wrapper -->