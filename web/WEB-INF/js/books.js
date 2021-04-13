$.ajax({
    url:'/Session',
    dataType:'text',
    type:'GET',
    success:function (data){
        if (data === "") {
            $('#deleteBTN').hide();
            $('#updateBTN').hide();
        }
    }
})
$.ajax({
    url: '/select',
    dataType: 'json',
    type: "GET",
    success: function (data) {
        console.log(data);
        if (data == null || data === '') {
            alert("检索不到图书数据，请联系管理员！");
        } else {
            let str = "";
            for (let i = 0; i < data.length; i++) {
                str += "<tr><td>" + data[i].bookName +
                    "</td><td>" + data[i].price +
                    "</td><td>" + data[i].bookType +
                    "</td><td>" + data[i].bookNums +
                    "</td><td><input type='checkbox' id=" + data[i].id +
                    "></td></tr>"
            }
            $("#books").html(str);
        }
    },
    error: function () {
        console.log("失败");
    }

});

function checkedID() {
    const length = $("input[type='checkbox']:checked").length;
    console.log("书籍数量")
    console.log(length);
    if (length === 0) {
        alert("请先勾选要操作的书籍");
        return;
    }
    if (length > 1) {
        alert("只能勾选一本书");
    }
}

function getID() {
    //获取书籍id
    const val = $('input:checkbox:checked').attr('id');
    console.log("当前书籍id");
    console.log(val);
    return val;
}

function deleteFun(id) {
    $.ajax({
        url: '/delete',
        data: {'id': id},
        dataType: 'json',
        type: 'POST',
        success: function () {
            location.reload();
        },
        error: function () {
            console.log("error");
        }
    })
}

const BTN = document.getElementById("deleteBTN");
const upBtn = document.getElementById('updateBTN');
BTN.onclick = function () {
    checkedID();
    deleteFun(getID());
};
upBtn.onclick = function () {
    location.href = "/updatedId/" + getID();
};

