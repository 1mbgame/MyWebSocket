var stompClient = null;

connect();
console.log("Version:1.0.3");


function connect() {
    var socket = new SockJS('http://127.0.0.1:8181/api/websocket-end-point');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        let username = "D" + (new Date()).getMilliseconds();
        console.log("username: " + username);
        stompClient.subscribe('/user/' + username + '/msg', function (greeting) {
           console.log("Message from server : " + greeting);
        });
        onUserConnected(username);
        
    });
}

function onUserConnected(username) {
    stompClient.send('/api/web-socket/user-connected', {},username);
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}




