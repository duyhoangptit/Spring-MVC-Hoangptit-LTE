<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Friends
            <small>tables</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i>Home</a></li>
            <li><a href="#">Profile</a></li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
                                data-target="#friendModel">
                            Add New Friends
                        </button>
                    </div><!-- /.box-header -->
                    <div class="box-body">
                        <table id="tblData" class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th class="data-view">STT</th>
                                <th class="data-view">Avatar</th>
                                <th class="data-view">FullName</th>
                                <th class="data-view">Birthday</th>
                                <th class="data-view">Email</th>
                                <th class="data-view">Facebook</th>
                                <th class="data-view">Skype</th>
                                <th class="data-view">Phone</th>
                                <th class="data-view">Sex</th>
                                <th class="data-view">Description</th>
                                <th class="data-view">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="friendItem" items="${friends}" varStatus="i">
                                <tr>
                                    <td class="data-view">${i.index + 1}</td>
                                    <td class="data-view"><img src="/upload/${friendItem.avatar}" class="img-circle"
                                                               alt="avatar"></td>
                                    <td class="data-view">${friendItem.fullName}</td>
                                    <td class="data-view">${friendItem.birthday}</td>
                                    <td class="data-view">${friendItem.email}</td>
                                    <td class="data-view">${friendItem.facebook}</td>
                                    <td class="data-view">${friendItem.skype}</td>
                                    <td class="data-view">${friendItem.phone}</td>
                                    <td class="data-view">${friendItem.sex}</td>
                                    <td class="data-view">${friendItem.description  }</td>
                                    <td class="data-view">
                                        <a href="/user/updateUser.html?userId=${friendItem.id}"><img
                                                src="/images/details-icon.png" class="size-img"></a>
                                        <a href="/user/updateUser.html?userId=${friendItem.id}"><img
                                                src="/images/delete-icon.png" class="size-img"></a>
                                        <a href="/user/deleteUser.html?userId=${friendItem.id}"><img
                                                src="/images/edit-icon.png" class="size-img"></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th class="data-view">STT</th>
                                <th class="data-view">Avatar</th>
                                <th class="data-view">FullName</th>
                                <th class="data-view">Birthday</th>
                                <th class="data-view">Email</th>
                                <th class="data-view">Facebook</th>
                                <th class="data-view">Skype</th>
                                <th class="data-view">Phone</th>
                                <th class="data-view">Sex</th>
                                <th class="data-view">Description</th>
                                <th class="data-view">Action</th>
                            </tr>
                            </tfoot>
                        </table>
                    </div><!-- /.box-body -->
                </div><!-- /.box -->
            </div><!-- /.col -->
        </div><!-- /.row -->
    </section><!-- /.content -->
</div>
<!-- /.content-wrapper -->

<!-- Modal -->
<div class="modal fade" id="friendModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Title popup</h4>
            </div>
            <form role="form">
                <div class="modal-body">

                    <div class="box-body">
                        <%-- name--%>
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input type="email" class="form-control" name="fullName" placeholder="Full Name">
                        </div>
                        <%-- birthday--%>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" class="form-control" data-inputmask="'alias': 'dd/mm/yyyy'" data-mask="">
                        </div>
                        <%-- email--%>
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope-square"></i></span>
                            <input type="email" class="form-control" placeholder="email">
                        </div>
                        <%-- phone--%>
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-phone"></i></span>
                            <input type="email" class="form-control" placeholder="phone">
                        </div>
                        <%--facebook--%>
                        <div class="input-group">
                            <span class="input-group-addon"><i class=" fa-facebook-square"></i></span>
                            <input type="email" class="form-control" placeholder="facebook">
                        </div>
                        <%--skype--%>
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-skype"></i></span>
                            <input type="email" class="form-control" placeholder="skype">
                        </div>
                        <%-- description--%>
                        <div class="form-group">
                            <span class="input-group-addon"><i class="fa fa-pencil-square-o"></i></span>
                            <textarea class="form-control" rows="3" placeholder="Enter ..."></textarea>
                        </div>
                        <%-- sex--%>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Sex
                            </label>
                        </div>
                        <%-- avatar--%>
                        <div class="form-group">
                            <label for="exampleInputFile"></label>
                            <input type="file" id="exampleInputFile">
                            <p class="help-block">Avatar</p>
                        </div>

                    </div><!-- /.box-body -->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal" id="btnClose">Close
                    </button>
                    <button type="button" class="btn btn-primary" id="btnSave">Save changes
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

