$(document).ready(function () {
    $("#tblData").DataTable();

});

function detailUser(user){
    var obj = eval("(" + user + ")");
    alert(obj.username);
}

function updateUser(password){

}

function deleteUser(id){
    alert(id);
}