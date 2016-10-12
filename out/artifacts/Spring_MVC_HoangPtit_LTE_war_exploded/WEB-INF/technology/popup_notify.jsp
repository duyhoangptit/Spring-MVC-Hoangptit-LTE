<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="content-wrapper">

    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Popup Notify
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Examples</a></li>
            <li class="active">User profile</li>
        </ol>
        <br/>
        Timeline
        <ul class="timeline">
            <!-- timeline time label -->
            <li class="time-label">
                <i class="fa fa-search bg-purple"></i>
                <div class="timeline-item">
                    <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>
                    <h3 class="timeline-header"><a href="#">HoangPtit</a> demo step1</h3>
                    <div class="timeline-body">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                    </div>
                </div>
            </li>
            <!-- /.timeline-label -->
            <!-- timeline item -->
            <li>
                <i class="fa fa-camera bg-purple"></i>
                <div class="timeline-item">
                    <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>
                    <h3 class="timeline-header"><a href="#">HoangPtit</a> demo step2</h3>
                    <div class="timeline-body">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                    </div>
                </div>
            </li>
            <!-- END timeline item -->
            <!-- timeline item -->
            <li>
                <i class="fa fa-paint-brush bg-purple"></i>
                <div class="timeline-item">
                    <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>
                    <h3 class="timeline-header"><a href="#">HoangPtit</a> demo step3</h3>
                    <div class="timeline-body">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                    </div>
                </div>
            </li>
            <!-- END timeline item -->
            <!-- timeline item -->
            <li>
                <i class="fa fa-camera bg-purple"></i>
                <div class="timeline-item">
                    <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>
                    <h3 class="timeline-header"><a href="#">HoangPtit</a> demo step4</h3>
                    <div class="timeline-body">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                    </div>
                </div>
            </li>
            <!-- END timeline item -->
            <!-- timeline time label -->
            <li class="time-label">
                <i class="fa  fa-plane bg-purple"></i>
                <div class="timeline-item">
                    <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>
                    <h3 class="timeline-header"><a href="#">HoangPtit</a> demo step5</h3>
                    <div class="timeline-body">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                    </div>
                </div>
            </li>
            <!-- /.timeline-label -->
            <!-- timeline item -->
            <li>
                <i class="fa fa-trophy bg-purple"></i>
                <div class="timeline-item">
                    <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>
                    <h3 class="timeline-header"><a href="#">HoangPtit</a> demo step6</h3>
                    <div class="timeline-body">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                    </div>
                </div>
            </li>
            <!-- END timeline item -->
            <!-- timeline item -->
            <li>
                <i class="fa fa-power-off bg-purple"></i>
                <div class="timeline-item">
                    <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>
                    <h3 class="timeline-header"><a href="#">HoangPtit</a> demo step7</h3>
                    <div class="timeline-body">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                    </div>
                </div>
            </li>
            <!-- END timeline item -->
            <li>
                <i class="fa fa-heartbeat bg-gray"></i>
            </li>
        </ul>

    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                Add New
            </button>
            <br/>
            <button type="button" class="btn btn-primary" id="btnSuccess">Save changes
            </button>
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
                            ...
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
        </div>
    </section><!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script src="/js/sweetalert.js"></script>
