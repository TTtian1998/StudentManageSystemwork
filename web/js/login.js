$(function(){

    $("#loginBtn").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        $.ajax({
            url:'../LoginServlet',
            method:'get',
            async:false,
            data:{
                username:username,
                password:password
            },
            success:function (result) {
                if(result == "true"){
                    setInterval(function () {
                        window.location.href = "http://localhost:8080/jsp/table.jsp";

                    },1000);
                }else{
                    alert("密码错误")
                    $("#loginBtn").attr('data-target','myModal');
                }
            }
        })
    })
});