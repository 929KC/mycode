////////////////////////////////////////////
// 这里实现标签页的切换
////////////////////////////////////////////

function initSwitchTab() {
    // 1. 先获取到相关的元素(标签页的按钮, 会话列表, 好友列表)
    let tabSession = document.querySelector('.tab .tab-session');
    let tabFriend = document.querySelector('.tab .tab-friend');
    // querySelectorAll 可以同时选中多个元素. 得到的结果是个数组
    // [0] 就是会话列表
    // [1] 就是好友列表
    let lists = document.querySelectorAll('.list');
    // 2. 针对标签页按钮, 注册点击事件. 
    //    如果是点击 会话标签按钮, 就把会话标签按钮的背景图片进行设置. 
    //    同时把会话列表显示出来, 把好友列表隐藏
    //    如果是点击 好友标签按钮, 就把好友标签按钮的背景图片进行设置. 
    //    同时把好友列表显示出来, 把会话列表进行隐藏
    tabSession.onclick = function() {
        // a) 设置图标
        tabSession.style.backgroundImage = 'url(img/对话.png)';
        tabFriend.style.backgroundImage = 'url(img/用户2.png)';
        // b) 让会话列表显示出来, 让好友列表进行隐藏
        lists[0].classList = 'list';
        lists[1].classList = 'list hide';
    }

    tabFriend.onclick = function() {
        // a) 设置图标
        tabSession.style.backgroundImage = 'url(img/对话2.png)';
        tabFriend.style.backgroundImage = 'url(img/用户.png)'
        // b) 让好友列表显示, 让会话列表隐藏
        lists[0].classList = 'list hide';
        lists[1].classList = 'list';
    }
}

initSwitchTab();

/////////////////////////////////////////////////////
// 操作 websocket
/////////////////////////////////////////////////////

// 创建 websocket 实例
// let websocket = new WebSocket("ws://127.0.0.1:8080/WebSocketMessage");
let websocket = new WebSocket("ws://" + location.host + "/WebSocketMessage");

websocket.onopen = function() {
    console.log("websocket 连接成功!");
}

websocket.onmessage = function(e) {
    console.log("websocket 收到消息! " + e.data);
    // 此时收到的 e.data 是个 json 字符串, 需要转成 js 对象
    let resp = JSON.parse(e.data);
    if (resp.type == 'message') {
        // 处理消息响应
        handleMessage(resp);
    } else {
        // resp 的 type 出错!
        console.log("resp.type 不符合要求!");
    }
}

websocket.onclose = function() {
    console.log("websocket 连接关闭!");
}

websocket.onerror = function() {
    console.log("websocket 连接异常!");
}

function handleMessage(resp) {
    // 把客户端收到的消息, 给展示出来. 
    // 展示到对应的会话预览区域, 以及右侧消息列表中. 

    // 1. 根据响应中的 sessionId 获取到当前会话对应的 li 标签. 
    //    如果 li 标签不存在, 则创建一个新的
    let curSessionLi = findSessionLi(resp.sessionId);
    if (curSessionLi == null) {
        // 就需要创建出一个新的 li 标签, 表示新会话. 
        curSessionLi = document.createElement('li');
        curSessionLi.setAttribute('message-session-id', resp.sessionId);
        // 此处 p 标签内部应该放消息的预览内容. 一会后面统一完成, 这里先置空
        curSessionLi.innerHTML = '<h3>' + resp.fromName + '</h3>'
            + '<p></p>';
        // 给这个 li 标签也加上点击事件的处理
        curSessionLi.onclick = function() {
            clickSession(curSessionLi);
        }
    }
    // 2. 把新的消息, 显示到会话的预览区域 (li 标签里的 p 标签中)
    //    如果消息太长, 就需要进行截断. 
    let p = curSessionLi.querySelector('p');
    p.innerHTML = resp.content;
    if (p.innerHTML.length > 10) {
        p.innerHTML = p.innerHTML.substring(0, 10) + '...';
    }
    // 3. 把收到消息的会话, 给放到会话列表最上面. 
    let sessionListUL = document.querySelector('#session-list');
    sessionListUL.insertBefore(curSessionLi, sessionListUL.children[0]);
    // 4. 如果当前收到消息的会话处于被选中状态, 则把当前的消息给放到右侧消息列表中. 
    //    新增消息的同时, 注意调整滚动条的位置, 保证新消息虽然在底部, 但是能够被用户直接看到. 
    if (curSessionLi.className == 'selected') {
        // 把消息列表添加一个新消息. 
        let messageShowDiv = document.querySelector('.right .message-show');
        addMessage(messageShowDiv, resp);
        scrollBottom(messageShowDiv);
    }
    // 其他操作, 还可以在会话窗口上给个提示 (红色的数字, 有几条消息未读), 还可以播放个提示音.  
    // 这些操作都是纯前端的. 实现也不难, 不是咱们的重点工作. 暂时不做了. 
}

