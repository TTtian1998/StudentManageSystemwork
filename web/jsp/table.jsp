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
    <title>学生管理系统</title>
    <script src="../js/jquery/jquery-3.3.1.min.js"></script>
    <script src="../js/jquery/bootstrap.min.js"></script>
    <script src="../js/jquery/bootstrap-table.js"></script>
    <script src="../js/jquery/bootstrap-table-zh-CN.js"></script>
    <link rel="stylesheet" type="text/css" media="screen" href="../css/bootstrap/bootstrap.min.css" />
    <script type="text/javascript" src="../js/table.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/table.css" />
    <link href="../css/bootstrap/bootstrap-table.css">

</head>
<body>
<div id="box">
    <%--菜单--%>
    <div id="nav">
        <nav class="navbar">
            <ul class="side-nav">
                <li><a href=http://localhost:8080/jsp/info.jsp target="main_frame">学生基本信息</a></li>
                <li><a href=http://localhost:8080/jsp/grade.jsp target="main_frame">学生成绩</a></li>
            </ul>
        </nav>
    </div>
    <iframe id="iframe" name="main_frame" src="http://localhost:8080/jsp/info.jsp" frameborder="0" width="80%" height="600px" scrolling="no"></iframe>
</div>
</body>
</html>
