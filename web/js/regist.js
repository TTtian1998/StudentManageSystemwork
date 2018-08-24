$(function(){

$("#registBtn").click(function() {
    alert("进入注册框了")
    var username = $("#username").val();
    var password = $("#password").val();
    $.ajax({
        url: '../RegistServlet',
        method: 'post',
        async: false, // 不让ajax异步请求
        data: {
            username:username,
            password:password
        },
        success: function(result) {
            if (result == "false") {
                $(".modal-body").append("<span>注册失败</span>");
                $("#registBtn").attr('data-target', '#myModal');
            } else {
                $(".modal-body").append("<span>注册成功，您的账户为：" + result + "</span>");
                setInterval(function () {
                    window.location.href = "http://localhost:8080/jsp/login.jsp";
                    alert("注册成功，点击返回登录页面");
                },2000);
                $("#registBtn").attr('data-target', '#myModal');
            }
        }
    });
});
});
