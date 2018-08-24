
$(function () {
    initTable();
});

function initTable() {
    $("#table").bootstrapTable({
        url: '../TableServlet',
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
            title: '学生ID',
            align: 'center',
            valign: 'middle',
            width: '5',
        }, {
            field: 'number',
            title: '学生学号',
            align: 'center',
            valign: 'middle',
            width: '5',
        },  {
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