function findSessionLi(targetSessionId) {
    // 获取到所有的会话列表中的 li 标签
    let sessionLis = document.querySelectorAll('#session-list li');
    for (let li of sessionLis) {
        let sessionId = li.getAttribute('message-session-id');
        if (sessionId == targetSessionId) {
            return li;
        }
    }
    // 啥时候会触发这个操作, 就比如如果当前新的用户直接给当前用户发送消息, 此时没存在现成的 li 标签
    return null;
}

/////////////////////////////////////////////////////
// 实现消息发送/接收逻辑
/////////////////////////////////////////////////////

function initSendButton() {
    // 1. 获取到发送按钮 和 消息输入框
    let sendButton = document.querySelector('.right .ctrl button');
    let messageInput = document.querySelector('.right .message-input');
    // 2. 给发送按钮注册一个点击事件
    sendButton.onclick = function() {
        // a) 先针对输入框的内容做个简单判定. 比如输入框内容为空, 则啥都不干
        if (!messageInput.value) {
            // value 的值是 null 或者 '' 都会触发这个条件
            return;
        }
        // b) 获取当前选中的 li 标签的 sessionId
        let selectedLi = document.querySelector('#session-list .selected');
        if (selectedLi == null) {
            // 当前没有 li 标签被选中. 
            return;
        }
        let sessionId = selectedLi.getAttribute('message-session-id');
        // c) 构造 json 数据
        let req = {
            type: 'message',
            sessionId: sessionId,
            content: messageInput.value
        };
        req = JSON.stringify(req);
        console.log("[websocket] send: " + req);
        // d) 通过 websocket 发送消息
        websocket.send(req);
        // e) 发送完成之后, 清空之前的输入框
        messageInput.value = '';
    }
}

initSendButton();


/////////////////////////////////////////////////////
// 从服务器获取到用户登录数据
/////////////////////////////////////////////////////

function getUserInfo() {
    $.ajax({
        type: 'get',
        url: 'userInfo',
        success: function(body) {
            // 从服务器获取到数据. 
            // 校验结果是否有效. 
            if (body.userId && body.userId > 0) {
                // 如果结果有效, 则把用户名显示到界面上. 
                // 同时也可以记录 userId 到 html 标签的属性中. (以备后用)
                let userDiv = document.querySelector('.main .left .user');
                userDiv.innerHTML = body.username;
                userDiv.setAttribute("user-id", body.userId);
            } else {
                // 如果结果无效, 当前未登录! 则跳转到登录页面. 
                alert("当前用户未登录!");
                location.assign('login.html');
            }
        }
    });
}

getUserInfo();

function getFriendList() {
    $.ajax({
        type: 'get',
        url: 'friendList',
        success: function(body) {
            // 1. 先把之前的好友列表的内容, 给清空
            let friendListUL = document.querySelector('#friend-list');
            friendListUL.innerHTML = '';
            // 2. 遍历 body, 把服务器响应的结果, 加回到当前的 friend-list 中. 
            for (let friend of body) {
                let li = document.createElement('li');
                li.innerHTML = '<h4>' + friend.friendName + '</h4>';
                // 此处把 friendId 也记录下来, 以备后用. 
                // 把 friendId 作为一个 html 的自定义属性, 加到 li 标签上就行了. 
                li.setAttribute('friend-id', friend.friendId);
                friendListUL.appendChild(li);

                // 每个 li 标签, 就对应界面上的一个好友的选项. 给这个 li 加上点击事件的处理. 
                li.onclick = function() {
                    // 参数表示区分了当前用户点击的是哪个好友. 
                    clickFriend(friend);
                }
            }
        },
        error: function() {
            console.log('获取好友列表失败!');
        }
    });
}

