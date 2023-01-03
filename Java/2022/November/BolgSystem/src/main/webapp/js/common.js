function getLoginStatus() {
    $.ajax({
        type: 'GET',
        url: 'login',
        success: function (body) {
            console.log("已经登录")
        }, error: function () {
            console.log("未登录");
            location.assign("index.html")
        }
    })
}
