var stompClient = null;

connect();

function setConnected(connected) {
    // $("#connect").prop("disabled", connected);
    // $("#disconnect").prop("disabled", !connected);
    // if (connected) {
    //     $("#conversation").show();
    // }
    // else {
    //     $("#conversation").hide();
    // }
    // $("#greetings").html("");

    console.log('WS connected');
}

function connect() {
    var socket = new SockJS('http://127.0.0.1:8181/api/websocket-end-point');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/api/web-socket/user-auth-status', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
        sendName()
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/api/web-socket/message", {}, JSON.stringify({'message' : 'this is andy'}));
}

function showGreeting(message) {
   console.log('message:'+message);
}

