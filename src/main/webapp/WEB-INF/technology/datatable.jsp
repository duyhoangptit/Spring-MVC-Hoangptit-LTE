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
                        <h3 class="box-title">Hover Data Table</h3>
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
                                        <button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="" data-original-title="Edit Client"><i class="fa fa-pencil"></i></button>
                                        <button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="" data-original-title="Remove Client"><i class="fa fa-times"></i></button>
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