getFriendList();

function getSessionList() {
    $.ajax({
        type: 'get',
        url: 'sessionList',
        success: function(body) {
            // 1. 清空之前的会话列表
            let sessionListUL = document.querySelector('#session-list');
            sessionListUL.innerHTML = '';
            // 2. 遍历响应的数组, 针对结果来构造页面
            for (let session of body) {
                // 针对 lastMessage 的长度进行截断处理
                if (session.lastMessage.length > 10) {
                    session.lastMessage = session.lastMessage.substring(0, 10) + '...';
                }

                let li = document.createElement('li');
                // 把会话 id 保存到 li 标签的自定义属性中. 
                li.setAttribute('message-session-id', session.sessionId);
                li.innerHTML = '<h3>' + session.friends[0].friendName + '</h3>' 
                    + '<p>' + session.lastMessage + '</p>';
                sessionListUL.appendChild(li);

                // 给 li 标签新增点击事件
                li.onclick = function() {
                    // 这个写法, 就能保证, 点击哪个 li 标签
                    // 此处对应的 clickSession 函数的参数就能拿到哪个 li 标签. 
                    clickSession(li);
                }
            }
        }
    });
}

getSessionList();

function clickSession(currentLi) {
    // 1. 设置高亮
    let allLis = document.querySelectorAll('#session-list>li');
    activeSession(allLis, currentLi);
    // 2. 获取指定会话的历史消息 TODO
    let sessionId = currentLi.getAttribute("message-session-id");
    getHistoryMessage(sessionId);
}

function activeSession(allLis, currentLi) {
    // 这里的循环遍历, 更主要的目的是取消未被选中的 li 标签的 className
    for (let li of allLis) {
        if (li == currentLi) {
            li.className = 'selected';
        } else {
            li.className = '';
        }
    }
}

// 这个函数负责获取指定会话的历史消息. 
function getHistoryMessage(sessionId) {
    console.log("获取历史消息 sessionId=" + sessionId);
    // 1. 先清空右侧列表中的已有内容
    let titleDiv = document.querySelector('.right .title');
    titleDiv.innerHTML = '';
    let messageShowDiv = document.querySelector('.right .message-show');
    messageShowDiv.innerHTML = '';

    // 2. 重新设置会话的标题. 新的会话标题是点击的那个会话上面显示的标题
    //    先找到当前选中的会话是哪个. 被选中的会话带有 selected 类的. 
    let selectedH3 = document.querySelector('#session-list .selected>h3');
    if (selectedH3) {
        // selectedH3 可能不存在的. 比如页面加载阶段, 可能并没有哪个会话被选中. 
        // 也就没有会话带有 selected 标签. 此时就无法查询出这个 selectedH3
        titleDiv.innerHTML = selectedH3.innerHTML;
    }
    // 3. 发送 ajax 请求给服务器, 获取到该会话的历史消息. 
    $.ajax({
        type: 'get',
        url: 'message?sessionId=' + sessionId,
        success: function(body) {
            // 此处返回的 body 是个 js 对象数组, 里面的每个元素都是一条消息. 
            // 直接遍历即可. 
            for (let message of body) {
                addMessage(messageShowDiv, message);
            }
            // 加个操作: 在构造好消息列表之后, 控制滚动条, 自动滚动到最下方. 
            scrollBottom(messageShowDiv);
        }
    });
}

