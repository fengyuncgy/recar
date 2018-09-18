function selectEmployee(id) {
    var a = '';
    a = '<option value="null">请选择</option>'
    $.ajax({
        type: "get",
        url: "/employee/findAllEmployee",
        async:false,
        success: function (data) {
            data = data.data;
            for(var i = 0 ; i<data.length;i++){
                a+='<option value="'+data[i].employeeid+'" '+(id==data[i].employeeid?"selected":"")+'>'+data[i].name+'</option>'
            }

        }
    });
    return a
}


function employeeInit() {
    $.ajax({
        type: "get",
        url: "/login/session",
        async:false,
        success: function (data) {
            if (data.data == null) {
                alert("权限不够")
                window.location.href = '/login';
            } else {
                $('#id').val(data.data.employeeid)
                $('#name').append("欢迎" + data.data.name)
                $('#sex').append(data.data.sex == 1 ? "男" : "女")
            }
        }
    });
}

function customerInit() {
    $.ajax({
        type: "get",
        url: "/login/session",
        async:false,
        success: function (data) {
            if (data.data == null) {
                alert("权限不够")
                window.location.href = '/login';
            } else {
                $('#id').val(data.data.customerid)
                $('#name').append("欢迎" + data.data.name)
                $('#sex').append(data.data.sex == 1 ? "男" : "女")
            }

        }
    });
}

function getCustomerCarId(id) {
    var a = '';
    a = ''
    $.ajax({
        type: "get",
        url: "/car/getOnes?id="+id,
        async:false,
        success: function (data) {
            data = data.data;
            for (var i = 0; i < data.length; i++)
                if (i == data.length - 1) a += data[i].carid
                else a += data[i].carid + ','
        }
    });
    return a
}
function ajaxSend(url,type,data) {
    $.ajax({
        type:"post",
        url: url,
        data: data,
        contentType: 'application/json;charset=UTF-8',
        dataType: "json",
        success: function (data) {
            layer.msg(data.message, {
                time: 0 //不自动关闭
                , btn: ['确定']
                , yes: function (index) {
                    layer.close(index);
                    window.location.href = '/'+type
                }
            });

        }
    });
}
function getMaintenanceId() {
    var a = '';
    $.ajax({
        type: "get",
        url: "/maintenancePart/getMaintenanceid",
        async: false,
        success: function (data) {
            a = data.data;
        }
    });
    return a
}
var getFlowId = function () {
    var a = '';
    $.ajax({
        type: "get",
        url: "/flow/getFlowid",
        async: false,
        success: function (data) {
            a = data.data;
        }
    });
    return a
}

