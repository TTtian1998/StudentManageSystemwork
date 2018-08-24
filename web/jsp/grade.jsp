<%--
  Created by IntelliJ IDEA.
  User: tzx
  Date: 2018/8/17
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>学生成绩</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../js/jquery/bootstrap-table.js"></script>
    <script src="../js/jquery/bootstrap-table-zh-CN.js"></script>
    <link href="../css/bootstrap/bootstrap-table.css" rel="stylesheet">
    <link href="../css/bootstrap/bootstrap-theme.css">
    <script src="../js/grade.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/grade.css" />
</head>
<body>
<div class="html container">
    <div class="header page-header">
        <h1>学生成绩管理</h1>
    </div>
    <div class="table-contenet">
        <div class="searchBar">
            <div class="left">
                <input id="name" name="name" class="form-control" placeholder="请输入学生ID"/>
                <button class="btn btn-primary" onclick="search()">搜索</button>
            </div>
            <div class="right">
                <button class="btn btn-success" data-toggle="modal" data-target="#addModal">新增</button>
                <button class="btn btn-danger" data-toggle="modal" onclick="deleteGrade()">删除</button>
                <button class="btn btn-warning" data-toggle="modal" data-target="#updateModal">修改</button>
            </div>
        </div>
        <div class="data">
            <table id="table" class="table table-bordered"></table>
        </div>
    </div>
</div>


<!-- 新增弹框 -->
<div id="addModal" class="modal fade" role="dialog"
     aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">新增</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12 col-md-12">
                        <h4>学生学号：</h4>
                        <input type="text" id="studentNumber" name="studentNumber" autofocus="autofocus"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>姓名：</h4>
                        <input type="text" id="studentName" name="studentName" autofocus="autofocus"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>数学</h4>
                        <input type="text" id="Math" name="Math"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>语文：</h4>
                        <input type="text" id="Chinese" name="Chinese"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>英语：</h4>
                        <input type="text" id="English" name="English"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>JAVA:</h4>
                        <input type="text" id="Java" name="Java"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="clear()">关闭</button>
                <button type="button" class="btn btn-primary" onclick="add()">新增</button>
            </div>
        </div>
    </div>
</div>

<!-- 修改模态框（Modal） -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="updateModalLabel">
                    修改
                </h4>
            </div>
            <div class="modal-body">
                按下 ESC 按钮退出。
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    提交更改
                </button>
            </div>
        </div>
    </div>
</div>

<!-- 删除模态框（Modal） -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="deleteModalLabel">
                    提示
                </h4>
            </div>
            <div class="modal-body deleteTeacher">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" data-dismiss="modal">确定
                </button>
            </div>
        </div>
    </div>
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
                    提示
                </h4>
            </div>
            <div class="modal-body alertP">
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
