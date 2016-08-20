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

    $(window).load(function() {
        // Animate loader off screen
        $("#loading").fadeOut("slow");;
    });
});


function notifyMessa() {
    setTimeout(function() {
        $('#notifyMessa').load("/user/notifyMessa.html",{data: 1},function (responseTxt, result, xhr) {
            if(result == "success")
                $('#notifyMessa').html();
            if(result == "error")
                alert("Error: " + xhr.status + ": " + xhr.statusText);
        });
    }, 2000);
}