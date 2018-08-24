$(function () {
    initTable();
});

function initTable() {
    $("#table").bootstrapTable({
        url: '../InfoTableServlet',
        contentType: 'application/json',// 发送到服务器的数据编码格式
        method: 'post',
        dataType: 'json',
        search: false,
        striped: false,
        pagination: true,
        pageSize: 10,
        pageNumber: 1,
        showRefresh: false,
        pageList: [10, 20, 30],
        clickToSelect: true,
        cache: false, //禁用缓存
        toolbar: '#toolbar',
        columns: [{
            width: '3',
            align: "center",
            valign: "middle",
            checkbox: true,
        }, {
            title: '序号',
            align: 'center',
            valign: 'middle',
            width: '5',
            formatter: function (value, row, index) {
                return index + 1;
            }
        }, {
            field: 'id',
            title: 'ID',
            align: 'center',
            valign: 'middle',
            width: '5',
        }, {
            field: 'number',
            title: '学生学号',
            align: 'center',
            valign: 'middle',
            width: '5',
        }, {
            field: 'name',
            title: '姓名',
            align: "center",
            valign: "middle",
            width: '10',
        }, {
            field: 'sex',
            title: '性别',
            align: "center",
            valign: "middle",
            width: '10',
        }, {
            field: 'age',
            title: '年龄',
            align: "center",
            valign: "middle",
            width: '10',
        }, {
            field: 'major',
            title: '专业',
            align: "center",
            valign: "middle",
            width: '5',
        }]
    });
}

//新增方法
function add() {
    var studentNumber=$("#studentNumber").val();
    var studentName = $("#studentName").val();
    var studentSex = $("#studentSex").val();
    var studentAge = $("#studentAge").val();
    var studentMajor= $("#studentMajor").val();
    $.ajax({
        url: '../AddInfoServlet',
        method: '',
        async: false,
        data: {
            studentNumber:studentNumber,
            studentName:  studentName,
            studentSex: studentSex,
            studentAge :studentAge ,
            studentMajor: studentMajor
        },
        success: function (result) {
            if (result == "true") {
                $('#addModal').modal('hide');
                $(".alertP").append("<span>新增成功</span>");
                $('#myModal').modal('show');
                refresh();
            } else {
                $('#addModal').modal('hide');
                $(".alertP").append("<span>新增失败</span>");
                $('#myModal').modal('show');
            }
            clear();
        }
    });
}

function alter() {
    var data = $("#table").bootstrapTable("getSelections");
    if (data.length != 1) {
        $('#updateModal').modal('hide');
        $(".alertP").append("<span>仅支持一条修改</span>");
        $('#myModal').modal('show');
        return;
    }
    var studentNumber1=$("#studentNumber1").val();
    var studentName1 = $("#studentName1").val();
    var studentSex1 = $("#studentSex1").val();
    var studentAge1 = $("#studentAge1").val();
    var studentMajor1= $("#studentMajor1").val();
    $.ajax({
        url: '../AlterInfoServlet',
        method: '',
        async: false,
        data: {
            id:data[0].id.toString(),
            studentNumber1:studentNumber1,
            studentName1:  studentName1,
            studentSex1: studentSex1,
            studentAge1 :studentAge1 ,
            studentMajor1: studentMajor1
        },
        success: function (result) {
            if (result == "true") {
                $('#updateModal').modal('hide');
                $(".alertP").append("<span>修改成功</span>");
                $('#myModal').modal('show');
                refresh();
            } else {
                $('#updateModal').modal('hide');
                $(".alertP").append("<span>修改失败</span>");
                $('#myModal').modal('show');
            }
            clear();
        }
    });
    
}
// 删除方法
function deleteInfo() {
    var data = $('#table').bootstrapTable("getSelections");

    if (data.length === 0) {
        $(".deleteInfo").append("<span>请至少选择一条数据</span>");
        $("#deleteModal").modal('show');
        return;
    }
    alert(data[0].id);
    var ids = "";
    for (var i = 0; i < data.length; i++) {
        if (i === 0) {
            ids += data[i].id;
            continue;
        }
        ids += "," + data[i].id;
    }
    console.log('-------------',ids);

    $.ajax({
        url: '../DeleteInfoServlet',
        method: 'post',
        async: false,
        data: {
            ids: ids
        },
        success: function (result) {
            if (result == 'true') {
                alert("删除成功");
                refresh();
            }
        }
    });
}

function search1() {
    $('#table').bootstrapTable('destroy');
    initTable();
}

// 搜索方法
function search() {
    var name = $("#name").val();
    ajaxParameter = {
        "name": name
    };
    $.ajax({
        url: '../SearchInfoServlet',
        method: 'post',
        data: {
            name: name
        },
        dataType: 'json',
        success: function(result) {
            alert(result);
        }
    });
}
/* 刷新方法 */
function refresh() {
    $("#name").val("");
    $('#table').bootstrapTable('refresh', null);
}
// 清空新增弹出框中的输入框的值
function clear() {
    $("#id").val("");
    $("#name").val("");
    $("#sex").val("");
    $("#age").val("");
    $("#major").val("");
}