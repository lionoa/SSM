const url = window.location.href;
const param = url.split("/");
const id = param[param.length - 1];
$.ajax({
    url:'/updatedBook',
    type:'POST',
    data:{"id":id},
    dataType:'json',
    success:function (data){
        document.getElementById("id").setAttribute("value",data.id);
        document.getElementById("bookName").setAttribute("placeholder",data.bookName);
        document.getElementById("price").setAttribute("placeholder",data.price);
        document.getElementById("bookType").setAttribute("placeholder",data.bookType);
        document.getElementById("bookNums").setAttribute("placeholder",data.bookNums);
    },
    error:function (){
        console.log("error");
    }
})
function updateFunc() {
    const bookName = document.getElementById("bookName");
    const price = document.getElementById("price");
    const bookType = document.getElementById("bookType");
    const bookNums = document.getElementById("bookNums");
    $.ajax({
        url:'/update',
        type:'POST',
        data:{
            "id":id,
            "bookName":bookName.value,
            "price":price.value,
            "bookType":bookType.value,
            "bookNums":bookNums.value
        },
        dataType:'json',
        success:function (data){
            console.log(data);
            alert("修改成功");
            location.href = "http://localhost:8080/books"
        },
        error:function (){
            console.log("error");
        }
    });
}
