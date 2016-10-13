var tmp = true;
var page = "#datatable-page";
$(document).ready(function () {
    picker();
    $('.btnSt').click(function () {
        if (tmp) {
            $("body").addClass("sidebar-collapse");
            tmp = false;
        } else {
            $("body").removeClass("sidebar-collapse");
            tmp = true;
        }
    });

    $(window).load(function () {
        // Animate loader off screen
        $("#loading").fadeOut("slow");
        ;
    });

    $('.progressBar').hide();

    var div = $('#header');
    var start = $(div).offset().top;

    $.event.add(window, "scroll", function () {
        var p = $(window).scrollTop();
        $(div).css('position', ((p) > start) ? 'fixed' : 'static');
        $(div).css('top', ((p) > start) ? '0px' : '');
    });
    var alt = $('#alt');
    var startAlt = $(alt).offset().top;

    $.event.add(window, "scroll", function () {
        var p = $(window).scrollTop();
        $(alt).css('position', ((p) > startAlt) ? 'static' : 'static');
        $(alt).css('top', ((p) > startAlt) ? '0px' : '');
    });
});

function picker() {
    var date = new Date();
    var h = date.getHours();
    var m = date.getMinutes();
    var s = date.getSeconds();
    var time = (h < 10 ? ("0" + h) : h) + ":" + (m < 10 ? ("0" + m) : m) + ":" + (s < 10 ? ("0" + s) : s);
    $('#picker').html(time);
    setTimeout(function () {
        picker();
    }, 1000);

}

function notifyMessa() {
    setTimeout(function () {
        $('#notifyMessa').load("/user/notifyMessa.html", {data: 1}, function (responseTxt, result, xhr) {
            if (result == "success")
                $('#notifyMessa').html();
            if (result == "error")
                alert("Error: " + xhr.status + ": " + xhr.statusText);
        });
    }, 2000);
}