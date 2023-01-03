var spans = document.querySelectorAll('span');
for (var i = 0; i < spans.length; i++) {
    spans[i].innerHTML = '';
}

function checkUser(user) {
    var t = /^[a-zA-Z]{4,12}$/;
    if (t.test(user)) return true;
    else return false;
}

function checkPW(pw) {
    var t = /^\w{6,20}$/;
    if (t.test(pw)) return true;
    else return false;
}

function checkPN(pn) {
    var t = /^1[34578]\d{9}$/;
    if (t.test(pn)) return true;
    else return false;
}

function checkEmail(email) {
    var t = /^(\w+(\_|\-|\.)*)+@(\w+(\-)?)+(\.\w{2,})+$/;
    if (t.test(email)) return true;
    else return false;
}