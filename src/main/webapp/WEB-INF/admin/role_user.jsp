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
        <form:form method="POST" action="/admin/addRole.html?${_csrf.parameterName}=${_csrf.token}">
            Role: <input type="file" name="role">
            <input type="submit" value="Add Role">
        </form:form>
    </section><!-- /.content -->
</div>
<!-- /.content-wrapper -->