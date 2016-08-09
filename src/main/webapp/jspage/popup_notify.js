$(document).ready(function () {
    $("#myBtn").click(function () {
        $("#myModal").modal();
    });

    $('#btnSave').click(function () {
        $.notify("    Thêm mới thành công ", "success");
        $('#myModal').modal('hide');
    });

    $('#btnSuccess').click(function () {
        swal("Thêm thành công!", "You clicked the button!", "success");
    });

});
