<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Data Tables
            <small>advanced tables</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Tables</a></li>
            <li class="active">Data tables</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                            Add New
                        </button>
                    </div><!-- /.box-header -->
                    <div class="box-body">
                        <table id="tblData" class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th class="data-view">STT</th>
                                <th class="data-view">Username</th>
                                <th class="data-view">Password</th>
                                <th class="data-view">Image</th>
                                <th class="data-view">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="account" items="${accounts}" varStatus="i">
                                <tr>
                                    <td class="data-view">${i.index + 1}</td>
                                    <td class="data-view">${account.username}</td>
                                    <td class="data-view">${account.password}</td>
                                    <td class="data-view">${account.customer.avatar}</td>
                                    <td class="data-view">
                                        <img src="/images/details-icon.png" class="size-img" data-toggle="modal" data-target="#myModal" onclick="detailUser('${account}')">
                                        <img src="/images/edit-icon.png" class="size-img" data-toggle="modal" data-target="#myModal" onclick="updateUser('${account.username}')">
                                        <img src="/images/delete-icon.png" class="size-img" onclick="deleteUser('${account.id}')">
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th class="data-view">STT</th>
                                <th class="data-view">Username</th>
                                <th class="data-view">Password</th>
                                <th class="data-view">Image</th>
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
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Title popup</h4>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal" id="btnClose">Close
                </button>

                <button type="button" class="btn btn-primary" id="btnSave">Save changes
                </button>
            </div>
        </div>
    </div>
</div>

