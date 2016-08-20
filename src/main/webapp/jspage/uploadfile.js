function _(el) {
    return document.getElementById(el);
}

function uploadFile() {
    var file = _('file1').files[0];
    var formdata = new FormData();
    formdata.append('file1',file);
    var ajax = new XMLHttpRequest();
    ajax.upload.addEventListener("progress",progressHandler, false);
    ajax.addEventListener("load",completeHanler, false);
    ajax.addEventListener("error",errorHanler, false);
    ajax.addEventListener("abort",abortHanler, false);
    ajax.open("POST","server");
    ajax.send(formdata);
}
function progressHandler(event) {
    _('loaded_n_total').innerHTML = "Uploaded" + event.loaded + " by of " + event.total;
    var percent = (event.loaded/event.total)*100;
    _('progressBar').value = Math.round(percent);
    _('status').innerHTML = Math.round(percent) + "% uploaded ... please wait";
}
function completeHanler(event) {
    _('status').innerHTML = event.target.responseText;
    _('progressBar').value = 0;
}
function errorHanler(event) {
    _('status').innerHTML = "Upload Failed";
}
function abortHanler(event) {
    _('status').innerHTML = "Upload Aborted";
}