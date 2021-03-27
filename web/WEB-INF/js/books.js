$.ajax({
    url:'/select',
    dataType:'json',
    type:"GET",
    success:function (data) {
        console.log(data);
        if (data == null || data === '') {
            alert("检索不到图书数据，请联系管理员！");
        }else {
            let str = "";
            for (let i = 0; i < data.length; i++) {
                str += "<tr><td>" + data[i].bookName +
                    "</td><td>" + data[i].price +
                    "</td><td>" + data[i].bookType +
                    "</td><td>" + data[i].bookNums +
                    "</td><td><input type='checkbox' id='check'>" +
                    "</td></tr>"
            }
            $("#books").html(str);
        }
    },
    error:function () {
        console.log("失败");
    }

});