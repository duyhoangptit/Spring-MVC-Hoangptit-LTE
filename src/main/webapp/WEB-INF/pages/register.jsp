<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<div class="register-box">
    <div class="register-logo">
        <a href="/home/index.html"><b>Admin</b>LTE</a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">Đăng ký tài khoản</p>
        <form class="form-signin">
            <div class="form-group has-feedback" id = "divUser">
                <input type="text" class="form-control" placeholder="Username" id="username"/>
                <span class="glyphicon glyphicon-user form-control-feedback" id = "spUser"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="Full name" id="full_name"/>
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" id="password"/>
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input name="password_again" type="password" class="form-control" id="password_again">
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-4">
                </div><!-- /.col -->
                <div class="col-xs-4" >
                    <img src="/images/icongif.gif" id = "waiting" style="position: absolute;z-index:10000" width="60px" height="60px">
                </div><!-- /.col -->
                <div class="col-xs-4">
                    <button type="button" id="btnRegister" class="btn btn-primary btn-block btn-flat">Đăng ký</button>
                </div><!-- /.col -->
            </div>
            <div class="rox">
                <p class="error" id="error"></p>
                <p class="success" id="success"></p>
            </div>
        </form>

        <div class="social-auth-links text-center">
            <p>- OR -</p>
            <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign up
                using Facebook</a>
            <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign up
                using Google+</a>
        </div>

        <a href="/home/login.html" class="text-center">Đăng nhập...</a>
    </div><!-- /.form-box -->
</div>


