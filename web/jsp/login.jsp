<%--
  Created by IntelliJ IDEA.
  User: tzx
  Date: 2018/8/16
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
    <title>学生成绩管理系统</title>
    <meta charset="UTF-8">
    <script src="../js/jquery/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/login.css" >
    <link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/login.js"></script>
</head>
<body>
<h1>学生成绩管理系统<br>登录界面</h1>
<div class="login-form">
    <form name="loginForm">
        <div class="login_input">
        <input type="text"  class="content-input form-control required" placeholder="请输入账号" id="username" name="username" >
        <input type="password" class="content-input form-control required" placeholder="请输入密码" id="password" name="password">
        </div>

        <div class="signin">
            <input id="loginBtn" class="btn btn-block btn-success full-right" data-toggle="modal" data-target="" type="button" value="登录">
            <input class="btn btn-block btn-link full-right" type="button" onclick="document.location.href='http://localhost:8080/jsp/regist.jsp'" value="注册">
        </div>
        <div class="choose">
            <div>
                <input type="checkbox" >
                <span>记住用户名和密码</span>
                <input type="checkbox" >
                <span>自动登录</span>
            </div>
        </div>
    </form>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    错误
                </h4>
            </div>
            <div class="modal-body">
                登录失败,请检查你的账户和密码
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" data-dismiss="modal">确定
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
