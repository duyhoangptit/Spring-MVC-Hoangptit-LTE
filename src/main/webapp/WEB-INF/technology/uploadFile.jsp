<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/css/dropzone.css"/>
<script type="text/javascript" src="/js/dropzone.js"></script>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">

    </section>

    <!-- Main content -->
    <section class="content">
        <div id="fileuploader">Upload</div>

        <form:form method="POST" enctype="multipart/form-data" action="/upload/singleSave.html?${_csrf.parameterName}=${_csrf.token}">
            Upload File: <input type="file" name="file">
            <br /><br />
            Description: <input type="text" name="desc"/>
            <br/><br/>   <input type="submit" value="Upload">
        </form:form>
        <br>
        <div class="image_upload_div">
            <form:form action="/upload/singleSave.html?${_csrf.parameterName}=${_csrf.token}"
                  class="dropzone"
                  id="my-awesome-dropzone">
            </form:form>
        </div>
        <audio controls>
            <source src="/upload/don_coi.mp3" type="audio/mpeg">
        </audio>

    </section><!-- /.content -->
</div>
<!-- /.content-wrapper -->