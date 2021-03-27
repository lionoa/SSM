const bookName = document.getElementById("bookName");
const price = document.getElementById("price");
const bookType = document.getElementById("bookType");
const bookNums = document.getElementById("bookNums");
function submitBtn() {
    if (bookName.value === '' || bookNums.value === '' || bookType.value === '' || price.value === ''){
        alert("输入不能为空")
        return;
    }
    $.ajax({
        url:"/add",
        type:"POST",
        dataType:"json",
        data:{
            "bookName":bookName.value,
            "price":price.value,
            "bookType":bookType.value,
            "bookNums":bookNums.value
        },
        success:function (data){
            console.log(data);
            if (data === 1) {
                alert("添加成功")
                location.href="http://localhost:8080/";
            }
            if (data === -1) {
                alert("已经有该书名的书籍")
            }
        },
        error:function (){
            console.log("失败");
        }
    });

}
