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
    <title>注册系统</title>
    <meta charset="UTF-8">
    <script src="../js/jquery/jquery-3.3.1.min.js"></script>
    <script src="../js/jquery/bootstrap.min.js"></script>
    <link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/regist.css" />
    <script type="text/javascript" src="../js/regist.js"></script>
</head>
<body>
<h1>注册</h1>
<div class="login-form">
    <div class="close"> </div>
    <div class="head-info">
        <div class="lab">
            <h6>注册你的账号，完成后提交</h6>
        </div>
    </div>
    <div class="clear"></div>
    <form name="registform">
        <input type="text" class="content-input form-control required" id="username" name="username" placeholder="请输入账号" >
        <div class="key">
            <input type="password" class="content-input form-control required" id="password" name="password" placeholder="请输入密码" >
        </div>
    <div class="form-group col-md-offset-8">
        <input type="button" id="registBtn" class="btn btn-block btn-warning full-right" data-toggle="modal" data-target="" value="提交" >
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

            </div>
            <div class="modal-footer">
                <button type="button" id="btnOk" class="btn btn-info" data-dismiss="modal">确定
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>