function addMessage(messageShowDiv, message) {
    // 使用这个 div 表示一条消息
    let messageDiv = document.createElement('div');
    // 此处需要针对当前消息是不是用户自己发的, 决定是靠左还是靠右. 
    let selfUsername = document.querySelector('.left .user').innerHTML;
    if (selfUsername == message.fromName) {
        // 消息是自己发的. 靠右
        messageDiv.className = 'message message-right';
    } else {
        // 消息是别人发的. 靠左
        messageDiv.className = 'message message-left';
    }
    messageDiv.innerHTML = '<div class="box">' 
        + '<h4>' + message.fromName + '</h4>'
        + '<p>' + message.content + '</p>'
        + '</div>';
    messageShowDiv.appendChild(messageDiv);
}

// 把 messageShowDiv 里的内容滚动到底部. 
function scrollBottom(elem) {
    // 1. 获取到可视区域的高度
    let clientHeight = elem.offsetHeight;
    // 2. 获取到内容的总高度
    let scrollHeight = elem.scrollHeight;
    // 3. 进行滚动操作, 第一个参数是水平方向滚动的尺寸. 第二个参数是垂直方向滚动的尺寸
    elem.scrollTo(0, scrollHeight - clientHeight);
}

// 点击好友列表项, 触发的函数
function clickFriend(friend) {
    // 1. 先判定一下当前这个好友是否有对应的会话. 
    //    使用一个单独的函数来实现. 这个函数参数是用户的名字. 返回值是一个 li 标签. 找到了就是返回了对应会话列表里的 li; 如果没找到, 返回 null
    let sessionLi = findSessionByName(friend.friendName);
    let sessionListUL = document.querySelector('#session-list');
    if (sessionLi) {
        // 2. 如果存在匹配的结果, 就把这个会话设置成选中状态, 获取历史消息, 并且置顶. 
        //    insertBefore 把这个找到的 li 标签放到最前面去. 
        sessionListUL.insertBefore(sessionLi, sessionListUL.children[0]);
        //    此处设置会话选中状态, 获取历史消息, 这俩功能其实在上面的 clickSession 中已经有了. 
        //    此处直接调用 clickSession 即可
        //    clickSession(sessionLi);
        //    或者还可以模拟一下点击操作. 
        sessionLi.click();
    } else {
        // 3. 如果不存在匹配的结果, 就创建个新会话(创建 li 标签 + 通知服务器)
        sessionLi = document.createElement('li');
        //    构造 li 标签内容. 由于新会话没有 "最后一条消息", p 标签内容就设为空即可
        sessionLi.innerHTML = '<h3>' + friend.friendName + '</h3>' + '<p></p>';
        //    把标签进行置顶
        sessionListUL.insertBefore(sessionLi, sessionListUL.children[0]);
        sessionLi.onclick = function() {
            clickSession(sessionLi);
        }
        sessionLi.click();
        //     发送消息给服务器, 告诉服务器当前新创建的会话是啥样的. 
        createSession(friend.friendId, sessionLi);
    }
    // 4. 还需要把标签页给切换到 会话列表. 
    //    实现方式很容易, 只要找到会话列表标签页按钮, 模拟一个点击操作即可. 
    let tabSession = document.querySelector('.tab .tab-session');
    tabSession.click();
}

function findSessionByName(username) {
    // 先获取到会话列表中所有的 li 标签
    // 然后依次遍历, 看看这些 li 标签谁的名字和要查找的名字一致. 
    let sessionLis = document.querySelectorAll('#session-list>li');
    for (let sessionLi of sessionLis) {
        // 获取到该 li 标签里的 h3 标签, 进一步得到名字
        let h3 = sessionLi.querySelector('h3');
        if (h3.innerHTML == username) {
            return sessionLi;
        }
    }
    return null;
}

// friendId 是构造 HTTP 请求时必备的信息
function createSession(friendId, sessionLi) {
    $.ajax({
        type: 'post',
        url: 'session?toUserId=' + friendId,
        success: function(body) {
            console.log("会话创建成功! sessionId = " + body.sessionId);
            sessionLi.setAttribute('message-session-id', body.sessionId);
        }, 
        error: function() {
            console.log('会话创建失败!');
        }
    });
}