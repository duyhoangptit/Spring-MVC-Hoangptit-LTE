$(document).ready(function () {
    //header send data post spring
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $('#error').hide();
    $('#success').hide();
    $('#waiting').hide();
    $("#username").blur(function () {
        var username = $(this).val();
        if (username == '') {
            $('#error').html('Username không được để trống');
            $('#error').show();
            $('#username').focus();
            return;
        }
        if (!checkValueInput(username)) {
            $('#error').html('Username chứa các ký tự từ a-z, A-Z, 0-9');
            $('#error').show();
            $('#username').focus();
            return;
        }
        $.get("/user/checkUsername.html", {username: username}, function (data) {
            if (data == 'success') {
                $('#divUser').addClass('has-success');
                $('#spUser').addClass('glyphicon-ok');
                $('#spUser').removeClass('glyphicon-user');
                $('#success').html('Bạn có thể sử dụng tài khoản này.');
                $('#error').hide();
                $('#success').show();
            } else {
                $('#divUser').removeClass('has-success');
                $('#spUser ').removeClass('glyphicon-ok');
                $('#spUser').addClass('glyphicon-user');
                $('#error').html('Tài khoản này đã được sử dụng.');
                $('#error').show();
                $('#success').hide();
            }
        });
    });

    $("#password").blur(function () {
        var password = $(this).val();
        if (!checkValueInput(password)) {
            $('#error').html('Password chứa các ký tự từ a-z, A-Z, 0-9');
            $('#error').show();
            $('#password').focus();
            return;
        }
    });

    $("#password_again").blur(function () {
        var password = $(this).val();
        if (!checkValueInput(password)) {
            $('#error').html('Password chứa các ký tự từ a-z, A-Z, 0-9');
            $('#error').show();
            $('#password_again').focus();
            return;
        }
    });
    $('#error').hide();
    $('#btnRegister').click(function () {
        var username = $('#username').val();
        var password = $('#password').val();
        var full_name = $('#full_name').val();
        var password_again = $('#password_again').val();
        if (checkValidate(username, password, password_again, full_name)) {
            registerUser(username, password, full_name, token, header);
        }
    });
});


/*check validate form HoangPtit   11/8*/
function checkValidate(username, password, password_again, full_name) {
    if (full_name == '') {
        $('#error').html('Full name không được để trống');
        $('#error').show();
        $('#full_name').focus();
        return false;
    }
    if (password == '') {
        $('#error').html('Password không được để trống');
        $('#error').show();
        $('#password').focus();
        return false;
    }
    if (password != password) {
        $('#error').html('Password phải giống nhau');
        $('#error').show();
        $('#password').focus();
        return false;
    }
    $('#error').hide();
    $('#success').html('Thông tin đã kiểm tra thành công!!!');
    $('#success').show();
    return true;
}


/*register form HoangPtit   11/8*/
function registerUser(username, password, full_name, token, header) {

    $.ajax({
        type: 'POST',
        data: {
            username: username,
            password: password,
            full_name: full_name
        },
        url: '/user/registerUser.html',
        dateType: "text", // dữ liệu trả về dạng text
        beforeSend: function (xhr) {// send data post spring
            // trong thời gian chờ đợi có thể hiện dialog waiting
            $('#waiting').show();
            // here it is
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data == 'success') {
                $('#waiting').hide();
                swal('Đăng ký thành công!!!', 'Click closed Ok', data);
                var username = $('#username').val('');
                var password = $('#password').val('');
                var full_name = $('#full_name').val('');
                var password_again = $('#password_again').val('');
                $('#success').hide();
            } else {
                $('#waiting').hide();
                var username = $('#username').val('');
                var password = $('#password').val('');
                var full_name = $('#full_name').val('');
                var password_again = $('#password_again').val('');
                $('#error').html('Đăng ký không thành công');
                $('#error').show();
            }
        }, error: function (e) {
            console.log(e);
        }
    });
}

function checkValueInput(input) {
    var ck_username = /^[a-zA-Z0-9\-.]+$/;// username or password chỉ được chứa các ký tự
    if (!ck_username.test(input)) {
        return false;
    }
    return true;
}
