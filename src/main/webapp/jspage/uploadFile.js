$(document).ready(function () {
    var fileName = $("#fileUpload").val();
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    // beforeSend: function (xhr) {// send data post spring
    //     // trong thời gian chờ đợi có thể hiện dialog waiting
    //     $('#waiting').show();
    //     // check tocken header
    //     xhr.setRequestHeader(header, token);
    // },
    // $("#multipleupload").uploadFile({
    //     url:"/upload/singleSave.html?" + header + "=" + token,
    //     multiple:true,
    //     dragDrop:true,
    //     fileName:fileName
    // });
    $("#fileuploader").uploadFile({
        url:"/upload/singleSave.html?"+ header + "=" + token,
        fileName:"myfile"
    });
});