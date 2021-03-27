const add = document.getElementById("add");
const update = document.getElementById("update");
const deleteTab = document.getElementById("delete");
$.ajax({
    url:'/Session',
    type:'GET',
    dataType:'text',
    success:function (data){
        if (data !== "") {
            console.log("当前用户名为：");
            console.log(data);
            const logout = document.getElementById("logoutHref");
            const login = document.getElementById("loginHref");
            logout.innerText = "欢迎你 " + data.toString();
            login.innerText = "";
            add.innerText = "添加书籍";
            update.innerText = "修改书籍";
            deleteTab.innerText = "删除书籍";
        }
    },
    error:function (){
        console.log("没有session");
    }
});
const a = document.getElementById("logoutHref");
function aHref(){
    $.ajax({
        url:'/logout',
        type:'GET',
        dataType:'json',
        success:function (data){
            if (data === 1){
                location.reload();
            }
        },
        error:function (){
            console.log("注销出错了");
        }
    });
}
a.onclick = aHref;

    /*时钟js*/
    // Get the local time using JS
    let date = new Date;
    let seconds = date.getSeconds();
    let minutes = date.getMinutes();
    let hours = date.getHours();

    // Create an object with each hand and it's angle in degrees
    const hands = [
        {
            hand: 'hours',
            angle: (hours * 30) + (minutes / 2)
        },
        {
            hand: 'minutes',
            angle: (minutes * 6)
        },
        {
            hand: 'seconds',
            angle: (seconds * 6)
        }
    ];
    // Loop through each of these hands to set their angle
    for (let j = 0; j < hands.length; j++) {
        const elements = document.querySelectorAll('.' + hands[j].hand);
        for (let k = 0; k < elements.length; k++) {
            elements[k].style.webkitTransform = 'rotateZ('+ hands[j].angle +'deg)';
            elements[k].style.transform = 'rotateZ('+ hands[j].angle +'deg)';
            // If this is a minute hand, note the seconds position (to calculate minute position later)
            if (hands[j].hand === 'minutes') {
                elements[k].parentNode.setAttribute('data-second-angle', hands[j + 1].angle);
            }
        }
    }
const containers = document.querySelectorAll('.seconds-container');
setInterval(function() {
    for (let i = 0; i < containers.length; i++) {
        if (containers[i].angle === undefined) {
            containers[i].angle = 6;
        } else {
            containers[i].angle += 6;
        }
        containers[i].style.webkitTransform = 'rotateZ('+ containers[i].angle +'deg)';
        containers[i].style.transform = 'rotateZ('+ containers[i].angle +'deg)';
    }
}, 1000);

