var tmp = true;
var page = "#datatable-page";
$(document).ready(function () {
    $('.btnSt').click(function () {
        if (tmp) {
            $("body").addClass("sidebar-collapse");
            tmp = false;
        } else {
            $("body").removeClass("sidebar-collapse");
            tmp = true;
        }
    });
    $('.progressBar').hide();

});