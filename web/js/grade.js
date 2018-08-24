
$(function () {
    initTable();
});

function initTable() {
    $("#table").bootstrapTable({
        url: '../GradeTableServlet',
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
        },{
            field: 'name',
            title: '姓名',
            align: "center",
            valign: "middle",
            width: '10',
        }, {
            field: 'math',
            title: '数学',
            align: "center",
            valign: "middle",
            width: '10',
        }, {
            field: 'chinese',
            title: '语文',
            align: "center",
            valign: "middle",
            width: '10',
        }, {
            field: 'english',
            title: '英语',
            align: "center",
            valign: "middle",
            width: '5',
        },{
            field: 'java',
            title: 'JAVA',
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
    var Math = $("#Math").val();
    var Chinese = $("#Chinese").val();
    var English = $("#English").val();
    var Java= $("#Java").val();

    $.ajax({
        url: '../AddGradeServlet',
        method: '',
        async: false,
        data: {
            studentNumber:studentNumber,
            studentName: studentName,
            Math: Math,
            Chinese: Chinese,
            English: English,
            Java: Java,
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

// 删除方法
function deleteGrade() {
    var data = $('#table').bootstrapTable("getSelections");

    if (data.length === 0) {
        $(".deleteGrade").append("<span>请至少选择一条数据</span>");
        $("#deleteModal").modal('show');
        return;
    }

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
        url: '../DeleteGradeServlet',
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
/* 刷新方法 */
function refresh() {
    $("#name").val("");
    $('#table').bootstrapTable('refresh', null);
}